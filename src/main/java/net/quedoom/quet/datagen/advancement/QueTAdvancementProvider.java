package net.quedoom.quet.datagen.advancement;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class QueTAdvancementProvider extends FabricAdvancementProvider {
    public QueTAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    protected abstract String namespace();

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        generateAdvancements(registryLookup, consumer, new QTAdvancementHolderConsumer(consumer, namespace()));
    }

    public abstract void generateAdvancements(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer, QTAdvancementHolderConsumer qtConsumer);

    protected static Criterion<InventoryChangeTrigger.TriggerInstance> singleItemTrigger(Item item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

}
