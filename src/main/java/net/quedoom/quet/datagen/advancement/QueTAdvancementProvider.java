package net.quedoom.quet.datagen.advancement;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class QueTAdvancementProvider extends FabricAdvancementProvider {
    protected QueTAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        generateAdvancement(registryLookup, consumer, new QTAdvancementHolderConsumer(consumer));
    }

    public abstract void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer, QTAdvancementHolderConsumer qtConsumer);
}
