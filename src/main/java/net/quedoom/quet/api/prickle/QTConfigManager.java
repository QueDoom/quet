package net.quedoom.quet.api.prickle;

import com.google.gson.*;
import net.darkhax.pricklemc.common.api.annotations.*;
import net.darkhax.pricklemc.common.api.config.ConfigManager;
import net.darkhax.pricklemc.common.impl.PrickleMod;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class QTConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface FileOnlyConfig {}

    protected static String findKey(JsonObject root, Field field, Value meta) {
        String snake = field.getName().replaceAll("([a-z0-9])([A-Z])", "$1_$2").toLowerCase(Locale.ROOT);
        for (String candidate : new String[]{meta.name(), field.getName(), snake}) {
            if (!candidate.isEmpty() && root.has(candidate)) return candidate;
        }
        return meta.name().isEmpty() ? field.getName() : meta.name();
    }

    protected static <T> T firstLoad(String configId, T config) {
        PrickleMod.LOG.info("Loaded {} configs!", config.toString());
        return ConfigManager.load(configId, config);
    }
    public static Path path(String configId) {
        return FabricLoader.getInstance().getConfigDir().resolve(configId + ".json");
    }


    public static <T> void save(Path path, Class<?> clazz, T config) {
        PrickleMod.LOG.info("Saving configs for {}...", config.toString());
        System.currentTimeMillis();
        long time;
        try {
            JsonObject root;
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                root = JsonParser.parseReader(reader).getAsJsonObject();
            }

            for (Field field : clazz.getDeclaredFields()) {
                time = System.currentTimeMillis();
                Value meta = field.getAnnotation(Value.class);
                if (meta == null) continue;
                field.setAccessible(true);

                String key = findKey(root, field, meta);
                JsonObject entry = root.has(key) && root.get(key).isJsonObject()
                        ? root.getAsJsonObject(key)
                        : new JsonObject();

                JsonElement value = GSON.toJsonTree(field.get(config));
                entry.add("value", value);
                root.add(key, entry);
                long writeTime = System.currentTimeMillis() - time;
                if (writeTime > 10) {
                    PrickleMod.LOG.warn("Wrote {} in {}ms", field.getName(), writeTime);
                } else {
                    PrickleMod.LOG.info("Wrote {} in {}ms", field.getName(), writeTime < 1 ? "<1" : writeTime);
                }
            }

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                GSON.toJson(root, writer);
            }
        }
        catch (IOException | IllegalAccessException e) {
            PrickleMod.LOG.error("Couldn't save {} config!", config.toString());
            e.printStackTrace();
        }
        PrickleMod.LOG.info("Saved {} config!", config.toString());
    }

    public static <T> List<AbstractWidget> asWidgets(Options options, Class<?> clazz, T config, String namespace) {
        List<AbstractWidget> widgets = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Value meta = field.getAnnotation(Value.class);
            if (meta == null || field.isAnnotationPresent(FileOnlyConfig.class)) continue;
            field.setAccessible(true);

            String key = "options." + namespace + '.' + field.getName();
            Component name = Component.translatable(key);
            Component comment = Component.literal(meta.comment());
            Class<?> type = field.getType();

            try {
                AbstractWidget widget = null;

                if (type == boolean.class) {
                    widget = OptionInstance.createBoolean(key,
                            OptionInstance.cachedConstantTooltip(comment),
                            field.getBoolean(config),
                            v -> set(config, field, v)).createButton(options);

                } else if (type == int.class && field.isAnnotationPresent(RangedInt.class)
                        && field.getAnnotation(RangedInt.class).min() != Integer.MIN_VALUE
                        && field.getAnnotation(RangedInt.class).max() != Integer.MAX_VALUE) {
                    RangedInt r = field.getAnnotation(RangedInt.class);
                    OptionInstance.TooltipSupplier<Integer> tip = OptionInstance.cachedConstantTooltip(comment);
                    widget = new OptionInstance<Integer>(key, tip,
                            (caption, v) -> Options.genericValueLabel(caption, Component.literal(String.valueOf(v))),
                            new OptionInstance.IntRange(r.min(), r.max()),
                            field.getInt(config),
                            v -> set(config, field, v)).createButton(options);

                } else if (type == long.class && field.isAnnotationPresent(RangedLong.class)
                        && field.getAnnotation(RangedLong.class).min() != Long.MIN_VALUE
                        && field.getAnnotation(RangedLong.class).max() != Long.MAX_VALUE) {
                    RangedLong r = field.getAnnotation(RangedLong.class);
                    double min = r.min(), span = (double) r.max() - r.min();
                    widget = unitSlider(options, key, comment,
                            d -> Math.max(r.min(), Math.min(r.max(), Math.round(min + d * span))),
                            (Long v) -> (v - min) / span,
                            String::valueOf,
                            field.getLong(config), v -> set(config, field, v));

                } else if (type == double.class && field.isAnnotationPresent(RangedDouble.class)
                        && isFinite(field.getAnnotation(RangedDouble.class).min(), field.getAnnotation(RangedDouble.class).max())) {
                    RangedDouble r = field.getAnnotation(RangedDouble.class);
                    double span = r.max() - r.min();
                    widget = unitSlider(options, key, comment,
                            d -> r.min() + d * span,
                            (Double v) -> (v - r.min()) / span,
                            v -> String.format("%.2f", v),
                            field.getDouble(config), v -> set(config, field, v));

                } else if (type == float.class && field.isAnnotationPresent(RangedFloat.class)
                        && isFinite(field.getAnnotation(RangedFloat.class).min(), field.getAnnotation(RangedFloat.class).max())) {
                    RangedFloat r = field.getAnnotation(RangedFloat.class);
                    double span = (double) r.max() - r.min();
                    widget = unitSlider(options, key, comment,
                            d -> (float) (r.min() + d * span),
                            (Float v) -> (v - r.min()) / span,
                            v -> String.format("%.2f", v),
                            field.getFloat(config), v -> set(config, field, v));

                } else if (type == int.class || type == long.class || type == float.class
                        || type == double.class || type == String.class) {
                    widget = textBox(config, field, name, comment);
                }

                if (widget != null) widgets.add(widget);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return widgets;
    }

    protected static boolean isFinite(double min, double max) {
        return min > -Double.MAX_VALUE && max < Double.MAX_VALUE;
    }

    protected static <T> AbstractWidget unitSlider(Options options, String key, Component comment,
                                                 DoubleFunction<T> to, ToDoubleFunction<T> from,
                                                 Function<T, String> format, T initial, Consumer<T> onChange) {
        OptionInstance.TooltipSupplier<T> tip = OptionInstance.cachedConstantTooltip(comment);
        return new OptionInstance<T>(key, tip,
                (caption, v) -> Options.genericValueLabel(caption, Component.literal(format.apply(v))),
                OptionInstance.UnitDouble.INSTANCE.xmap(to, from),
                initial, onChange).createButton(options);
    }

    protected static <T> AbstractWidget textBox(T config, Field field, Component name, Component comment) throws IllegalAccessException {
        EditBox box = new EditBox(Minecraft.getInstance().font, 0, 0, 150, 20, name);
        box.setMaxLength(256);
        box.setHint(name);
        box.setTooltip(Tooltip.create(name.copy().append("\n").append(comment)));
        box.setValue(String.valueOf(field.get(config)));
        box.setResponder(text -> {
            try {
                set(config, field, parse(field, text));
                box.setTextColor(0xFFE0E0E0);
            } catch (Exception e) {
                box.setTextColor(0xFFFF5555);
            }
        });
        return box;
    }

    protected static Object parse(Field field, String text) {
        Class<?> type = field.getType();
        if (type == String.class) {
            Regex regex = field.getAnnotation(Regex.class);
            if (regex != null && !text.matches(regex.value())) throw new IllegalArgumentException();
            return text;
        }
        text = text.trim();
        if (type == int.class) {
            int v = Integer.parseInt(text);
            RangedInt r = field.getAnnotation(RangedInt.class);
            if (r != null && (v < r.min() || v > r.max())) throw new IllegalArgumentException();
            return v;
        } else if (type == long.class) {
            long v = Long.parseLong(text);
            RangedLong r = field.getAnnotation(RangedLong.class);
            if (r != null && (v < r.min() || v > r.max())) throw new IllegalArgumentException();
            return v;
        } else if (type == float.class) {
            float v = Float.parseFloat(text);
            RangedFloat r = field.getAnnotation(RangedFloat.class);
            if (r != null && (v < r.min() || v > r.max())) throw new IllegalArgumentException();
            return v;
        } else {
            double v = Double.parseDouble(text);
            RangedDouble r = field.getAnnotation(RangedDouble.class);
            if (r != null && (v < r.min() || v > r.max())) throw new IllegalArgumentException();
            return v;
        }
    }

    protected static <T> void set(T config, Field field, Object value) {
        try {
            field.set(config, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
