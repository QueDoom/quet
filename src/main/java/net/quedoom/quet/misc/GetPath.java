package net.quedoom.quet.misc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GetPath {
    /**
     * Takes a Block, Item or Tag and gives the path of it <br>
     * Example: Blocks.DIRT -> minecraft:dirt -> dirt
     *
     * @return The path of the inputted Block, Item or Tag
     */
    public static String get(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public static String get(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public static String get(TagKey<?> tagKey) {
        return tagKey.location().getPath();
    }

}
