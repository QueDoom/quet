package net.quedoom.quet.datagen.advancement;

import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.quedoom.quet.init.ModRegistrator;

import java.util.function.Consumer;

public record QTAdvancementHolderConsumer(Consumer<AdvancementHolder> consumer) {
    private AdvancementHolder newRewardsHolder(Item item, String name,
                                                      AdvancementType type, Criterion<?> trigger, AdvancementRewards.Builder rewards) {
        return Advancement.Builder.advancement()
                .display(
                        item,
                        ModRegistrator.translatable("advancement", "title." + name),
                        ModRegistrator.translatable("advancement", "description." + name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        true,
                        true,
                        false
                )
                .rewards(rewards)
                .addCriterion(name, trigger).save(consumer, ModRegistrator.of(name));
    }

    private AdvancementHolder newRewardsHolder(Item item, String name,
                                                      AdvancementType type, Criterion<?> trigger, AdvancementRewards.Builder rewards, AdvancementHolder parent) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        item,
                        ModRegistrator.translatable("advancement", "title." + name),
                        ModRegistrator.translatable("advancement", "description." + name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        true,
                        true,
                        false
                )
                .rewards(rewards)
                .addCriterion(name, trigger).save(consumer, ModRegistrator.of(name));
    }

    private AdvancementHolder newItemPickupHolder(Item item, String name,
                                                         AdvancementType type) {
        return newHolder(item, name, type,
                InventoryChangeTrigger.TriggerInstance.hasItems(item));
    }

    private AdvancementHolder newItemPickupHolder(Item item, String name,
                                                         AdvancementType type, AdvancementHolder parent) {
        return newHolder(item, name, type,
                InventoryChangeTrigger.TriggerInstance.hasItems(item), parent);
    }

    private AdvancementHolder newHolder(Item item, String name,
                                               AdvancementType type, Criterion<?> trigger) {
        return Advancement.Builder.advancement()
                .display(
                        item,
                        ModRegistrator.translatable("advancement", "title." + name),
                        ModRegistrator.translatable("advancement", "description." + name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        true,
                        true,
                        false
                ).addCriterion(name, trigger).save(consumer, ModRegistrator.of(name));
    }
    private AdvancementHolder newHolder(Item item, String name,
                                               AdvancementType type, Criterion<?> trigger, AdvancementHolder parent) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        item,
                        ModRegistrator.translatable("advancement", "title." + name),
                        ModRegistrator.translatable("advancement", "description." + name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        true,
                        true,
                        false
                ).addCriterion(name, trigger).save(consumer, ModRegistrator.of(name));
    }
}
