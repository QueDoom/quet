package net.quedoom.quet.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.JukeboxSong;
import org.jspecify.annotations.NonNull;

public class QueTJukeboxSongs extends ModRegistrator {

    public QueTJukeboxSongs(@NonNull String namespace) {
        super(namespace);
    }

    public ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, of(name));
    }

    public void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key,
                                   Holder.Reference<SoundEvent> event, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(event,
                Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), lengthInSeconds, comparatorOutput));
    }
}
