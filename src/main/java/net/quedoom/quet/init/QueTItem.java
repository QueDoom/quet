package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.FlowingFluid;
import net.quedoom.quet.QueT;

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

    protected static Item registerBucket(String name, FlowingFluid fluid, Item.Properties properties) {
        return register(create(name), p -> new BucketItem(fluid, p), properties.stacksTo(1));
    }
    protected static Item registerBucketStackable(String name, FlowingFluid fluid, Item.Properties properties) {
        return register(create(name), p -> new BucketItem(fluid, p), properties);
    }
    protected static Item registerBucket(String name, FlowingFluid fluid) {
        return registerBucket(name, fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET));
    }

    protected static Item registerSpawnEgg(String name, EntityType entity, Item.Properties properties) {
        return register(create(name), SpawnEggItem::new, properties.spawnEgg(entity));
    }
    protected static Item registerSpawnEgg(String name, EntityType entity) {
        return registerSpawnEgg(name, entity, new Item.Properties());
   }


    protected static ResourceKey<Item> create(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + QueTItem.class);
        }
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }
}
