package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.quedoom.quet.misc.QueTObjectStorage;

public abstract class QueTDataGeneratorEntrypoint implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        doDatagen(fabricDataGenerator, pack);
        QueTObjectStorage.clear();
    }

    protected abstract void doDatagen(FabricDataGenerator fabricDataGenerator, FabricDataGenerator.Pack pack);

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        buildRegistry(QTRegistryBuilder.of(registryBuilder));
    }

    protected abstract void buildRegistry(QTRegistryBuilder qtRegistryBuilder);
}
