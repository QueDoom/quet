package net.quedoom.quet.init;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public class QueTPoiType extends ModRegistrator {

    public QueTPoiType(@NonNull String namespace) {
        super(namespace);
    }

    public ResourceKey<PoiType> create(String path) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE,
                of(path + "_poi"));
    }
    public PoiType registerVillager(String name, Block... blocks) {
        return PoiHelper.register(of(name), 1, 1, blocks);
    }

}