package net.quedoom.quet.datagen.models;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.List;

public record QTItemModelGenerators(ItemModelGenerators generators, String namespace) {
    public static QTItemModelGenerators of(ItemModelGenerators generators, String namespace) {
        return new QTItemModelGenerators(generators, namespace);
    }

    public void generate(Item item, ModelTemplate template) {
        generators.generateFlatItem(item, template);
    }

    public void generateGenerated(Item item) {
        generate(item, ModelTemplates.FLAT_ITEM);
    }
    public void generateHandheld(Item item) {
        generate(item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
    public void generateTrimmableArmor(Item item, ResourceKey<EquipmentAsset> key, Identifier prefix, boolean dyeable) {
        generators.generateTrimmableItem(item, key, prefix, dyeable);
    }
    public void generateTrimmableArmor(Item item, ResourceKey<EquipmentAsset> key, Identifier prefix) {
        generators.generateTrimmableItem(item, key, prefix, false);
    }

    public void generateHelmet(Item item, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_HELMET, dyeable);
    }
    public void generateHelmet(Item item, ResourceKey<EquipmentAsset> key) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_HELMET);
    }

    public void generateChestplate(Item item, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, dyeable);
    }
    public void generateChestplate(Item item, ResourceKey<EquipmentAsset> key) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
    }

    public void generateLeggings(Item item, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, dyeable);
    }
    public void generateLeggings(Item item, ResourceKey<EquipmentAsset> key) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
    }

    public void generateBoots(Item item, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_BOOTS, dyeable);
    }
    public void generateBoots(Item item, ResourceKey<EquipmentAsset> key) {
        generateTrimmableArmor(item, key, ItemModelGenerators.TRIM_PREFIX_BOOTS);
    }

    public void addFlatItems() {
        List<Item> automodels = QueTObjectStorage.automodel();
        if (automodels.isEmpty()) {
            new ModRegistrator(namespace).logInfo("No Autmodels registered in " + QTTranslationBuilder.snakeToTitleCase(namespace) + ". Skipping!");
            return;
        }
        for (Item autmodel : automodels) {
            generate(autmodel, ModelTemplates.FLAT_ITEM);
        }
    }
}
 