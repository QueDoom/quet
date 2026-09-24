package net.quedoom.quet.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.block.CompleteWoodSet;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class QueTBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public QueTBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    protected void add(CompleteWoodSet woodSet) {
        valueLookupBuilder(woodSet.BLOCK_LOG_TAG)
                .add(
                        woodSet.LOG,
                        woodSet.STRIPPED,
                        woodSet.WOOD,
                        woodSet.STRIPPED_WOOD
                );
        if (woodSet.isOverwoldAndNatural) valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(woodSet.LOG);
    }

    protected void addCrops() {
        List<Block> crops = QueTObjectStorage.crops();

        for (Block crop : crops) {
            valueLookupBuilder(BlockTags.CROPS)
                    .add(crop);
        }
    }

    protected void woodSetGen(CompleteWoodSet woodSet, TagKey<Block> blockTagKey) {
        valueLookupBuilder(BlockTags.LOGS)
                .add(
                        woodSet.LOG,
                        woodSet.STRIPPED,
                        woodSet.WOOD,
                        woodSet.STRIPPED_WOOD
                );
        valueLookupBuilder(blockTagKey)
                .add(
                        woodSet.LOG,
                        woodSet.STRIPPED,
                        woodSet.WOOD,
                        woodSet.STRIPPED_WOOD
                );
        valueLookupBuilder(BlockTags.PLANKS)
                .add(
                        woodSet.PLANK
                );
                valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(
                        woodSet.SLAB
                );
                valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(
                        woodSet.STAIRS
                );
                if (woodSet.FENCE != null) {
                    valueLookupBuilder(BlockTags.FENCES)
                            .add(
                                    woodSet.FENCE
                            );
                }
                if (woodSet.GATE != null) {
                    valueLookupBuilder(BlockTags.FENCE_GATES)
                            .add(
                                    woodSet.GATE
                            );
                }
                if (woodSet.TRAPDOOR != null) {
                    valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                            .add(
                                    woodSet.TRAPDOOR
                            );
                }
                if (woodSet.DOOR != null) {
                    valueLookupBuilder(BlockTags.WOODEN_DOORS)
                            .add(
                                    woodSet.DOOR
                            );
                }
                if (woodSet.PRESSURE_PLATE != null) {
                    valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                            .add(
                                    woodSet.PRESSURE_PLATE
                            );
                }
    }

}
