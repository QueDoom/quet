package net.quedoom.quet.init;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.FuelValues;
import net.quedoom.quet.block.CompleteWoodSet;

public class QueTFuel extends ModRegistrator {

    protected static void register(Item item, float itemsSmelt) {
        register(item, (int) (itemsSmelt * 200));
    }

    protected static void register(Item item, int timeInTicks) {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(item, timeInTicks);
        });
    }

    protected static void register(CompleteWoodSet woodSet) {

    }
}
