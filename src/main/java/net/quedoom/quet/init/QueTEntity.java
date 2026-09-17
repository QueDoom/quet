package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class QueTEntity extends ModRegistrator {
    protected static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }


}
