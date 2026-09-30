package net.quedoom.quet.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.alchemy.Potions;

import java.util.concurrent.CompletableFuture;

public abstract class QueTLanguageProvider extends FabricLanguageProvider {
    public QueTLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        QTTranslationBuilder autoTranslate = QTTranslationBuilder.of(translationBuilder, getNamespace());
        autoTranslate.autotranslateInStorage();
        generateTranslations(registryLookup, translationBuilder, autoTranslate);
    }

    protected abstract String getNamespace();
    public abstract void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder, QTTranslationBuilder autoTranslate);
}
