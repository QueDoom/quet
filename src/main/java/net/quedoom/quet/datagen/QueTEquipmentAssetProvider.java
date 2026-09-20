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
    protected abstract void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer);

    public QueTEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup<HolderLookup.Provider>> completableFuture) {
        this.pathProvider = createPathProvider(packOutput);

    }

    protected static void registerHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key) {
        consumer.accept(key, EquipmentClientInfo
                .builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()))
                .build());
    }
    protected static void registerHumanoidArmor(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, ResourceKey<EquipmentAsset> key, boolean dyeable) {
        consumer.accept(key, EquipmentClientInfo
                .builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()), dyeable)
                .build());
    }
    protected static EquipmentClientInfo.Builder createMainHumanoidLayer(ResourceKey<EquipmentAsset> key, boolean dyeable) {
        return EquipmentClientInfo.builder().addMainHumanoidLayer(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), key.identifier().getPath()), dyeable);
    }
    protected static EquipmentClientInfo.Builder addLayer(EquipmentClientInfo.Builder builder, EquipmentClientInfo.LayerType type, String name) {
        return builder.addLayers(type,
                new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name)));
    }
    protected static void registerHorseArmor(EquipmentClientInfo.Builder builder, String name) {
        addLayer(builder, EquipmentClientInfo.LayerType.HORSE_BODY, name);
    }
    protected static void registerWolfArmor(EquipmentClientInfo.Builder builder, String name) {
        addLayer(builder, EquipmentClientInfo.LayerType.WOLF_BODY, name);
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
