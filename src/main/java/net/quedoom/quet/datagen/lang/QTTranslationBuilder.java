package net.quedoom.quet.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.LocalizedGetPath;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.List;

public record QTTranslationBuilder(FabricLanguageProvider.TranslationBuilder builder, String namespace) implements LocalizedGetPath {
    public static boolean SHOULD_AUTO_TRANSLATE_BY_DEFAULT = false;

    public static QTTranslationBuilder of(FabricLanguageProvider.TranslationBuilder builder, String namespace) {
        return new QTTranslationBuilder(builder, namespace);
    }

    public void auto(Block block) {
        String snakeCase = getPath(block);
        this.builder.add(block, snakeToTitleCase(snakeCase));
    }
    public void auto(Item item) {
        String snakeCase = getPath(item);
        this.builder.add(item, snakeToTitleCase(snakeCase));
    }
    public void auto(TagKey<?> tag) {
        String translateLeft = tag.getTranslationKey();
        String snakeCase = getPath(tag);
        this.builder.add(translateLeft, snakeToTitleCase(snakeCase));
    }

    public void auto(ResourceKey<CreativeModeTab> tab) {
        String translateLeft = namespace + ".creativeModeTab." + tab.identifier().getNamespace();
        this.builder.add(translateLeft, snakeToTitleCase(tab.identifier().getNamespace()));
    }


    public void addEffect(String name, String title, String description) {
        String translateLeft = "effect." + namespace + '.' + name;
        this.builder.add(translateLeft, title);
        this.builder.add(translateLeft, description);
    }

    public void addDisc(SoundEvent event, String title, String desc) {
        this.builder.add(event.location().toLanguageKey("jukebox_song"), title);
        this.builder.add(event.location().toLanguageKey("jukebox_song", "desc"), desc);
    }

    public void auto(Holder.Reference<Potion> potion) {
        add(potion, snakeToTitleCase(potion.key().identifier().getPath()));
    }

    public void add(Holder.Reference<Potion> potion, String translation) {
        builder.add(potion.key().identifier(), translation);
    }

    public void auto(DamageSource source) {
        add(source, snakeToTitleCase(source.type().deathMessageType().getSerializedName()));
    }

    public void add(DamageSource source, String translation) {
        builder.add(source.type().deathMessageType().getSerializedName(), translation);
    }

    /**
     * Auto translates all items set to be auto translated. <br>
     * You can add items to the list by appending true while registering items. <br>
     * <strong>Is automatically called if you extend {@link QueTLanguageProvider}</strong> <br>
     * Example: register("name", true);
     */
    public void autotranslateInStorage() {
        List<Item> items = QueTObjectStorage.autotranslateItems();
        List<Block> blocks = QueTObjectStorage.autotranslateBlocks();
        if (items.isEmpty()) {
            new ModRegistrator(namespace).logInfo("No Items set to be auto translated in " + QTTranslationBuilder.snakeToTitleCase(namespace + ". Skipping!"));
        } else {
            for (Item item : items) {
                auto(item);
            }
        }
        if (blocks.isEmpty()) {
            new ModRegistrator(namespace).logInfo("No Items set to be auto translated in " + QTTranslationBuilder.snakeToTitleCase(namespace) + ". Skipping!");
        } else {
            for (Block block : blocks ) {
                auto(block);
            }
        }
    }

    public void translateAllTabs() {
        List<ResourceKey<CreativeModeTab>> tabs = QueTObjectStorage.getTabs();
        if (tabs.isEmpty()) {
            new ModRegistrator(namespace).logInfo("No tabs registered in " + QTTranslationBuilder.snakeToTitleCase(namespace) + ". Skipping!");
            return;
        }
        for (ResourceKey<CreativeModeTab> tab : tabs) {
            auto(tab);
        }
    }

    public void addTooltip(Item item, String translation) {
        this.builder.add("tooltip." + namespace + getPath(item), translation);
    }

    public void addPaintingTitle(ResourceKey<PaintingVariant> key, String translation) {
        this.builder.add(key.identifier().toLanguageKey("painting", "title"), translation);
    }
    public void addPaintingAuthor(ResourceKey<PaintingVariant> key, String translation) {
        this.builder.add(key.identifier().toLanguageKey("painting", "author"), translation);
    }
    public void addPainting(ResourceKey<PaintingVariant> key, String title, String author) {
        addPaintingTitle(key, title);
        addPaintingAuthor(key, author);
    }

    public void addStat(String name, String translation) {
        this.builder.add(Identifier.fromNamespaceAndPath(namespace, name).toLanguageKey("stat"), translation);
    }

    /**
     * Takes a string (snake_case) and makes it Title Case
     * @param snakeCase The string to make Title Case (example_string)
     * @return The Title Case version of the parameter
     */
    public static String snakeToTitleCase(String snakeCase) {
        String replaceDashes = snakeCase.replace('-', ' ');
        String replaceUnderscores = replaceDashes.replace('_', ' ');
        String[] words = replaceUnderscores.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

}