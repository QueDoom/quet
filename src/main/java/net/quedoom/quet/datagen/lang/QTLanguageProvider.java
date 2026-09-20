package net.quedoom.quet.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.quedoom.quet.init.ModRegistrator;

import java.util.concurrent.CompletableFuture;

public abstract class QTLanguageProvider extends FabricLanguageProvider {
    public QTLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        AutoTranslate autoTranslate = AutoTranslate.of(translationBuilder);
        autoTranslate.addInStorage();
        generateTranslations(registryLookup, translationBuilder, autoTranslate);
    }

    public abstract void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder, AutoTranslate autoTranslate);
}
