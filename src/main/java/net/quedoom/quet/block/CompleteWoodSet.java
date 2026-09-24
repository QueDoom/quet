package net.quedoom.quet.block;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.quedoom.quet.QueT;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.datagen.models.QTBlockModelGenerators;
import net.quedoom.quet.datagen.models.QTItemModelGenerators;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.jspecify.annotations.Nullable;

import java.util.function.BiFunction;
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
    public final @Nullable Item SIGN_ITEM;
    public final @Nullable Block WALL_SIGN;
    public final @Nullable Block HANGING_SIGN;
    public final @Nullable Item HANGING_SIGN_ITEM;
    public final @Nullable Block WALL_HANGING_SIGN;
    public final @Nullable Block FENCE;
    public final @Nullable Block GATE;
    public final @Nullable Block TRAPDOOR;
    public final @Nullable Block DOOR;
    public final @Nullable Item DOOR_ITEM;
    public final @Nullable Block PRESSURE_PLATE;
    public final @Nullable Block BUTTON;

    public final TagKey<Item> ITEM_LOG_TAG;
    public final TagKey<Block> BLOCK_LOG_TAG;

    public final String name;
    public final WoodType woodType;
    public final BlockSetType blockSetType;
    public final boolean isFireProof;
    public final boolean isOverwoldAndNatural;

    private CompleteWoodSet(String name, WoodType woodType, BlockSetType setType, boolean isFireProof, boolean isOverwoldAndNatural,
                            @Nullable Block log, @Nullable Block stripped, @Nullable Block wood, @Nullable Block strippedWood,
                            @Nullable Block plank, @Nullable Block stairs, @Nullable Block slab, @Nullable Block shelf,
                            @Nullable Block sign, @Nullable Item signItem, @Nullable Block wallSign, @Nullable Block hangingSign,
                            @Nullable Item hangingSignItem, @Nullable Block wallHangingSign, @Nullable Block fence, @Nullable Block gate,
                            @Nullable Block trapdoor, @Nullable Block door, @Nullable Item doorItem, @Nullable Block pressurePlate, @Nullable Block button) {
        this.name = name;
        this.woodType = woodType;
        this.blockSetType = setType;
        this.isFireProof = isFireProof;
        this.isOverwoldAndNatural = isOverwoldAndNatural;
        this.LOG = log;
        this.STRIPPED = stripped;
        this.WOOD = wood;
        this.STRIPPED_WOOD = strippedWood;
        this.PLANK = plank;
        this.STAIRS = stairs;
        this.SLAB = slab;
        this.SHELF = shelf;
        this.SIGN = sign;
        this.SIGN_ITEM = signItem;
        this.WALL_SIGN = wallSign;
        this.HANGING_SIGN = hangingSign;
        this.HANGING_SIGN_ITEM = hangingSignItem;
        this.WALL_HANGING_SIGN = wallHangingSign;
        this.FENCE = fence;
        this.GATE = gate;
        this.TRAPDOOR = trapdoor;
        this.DOOR = door;
        this.DOOR_ITEM = doorItem;
        this.PRESSURE_PLATE = pressurePlate;
        this.BUTTON = button;
        this.ITEM_LOG_TAG = createItemTag(name + "_logs");
        this.BLOCK_LOG_TAG = createBlockTag(name + "_logs");
    }

    public boolean hasSigns() {
        return SIGN != null;
    }

    public boolean hasFences() {
        return FENCE != null;
    }

    public boolean hasDoors() {
        return DOOR != null;
    }

    public boolean hasButtons() {
        return BUTTON != null;
    }

    public static CompleteWoodSet.Builder incomplete(String name, WoodType type, boolean isFireProof, boolean isOverwoldAndNatural) {
        return new CompleteWoodSet.Builder(name, type, isFireProof, isOverwoldAndNatural);
    }

    public static class Builder {
        private Block LOG;
        private Block STRIPPED;
        private Block WOOD;
        private Block STRIPPED_WOOD;
        private Block PLANK;
        private Block STAIRS;
        private Block SLAB;
        private Block SHELF;
        private @Nullable Block SIGN;
        private @Nullable Item SIGN_ITEM;
        private @Nullable Block WALL_SIGN;
        private @Nullable Block HANGING_SIGN;
        private @Nullable Item HANGING_SIGN_ITEM;
        private @Nullable Block WALL_HANGING_SIGN;
        private @Nullable Block FENCE;
        private @Nullable Block GATE;
        private BlockSetType SET_TYPE;
        private @Nullable Block TRAPDOOR;
        private @Nullable Block DOOR;
        private @Nullable Item DOOR_ITEM;
        private @Nullable Block PRESSURE_PLATE;
        private @Nullable Block BUTTON;

        private final String name;
        private final WoodType woodType;
        private final boolean isFireProof;
        public final boolean isOverwoldAndNatural;

        private Builder(String name, WoodType type, boolean isFireProof, boolean isOverwoldAndNatural) {
            this.name = name;
            this.woodType = type;
            this.isFireProof = isFireProof;
            this.isOverwoldAndNatural = isOverwoldAndNatural;
        }


        public CompleteWoodSet.Builder init(MapColor color) {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD);
            properties = !isFireProof ? properties.ignitedByLava() : properties;

            Block plank = register(genName("planks"), Block::new, properties.mapColor(color));

            this.LOG = register(genName("log"), RotatedPillarBlock::new, properties);
            this.STRIPPED = register(stripped("log"), RotatedPillarBlock::new, properties);
            this.WOOD = register(genName("wood"), RotatedPillarBlock::new, properties);
            this.STRIPPED_WOOD = register(stripped("wood"), RotatedPillarBlock::new, properties);
            this.PLANK = plank;
            this.STAIRS = registerStair(genName("stairs"), plank);
            this.SLAB = registerSlab(genName("slab"), plank);
            this.SHELF = registerShelf(genName("shelf"), plank);

            // Auto
            QueTObjectStorage.addAutotranslate(LOG, STRIPPED, WOOD, STRIPPED_WOOD, PLANK, STAIRS, SLAB, SHELF);

            return this;
        }

        public CompleteWoodSet.Builder addSigns() {
            Block plank = this.PLANK;
            BlockBehaviour.Properties plankProperties = BlockBehaviour.Properties.ofFullCopy(plank);
            if (this.SIGN == null) {
                this.SIGN = register(genName("sign"), p -> new StandingSignBlock(woodType, p), plankProperties.forceSolidOn().noCollision().noOcclusion().strength(1F), false);
                this.WALL_SIGN = register(genName("wall_sign"), p -> new WallSignBlock(woodType, p), Blocks.wallVariant(plank, false).forceSolidOn().strength(1F), false);
                this.HANGING_SIGN = register(genName("hanging_sign"), p -> new CeilingHangingSignBlock(woodType, p), plankProperties.forceSolidOn().noOcclusion().strength(1F), false);
                this.WALL_HANGING_SIGN = register(genName("wall_hanging_sign"), p -> new WallHangingSignBlock(woodType, p), Blocks.wallVariant(plank, false).forceSolidOn().strength(1F), false);
                this.SIGN_ITEM = registerBlockItem(name, plank, (b, p) -> new SignItem(b, this.WALL_SIGN, p), new Item.Properties().stacksTo(16));
                this.HANGING_SIGN_ITEM = registerBlockItem(name, plank, (b, p) -> new HangingSignItem(b, this.WALL_HANGING_SIGN, p), new Item.Properties().stacksTo(16));

                QueTObjectStorage.addAutotranslate(SIGN, WALL_SIGN, HANGING_SIGN, WALL_HANGING_SIGN);
                QueTObjectStorage.addAutotranslate(SIGN_ITEM, HANGING_SIGN_ITEM);
            }
            return this;
        }

        public CompleteWoodSet.Builder addFences() {
            Block plank = this.PLANK;
            if (this.FENCE == null) {
                this.FENCE = registerFence(genName("fence"), plank);
                this.GATE = registerFenceGate(genName("fence_gate"), woodType, plank);
                QueTObjectStorage.addAutotranslate(FENCE, GATE);
            }
            return this;
        }

        public CompleteWoodSet.Builder addDoors() {
            Block plank = this.PLANK;
            if (this.TRAPDOOR == null) {
                this.TRAPDOOR = registerTrapdoor(genName("trapdoor"), SET_TYPE, plank);
                this.DOOR = registerDoor(genName("door"), SET_TYPE, plank);
                this.DOOR_ITEM = registerBlockItem(name, DOOR, DoubleHighBlockItem::new);
                QueTObjectStorage.addAutotranslate(DOOR, TRAPDOOR);
            }
            return this;
        }

        public CompleteWoodSet.Builder addButtons() {
            return addButtons(this.PLANK.defaultMapColor());
        }
        public CompleteWoodSet.Builder addButtons(MapColor color) {
            Block block = this.PLANK;
            if (this.PRESSURE_PLATE == null) {
                this.PRESSURE_PLATE = registerPressurePlate(genName("pressure_plate"), SET_TYPE, color);
                this.BUTTON = registerWoodenButton(genName("button"), SET_TYPE, color);
                QueTObjectStorage.addAutotranslate(PRESSURE_PLATE, BUTTON);
            }
            return this;
        }

        public CompleteWoodSet complete() {
            return new CompleteWoodSet(
                    this.name, this.woodType, this.SET_TYPE, this.isFireProof, this.isOverwoldAndNatural,
                    this.LOG, this.STRIPPED, this.WOOD, this.STRIPPED_WOOD, this.PLANK, this.STAIRS,
                    this.SLAB, this.SHELF, this.SIGN, this.SIGN_ITEM, this.WALL_SIGN, this.HANGING_SIGN,
                    this.HANGING_SIGN_ITEM, this.WALL_HANGING_SIGN, this.FENCE, this.GATE, this.TRAPDOOR,
                    this.DOOR, this.DOOR_ITEM, this.PRESSURE_PLATE, this.BUTTON);
        }

        private String genName(String suffix) {
            return this.name + '_' + suffix;
        }

        private String stripped(String suffix) {
            return "stripped_" + this.name + '_' + suffix;
        }
    }

    //region datagen

    /**
     * Creates all recipes.
     * @param provider This is the provider to generate the recipes
     */
    public void recipeGen(RecipeProvider provider) {
        provider.planksFromLog(PLANK, ITEM_LOG_TAG, 4);
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

    /**
     *
     * @param qtGenerators provide {@link QTItemModelGenerators} or {@link ItemModelGenerators}
     */
    public void itemModelGen(QTItemModelGenerators qtGenerators) {
        itemModelGen(qtGenerators.generators());
    }
    public void itemModelGen(ItemModelGenerators generators) {
        if (hasSigns()) {
            generators.generateFlatItem(SIGN_ITEM, ModelTemplates.FLAT_ITEM);
            generators.generateFlatItem(HANGING_SIGN_ITEM, ModelTemplates.FLAT_ITEM);
        }
        if (hasDoors()) generators.generateFlatItem(DOOR_ITEM, ModelTemplates.FLAT_ITEM);
    }

    public void blockModelGen(QTBlockModelGenerators qtGenerators) {
        blockModelGen(qtGenerators.generators());
    }
    public void blockModelGen(BlockModelGenerators generators) {
        BlockModelGenerators.BlockFamilyProvider family = generators.family(this.PLANK);
        family.stairs(this.STAIRS)
        .slab(this.SLAB);
        if (hasSigns()) {
            family.sign(this.SIGN)
            .sign(this.WALL_SIGN);
            generators.createHangingSign(this.PLANK, this.HANGING_SIGN, this.WALL_HANGING_SIGN);
        }
        if (hasFences()) {
            family.fence(this.FENCE)
                    .fenceGate(this.GATE);
        }
        if (hasDoors()) {
            generators.createDoor(this.DOOR);
            generators.createOrientableTrapdoor(this.TRAPDOOR);
        }
        if (hasButtons()) {
            family.pressurePlate(this.PRESSURE_PLATE)
                    .button(this.BUTTON);
        }

        generators.createAxisAlignedPillarBlock(this.LOG, TexturedModel.COLUMN);
        generators.createAxisAlignedPillarBlock(this.STRIPPED, TexturedModel.COLUMN);
        generators.createAxisAlignedPillarBlock(this.WOOD, TexturedModel.COLUMN);
        generators.createAxisAlignedPillarBlock(this.STRIPPED_WOOD, TexturedModel.COLUMN);
        generators.createShelf(this.SHELF, this.PLANK);
    }

    //endregion datagen

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

    private static Item registerBlockItem(String name, Block block, BiFunction<Block, Item.Properties, Item> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = keyOfItem(name);
        Item item = itemFactory.apply(block, properties.setId(itemKey).useBlockDescriptionPrefix());
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    private static Item registerBlockItem(String name, Block block, BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlockItem(name, block, itemFactory, new Item.Properties());
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

    protected static Block registerShelf(String name, Block baseBlock) {
        return register(name, ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerStair(String name, Block baseBlock) {
        return register(name, p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerSlab(String name, Block baseBlock) {
        return register(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerWoodenButton(String name, BlockSetType type, MapColor color) {
        return register(name, p -> new ButtonBlock(type, 30, p), Blocks.buttonProperties().mapColor(color));
    }
    protected static Block registerPressurePlate(String name, BlockSetType type, MapColor mapColor) {
        return register(name, p -> new PressurePlateBlock(type, p), BlockBehaviour.Properties.of().forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(mapColor));
    }
    protected static Block registerFence(String name, Block baseBlock) {
        return register(name, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerFenceGate(String name, WoodType type, Block baseBlock) {
        return register(name, p -> new FenceGateBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }
    protected static Block registerDoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new DoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).pushReaction(PushReaction.DESTROY).strength(3.0F).noOcclusion(), false);
    }
    protected static Block registerTrapdoor(String name, BlockSetType type, Block baseBlock) {
        return register(name, p -> new TrapDoorBlock(type, p), BlockBehaviour.Properties.ofFullCopy(baseBlock).noOcclusion().isValidSpawn(Blocks::never));
    }
    //endregion registe
}
