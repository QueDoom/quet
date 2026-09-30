package net.quedoom.quet.datagen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.level.ItemLike;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.villager.QTVillagerTrade;
import net.quedoom.villager.VillagerLevels;
import org.jspecify.annotations.NonNull;

public class QueTVillagerTrade {
    protected static QTVillagerTrade trade(ResourceKey<VillagerProfession> villagerProfession,
                                           VillagerLevels villagerLevel, ItemLike from, ItemLike to) {
        return new QTVillagerTrade(villagerProfession, villagerLevel, from.asItem(), to.asItem());
    }

    protected static QTVillagerTrade trade(ResourceKey<VillagerProfession> villagerProfession,
                                           VillagerLevels villagerLevel, ItemLike to) {
        return new QTVillagerTrade(villagerProfession, villagerLevel, to.asItem());
    }


}
