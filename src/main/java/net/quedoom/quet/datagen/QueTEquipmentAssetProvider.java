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
import java.util.function.Consumer;

public abstract class QueTEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    private final String namespace;

    protected abstract void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer);

    public QueTEquipmentAssetProvider(PackOutput packOutput, String namespace) {
        this.pathProvider = createPathProvider(packOutput);
        this.namespace = namespace;
    }

    protected Identifier of(String path) {
        return Identifier.fromNamespaceAndPath(namespace, path);
    }

    protected void registerHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key) {
        consumer.accept(key, EquipmentClientInfo.builder()
                .addHumanoidLayers(of(key.identifier().getPath()))
                .build());
    }

    protected void registerHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        consumer.accept(key, EquipmentClientInfo.builder()
                .addHumanoidLayers(of(key.identifier().getPath()), dyeable)
                .build());
    }

    protected EquipmentClientInfo.Builder createMainHumanoidLayer(ResourceKey<EquipmentAsset> key, boolean dyeable) {
        return EquipmentClientInfo.builder()
                .addMainHumanoidLayer(of(key.identifier().getPath()), dyeable);
    }

    protected EquipmentClientInfo.Builder addLayer(EquipmentClientInfo.Builder builder, EquipmentClientInfo.LayerType type, String name) {
        return builder.addLayers(type, new EquipmentClientInfo.Layer(of(name)));
    }

    protected void registerHorseArmor(EquipmentClientInfo.Builder builder, String name) {
        addLayer(builder, EquipmentClientInfo.LayerType.HORSE_BODY, name);
    }

    protected void registerWolfArmor(EquipmentClientInfo.Builder builder, String name) {
        addLayer(builder, EquipmentClientInfo.LayerType.WOLF_BODY, name);
    }

    protected static PackOutput.PathProvider createPathProvider(PackOutput packOutput) {
        return packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, pathProvider::json, equipmentAssets);
    }
}
