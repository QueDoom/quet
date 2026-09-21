package net.quedoom.quet.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.init.QueTTag;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.function.Function;

public class CompleteWoodSet {
    public final Block LOG;
    public final Block STRIPPED;
    public final Block WOOD;
    public final Block STRIPPED_WOOD;
    public final Block PLANK;
    public final Block STAIRS;
    public final Block SLAB;
    public final Block SHELF;
    public final @Nullable Block SIGN;
    public final @Nullable Block HANGING_SIGN;
    public final @Nullable Block FENCE;
    public final @Nullable Block GATE;
    public final @Nullable Block TRAPDOOR;
    public final @Nullable Block DOOR;
    public final @Nullable Block PRESSURE_PLATE;
    public final @Nullable Block BUTTON;

    private String name = null;

    private CompleteWoodSet(String name, @NotNull Block log, @NotNull Block stripped, @NotNull Block wood,
                            @NotNull Block strippedWood, @NotNull Block plank, @NotNull Block stairs,
                            @NotNull Block slab, @NotNull Block shelf, @Nullable Block sign, @Nullable Block hangingSign,
                            @Nullable Block fence, @Nullable Block gate, @Nullable Block trapdoor,
                            @Nullable Block door, @Nullable Block pressurePlate, @Nullable Block button) {
        this.name = name;
        this.LOG = log;
        this.STRIPPED = stripped;
        this.WOOD = wood;
        this.STRIPPED_WOOD = strippedWood;
        this.PLANK = plank;
        this.STAIRS = stairs;
        this.SLAB = slab;
        this.SHELF = shelf;
        this.SIGN = sign;
        this.HANGING_SIGN = hangingSign;
        this.FENCE = fence;
        this.GATE = gate;
        this.TRAPDOOR = trapdoor;
        this.DOOR = door;
        this.PRESSURE_PLATE = pressurePlate;
        this.BUTTON = button;
    }


    public CompleteWoodSet set(String name, @NotNull Block log, @NotNull Block stripped, @NotNull Block wood, @NotNull Block strippedWood, @NotNull Block plank, @NotNull Block stairs, @NotNull Block slab, @NotNull Block shelf, @Nullable Block sign, @Nullable Block hangingSign, @Nullable Block fence, @Nullable Block gate, @Nullable Block trapdoor, @Nullable Block door, @Nullable Block pressurePlate, @Nullable Block button) {
        return new CompleteWoodSet(name, log, stripped, wood, strippedWood, plank, stairs, slab, shelf, sign, hangingSign, fence, gate, trapdoor, door, pressurePlate, button);
    }

    public void recipeGen(RecipeProvider provider) {
        provider.planksFromLog(PLANK, LOG_TAG_ITEM, 4);
        provider.woodFromLogs(WOOD, LOG);
        provider.woodFromLogs(STRIPPED_WOOD, STRIPPED);
        provider.slab(RecipeCategory.BUILDING_BLOCKS, SLAB, PLANK);
        provider.stairBuilder(STAIRS, Ingredient.of(PLANK)).save(provider.output);
        provider.shelf(SHELF, STRIPPED);
        if (SIGN != null) {
            provider.signBuilder(SIGN, Ingredient.of(PLANK));
        }
        if (HANGING_SIGN != null) {
            provider.hangingSign(HANGING_SIGN, STRIPPED);
        }
        if (FENCE != null) {
            provider.fenceBuilder(FENCE, Ingredient.of(PLANK));
        }
        if (GATE != null) {
            provider.fenceGateBuilder(GATE, Ingredient.of(PLANK));
        }
        if (TRAPDOOR != null) {
            provider.trapdoorBuilder(TRAPDOOR, Ingredient.of(PLANK));
        }
        if (DOOR != null) {
            provider.doorBuilder(DOOR, Ingredient.of(PLANK));
        }
        if (PRESSURE_PLATE != null) {
            provider.pressurePlate(PRESSURE_PLATE, PLANK);
        }
        if (BUTTON != null) {
            provider.buttonBuilder(BUTTON, Ingredient.of(PLANK));
        }

    }

    public TagKey<Block> LOG_TAG_BLOCK = createBlockTag(name);
    public TagKey<Item> LOG_TAG_ITEM = createItemTag(name);

    protected TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }
    protected TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    //region register

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    protected static Block registerStair(String name, Block baseBlock) {
        return register(name, p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerStair(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    protected static Block registerSlab(String name, Block baseBlock) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerSlab(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    protected static Block registerWoodenButton(String name, BlockSetType type) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties());
    }
    protected static Block registerWoodenButton(String name, BlockSetType type, boolean shouldRegisterItem) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties(), shouldRegisterItem);
    }
    protected static Block registerPressurePlate(String name, BlockSetType type, MapColor mapColor) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(mapColor));
    }
    protected static Block registerPressurePlate(String name, BlockSetType type, MapColor mapColor, boolean shouldRegisterItem) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(mapColor), shouldRegisterItem);
    }
    protected static Block registerPressurePlate(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(baseBlock.defaultMapColor()));
    }
    protected static Block registerPressurePlate(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of()
                .forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(baseBlock.defaultMapColor()), shouldRegisterItem);
    }

    protected static Block registerFence(String name, Block baseBlock) {
        return register(name, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerFence(String name, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    protected static Block registerFenceGate(String name, WoodType type, Block baseBlock) {
        return register(name, p -> new FenceGateBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerFenceGate(String name, WoodType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new FenceGateBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock), shouldRegisterItem);
    }
    protected static Block registerDoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new DoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock)
                .pushReaction(PushReaction.DESTROY).strength(3.0F).noOcclusion());
    }
    protected static Block registerDoor(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new DoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock)
                .pushReaction(PushReaction.DESTROY).strength(3.0F).noOcclusion(), shouldRegisterItem);
    }
    protected static Block registerTrapdoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new TrapDoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).noOcclusion().isValidSpawn(Blocks::never));
    }
    protected static Block registerTrapdoor(String name, BlockSetType type, Block baseBlock, boolean shouldRegisterItem) {
        return register(name, p -> new TrapDoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).noOcclusion().isValidSpawn(Blocks::never), shouldRegisterItem);
    }

    //endregion registe
}
