package net.quedoom.quet.api.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import net.minecraft.resources.Identifier;

public abstract class ReliableClientRecipeWithoutTransfer implements ReliableClientRecipe {
    public ReliableClientRecipeWithoutTransfer() {}
    @Override
    public boolean supportsItemTransfer() {
        return false;
    }

    @Override
    public ReliableClientRecipeType getType() {
        return zeType();
    }

    protected abstract ReliableClientRecipeType zeType();

    @Override
    public Identifier getId() {
        return identifier();
    }

    public abstract Identifier identifier();
}
