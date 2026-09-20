package net.quedoom.quet.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class QueTPaintingTagProvider extends FabricTagsProvider<PaintingVariant> {
    public QueTPaintingTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        for (ResourceKey<PaintingVariant> key : getPaintings()) {
            getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
                    .add(TagEntry.element(key.identifier()));
        }
    }

    protected abstract List<ResourceKey<PaintingVariant>> getPaintings();
}
