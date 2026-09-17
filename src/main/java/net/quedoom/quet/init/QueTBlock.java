package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Function;

public class QueTBlock extends ModRegistrator{
    protected static Block registerStair(String name, Block block) {
        return register(name, p -> new StairBlock(block.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(block));
    }

    protected static Item registerItem(String name, Block block, Item.Properties properties) {
        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, properties);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
    }

    protected static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(properties.setId(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }
    protected static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(properties.setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    protected static Block register(String name, BlockBehaviour.Properties properies) {
        return register(name, Block::new, properies);
    }

    protected static Block registerFluid(String name, FlowingFluid fluid) {
        return registerFluid(name, fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER));
    }

    protected static Block registerFluid(String name, FlowingFluid fluid, BlockBehaviour.Properties properties) {
        return register(name,
                p -> new LiquidBlock(fluid, p),
                properties,false
        );
    }

    protected static ResourceKey<Block> keyOfBlock(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    protected static ResourceKey<Item> keyOfItem(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    public static void registerBlocks() {

    }
}
