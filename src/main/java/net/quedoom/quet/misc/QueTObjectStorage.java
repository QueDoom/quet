package net.quedoom.quet.misc;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.Map;

public class QueTObjectStorage {

    private static List<Item> REGISTERED_BUCKETS = List.of();
    public static void addBucket(Item item) {
        if (!(item instanceof BucketItem)) return;
        REGISTERED_BUCKETS.add(item);
    }
    public static List<Item> buckets() {return REGISTERED_BUCKETS;}

    private static Map<CreativeModeTab, String> CREATIVE_MODE_TABS = Map.of();
    private static List<CreativeModeTab> CREATIVE_MODE_TABS_LIST = List.of();
    public static String tabName(CreativeModeTab tab) {
        return CREATIVE_MODE_TABS.get(tab);
    }
    public static List<CreativeModeTab> getAllTabs() {
        return CREATIVE_MODE_TABS_LIST;
    }
    public static void addTab(CreativeModeTab tab, String name) {
        CREATIVE_MODE_TABS.put(tab, name);
        CREATIVE_MODE_TABS_LIST.add(tab);
    }

}
