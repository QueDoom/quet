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
import org.jspecify.annotations.NonNull;

import java.util.Map;


public class QueTArmorMaterial extends ModRegistrator {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public QueTArmorMaterial(@NonNull String namespace) {
        super(namespace);
    }

    public ResourceKey<EquipmentAsset> create(String name) {
        return ResourceKey.create(REGISTRY_KEY, of(name));
    }

    /**
     * @param durability Max damage armor can take
     * @param defense Create using {@link ArmorMaterials#makeDefense(int, int, int, int, int)}
     */
    public ArmorMaterial register(ResourceKey<EquipmentAsset> key, int durability, Map<ArmorType, Integer> defense, int enchantmentValue, Holder<SoundEvent> equip,
                                            float toughness, float knockbackResistance, TagKey<Item> repairable) {
        return new ArmorMaterial(durability, defense, enchantmentValue, equip, toughness, knockbackResistance, repairable, key);
    }
    public ArmorMaterial register(ResourceKey<EquipmentAsset> key, int durability, Map<ArmorType, Integer> defense, int enchantmentValue, Holder<SoundEvent> equip, TagKey<Item> repairable) {
        return new ArmorMaterial(durability, defense, enchantmentValue, equip, 0F, 0F, repairable, key);
    }
}
