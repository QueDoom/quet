package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.world.item.Item;

public interface QTItemTagsImpl {

    // TODO FabricIntrinsicHolderTagsProvider#valueLookupBuilder() is protected, so use this code:
    /*
    for (Item bucket : QueTObjectStorage.buckets()) {
            valueLookupBuilder(ConventionalItemTags.BUCKETS)
                    .add(bucket);
    }
     */
    void addBuckets(FabricTagsProvider.FabricIntrinsicHolderTagsProvider<Item> provider);
}
