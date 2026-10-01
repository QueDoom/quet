package net.quedoom.quet.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.VillagerTrade;
import net.quedoom.quet.villager.QTVillagerTrade;

import java.util.concurrent.CompletableFuture;

public abstract class QueTVillagerTradeTagProvider extends FabricTagsProvider<VillagerTrade> {
    public QueTVillagerTradeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
    }

    protected abstract String getNamepace();

    protected void add(TagKey<VillagerTrade> tradeTagKey, QTVillagerTrade qtTrade) {
        getOrCreateRawBuilder(tradeTagKey)
                .add(TagEntry.element(qtTrade.key(getNamepace()).identifier()));
    }

    protected void add(TagKey<VillagerTrade> tradeTagKey, QTVillagerTrade... qtTrades) {
        for (QTVillagerTrade qtTrade : qtTrades) {
            add(tradeTagKey, qtTrade);
        }
    }

    protected void add(QTVillagerTrade qtTrade) {
        getOrCreateRawBuilder(qtTrade.tag())
                .add(TagEntry.element(qtTrade.key(getNamepace()).identifier()));
    }

    protected void add(QTVillagerTrade... qtVillagerTrades) {
        for (QTVillagerTrade qtTrade : qtVillagerTrades) {
            add(qtTrade);
        }
    }
}
