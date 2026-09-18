package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class QueTLanguageGenerator extends FabricLanguageProvider {
    public QueTLanguageGenerator(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("tooltip.quet.standard.press_shift", "Hold [§eSHIFT§r] for more information!");
        translationBuilder.add("tooltip.quet.standard.press_ctrl", "Hold [§eCONTROL§r] for more information!");
        translationBuilder.add("tooltip.quet.standard.press_alt", "Hold [§eALT§r] for more information!");
    }
}
