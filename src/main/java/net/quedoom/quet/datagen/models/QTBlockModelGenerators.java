package net.quedoom.quet.datagen.models;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;

public record QTBlockModelGenerators(BlockModelGenerators generators) {
    public static QTBlockModelGenerators of(BlockModelGenerators generators) {
        return new QTBlockModelGenerators(generators);
    }

    public void createBushBlock(Block block) {
        this.generators.createCrossBlock(block, BlockModelGenerators.PlantType.NOT_TINTED,
                SweetBerryBushBlock.AGE, 0, 1, 3);
    }
}
