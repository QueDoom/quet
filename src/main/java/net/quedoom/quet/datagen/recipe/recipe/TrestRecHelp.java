package net.quedoom.quet.datagen.recipe.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.quedoom.quet.datagen.recipe.QueTAdvancedRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class TrestRecHelp extends QueTAdvancedRecipeProvider<QueTHelper> {
    public TrestRecHelp(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }
}
