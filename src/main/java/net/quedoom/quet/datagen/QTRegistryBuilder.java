package net.quedoom.quet.datagen;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.JukeboxSong;

public record QTRegistryBuilder(RegistrySetBuilder setBuilder) {
    public static QTRegistryBuilder of(RegistrySetBuilder setBuilder) {
        return new QTRegistryBuilder(setBuilder);
    }

    public <T> RegistrySetBuilder add(final ResourceKey<? extends Registry<T>> key, final Lifecycle lifecycle, final RegistrySetBuilder.RegistryBootstrap<T> bootstrap) {
        return this.setBuilder.add(key, lifecycle, bootstrap);
    }

    public <T> RegistrySetBuilder add(final ResourceKey<? extends Registry<T>> key, final RegistrySetBuilder.RegistryBootstrap<T> bootstrap) {
        return this.setBuilder.add(key, bootstrap);
    }

    public void addPaintings(final RegistrySetBuilder.RegistryBootstrap<PaintingVariant> bootstrap) {
        add(Registries.PAINTING_VARIANT, bootstrap);
    }

    public void addJukeboxSongs(final RegistrySetBuilder.RegistryBootstrap<JukeboxSong> bootstrap) {
        add(Registries.JUKEBOX_SONG, bootstrap);
    }
}
