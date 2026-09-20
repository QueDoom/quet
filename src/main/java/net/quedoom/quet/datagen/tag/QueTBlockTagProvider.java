package net.quedoom.quet.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class QueTBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public QueTBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    protected void addCrops() {
        List<Block> crops = QueTObjectStorage.crops();

        for (Block crop : crops) {
            valueLookupBuilder(BlockTags.CROPS)
                    .add(crop);
        }
    }

}
