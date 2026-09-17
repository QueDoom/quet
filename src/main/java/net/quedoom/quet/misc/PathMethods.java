package net.quedoom.quet.misc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface PathMethods {
    public default String getPath(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public default String getPath(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public default String getPath(TagKey<?> tagKey) {
        return tagKey.location().getPath();
    }
}
