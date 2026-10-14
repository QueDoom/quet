package net.quedoom.quet.api;

import net.fabricmc.loader.api.FabricLoader;

public class LoadedMods {
    public static final boolean RRV = FabricLoader.getInstance().isModLoaded("rrv");
    public static final boolean TOUGH_AS_NAILS = FabricLoader.getInstance().isModLoaded("toughasnails");
    public static final boolean MODMENU = FabricLoader.getInstance().isModLoaded("modmenu");
    public static final boolean MODMENU_BADGES = FabricLoader.getInstance().isModLoaded("modmenu-badges-lib");
    public static final boolean PRICKLE = FabricLoader.getInstance().isModLoaded("prickle");

    public static void set() {
    }
}
