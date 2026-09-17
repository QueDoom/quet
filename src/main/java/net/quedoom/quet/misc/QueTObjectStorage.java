package net.quedoom.quet.misc;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.FlowingFluid;
import net.quedoom.quet.datagen.AutoTranslate;

import java.util.List;
import java.util.Map;

public class QueTObjectStorage {

    /**
     * All {@link BucketItem}s registered with QueTItem#registerBucket() gets added to the list and will be added to the tag Buckets
     * if you implement the {@link net.quedoom.quet.init.QueTTag.QTItemTags} and make the propper method.
     */
    private static List<Item> REGISTERED_BUCKETS = List.of();
    public static void addBucket(Item item) {
        if (!(item instanceof BucketItem)) return;
        REGISTERED_BUCKETS.add(item);
    }
    public static List<Item> buckets() {return REGISTERED_BUCKETS;}


    private static List<ResourceKey<CreativeModeTab>> CREATIVE_MODE_TABS_LIST = List.of();
    public static List<ResourceKey<CreativeModeTab>> getTabs() {
        return CREATIVE_MODE_TABS_LIST;
    }

    public static void addTab(ResourceKey<CreativeModeTab> tab) {
        CREATIVE_MODE_TABS_LIST.add(tab);
    }

}
