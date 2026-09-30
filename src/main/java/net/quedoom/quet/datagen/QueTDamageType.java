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
import org.jspecify.annotations.NonNull;

public class QueTDamageType extends ModRegistrator {
    public QueTDamageType(@NonNull String namespace) {
        super(namespace);
    }

    protected ResourceKey<DamageType> createKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(namespace(), name));
    }

    public DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().getOrThrow(Registries.DAMAGE_TYPE).value().getOrThrow(key));
    }

    protected DamageType type(String name) {
        return type(name, 0.0F);
    }

    protected DamageType type(String name, float exhaustion) {
        return type(name, exhaustion, DamageEffects.HURT);
    }

    protected DamageType type(String name, float exhaustion, DamageEffects effects) {
        return new DamageType(name, exhaustion, effects);
    }

}
