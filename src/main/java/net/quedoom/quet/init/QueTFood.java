package net.quedoom.quet.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class QueTFood extends ModRegistrator {
    private static final Consumable.Builder FOOD = Consumables.defaultFood();
    private static final Consumable.Builder DRINK = Consumables.defaultDrink();


    protected static Consumable.Builder food() {
        return Consumables.defaultFood();
    }
    protected static Consumable foodDotBuild() {
        return Consumables.defaultFood().build();
    }

    protected static Consumable.Builder food(ApplyStatusEffectsConsumeEffect effects) {
        return Consumables.defaultFood().onConsume(effects);
    }
    protected static Consumable foodDotBuild(ApplyStatusEffectsConsumeEffect effects) {
        return Consumables.defaultFood().onConsume(effects).build();
    }

    protected static Consumable.Builder drink() {
        return DRINK;
    }
    protected static Consumable.Builder drinkDotBuild() {
        return FOOD;
    }

    protected static Consumable.Builder drink(ApplyStatusEffectsConsumeEffect effects) {
        return DRINK.onConsume(effects);
    }
    protected static Consumable drinkDotBuild(ApplyStatusEffectsConsumeEffect effects) {
        return DRINK.onConsume(effects).build();
    }

    protected static FoodProperties createDefaultFoodProperties(int nutrition, float saturation) {
        return createDefaultFoodProperties(nutrition, saturation, false);
    }

    protected static FoodProperties createDefaultFoodProperties(int nutrition, float saturation, boolean canAlwaysEat) {
        FoodProperties.Builder builder = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);
        return canAlwaysEat ? builder.alwaysEdible().build() : builder.build();
    }

}
