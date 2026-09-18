package net.quedoom.quet.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.quedoom.quet.init.ModRegistrator;

import java.util.concurrent.CompletableFuture;

public abstract class QTLanguageProvider extends FabricLanguageProvider {
    protected QTLanguageProvider(FabricPackOutput packOutput, String languageCode, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, languageCode, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        generateTranslations(registryLookup, translationBuilder, AutoTranslate.of(translationBuilder));
    }

    public abstract void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder, AutoTranslate autoTranslate);
}
