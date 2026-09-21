package net.quedoom.quet.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.quedoom.quet.misc.LocalizedGetPath;

import java.util.concurrent.CompletableFuture;

public abstract class QTRecipeProvider extends RecipeProvider implements LocalizedGetPath {
    protected QTRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    protected void campfireSmelting(ItemLike out, ItemLike in, RecipeCategory category, int cookingTime) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(in), category, out, 0, cookingTime)
                .unlockedBy(RecipeProvider.getHasName(in), this.has(in))
                .group(getPath(out.asItem()))
                .save(output, out + "_from_campfire");
    }

    protected void campfireSmelting(ItemLike out, ItemLike in, RecipeCategory category) {
        campfireSmelting(out, in, category, 200);
    }
}
