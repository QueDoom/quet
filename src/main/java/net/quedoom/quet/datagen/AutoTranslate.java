package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.LocalizedGetPath;
import net.quedoom.quet.misc.QueTObjectStorage;

public record AutoTranslate(FabricLanguageProvider.TranslationBuilder builder, String namespace) implements LocalizedGetPath {

    public static AutoTranslate of(FabricLanguageProvider.TranslationBuilder builder, String namespace) {
        return new AutoTranslate(builder, namespace);
    }

    public void add(Block block) {
        String snakeCase = getPath(block);
        this.builder.add(block, snakeToTitleCase(snakeCase));
    }
    public void add(Item item) {
        String snakeCase = getPath(item);
        this.builder.add(item, snakeToTitleCase(snakeCase));
    }
    public void add(TagKey<?> tag) {
        String translateLeft = tag.getTranslationKey();
        String snakeCase = getPath(tag);
        this.builder.add(translateLeft, snakeToTitleCase(snakeCase));
    }

    public void add(ResourceKey<CreativeModeTab> tab) {
        String translateLeft = namespace + ".creativeModeTab." + tab.identifier().getNamespace();
        this.builder.add(translateLeft, snakeToTitleCase(tab.identifier().getNamespace()));

    }

    public void translateAllTabs() {
        for (ResourceKey<CreativeModeTab> tab : QueTObjectStorage.getTabs()) {
            add(tab);
        }
    }

    public void addTooltip(Item item, String translation) {
        this.builder.add("tooltip." + ModRegistrator.namespace() + getPath(item), translation);
    }

    /**
     * Takes a string (snake_case) and makes it Title Case
     * @param snakeCase The string to make Title Case (example_string)
     * @return The Title Case version of the parameter
     */
    private String snakeToTitleCase(String snakeCase) {
        String replaceUnderscores = snakeCase.replace('_', ' ');
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