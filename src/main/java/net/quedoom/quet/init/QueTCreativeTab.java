package net.quedoom.quet.init;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.quedoom.quet.item.CreateiveTab;
import net.quedoom.quet.misc.QueTObjectStorage;

public class QueTCreativeTab extends ModRegistrator {
    protected static ResourceKey<CreativeModeTab> create(String name) {
        return ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(namespace(), name));
    }

    protected static CreativeModeTab register(Item icon, String name, CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
        return FabricCreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(ModRegistrator.namespace() + ".creativeModeTab." + name))
                .displayItems(displayItemsGenerator)
                .build();
    }

    protected static void connectEntries(CreativeModeTab tab, ResourceKey<CreativeModeTab> key) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
        QueTObjectStorage.addTab(key);
    }
}
