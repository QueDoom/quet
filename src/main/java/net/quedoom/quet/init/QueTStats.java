package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import org.jspecify.annotations.NonNull;

public class QueTStats extends ModRegistrator {
    public QueTStats(@NonNull String namespace) {
        super(namespace);
    }


    public Stat<?> makeCustomStat(String name, StatFormatter formatter) {
        Identifier id = of(name);
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, name, id);

        return Stats.CUSTOM.get(newStat, formatter);
    }
    public Stat<?> makeCustomStat(String name) {
        return makeCustomStat(name, StatFormatter.DEFAULT);
    }


}
