package net.quedoom.quet.datagen;

import net.minecraft.client.renderer.item.properties.numeric.Damage;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.quedoom.quet.init.ModRegistrator;

public class QueTDamageType {
    public static void bootstrap(BootstrapContext<DamageType> context) {
        throw new AssertionError("Must be overridden in child Class");
    }

    protected static ResourceKey<DamageType> createKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
    }

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().getOrThrow(Registries.DAMAGE_TYPE).value().getOrThrow(key));
    }

    protected static DamageType type(String name) {
        return type(name, 0.0F);
    }

    protected static DamageType type(String name, float exhaustion) {
        return type(name, exhaustion, DamageEffects.HURT);
    }

    protected static DamageType type(String name, float exhaustion, DamageEffects effects) {
        return new DamageType(name, exhaustion, effects);
    }

}
