package net.quedoom.quet.init;

import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.minecraft.world.item.Item;

public abstract class QueTCompostable {
    /**
     * Please override :)
     */
    public static void bootstrap() {
    }

    protected static void add(Item item, float chance) {
        CompostableRegistry.INSTANCE.add(item, chance);
    }

    protected static void addGuaranteed(Item item) {
        add(item, 1F);
    }

    protected static void addSeed(Item item) {
        add(item, 0.3F);
    }

    protected static void addCrop(Item item) {
        add(item, 0.65F);
    }
}
