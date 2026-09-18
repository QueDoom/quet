package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.quedoom.quet.misc.LocalizedGetPath;

import java.util.concurrent.CompletableFuture;

public abstract class QueTRecipeGen extends FabricRecipeProvider implements LocalizedGetPath {
    public QueTRecipeGen(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private void campfireSmelting(ItemLike in, ItemLike out, RecipeCategory category, int cookingTime, RecipeProvider provider, RecipeOutput output) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(in), category, out, 0, cookingTime)
                .unlockedBy(RecipeProvider.getHasName(in), provider.has(in))
                .group(getPath(out.asItem()))
                .save(output, out + "_from_campfire");
    }
}
