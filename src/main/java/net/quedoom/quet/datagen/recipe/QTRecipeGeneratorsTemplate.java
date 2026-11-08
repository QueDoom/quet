package net.quedoom.quet.datagen.recipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.quedoom.quet.misc.LocalizedGetPath;

public class QTRecipeGeneratorsTemplate implements LocalizedGetPath {
    private final RecipeProvider provider;
    private final RecipeOutput output;

    public QTRecipeGeneratorsTemplate(RecipeProvider provider, RecipeOutput output) {
        this.provider = provider;
        this.output = output;
    }

    public void campfireSmelting(ItemLike out, ItemLike in, RecipeCategory category, int cookingTime) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(in), category, out, 0, cookingTime)
                .unlockedBy(RecipeProvider.getHasName(in), provider.has(in))
                .group(getPath(out.asItem()))
                .save(output, out + "_from_campfire");
    }

    public void campfireSmelting(ItemLike out, ItemLike in, RecipeCategory category) {
        campfireSmelting(out, in, category, 200);
    }

    public String getHasName(final ItemLike item) {
        return RecipeProvider.getHasName(item);
    }
    public String getHasName(final TagKey<Item> tag) {
        return "has_any_of_" + getPath(tag);
    }
    public Criterion<InventoryChangeTrigger.TriggerInstance> has(final ItemLike item) {
        return provider.has(item);
    }
    public Criterion<InventoryChangeTrigger.TriggerInstance> has(final ItemLike item, final MinMaxBounds.Ints count) {
        return provider.has(count, item);
    }
    public Criterion<InventoryChangeTrigger.TriggerInstance> has(final TagKey<Item> tag) {
        return provider.has(tag);
    }
}
