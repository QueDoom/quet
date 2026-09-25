package net.quedoom.quet.init.test;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.VillagerTrade;
import net.quedoom.quet.datagen.QueTVillagerTrade;
import net.quedoom.villager.QTVillagerTrade;
import net.quedoom.villager.VillagerLevels;

public class ModVillagerTrades extends QueTVillagerTrade {
    public static final QTVillagerTrade FARMER_1_EMERALD_POISONOUS_POTATO = trade(VillagerProfession.CLERIC, VillagerLevels.JOURNEYMAN, Items.POISONOUS_POTATO);

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        FARMER_1_EMERALD_POISONOUS_POTATO.bootstrap(context, 27, 8);
    }
}
