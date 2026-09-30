package net.quedoom.quet.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluid;
import net.quedoom.quet.misc.GetPath;
import org.jspecify.annotations.NonNull;


public class QueTTag {
    public class QTItemTags extends ModRegistrator {
        public QTItemTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<net.minecraft.world.item.Item> create(String name) {
            return TagKey.create(Registries.ITEM, of(name));
        }

        public TagKey<Item> materialRepairable(String material) {
            return create(material + "_repairable");
        }

    }
    public class QTBlockTags extends ModRegistrator {
        public QTBlockTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, of(name));
        }

        public TagKey<Block> toolMineable(String tool) {
           return create("mineable/" + tool);
        }

        public TagKey<Block> materialIncorrect(String material) {
           return create("incorrect_for_" + material);
        }
        public TagKey<Block> materialNeeds(String material) {
           return create("needs_" + material);
        }
    }
    public class QTBlockEntityTags extends ModRegistrator {
        public QTBlockEntityTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<BlockEntityType<?>> create(String name) {
            return TagKey.create(Registries.BLOCK_ENTITY_TYPE, of(name));
        }
    }
    public class QTEntityTags extends ModRegistrator {
        public QTEntityTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<EntityType<?>> create(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, of(name));
        }
    }
    public class QTFluidTags extends ModRegistrator {
        public QTFluidTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<Fluid> create(String name) {
            return TagKey.create(Registries.FLUID, of(name));
        }
    }
    public class TQPotionTags extends ModRegistrator {
        public TQPotionTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<Potion> create(String name) {
            return TagKey.create(Registries.POTION, of(name));
        }
    }
    public class QTVillagerTradeTags extends ModRegistrator {
        public QTVillagerTradeTags(@NonNull String namespace) {
            super(namespace);
        }

        public TagKey<VillagerTrade> createWithLevel(String name, int level) {
            return TagKey.create(Registries.VILLAGER_TRADE,
                    Identifier.fromNamespaceAndPath(namespace(), name + "/level_" + level));
        }
    }


}
