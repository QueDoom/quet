package net.quedoom.quet.potion;

import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.mixin.content.registry.PotionBrewingBuilderMixin;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class QueTPotionRecipe {
    public static void register(Holder<Potion> potionHolder, ItemLike ingredient, Holder<Potion> output) {
        FabricPotionBrewingBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(potionHolder, Ingredient.of(ingredient), output)
        );
    }
}
