package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.material.FlowingFluid;
import net.quedoom.quet.QueT;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.Properties;
import java.util.function.Function;

public class QueTItem extends ModRegistrator {
    protected static Item register(String name) {
        return register(create(name), Item::new, new Item.Properties());
    }
    protected static Item register(String name, Item.Properties properties) {
        return register(create(name), Item::new, properties);
    }
    protected static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> function) {
        return register(key, function, new Item.Properties());
    }
    protected static Item register(String stringKey, Function<Item.Properties, Item> function) {
        return register(create(stringKey), function, new Item.Properties());
    }
    protected static Item register(ResourceKey<Item> key) {
        return register(key, Item::new, new Item.Properties());
    }

    protected static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    protected static Item register(String name, boolean autoTranslate) {
        return register(create(name), Item::new, new Item.Properties(), autoTranslate);
    }
    protected static Item register(String name, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), Item::new, properties, autoTranslate);
    }
    protected static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> function, boolean autoTranslate) {
        return register(key, function, new Item.Properties(), autoTranslate);
    }
    protected static Item register(String stringKey, Function<Item.Properties, Item> function, boolean autoTranslate) {
        return register(create(stringKey), function, new Item.Properties(), autoTranslate);
    }
    protected static Item register(ResourceKey<Item> key, boolean autoTranslate) {
        return register(key, Item::new, new Item.Properties(), autoTranslate);
    }

    protected static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties, boolean autoTranslate) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
        Item autoItem = Registry.register(BuiltInRegistries.ITEM, key, item);
        if (autoTranslate) QueTObjectStorage.addAutotranslate(autoItem);
        return autoItem;
    }

    protected static Item registerBucket(String name, FlowingFluid fluid, Item.Properties properties) {
        Item bucket = register(create(name), p -> new BucketItem(fluid, p), properties.stacksTo(1));
        QueTObjectStorage.addBucket(bucket);
        return bucket;
    }
    protected static Item registerBucketStackable(String name, FlowingFluid fluid, Item.Properties properties) {
        return register(create(name), p -> new BucketItem(fluid, p), properties);
    }
    protected static Item registerBucket(String name, FlowingFluid fluid) {
        return registerBucket(name, fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET));
    }
    protected static Item registerBucket(String name, FlowingFluid fluid, Item.Properties properties, boolean autoTranslate) {
        Item bucket = register(create(name), p -> new BucketItem(fluid, p), properties.stacksTo(1), autoTranslate);
        QueTObjectStorage.addBucket(bucket);
        return bucket;
    }
    protected static Item registerBucketStackable(String name, FlowingFluid fluid, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), p -> new BucketItem(fluid, p), properties, autoTranslate);
    }
    protected static Item registerBucket(String name, FlowingFluid fluid, boolean autoTranslate) {
        return registerBucket(name, fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET), autoTranslate);
    }

    protected static Item registerSpawnEgg(String name, EntityType entity, Item.Properties properties) {
        return register(create(name), SpawnEggItem::new, properties.spawnEgg(entity));
    }
    protected static Item registerSpawnEgg(String name, EntityType entity) {
        return registerSpawnEgg(name, entity, new Item.Properties());
    }
    protected static Item registerSpawnEgg(String name, EntityType entity, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), SpawnEggItem::new, properties.spawnEgg(entity), autoTranslate);
    }
    protected static Item registerSpawnEgg(String name, EntityType entity, boolean autoTranslate) {
        return registerSpawnEgg(name, entity, new Item.Properties(), autoTranslate);
    }

    protected static Item registerFood(String name, FoodProperties food, Consumable consumable) {
        return register(name, p -> new Item(p.food(food, consumable)));
    }
    protected static Item registerFood(String name, FoodProperties food, Consumable consumable, boolean autoTranslate) {
        return register(name, p -> new Item(p.food(food, consumable)), autoTranslate);
    }

    protected static Item registerSword(String name, ToolMaterial material) {
        return register(name, new Item.Properties().sword(material, 3.0F, -2.4F).stacksTo(1));
    }
    protected static Item registerSpear(String name, ToolMaterial material, float attackDuration, float damageMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float damageTime) {
        return register(name, new Item.Properties().spear(material, attackDuration, damageMultiplier, delay, dismountTime, dismountThreshold, knockbackTime, 5.1F, damageTime, 4.5F));
    }
    protected static Item registerPickaxe(String name, ToolMaterial material) {
        return register(name, new Item.Properties().pickaxe(material, 1.0F, -2.8F).stacksTo(1));
    }
    protected static Item registerAxe(String name, ToolMaterial material) {
        return register(create(name), p -> new AxeItem(material, 6.0F, -3.2F, p));
    }
    protected static Item registerShovel(String name, ToolMaterial material) {
        return register(create(name), p -> new ShovelItem(material, 1.5F, -3.0F, p));
    }
    protected static Item registerHoe(String name, ToolMaterial material) {
        return register(create(name), p -> new HoeItem(material, 0.0F, -3.0F, p));
    }
    protected static Item registerSword(String name, ToolMaterial material, boolean autoTranslate) {
        return register(name, new Item.Properties().sword(material, 3.0F, -2.4F).stacksTo(1), autoTranslate);
    }
    protected static Item registerSpear(String name, ToolMaterial material, float attackDuration, float damageMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float damageTime, boolean autoTranslate) {
        return register(name, new Item.Properties().spear(material, attackDuration, damageMultiplier, delay, dismountTime, dismountThreshold, knockbackTime, 5.1F, damageTime, 4.5F), autoTranslate);
    }
    protected static Item registerPickaxe(String name, ToolMaterial material, boolean autoTranslate) {
        return register(name, new Item.Properties().pickaxe(material, 1.0F, -2.8F).stacksTo(1), autoTranslate);
    }
    protected static Item registerAxe(String name, ToolMaterial material, boolean autoTranslate) {
        return register(create(name), p -> new AxeItem(material, 6.0F, -3.2F, p), autoTranslate);
    }
    protected static Item registerShovel(String name, ToolMaterial material, boolean autoTranslate) {
        return register(create(name), p -> new ShovelItem(material, 1.5F, -3.0F, p), autoTranslate);
    }
    protected static Item registerHoe(String name, ToolMaterial material, boolean autoTranslate) {
        return register(create(name), p -> new HoeItem(material, 0.0F, -3.0F, p), autoTranslate);
    }

    protected static Item registerArmor(String name, ArmorMaterial material, ArmorType type) {
        return register(create(name), Item::new, new Item.Properties().humanoidArmor(material, type));
    }
    protected static Item registerHelmet(String name, ArmorMaterial material) {
        Item helmet = registerArmor(name, material, ArmorType.HELMET);
        QueTObjectStorage.addHelmet(helmet);
        return helmet;
    }
    protected static Item registerChestplate(String name, ArmorMaterial material) {
        Item chestplate = registerArmor(name, material, ArmorType.CHESTPLATE);
        QueTObjectStorage.addChestplate(chestplate);
        return chestplate;
    }
    protected static Item registerLeggings(String name, ArmorMaterial material) {
        Item leggings = registerArmor(name, material, ArmorType.LEGGINGS);
        QueTObjectStorage.addLeggings(leggings);
        return leggings;
    }
    protected static Item registerBoots(String name, ArmorMaterial material) {
        Item boots = registerArmor(name, material, ArmorType.BOOTS);
        QueTObjectStorage.addBoots(boots);
        return boots;
    }
    protected static Item registerArmor(String name, ArmorMaterial material, ArmorType type, boolean autoTranslate) {
        return register(create(name), Item::new, new Item.Properties().humanoidArmor(material, type), autoTranslate);
    }
    protected static Item registerHelmet(String name, ArmorMaterial material, boolean autoTranslate) {
        Item helmet = registerArmor(name, material, ArmorType.HELMET, autoTranslate);
        QueTObjectStorage.addHelmet(helmet);
        return helmet;
    }
    protected static Item registerChestplate(String name, ArmorMaterial material, boolean autoTranslate) {
        Item chestplate = registerArmor(name, material, ArmorType.CHESTPLATE, autoTranslate);
        QueTObjectStorage.addChestplate(chestplate);
        return chestplate;
    }
    protected static Item registerLeggings(String name, ArmorMaterial material, boolean autoTranslate) {
        Item leggings = registerArmor(name, material, ArmorType.LEGGINGS, autoTranslate);
        QueTObjectStorage.addLeggings(leggings);
        return leggings;
    }
    protected static Item registerBoots(String name, ArmorMaterial material, boolean autoTranslate) {
        Item boots = registerArmor(name, material, ArmorType.BOOTS, autoTranslate);
        QueTObjectStorage.addBoots(boots);
        return boots;
    }

    protected static Item registerShears(String name, int maxDamage) {
        return register(create(name), ShearsItem::new, new Item.Properties().durability(maxDamage).component(DataComponents.TOOL, ShearsItem.createToolProperties()));
    }
    protected static Item registerShears(String name) {
        return registerShears(name, 238);
    }
    protected static Item registerShears(String name, int maxDamage, boolean autoTranslate) {
        return register(create(name), ShearsItem::new, new Item.Properties().durability(maxDamage).component(DataComponents.TOOL, ShearsItem.createToolProperties()), autoTranslate);
    }
    protected static Item registerShears(String name, boolean autoTranslate) {
        return registerShears(name, 238, autoTranslate);
    }

    protected static Item registerBrush(String name, int maxDamage) {
        return register(create(name), BrushItem::new, new Item.Properties().durability(maxDamage));
    }
    protected static Item registerBrush(String name) {
        return registerBrush(name, 64);
    }
    protected static Item registerBrush(String name, int maxDamage, boolean autoTranslate) {
        return register(create(name), BrushItem::new, new Item.Properties().durability(maxDamage), autoTranslate);
    }
    protected static Item registerBrush(String name, boolean autoTranslate) {
        return registerBrush(name, 64, autoTranslate);
    }


        protected static ResourceKey<Item> create(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + QueTItem.class);
        }
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }
}
