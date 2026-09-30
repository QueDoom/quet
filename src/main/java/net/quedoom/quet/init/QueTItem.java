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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.jspecify.annotations.NonNull;

import java.util.function.Function;

public class QueTItem extends ModRegistrator {
    public QueTItem(@NonNull String namespace) {
        super(namespace);
    }

    public Item register(String name) {
        return register(create(name), Item::new, new Item.Properties());
    }
    public Item register(String name, Item.Properties properties) {
        return register(create(name), Item::new, properties);
    }
    public Item register(ResourceKey<Item> key, Function<Item.Properties, Item> function) {
        return register(key, function, new Item.Properties());
    }
    public Item register(String stringKey, Function<Item.Properties, Item> function) {
        return register(create(stringKey), function, new Item.Properties());
    }
    public Item register(ResourceKey<Item> key) {
        return register(key, Item::new, new Item.Properties());
    }

    public Item register(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
        Item autoItem = Registry.register(BuiltInRegistries.ITEM, key, item);
        if (QTTranslationBuilder.SHOULD_AUTO_TRANSLATE_BY_DEFAULT) QueTObjectStorage.addAutotranslate(autoItem);
        return autoItem;
    }

    public Item register(String name, boolean autoTranslate) {
        return register(create(name), Item::new, new Item.Properties(), autoTranslate);
    }
    public Item register(String name, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), Item::new, properties, autoTranslate);
    }
    public Item register(ResourceKey<Item> key, Function<Item.Properties, Item> function, boolean autoTranslate) {
        return register(key, function, new Item.Properties(), autoTranslate);
    }
    public Item register(String stringKey, Function<Item.Properties, Item> function, boolean autoTranslate) {
        return register(create(stringKey), function, new Item.Properties(), autoTranslate);
    }
    public Item register(ResourceKey<Item> key, boolean autoTranslate) {
        return register(key, Item::new, new Item.Properties(), autoTranslate);
    }

    public Item register(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties, boolean autoTranslate) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
        Item autoItem = Registry.register(BuiltInRegistries.ITEM, key, item);
        if (autoTranslate) QueTObjectStorage.addAutotranslate(autoItem);
        return autoItem;
    }

    public Item registerBlock(String name, Block block, Item.Properties properties) {
        return register(create(name), p -> new BlockItem(block, p), properties);
    }
    public Item registerBlock(String name, Block block, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), p -> new BlockItem(block, p), properties, autoTranslate);
    }

    public Item registerSeedOrBush(String name, Block block) {
        return registerBlock(name, block, new Item.Properties().useBlockDescriptionPrefix());
    }
    public Item registerSeedOrBush(String name, Block block, boolean autoTranslate) {
        return registerBlock(name, block, new Item.Properties().useBlockDescriptionPrefix(), autoTranslate);
    }
    public Item registerWaterCrop(String name, Block block) {
        return register(create(name), p -> new PlaceOnWaterBlockItem(block, p), new Item.Properties().useBlockDescriptionPrefix());
    }

    public Item registerBucket(String name, FlowingFluid fluid, Item.Properties properties) {
        Item bucket = register(create(name), p -> new BucketItem(fluid, p), properties.stacksTo(1));
        QueTObjectStorage.addBucket(bucket);
        return bucket;
    }
    public Item registerBucketStackable(String name, FlowingFluid fluid, Item.Properties properties) {
        return register(create(name), p -> new BucketItem(fluid, p), properties);
    }
    public Item registerBucket(String name, FlowingFluid fluid) {
        return registerBucket(name, fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET));
    }
    public Item registerBucket(String name, FlowingFluid fluid, Item.Properties properties, boolean autoTranslate) {
        Item bucket = register(create(name), p -> new BucketItem(fluid, p), properties.stacksTo(1), autoTranslate);
        QueTObjectStorage.addBucket(bucket);
        return bucket;
    }
    public Item registerBucketStackable(String name, FlowingFluid fluid, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), p -> new BucketItem(fluid, p), properties, autoTranslate);
    }
    public Item registerBucket(String name, FlowingFluid fluid, boolean autoTranslate) {
        return registerBucket(name, fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET), autoTranslate);
    }

    public Item registerSpawnEgg(String name, EntityType entity, Item.Properties properties) {
        return register(create(name), SpawnEggItem::new, properties.spawnEgg(entity));
    }
    public Item registerSpawnEgg(String name, EntityType entity) {
        return registerSpawnEgg(name, entity, new Item.Properties());
    }
    public Item registerSpawnEgg(String name, EntityType entity, Item.Properties properties, boolean autoTranslate) {
        return register(create(name), SpawnEggItem::new, properties.spawnEgg(entity), autoTranslate);
    }
    public Item registerSpawnEgg(String name, EntityType entity, boolean autoTranslate) {
        return registerSpawnEgg(name, entity, new Item.Properties(), autoTranslate);
    }

    public Item registerFood(String name, FoodProperties food, Consumable consumable) {
        return register(name, p -> new Item(p.food(food, consumable)));
    }
    public Item registerFood(String name, FoodProperties food, Consumable consumable, boolean autoTranslate) {
        return register(name, p -> new Item(p.food(food, consumable)), autoTranslate);
    }

    public Item registerSword(String name, ToolMaterial material) {
        Item item = register(name, new Item.Properties().sword(material, 3.0F, -2.4F).stacksTo(1));
        QueTObjectStorage.addSword(item);
        return item;
    }
    public Item registerSpear(String name, ToolMaterial material, float attackDuration, float damageMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float damageTime) {
        Item item = register(name, new Item.Properties().spear(material, attackDuration, damageMultiplier, delay, dismountTime, dismountThreshold, knockbackTime, 5.1F, damageTime, 4.5F));;
        QueTObjectStorage.addSpear(item);
        return item;
    }
    public Item registerPickaxe(String name, ToolMaterial material) {
        Item item = register(name, new Item.Properties().pickaxe(material, 1.0F, -2.8F).stacksTo(1));;
        QueTObjectStorage.addPickaxe(item);
        return item;
    }
    public Item registerAxe(String name, ToolMaterial material) {
        Item item = register(create(name), p -> new AxeItem(material, 6.0F, -3.2F, p));;
        QueTObjectStorage.addAxe(item);
        return item;
    }
    public Item registerShovel(String name, ToolMaterial material) {
        Item item = register(create(name), p -> new ShovelItem(material, 1.5F, -3.0F, p));;
        QueTObjectStorage.addShovel(item);
        return item;
    }
    public Item registerHoe(String name, ToolMaterial material) {
        Item item = register(create(name), p -> new HoeItem(material, 0.0F, -3.0F, p));;
        QueTObjectStorage.addHoe(item);
        return item;
    }
    public Item registerBow(String name) {
        Item item = register(create(name), BowItem::new);;
        QueTObjectStorage.addBow(item);
        return item;
    }
    public Item registerCrossbow(String name) {
        Item item = register(create(name), CrossbowItem::new);;
        QueTObjectStorage.addCrossbow(item);
        return item;
    }
    public Item registerSword(String name, ToolMaterial material, boolean autoTranslate) {
        Item item = register(name, new Item.Properties().sword(material, 3.0F, -2.4F).stacksTo(1), autoTranslate);;
        QueTObjectStorage.addSword(item);
        return item;
    }
    public Item registerSpear(String name, ToolMaterial material, float attackDuration, float damageMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float damageTime, boolean autoTranslate) {
        Item item = register(name, new Item.Properties().spear(material, attackDuration, damageMultiplier, delay, dismountTime, dismountThreshold, knockbackTime, 5.1F, damageTime, 4.5F), autoTranslate);;
        QueTObjectStorage.addSpear(item);
        return item;
    }
    public Item registerPickaxe(String name, ToolMaterial material, boolean autoTranslate) {
        Item item = register(name, new Item.Properties().pickaxe(material, 1.0F, -2.8F).stacksTo(1), autoTranslate);;
        QueTObjectStorage.addPickaxe(item);
        return item;
    }
    public Item registerAxe(String name, ToolMaterial material, boolean autoTranslate) {
        Item item = register(create(name), p -> new AxeItem(material, 6.0F, -3.2F, p), autoTranslate);;
        QueTObjectStorage.addAxe(item);
        return item;
    }
    public Item registerShovel(String name, ToolMaterial material, boolean autoTranslate) {
        Item item = register(create(name), p -> new ShovelItem(material, 1.5F, -3.0F, p), autoTranslate);;
        QueTObjectStorage.addShovel(item);
        return item;
    }
    public Item registerHoe(String name, ToolMaterial material, boolean autoTranslate) {
        Item item = register(create(name), p -> new HoeItem(material, 0.0F, -3.0F, p), autoTranslate);;
        QueTObjectStorage.addHoe(item);
        return item;
    }
    public Item registerBow(String name, boolean autoTranslate) {
        Item item = register(create(name), BowItem::new, autoTranslate);;
        QueTObjectStorage.addBow(item);
        return item;
    }
    public Item registerCrossbow(String name, boolean autoTranslate) {
        Item item = register(create(name), CrossbowItem::new, autoTranslate);;
        QueTObjectStorage.addCrossbow(item);
        return item;
    }

    public Item registerArmor(String name, ArmorMaterial material, ArmorType type) {
        return register(create(name), Item::new, new Item.Properties().humanoidArmor(material, type));
    }
    public Item registerHelmet(String name, ArmorMaterial material) {
        Item helmet = registerArmor(name, material, ArmorType.HELMET);
        QueTObjectStorage.addHelmet(helmet);
        return helmet;
    }
    public Item registerChestplate(String name, ArmorMaterial material) {
        Item chestplate = registerArmor(name, material, ArmorType.CHESTPLATE);
        QueTObjectStorage.addChestplate(chestplate);
        return chestplate;
    }
    public Item registerLeggings(String name, ArmorMaterial material) {
        Item leggings = registerArmor(name, material, ArmorType.LEGGINGS);
        QueTObjectStorage.addLeggings(leggings);
        return leggings;
    }
    public Item registerBoots(String name, ArmorMaterial material) {
        Item boots = registerArmor(name, material, ArmorType.BOOTS);
        QueTObjectStorage.addBoots(boots);
        return boots;
    }
    public Item registerHorseArmor(String name, ArmorMaterial material) {
        Item horseArmor = register(create(name), Item::new, new Item.Properties().horseArmor(material));
        QueTObjectStorage.addHorseArmor(horseArmor);
        return horseArmor;
    }
    public Item registerWolfArmor(String name, ArmorMaterial material) {
        Item wolfArmor = register(create(name), Item::new, new Item.Properties().wolfArmor(material));
        QueTObjectStorage.addWolfArmor(wolfArmor);
        return wolfArmor;
    }
    public Item registerArmor(String name, ArmorMaterial material, ArmorType type, boolean autoTranslate) {
        return register(create(name), Item::new, new Item.Properties().humanoidArmor(material, type), autoTranslate);
    }
    public Item registerHelmet(String name, ArmorMaterial material, boolean autoTranslate) {
        Item helmet = registerArmor(name, material, ArmorType.HELMET, autoTranslate);
        QueTObjectStorage.addHelmet(helmet);
        return helmet;
    }
    public Item registerChestplate(String name, ArmorMaterial material, boolean autoTranslate) {
        Item chestplate = registerArmor(name, material, ArmorType.CHESTPLATE, autoTranslate);
        QueTObjectStorage.addChestplate(chestplate);
        return chestplate;
    }
    public Item registerLeggings(String name, ArmorMaterial material, boolean autoTranslate) {
        Item leggings = registerArmor(name, material, ArmorType.LEGGINGS, autoTranslate);
        QueTObjectStorage.addLeggings(leggings);
        return leggings;
    }
    public Item registerBoots(String name, ArmorMaterial material, boolean autoTranslate) {
        Item boots = registerArmor(name, material, ArmorType.BOOTS, autoTranslate);
        QueTObjectStorage.addBoots(boots);
        return boots;
    }
    public Item registerHorseArmor(String name, ArmorMaterial material, boolean autoTranslate) {
        Item horseArmor = register(create(name), Item::new, new Item.Properties().horseArmor(material), autoTranslate);
        QueTObjectStorage.addHorseArmor(horseArmor);
        return horseArmor;
    }
    public Item registerWolfArmor(String name, ArmorMaterial material, boolean autoTranslate) {
        Item wolfArmor = register(create(name), Item::new, new Item.Properties().wolfArmor(material), autoTranslate);
        QueTObjectStorage.addWolfArmor(wolfArmor);
        return wolfArmor;
    }

    public Item registerShears(String name, int maxDamage) {
        Item item = register(create(name), ShearsItem::new, new Item.Properties().durability(maxDamage).component(DataComponents.TOOL, ShearsItem.createToolProperties()));
        QueTObjectStorage.addShear(item);
        return item;
    }
    public Item registerShears(String name) {
        return registerShears(name, 238);
    }
    public Item registerShears(String name, int maxDamage, boolean autoTranslate) {
        Item item = register(create(name), ShearsItem::new, new Item.Properties().durability(maxDamage).component(DataComponents.TOOL, ShearsItem.createToolProperties()), autoTranslate);
        QueTObjectStorage.addShear(item);
        return item;
    }
    public Item registerShears(String name, boolean autoTranslate) {
        return registerShears(name, 238, autoTranslate);
    }

    public Item registerBrush(String name, int maxDamage) {
        Item item = register(create(name), BrushItem::new, new Item.Properties().durability(maxDamage));
        QueTObjectStorage.addBrush(item);
        return item;
    }
    public Item registerBrush(String name) {
        return registerBrush(name, 64);
    }
    public Item registerBrush(String name, int maxDamage, boolean autoTranslate) {
        Item item = register(create(name), BrushItem::new, new Item.Properties().durability(maxDamage), autoTranslate);
        QueTObjectStorage.addBrush(item);
        return item;
    }
    public Item registerBrush(String name, boolean autoTranslate) {
        return registerBrush(name, 64, autoTranslate);
    }

    public Item registerMusicDisc(String name, ResourceKey<JukeboxSong> song) {
        return register(create(name), Item::new, new Item.Properties().jukeboxPlayable(song).stacksTo(1).rarity(Rarity.RARE));
    }

    public Item registerMusicDisc(String name, ResourceKey<JukeboxSong> song, boolean autoTranslate) {
        return register(create(name), Item::new, new Item.Properties().jukeboxPlayable(song).stacksTo(1).rarity(Rarity.RARE), autoTranslate);
    }

    public ResourceKey<Item> create(String name) {
    return ResourceKey.create(Registries.ITEM, of(name));
    }
}
