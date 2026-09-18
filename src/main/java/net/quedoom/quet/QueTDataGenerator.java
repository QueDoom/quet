package net.quedoom.quet;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.quedoom.quet.datagen.QueTLanguageGenerator;
import net.quedoom.quet.datagen.TagProvider;
import net.quedoom.quet.misc.QueTObjectStorage;

public class QueTDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(QueTLanguageGenerator::new);
		pack.addProvider(TagProvider::new);

		QueTObjectStorage.clear();
	}
}
