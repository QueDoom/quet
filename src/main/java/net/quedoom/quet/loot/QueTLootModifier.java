package net.quedoom.quet.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class QueTLootModifier {
    protected void addItemToLootTable(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                      Identifier equals, float chance, ItemLike itemLike, UniformGenerator between) {
        if (key.identifier().equals(equals)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1F))
                    .when(LootItemRandomChanceCondition.randomChance(chance))
                    .add(LootItem.lootTableItem(itemLike))
                    .apply(SetItemCountFunction.setCount(between));
            builder.pool(poolBuilder.build());
        }
    }
}
