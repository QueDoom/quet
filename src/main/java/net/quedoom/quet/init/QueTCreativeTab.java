package net.quedoom.quet.init;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.quedoom.quet.misc.QueTObjectStorage;

public class QueTCreativeTab extends ModRegistrator{
    protected static CreativeModeTab createTab(Item icon, String name, CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
        CreativeModeTab tab = FabricCreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(ModRegistrator.namespace() + ".creativeModeTab." + name))
                .displayItems(displayItemsGenerator)
                .build();
        QueTObjectStorage.addTab(tab, name);
        return tab;
    }
}
