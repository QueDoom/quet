package net.quedoom.quet.datagen.advancement;

import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.QTLogger;

import java.util.function.Consumer;

public record QTAdvancementHolderConsumer(Consumer<AdvancementHolder> consumer, ModRegistrator modRegistrator) {
    
    public QTAdvancementHolderConsumer(Consumer<AdvancementHolder> consumer, String namespace) {
        this(consumer, new ModRegistrator(namespace));
    }

    public QTAdvancement.Builder builderWithoutParent(ItemLike display, String pageName, String name, AdvancementType type, boolean showToast, boolean announceToChat) {
        return new QTAdvancement.Builder(
                Advancement.Builder.advancement().display(
                        display,
                        modRegistrator.translatable("advancementTitle", name),
                        modRegistrator.translatable("advancementDescription", name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        showToast,
                        announceToChat,
                        false
                        ),
                name, modRegistrator.namespace(), pageName
        );
    }
    public QTAdvancement.Builder builder(QTAdvancement parent, ItemLike display, String name, AdvancementType type,
                                         boolean showToast, boolean announceChat, boolean hidden) {
        return new QTAdvancement.Builder(
                Advancement.Builder.advancement().display(
                        display,
                        modRegistrator.translatable("advancementTitle", name),
                        modRegistrator.translatable("advancementDescription", name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        showToast,
                        announceChat,
                        hidden
                        )
                        .parent(parent.holder()),
                name, modRegistrator.namespace(), parent.pageName
        );
    }
    public QTAdvancement.Builder builder(QTAdvancement parent, ItemLike display, String name, AdvancementType type,
                                         boolean showToast, boolean announceChat) {
        return new QTAdvancement.Builder(
                Advancement.Builder.advancement().display(
                        display,
                        modRegistrator.translatable("advancementTitle", name),
                        modRegistrator.translatable("advancementDescription", name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        showToast,
                        announceChat,
                        false
                        )
                        .parent(parent.holder()),
                name, modRegistrator.namespace(), parent.pageName
        );
    }
    public QTAdvancement.Builder builderSuperHidden(QTAdvancement parent, ItemLike display, String name, AdvancementType type) {
        return new QTAdvancement.Builder(
                Advancement.Builder.advancement().display(
                        display,
                        modRegistrator.translatable("advancementTitle", name),
                        modRegistrator.translatable("advancementDescription", name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        false,
                        false,
                        false
                        )
                        .parent(parent.holder()),
                name, modRegistrator.namespace(), parent.pageName
        );
    }
    public QTAdvancement.Builder builder(QTAdvancement parent, ItemLike display, String name, AdvancementType type) {
        return new QTAdvancement.Builder(
                Advancement.Builder.advancement().display(
                        display,
                        modRegistrator.translatable("advancementTitle", name),
                        modRegistrator.translatable("advancementDescription", name),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        type,
                        true,
                        true,
                        false
                        )
                        .parent(parent.holder()),
                name, modRegistrator.namespace(), parent.pageName
        );
    }
}
