package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.quedoom.quet.QueTDataGenerator;
import net.quedoom.quet.block.ConfigurableLampBlock;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.jspecify.annotations.NonNull;

import java.util.function.Function;

public class QueTBlock extends ModRegistrator{
    public QueTBlock(@NonNull String namespace) {
        super(namespace);
    }

    public Block registerStair(String name, Block baseBlock) {
        return register(name, p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    public Block registerStair(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }

    public Block registerSlab(String name, Block baseBlock) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    public Block registerSlab(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }

    public Block registerButton(String name, BlockSetType type, int ticksToStayPressed) {
        return register(name, p -> new ButtonBlock(type, ticksToStayPressed, p), Blocks.buttonProperties());
    }
    public Block registerButton(String name, BlockSetType type, int ticksToStayPressed, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, ticksToStayPressed, p), Blocks.buttonProperties(), shouldRegisterItem);
    }
    public Block registerButton(String name, BlockSetType type, int ticksToStayPressed, MapColor color) {
        return register(name, p -> new ButtonBlock(type, ticksToStayPressed, p), Blocks.buttonProperties().mapColor(color));
    }
    public Block registerButton(String name, BlockSetType type, int ticksToStayPressed, MapColor color, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, ticksToStayPressed, p), Blocks.buttonProperties().mapColor(color), shouldRegisterItem);
    }
    public Block registerStoneButton(String name, BlockSetType type) {
        return register(name, p -> new ButtonBlock(type, 20, p), Blocks.buttonProperties());
    }
    public Block registerStoneButton(String name, BlockSetType type, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, 20, p), Blocks.buttonProperties(), shouldRegisterItem);
    }
    public Block registerStoneButton(String name, BlockSetType type, MapColor color) {
        return register(name, p -> new ButtonBlock(type, 20, p), Blocks.buttonProperties().mapColor(color));
    }
    public Block registerStoneButton(String name, BlockSetType type, MapColor color, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, 20, p), Blocks.buttonProperties().mapColor(color), shouldRegisterItem);
    }
    public Block registerWoodenButton(String name, BlockSetType type) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties());
    }
    public Block registerWoodenButton(String name, BlockSetType type, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties(), shouldRegisterItem);
    }
    public Block registerWoodenButton(String name, BlockSetType type, MapColor color) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties().mapColor(color));
    }
    public Block registerWoodenButton(String name, BlockSetType type, MapColor color, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties().mapColor(color), shouldRegisterItem);
    }
    public Block registerLever(String name) {
        return register(name, LeverBlock::new, Blocks.buttonProperties());
    }
    public Block registerLever(String name, boolean shouldRegisterItem) {
        return register(name, LeverBlock::new, Blocks.buttonProperties(), shouldRegisterItem);
    }

    public Block registerPressurePlate(String name, BlockSetType type, MapColor mapColor) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(mapColor));
    }
    public Block registerPressurePlate(String name, BlockSetType type, MapColor mapColor, boolean shouldRegisterItem) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(mapColor), shouldRegisterItem);
    }
    public Block registerPressurePlate(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(baseBlock.defaultMapColor()));
    }
    public Block registerPressurePlate(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(baseBlock.defaultMapColor()), shouldRegisterItem);
    }

    public Block registerFence(String name, Block baseBlock) {
        return register(name, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    public Block registerFence(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    public Block registerFenceGate(String name, WoodType type, Block baseBlock) {
        return register(name, p -> new FenceGateBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    public Block registerFenceGate(String name, WoodType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new FenceGateBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    public Block registerWall(String name, Block baseBlock) {
        return register(name, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    public Block registerWall(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }

    public Block registerDoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new DoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock)
                .pushReaction(PushReaction.DESTROY).strength(3.0F).noOcclusion());
    }
    public Block registerDoor(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new DoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock)
                .pushReaction(PushReaction.DESTROY).strength(3.0F).noOcclusion(), shouldRegisterItem);
    }
    public Block registerTrapdoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new TrapDoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).noOcclusion().isValidSpawn(Blocks::never));
    }
    public Block registerTrapdoor(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new TrapDoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).noOcclusion().isValidSpawn(Blocks::never), shouldRegisterItem);
    }

    public Block registerLamplike(String name, int ticksToTurnOff, BlockBehaviour.Properties properties) {
        return register(name, p -> new ConfigurableLampBlock(p, ticksToTurnOff), properties);
    }
    public Block registerLamplike(String name, int ticksToTurnOff, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        return register(name, p -> new ConfigurableLampBlock(p, ticksToTurnOff), properties, shouldRegisterItem);
    }

    public Block registerCrop(String name, Function<BlockBehaviour.Properties, Block> block) {
        Block cropBlock = register(name, block, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES), false);
        QueTObjectStorage.addCrop(cropBlock);
        return cropBlock;
    }

    public Block registerBush(String name, Function<BlockBehaviour.Properties, Block> block) {
        Block cropBlock = register(name, block, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH), false);
//        QueTObjectStorage.addCrop(cropBlock);
        return cropBlock;
    }

    public Block registerShelf(String name, Block baseBlock) {
        return register(name, ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }

    public Item registerItem(String name, Block block, Item.Properties properties) {
        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, properties);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
    }

    public Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
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
    public Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(properties.setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public Block register(String name, BlockBehaviour.Properties properies) {
        return register(name, Block::new, properies);
    }

    public Block registerFluid(String name, FlowingFluid fluid) {
        return registerFluid(name, fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER));
    }
    public Block registerFluid(String name, FlowingFluid fluid, BlockBehaviour.Properties properties) {
        return register(name,
                p -> new LiquidBlock(fluid, p),
                properties,false
        );
    }

    public ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, of(name));
    }

    public ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, of(name));
    }

    public static void registerBlocks() {

    }
}
