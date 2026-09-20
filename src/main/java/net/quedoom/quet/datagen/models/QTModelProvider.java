package net.quedoom.quet.datagen.models;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public abstract class QTModelProvider extends FabricModelProvider {
    public QTModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        generateItemModels(itemModelGenerators, QTItemModelGenerators.of(itemModelGenerators));
    }

    public abstract void generateItemModels(ItemModelGenerators itemModelGenerators, QTItemModelGenerators qtItemModelGenerators);

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        generateBlockStateModels(blockModelGenerators, QTBlockModelGenerators.of(blockModelGenerators));
    }

    public abstract void generateBlockStateModels(BlockModelGenerators blockModelGenerators, QTBlockModelGenerators qtBlockModelGenerators);
}
