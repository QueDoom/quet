package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class Dater extends FabricLanguageProvider {
    public Dater(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        AutoTranslate auto = AutoTranslate.of(translationBuilder, ModRegistrator.namespace());

        auto.add(ModItems.TEST_ITEM);
        auto.addTooltip(ModItems.TEST_ITEM, "Hey there!");
        auto.translateAllTabs();


        translationBuilder.add("tooltip.quet.standard.press_shift", "Hold [§eSHIFT§r] for more information!");
        translationBuilder.add("tooltip.quet.standard.press_ctrl", "Hold [§eCONTROL§r] for more information!");
        translationBuilder.add("tooltip.quet.standard.press_alt", "Hold [§eALT§r] for more information!");
    }
}
