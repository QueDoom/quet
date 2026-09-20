package net.quedoom.quet.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public abstract class QueTBlockStateLootProvider extends FabricBlockLootSubProvider {
    protected QueTBlockStateLootProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    protected void addCrop(Block cropBlock, IntegerProperty age, int maxAge, Item cropItem, Item cropSeeds) {
        this.add(cropBlock, this.createCropDrops(cropBlock, cropItem, cropSeeds,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, maxAge))
        ));
    }

    protected void addBush(Block bushBlock, Item bushItem) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(bushBlock,
                (block) -> this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SWEET_BERRY_BUSH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(bushItem)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))).withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bushBlock)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2)))
                        .add(LootItem.lootTableItem(bushItem)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))));
    }

}
