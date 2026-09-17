package net.quedoom.quet.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;


public class QueTArmorMaterial extends ModRegistrator {
    protected static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    protected static ResourceKey<EquipmentAsset> create(String name) {
        return ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    /**
     * @param durability Max damage armor can take
     * @param defense Create using {@link ArmorMaterials#makeDefense(int, int, int, int, int)}
     */
    protected static ArmorMaterial register(ResourceKey<EquipmentAsset> key, int durability, Map<ArmorType, Integer> defense, int enchantmentValue, Holder<SoundEvent> equip,
                                            float toughness, float knockbackResistance, TagKey<Item> repairable) {
        return new ArmorMaterial(durability, defense, enchantmentValue, equip, toughness, knockbackResistance, repairable, key);
    }
    protected static ArmorMaterial register(ResourceKey<EquipmentAsset> key, int durability, Map<ArmorType, Integer> defense, int enchantmentValue, Holder<SoundEvent> equip, TagKey<Item> repairable) {
        return new ArmorMaterial(durability, defense, enchantmentValue, equip, 0F, 0F, repairable, key);
    }
}
