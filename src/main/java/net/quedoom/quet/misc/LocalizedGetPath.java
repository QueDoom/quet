package net.quedoom.quet.misc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface LocalizedGetPath {

    /**
     * Does the same thing as {@link GetPath} but you have to implement it into your class. <br>
     * This makes it so you don't have to type anything before the getPath() (which looks nicer/is slightly faster).
     */
    default String getPath(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    default String getPath(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    default String getPath(TagKey<?> tagKey) {
        return tagKey.location().getPath();
    }
}
