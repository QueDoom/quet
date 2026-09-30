package net.quedoom.quet.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public class QueTToolMaterial {
    public static ToolMaterial register(TagKey<Block> incorrectBlocks,
                                           int durability,
                                           float speed,
                                           float attackDamageBonus,
                                           int enchantmentValue, TagKey<Item> repairable) {
        return new ToolMaterial(incorrectBlocks, durability, speed, attackDamageBonus, enchantmentValue, repairable);
    }

    public static ToolMaterial registerNetheriteLike(TagKey<Block> incorrectBlocks, float speed, TagKey<Item> repairable) {
        return register(incorrectBlocks, 2031, speed, 4.0F, 15, repairable);
    }
    public static ToolMaterial registerNetheriteLike(float speed, TagKey<Item> repairable) {
        return registerNetheriteLike(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, speed, repairable);
    }
}
