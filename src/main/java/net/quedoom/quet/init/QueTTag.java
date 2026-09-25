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


public class QueTTag extends ModRegistrator {
    public static class QTItemTags {
        protected static TagKey<net.minecraft.world.item.Item> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.ITEM, ModRegistrator.of(name));
        }

        protected static TagKey<Item> materialRepairable(String material) {
            return create(material + "_repairable");
        }

    }
    public static class QTBlockTags {
       protected static TagKey<Block> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.BLOCK, ModRegistrator.of(name));
        }

        protected static TagKey<Block> toolMineable(String tool) {
           return create("mineable/" + tool);
        }

        protected static TagKey<Block> materialIncorrect(String material) {
           return create("incorrect_for_" + material);
        }
        protected static TagKey<Block> materialNeeds(String material) {
           return create("needs_" + material);
        }
    }
    public static class QTBlockEntityTags {
       protected static TagKey<BlockEntityType<?>> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.BLOCK_ENTITY_TYPE, ModRegistrator.of(name));
        }
    }
    public static class QTEntityTags {
        protected static TagKey<EntityType<?>> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.ENTITY_TYPE, ModRegistrator.of(name));
        }
    }
    public static class QTFluidTags {
        protected static TagKey<Fluid> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.FLUID, ModRegistrator.of(name));
        }
    }
    public static class TQPotionTags {
        protected static TagKey<Potion> create(String name) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.POTION, ModRegistrator.of(name));
        }
    }
    public static class QTVillagerTradeTags {
        protected static TagKey<VillagerTrade> createWithLevel(String name, int level) {
            if (ModRegistrator.namespace() == null) {
                throw new NullPointerException("Unset namespace in " + QueTTag.class);
            }
            return TagKey.create(Registries.VILLAGER_TRADE,
                    Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), name + "/level_" + level));
        }
    }


}
