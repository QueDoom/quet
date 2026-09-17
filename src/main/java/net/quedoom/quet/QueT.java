package net.quedoom.quet;

import net.fabricmc.api.ModInitializer;

import net.quedoom.quet.init.*;
import net.quedoom.quet.item.CreateiveTab;
import net.quedoom.quet.item.ModItems;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueT extends ModRegistrator implements ModInitializer {
	public static final String MOD_ID = setNamespace("quet");
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		CreateiveTab.register();
		//QueTObjectStorage.addTab(CreateiveTab.TEST_KEY);
	}

}
