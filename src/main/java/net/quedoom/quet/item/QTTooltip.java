package net.quedoom.quet.item;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.quedoom.quet.datagen.lang.AutoTranslate;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.LocalizedGetPath;
import net.quedoom.quet.misc.GetPath;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public record QTTooltip(Consumer<Component> builder, @Nullable Item item) implements LocalizedGetPath {
    public static final String SHIFT = "tooltip.quet.standard.press_shift";
    public static final String CONTROL = "tooltip.quet.standard.press_control";
    public static final String ALT = "tooltip.quet.standard.press_alt";

    public static QTTooltip of(Consumer<Component> builder, @NonNull Item item) {
        return new QTTooltip(builder, item);
    }
    public static QTTooltip of(Consumer<Component> builder) {
        return new QTTooltip(builder, null);
    }

    public static void addStatic(Consumer<Component> builder, Item item) {
        builder.accept(Component.translatable("tooltip." + ModRegistrator.namespace() + GetPath.get(item)));
    }
    public static void addStaticCustomKey(Consumer<Component> builder, String key) {
        builder.accept(Component.translatable(key));
    }

    public static void addStaticLiteral(Consumer<Component> builder, String name) {
        builder.accept(Component.literal(name));
    }

    /**
     * Adds a tooltip to the item: <br>
     * It requires you to translate the following key ({@link AutoTranslate} has a method for this)
     *
     * @param item Determines what the key will look like (example: "tooltip.namespace.item")
     */
    public void addStatic(Item item) {
        addStatic(this.builder, item);
    }
    public void addStatic() {
        if (item == null) throw new NullPointerException("You need to call QTTooltip#addStatic(Item item) instead (add an item to the tooltip)");
        addStatic(this.item);
    }

    /**
     * Adds a tooltip to the item: <br>
     * It requires you to translate the key
     *
     * @param key The key that you have to translate
     */
    public void addStaticCustomKey(String key) {
        addStaticCustomKey(this.builder, key);
    }
    /**
     * Adds a tooltip to the item: <br>
     * @param name The text of the Tooltip
     */
    public void addStaticLiteral(String name) {
        addStaticLiteral(this.builder, name);
    }


    /**
     * Adds a tooltip to the item: <br>
     * If you create a new QTTooltip using the {@link QTTooltip#of(Consumer, Item)} method that has both
     * and {@link Item} and a Builder
     * you can use the method {@link QTTooltip#addShift()} (or other keys) <br>
     * This makes it easy to add tooltips that have a "hidden" message if you do a specific action (example: press a key)
     * <br> <br>
     * @param pressed           Condition for if it should hide the ful tooltip (usually a key)
     * @param builder           Is not needed if you instantiate the class (recommended)
     * @param customNonShiftKey The key when the condition is false
     * @param item              Item used to automatically create a translation key
     */
    public static void addShowIf(boolean pressed, Consumer<Component> builder, String customNonShiftKey, Item item) {
        if (pressed)
            builder.accept(Component.translatable("tooltip." + ModRegistrator.namespace() + GetPath.get(item)));
        else
            builder.accept(Component.translatable(customNonShiftKey));
    }

    public void addShowIf(boolean pressed, String customNonShiftKey, Item item) {
        addShowIf(pressed, this.builder, customNonShiftKey, item);
    }

    /**
     * @throws NullPointerException Since the record does not require an Item in order to instantiate it is possible to call this method when it is null, this will prevent this for this and other methods alike
     */
    public void addShowIf(boolean pressed, String customNonShiftKey) {
        if (item == null) throw new NullPointerException("You need to call QTTooltip#addShowIf(boolean pressed, String customNonShiftKey, Item item) instead (add an item to the tooltip)");
        addShowIf(pressed, this.builder, customNonShiftKey, item);
    }


    public static void addShift(Consumer<Component> builder, String customNonShiftKey, Item item) {
        addShowIf(Minecraft.getInstance().hasShiftDown(), builder, customNonShiftKey, item);
    }
    public static void addShift(Consumer<Component> builder, Item item) {
        addShift(builder, SHIFT, item);
    }

    public static void addControl(Consumer<Component> builder, String customNonControlKey, Item item) {
        addShowIf(Minecraft.getInstance().hasControlDown(), builder, customNonControlKey, item);
    }
    public static void addControl(Consumer<Component> builder, Item item) {
        addControl(builder, CONTROL, item);
    }

    public static void addAlt(Consumer<Component> builder, String customNonAltKey, Item item) {
        addShowIf(Minecraft.getInstance().hasAltDown(), builder, customNonAltKey, item);
    }
    public static void addAlt(Consumer<Component> builder, Item item) {
        addAlt(builder, ALT, item);
    }


    public void addShift(String customNonShiftKey, Item item) {
        addShowIf(Minecraft.getInstance().hasShiftDown(), customNonShiftKey, item);
    }
    public void addShift(Item item) {
        addShift(SHIFT, item);
    }
    public void addShift(String customNonShiftKey) {
        if (item == null)
            throw new NullPointerException("You need to call QTTooltip#addShift(String customNonShiftKey, Item item) instead (add an item to the tooltip)");
        addShift(customNonShiftKey, this.item);
    }
    public void addShift() {
        if (item == null) throw new NullPointerException("You need to call QTTooltip#addShift(Item item) instead (add an item to the tooltip)");
        addShift(SHIFT, this.item);
    }

    public void addControl(String customNonShiftKey, Item item) {
        addShowIf(Minecraft.getInstance().hasControlDown(), customNonShiftKey, item);
    }
    public void addControl(Item item) {
        addControl(CONTROL, item);
    }
    public void addControl(String customNonShiftKey) {
        if (item == null)
            throw new NullPointerException("You need to call QTTooltip#addControl(String customNonShiftKey, Item item) instead (add an item to the tooltip)");
        addControl(customNonShiftKey, this.item);
    }
    public void addControl() {
        if (item == null) throw new NullPointerException("You need to call QTTooltip#addControl(Item item) instead (add an item to the tooltip)");
        addControl(CONTROL, this.item);
    }

    public void addAlt(String customNonShiftKey, Item item) {
        addShowIf(Minecraft.getInstance().hasAltDown(), customNonShiftKey, item);
    }
    public void addAlt(Item item) {
        addAlt(ALT, item);
    }
    public void addAlt(String customNonShiftKey) {
        if (item == null)
            throw new NullPointerException("You need to call QTTooltip#addAlt(String customNonShiftKey, Item item) instead (add an item to the tooltip)");
        addAlt(customNonShiftKey, this.item);
    }
    public void addAlt() {
        if (item == null) throw new NullPointerException("You need to call QTTooltip#addAlt(Item item) instead (add an item to the tooltip)");
        addAlt(ALT, this.item);
    }

//  All the methods in between are the same with some parameters already inputted
}
