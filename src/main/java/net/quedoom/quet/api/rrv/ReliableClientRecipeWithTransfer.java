package net.quedoom.quet.api.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.Identifier;

import java.util.List;

public abstract class ReliableClientRecipeWithTransfer implements ReliableClientRecipe {
    private final List<Class<? extends AbstractContainerScreen<?>>> screenClasses;

    protected ReliableClientRecipeWithTransfer(List<Class<? extends AbstractContainerScreen<?>>> screenClasses) {
        this.screenClasses = screenClasses;
    }

    @Override
    public Identifier getId() {
        return identifier();
    }

    @Override
    public ReliableClientRecipeType getType() {
        return zeType();
    }

    protected abstract ReliableClientRecipeType zeType();

    public abstract Identifier identifier();

    @Override
    public boolean supportsItemTransfer() {
        return true;
    }

    @Override
    public List<Class<? extends AbstractContainerScreen<?>>> getTransferClasses() {
        return screenClasses;
    }

    @Override
    public void mapRecipeItems(RecipeTransferMap transferMap, AbstractContainerScreen<?> screen) {
        mapRecipesItem(transferMap, screen);
    }

    protected abstract void mapRecipesItem(RecipeTransferMap transferMap, AbstractContainerScreen<?> screen);
}
