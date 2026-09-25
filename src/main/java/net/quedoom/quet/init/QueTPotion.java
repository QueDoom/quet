package net.quedoom.quet.init;


import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.alchemy.Potion;

public class QueTPotion extends ModRegistrator {
    protected static Holder.Reference<Potion> register(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, ModRegistrator.of(name), potion);
    }

}
