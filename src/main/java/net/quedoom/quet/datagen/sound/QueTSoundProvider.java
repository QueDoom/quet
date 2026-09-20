package net.quedoom.quet.datagen.sound;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public abstract class QueTSoundProvider extends FabricSoundsProvider {
    public QueTSoundProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        configure(registryLookup, exporter, QTSoundExporter.of(exporter));
    }

    protected abstract void configure(HolderLookup.Provider registryLookup, SoundExporter exporter, QTSoundExporter qtExporter);
}
