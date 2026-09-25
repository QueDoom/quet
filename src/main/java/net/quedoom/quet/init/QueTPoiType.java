package net.quedoom.quet.init;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.quedoom.villager.QTVillagerTrade;

public class QueTPoiType extends ModRegistrator {

    protected static ResourceKey<PoiType> create(String path) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE,
                ModRegistrator.of(path + "_poi"));
    }
    protected static PoiType registerVillager(String name, Block... blocks) {
        return PoiHelper.register(ModRegistrator.of(name), 1, 1, blocks);
    }

}