package net.quedoom.quet.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public abstract class QTCropBlock extends CropBlock {
    public QTCropBlock(Properties properties) {
        super(properties);
    }

    protected static IntegerProperty newAgeProperty(int max) {
        return IntegerProperty.create("age", 0, max);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getSeed();
    }
    protected abstract ItemLike getSeed();

    @Override
    protected IntegerProperty getAgeProperty() {
        return qtGetAgeProperty();
    }
    protected abstract IntegerProperty qtGetAgeProperty();

    @Override
    public int getMaxAge() {
        return maxAge();
    }
    protected abstract int maxAge();

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        defineBlockState(builder);
    }
    protected abstract void defineBlockState(StateDefinition.Builder<Block, BlockState> builder);

}
