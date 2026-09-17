package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.misc.PathMethods;
import net.quedoom.quet.misc.QueTObjectStorage;

public record AutoTranslate(FabricLanguageProvider.TranslationBuilder builder, String namespace) implements PathMethods {

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

    public void add(CreativeModeTab tab) {
        String tabName = QueTObjectStorage.tabName(tab);
        String translateLeft = namespace + ".creativeModeTab." + tabName;
        this.builder.add(translateLeft, snakeToTitleCase(tabName));

    }

    public void translateAllTabs() {
        for (CreativeModeTab tab : QueTObjectStorage.getAllTabs()) {
            add(tab);
        }
    }

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