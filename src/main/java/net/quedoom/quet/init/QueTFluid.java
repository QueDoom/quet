package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.FlowingFluid;
import org.jspecify.annotations.NonNull;

public class QueTFluid extends ModRegistrator {
    public QueTFluid(@NonNull String namespace) {
        super(namespace);
    }

    public FlowingFluid register(String name, FlowingFluid fluid) {
        return Registry.register(BuiltInRegistries.FLUID, of(name), fluid);
    }
}
