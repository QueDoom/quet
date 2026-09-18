package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.quedoom.quet.datagen.tag.QTItemTagProvider;

import java.util.concurrent.CompletableFuture;

public class TagProvider extends QTItemTagProvider {
    public TagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        addBuckets();
    }
}
