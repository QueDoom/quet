package net.quedoom.quet.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jspecify.annotations.Nullable;

public class WaterCrop extends SupportingCropBlock {
    private final ItemLike seed;
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = newAgeProperty(MAX_AGE);

    public WaterCrop(ItemLike seed, Properties properties) {
        super(Blocks.WATER, properties);
        this.seed = seed;
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    protected ItemLike getSeed() {
        return seed;
    }

    @Override
    protected IntegerProperty qtGetAgeProperty() {
        return AGE;
    }

    @Override
    protected int maxAge() {
        return MAX_AGE;
    }

    @Override
    protected void defineBlockState(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
