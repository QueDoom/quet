package net.quedoom.quet.init.test;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.trading.VillagerTrade;
import net.quedoom.quet.datagen.tag.QueTVillagerTradeTagProvider;

import java.util.concurrent.CompletableFuture;

public class VillagerTags extends QueTVillagerTradeTagProvider {
    public VillagerTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

    }
}
