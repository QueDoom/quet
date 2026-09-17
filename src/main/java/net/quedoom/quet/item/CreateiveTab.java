package net.quedoom.quet.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.quedoom.quet.init.QueTCreativeTab;

public class CreateiveTab extends QueTCreativeTab {
    public static final ResourceKey<CreativeModeTab> TEST_KEY = create("test_key");

    public static final CreativeModeTab TEST_TAB = register(ModItems.TEST_ITEM, "test_tab", ((parameters, output) -> {
        output.accept(ModItems.TEST_ITEM);
    }));

    public static void register() {
        connectEntries(TEST_TAB, TEST_KEY);
    }
}
