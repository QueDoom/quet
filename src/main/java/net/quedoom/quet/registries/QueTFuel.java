package net.quedoom.quet.registries;


import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.item.Item;

public interface QueTFuel {

    static void register(Item item, float itemsSmelt) {
        register(item, (int) (itemsSmelt * 200));
    }

    static void register(Item item, int time) {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(item, time);
        });
    }
}
