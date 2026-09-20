package net.quedoom.quet.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.QueTObjectStorage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class QueTItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public QueTItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    protected void addMisc() {
        List<Item> discs = QueTObjectStorage.discs();
        if (discs.isEmpty()) {
            ModRegistrator.logInfo("No Discs registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
            return;
        }
        for (Item disc : discs) {
            valueLookupBuilder(ConventionalItemTags.MUSIC_DISCS)
                    .add(disc);
        }
    }

    protected void addArmorSet(Item helmet, Item chestplate, Item leggings, Item boots) {
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(helmet);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(chestplate);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(leggings);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(boots);
    }

    protected void addBuckets() {
        List<Item> buckets = QueTObjectStorage.buckets();
        if (buckets.isEmpty()) {
            ModRegistrator.logInfo("No Buckets registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
            return;
        }
        for (Item bucket : buckets) {
            valueLookupBuilder(ConventionalItemTags.BUCKETS)
                    .add(bucket);
        }
    }

    protected void addArmor() {
        List<Item> helmets = QueTObjectStorage.helmets();
        List<Item> chestplates = QueTObjectStorage.chestplates();
        List<Item> leggings = QueTObjectStorage.leggings();
        List<Item> boots = QueTObjectStorage.boots();

        if (helmets.isEmpty()) {
            ModRegistrator.logInfo("No Helmets registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item helmet : helmets) {
                valueLookupBuilder(ItemTags.HEAD_ARMOR).add(helmet);
                valueLookupBuilder(ConventionalItemTags.ARMORS).add(helmet);
            }
        }
        if (chestplates.isEmpty()) {
            ModRegistrator.logInfo("No Chestplates registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item chestplate : chestplates) {
                valueLookupBuilder(ItemTags.CHEST_ARMOR).add(chestplate);
                valueLookupBuilder(ConventionalItemTags.ARMORS).add(chestplate);
            }
        }
        if (leggings.isEmpty()) {
            ModRegistrator.logInfo("No Leggings registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item legging : leggings) {
                valueLookupBuilder(ItemTags.LEG_ARMOR).add(legging);
                valueLookupBuilder(ConventionalItemTags.ARMORS).add(legging);
            }
        }
        if (boots.isEmpty()) {
            ModRegistrator.logInfo("No Boots registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item boot : boots) {
                valueLookupBuilder(ItemTags.FOOT_ARMOR).add(boot);
                valueLookupBuilder(ConventionalItemTags.ARMORS).add(boot);
            }
        }
    }

    protected void addToolsAndWeapons() {
        List<Item> swords = QueTObjectStorage.swords();
        List<Item> pickaxes = QueTObjectStorage.pickaxes();
        List<Item> axes = QueTObjectStorage.axes();
        List<Item> shovels = QueTObjectStorage.shovels();
        List<Item> hoes = QueTObjectStorage.hoes();
        List<Item> spears = QueTObjectStorage.spears();
        List<Item> shears = QueTObjectStorage.shears();
        List<Item> brushes = QueTObjectStorage.brushes();
        List<Item> bows = QueTObjectStorage.bows();
        List<Item> crossbows = QueTObjectStorage.crossbows();

        if (swords.isEmpty()) {
            ModRegistrator.logInfo("No Swords registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item sword : swords) {
                valueLookupBuilder(ItemTags.SWORDS).add(sword);
            }
        }
        if (axes.isEmpty()) {
            ModRegistrator.logInfo("No Axes registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item axe : axes) {
                valueLookupBuilder(ItemTags.AXES).add(axe);
            }
        }
        if (pickaxes.isEmpty()) {
            ModRegistrator.logInfo("No Pickaxes registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item pickaxe : pickaxes) {
                valueLookupBuilder(ItemTags.PICKAXES).add(pickaxe);
            }
        }
        if (hoes.isEmpty()) {
            ModRegistrator.logInfo("No Hoes registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item hoe : hoes) {
                valueLookupBuilder(ItemTags.HOES).add(hoe);
            }
        }
        if (shovels.isEmpty()) {
            ModRegistrator.logInfo("No Shovels registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item shovel : shovels) {
                valueLookupBuilder(ItemTags.SHOVELS).add(shovel);
            }
        }
        if (spears.isEmpty()) {
            ModRegistrator.logInfo("No Spears registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item spear : spears) {
                valueLookupBuilder(ItemTags.SPEARS).add(spear);
            }
        }
        if (shears.isEmpty()) {
            ModRegistrator.logInfo("No Shears registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item shear : shears) {
                valueLookupBuilder(ConventionalItemTags.SHEAR_TOOLS).add(shear);
            }
        }
        if (brushes.isEmpty()) {
            ModRegistrator.logInfo("No Brushes registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item brush : brushes) {
                valueLookupBuilder(ConventionalItemTags.BRUSH_TOOLS).add(brush);
            }
        }
        if (bows.isEmpty()) {
            ModRegistrator.logInfo("No Bows registered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item bow : bows) {
                valueLookupBuilder(ConventionalItemTags.BOW_TOOLS).add(bow);
            }
        }
        if (crossbows.isEmpty()) {
            ModRegistrator.logInfo("No Crossbowsregistered in " + QTTranslationBuilder.snakeToTitleCase(ModRegistrator.namespace()) + ". Skipping!");
        } else {
            for (Item crossbow : crossbows) {
                valueLookupBuilder(ConventionalItemTags.CROSSBOW_TOOLS).add(crossbow);
            }
        }
    }
}
