package net.quedoom.quet.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class QueTSounds extends ModRegistrator {

    protected static SoundEvent register(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(namespace(), name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static Holder.Reference<SoundEvent> registerDisc(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(namespace(), name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }


}
