package net.quedoom.quet.misc;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.quedoom.quet.datagen.tag.QueTItemTagProvider;

import java.util.ArrayList;
import java.util.List;

public class QueTObjectStorage {
    public static boolean HAS_CLEARED = false;

    /**
     * You can clear the storage if you want to :) <br>
     * You can call it at the end of the DataGenerator class
     */
    public static void clear() {
        HAS_CLEARED = true;
        REGISTERED_BUCKETS = new ArrayList<>();
        CREATIVE_MODE_TABS_LIST = new ArrayList<>();
        REGISTERED_HELMETS = new ArrayList<>();
        REGISTERED_CHESTPLATES = new ArrayList<>();
        REGISTERED_LEGGINGS = new ArrayList<>();
        REGISTERED_BOOTS = new ArrayList<>();
        REGISTERED_HORSE_ARMOR = new ArrayList<>();
        REGISTERED_WOLF_ARMOR = new ArrayList<>();
        AUTOTRANSLATE_ITEMS = new ArrayList<>();
        REGISTERED_SWORDS = new ArrayList<>();
        REGISTERED_AXES = new ArrayList<>();
        REGISTERED_PICKAXES = new ArrayList<>();
        REGISTERED_SHOVELS = new ArrayList<>();
        REGISTERED_HOES = new ArrayList<>();
        REGISTERED_SPEARS = new ArrayList<>();
        REGISTERED_SHEARS = new ArrayList<>();
        REGISTERED_BRUSHES = new ArrayList<>();
        REGISTERED_BOWS = new ArrayList<>();
        REGISTERED_CROSSBOWS = new ArrayList<>();
        REGISTERED_CROPS = new ArrayList<>();
        REGISTERED_MUSIC_DISCS = new ArrayList<>();
    }

    //region Misc Items

    private static List<Item> REGISTERED_MUSIC_DISCS = new ArrayList<>();

    public static List<Item> discs() {
        return REGISTERED_MUSIC_DISCS;
    }

    public static void addDisc(Item discItem) {
        REGISTERED_MUSIC_DISCS.add(discItem);
    }

    //endregion Misc Items

    //region Autotranslate
    private static List<Item> AUTOTRANSLATE_ITEMS = new ArrayList<>();
    public static void addAutotranslate(Item item) {
        AUTOTRANSLATE_ITEMS.add(item);
    }
    public static List<Item> autotranslateItems() {
        return AUTOTRANSLATE_ITEMS;
    }
    //endregion Autotranslate

    //region Blocks
    private static List<Block> REGISTERED_CROPS = new ArrayList<>();

    public static List<Block> crops() {
        return REGISTERED_CROPS;
    }

    public static void addCrop(Block block) {
        REGISTERED_CROPS.add(block);
    }

    //endregion Blocks

    //region Buckets
    /**
     * All {@link BucketItem}s registered with QueTItem#registerBucket() gets added to the list and will be added to the tag Buckets
     * if you extend {@link QueTItemTagProvider} instead of {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider.ItemTagsProvider}
     */
    private static List<Item> REGISTERED_BUCKETS = new ArrayList<>();
    public static void addBucket(Item item) {
        REGISTERED_BUCKETS.add(item);
    }
    public static List<Item> buckets() {return REGISTERED_BUCKETS;}
    //endregion Buckets

    //region Tabs
    private static List<ResourceKey<CreativeModeTab>> CREATIVE_MODE_TABS_LIST = new ArrayList<>();
    public static List<ResourceKey<CreativeModeTab>> getTabs() {
        return CREATIVE_MODE_TABS_LIST;
    }

    public static void addTab(ResourceKey<CreativeModeTab> tab) {
        CREATIVE_MODE_TABS_LIST.add(tab);
    }
    //endregion Tabs

    //region Armor
    private static List<Item> REGISTERED_HELMETS = new ArrayList<>();
    private static List<Item> REGISTERED_CHESTPLATES = new ArrayList<>();
    private static List<Item> REGISTERED_LEGGINGS = new ArrayList<>();
    private static List<Item> REGISTERED_BOOTS = new ArrayList<>();
    private static List<Item> REGISTERED_HORSE_ARMOR = new ArrayList<>();
    private static List<Item> REGISTERED_WOLF_ARMOR = new ArrayList<>();

    public static List<Item> helmets() {
        return REGISTERED_HELMETS;
    }
    public static List<Item> chestplates() {
        return REGISTERED_CHESTPLATES;
    }
    public static List<Item> leggings() {
        return REGISTERED_LEGGINGS;
    }
    public static List<Item> boots() {
        return REGISTERED_BOOTS;
    }
    public static List<Item> horse_armors() {
        return REGISTERED_HORSE_ARMOR;
    }
    public static List<Item> wolf_armors() {
        return REGISTERED_WOLF_ARMOR;
    }

    public static void addHelmet(Item item) {
        REGISTERED_HELMETS.add(item);
    }
    public static void addChestplate(Item item) {
        REGISTERED_CHESTPLATES.add(item);
    }
    public static void addLeggings(Item item) {
        REGISTERED_LEGGINGS.add(item);
    }
    public static void addBoots(Item item) {
        REGISTERED_BOOTS.add(item);
    }
    public static void addHumanoidArmor(Item helmet, Item chestplate, Item leggings, Item boots) {
        addHelmet(helmet);
        addChestplate(chestplate);
        addLeggings(leggings);
        addBoots(boots);
    }
    public static void addHorseArmor(Item item) {
        REGISTERED_HORSE_ARMOR.add(item);
    }
    public static void addWolfArmor(Item item) {
        REGISTERED_WOLF_ARMOR.add(item);
    }
    //endregion Armor

    //region Tools and Weapons
    private static List<Item> REGISTERED_SWORDS = new ArrayList<>();
    private static List<Item> REGISTERED_PICKAXES = new ArrayList<>();
    private static List<Item> REGISTERED_SHOVELS = new ArrayList<>();
    private static List<Item> REGISTERED_AXES = new ArrayList<>();
    private static List<Item> REGISTERED_HOES = new ArrayList<>();
    private static List<Item> REGISTERED_SPEARS = new ArrayList<>();
    private static List<Item> REGISTERED_SHEARS = new ArrayList<>();
    private static List<Item> REGISTERED_BRUSHES = new ArrayList<>();
    private static List<Item> REGISTERED_BOWS = new ArrayList<>();
    private static List<Item> REGISTERED_CROSSBOWS = new ArrayList<>();

    public static List<Item> swords() {
        return REGISTERED_SWORDS;
    }
    public static List<Item> pickaxes() {
        return REGISTERED_PICKAXES;
    }
    public static List<Item> axes() {
        return REGISTERED_AXES;
    }
    public static List<Item> shovels() {
        return REGISTERED_SHOVELS;
    }
    public static List<Item> hoes() {
        return REGISTERED_HOES;
    }
    public static List<Item> spears() {
        return REGISTERED_SPEARS;
    }
    public static List<Item> shears() {
        return REGISTERED_SHEARS;
    }
    public static List<Item> brushes() {
        return REGISTERED_BRUSHES;
    }
    public static List<Item> bows() {
        return REGISTERED_BOWS;
    }
    public static List<Item> crossbows() {
        return REGISTERED_CROSSBOWS;
    }

    public static void addSword(Item item) {
        REGISTERED_SWORDS.add(item);
    }
    public static void addAxe(Item item) {
        REGISTERED_AXES.add(item);
    }
    public static void addPickaxe(Item item) {
        REGISTERED_PICKAXES.add(item);
    }
    public static void addHoe(Item item) {
        REGISTERED_HOES.add(item);
    }
    public static void addShovel(Item item) {
        REGISTERED_SHOVELS.add(item);
    }
    public static void addSpear(Item item) {
        REGISTERED_SPEARS.add(item);
    }
    public static void addShear(Item item) {
        REGISTERED_SHEARS.add(item);
    }
    public static void addBrush(Item item) {
        REGISTERED_BRUSHES.add(item);
    }
    public static void addBow(Item item) {
        REGISTERED_BOWS.add(item);
    }
    public static void addCrossbow(Item item) {
        REGISTERED_CROSSBOWS.add(item);
    }

    //endregion Tools and Weapons

}
