package net.quedoom.quet.misc;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.quedoom.quet.datagen.tag.QTItemTagProvider;

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
        AUTOTRANSLATE_ITEMS = new ArrayList<>();
        REGISTERED_SWORDS = new ArrayList<>();
        REGISTERED_AXES = new ArrayList<>();
        REGISTERED_PICKAXES = new ArrayList<>();
        REGISTERED_SHOVELS = new ArrayList<>();
        REGISTERED_HOES = new ArrayList<>();
        REGISTERED_SPEARS = new ArrayList<>();
    }

    //region Autotranslate
    private static List<Item> AUTOTRANSLATE_ITEMS = new ArrayList<>();
    public static void addAutotranslate(Item item) {
        AUTOTRANSLATE_ITEMS.add(item);
    }
    public static List<Item> autotranslateItems() {
        return AUTOTRANSLATE_ITEMS;
    }
    //endregion Autotranslate

    //region Buckets
    /**
     * All {@link BucketItem}s registered with QueTItem#registerBucket() gets added to the list and will be added to the tag Buckets
     * if you extend {@link QTItemTagProvider} instead of {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider.ItemTagsProvider}
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

    //endregion Armor

    //region Tools and Weapons
    private static List<Item> REGISTERED_SWORDS = new ArrayList<>();
    private static List<Item> REGISTERED_PICKAXES = new ArrayList<>();
    private static List<Item> REGISTERED_SHOVELS = new ArrayList<>();
    private static List<Item> REGISTERED_AXES = new ArrayList<>();
    private static List<Item> REGISTERED_HOES = new ArrayList<>();
    private static List<Item> REGISTERED_SPEARS = new ArrayList<>();

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

    //endregion Tools and Weapons

}
