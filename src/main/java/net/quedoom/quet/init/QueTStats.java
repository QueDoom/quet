package net.quedoom.quet.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class QueTStats extends ModRegistrator {
    public static final Stat<?> STAT = makeCustomStat("stat");


    protected static Stat<?> makeCustomStat(String name, StatFormatter formatter) {
        Identifier id = Identifier.fromNamespaceAndPath(namespace(), name);
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, name, id);

        return Stats.CUSTOM.get(newStat, formatter);
    }
    protected static Stat<?> makeCustomStat(String name) {
        return makeCustomStat(name, StatFormatter.DEFAULT);
    }


}
