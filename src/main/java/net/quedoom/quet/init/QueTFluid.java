package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.FlowingFluid;

public class QueTFluid extends ModRegistrator {
    protected static FlowingFluid register(String name, FlowingFluid fluid) {
        if (ModRegistrator.namespace() == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return Registry.register(BuiltInRegistries.FLUID, Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name), fluid);
    }
}
