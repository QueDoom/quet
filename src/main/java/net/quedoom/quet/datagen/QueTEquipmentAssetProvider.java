package net.quedoom.quet.datagen;

import com.mojang.serialization.Codec;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.quedoom.quet.init.ModRegistrator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class QueTEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    protected abstract void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer);

    public QueTEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup<HolderLookup.Provider>> completableFuture) {
        this.pathProvider = createPathProvider(packOutput);

    }

    protected static void createHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key) {
        consumer.accept(key, EquipmentClientInfo
                .builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()))
                .build());
    }
    protected static void createHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        consumer.accept(key, EquipmentClientInfo
                .builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()), dyeable)
                .build());
    }
    protected static void createMainHumanoidLayer(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        consumer.accept(key, EquipmentClientInfo
                .builder().addMainHumanoidLayer(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()), dyeable)
                .build());
    }

    protected static PackOutput.PathProvider createPathProvider(PackOutput packOutput) {
        return packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + String.valueOf(id));
            }
        });
        Codec codec = EquipmentClientInfo.CODEC;
        Objects.requireNonNull(this.pathProvider);
        return DataProvider.saveAll(cache, codec, this.pathProvider::json, equipmentAssets);
    }
}
