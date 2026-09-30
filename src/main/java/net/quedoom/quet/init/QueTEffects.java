package net.quedoom.quet.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import org.jspecify.annotations.NonNull;

public class QueTEffects extends ModRegistrator {
    public QueTEffects(@NonNull String namespace) {
        super(namespace);
    }

    public Holder<MobEffect> register(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, of(name), effect);
    }
}
