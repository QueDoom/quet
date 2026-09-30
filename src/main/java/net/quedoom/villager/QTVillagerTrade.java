package net.quedoom.villager;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.quedoom.quet.init.ModRegistrator;
import net.quedoom.quet.misc.GetPath;

import java.util.List;
import java.util.Optional;

public class QTVillagerTrade {

    private final ResourceKey<VillagerProfession> villagerProfession;
    private final VillagerLevels villagerLevel;
    private final ItemLike payment;
    private final ItemLike product;

    private Optional<ResourceKey<VillagerTrade>> key = Optional.empty();

    public QTVillagerTrade(ResourceKey<VillagerProfession> villagerProfession, VillagerLevels villagerLevel,
                           ItemLike payment, ItemLike product) {
        this.villagerProfession = villagerProfession;
        this.villagerLevel = villagerLevel;
        this.payment = payment;
        this.product = product;
    }

    public QTVillagerTrade(ResourceKey<VillagerProfession> villagerProfession, VillagerLevels villagerLevel, ItemLike product) {
        this.villagerProfession = villagerProfession;
        this.villagerLevel = villagerLevel;
        this.payment = Items.EMERALD;
        this.product = product;
    }

    public ResourceKey<VillagerProfession> villagerProfession() {
        return villagerProfession;
    }
    public VillagerLevels villagerLevel() {
        return villagerLevel;
    }
    public ItemLike payment() {
        return payment;
    }
    public ItemLike product() {
        return product;
    }

    public ResourceKey<VillagerTrade> key(String namespace) {
        if (key.isEmpty()) {
            key = Optional.of(
            ResourceKey.create(Registries.VILLAGER_TRADE, new ModRegistrator(namespace).of(
                    villagerProfession.identifier().getPath() + '_' +
                            villagerLevel.value() + '_' +
                            GetPath.get(payment.asItem()) + '_' +
                            GetPath.get(product.asItem())))
            );
        }
        return key.get();
    }

    public TagKey<VillagerTrade> tag() {
        return switch (villagerProfession.identifier().getPath()) {
            case "armorer" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.ARMORER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.ARMORER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.ARMORER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.ARMORER_LEVEL_4;
                case MASTER -> VillagerTradeTags.ARMORER_LEVEL_5;
            };
            case "butcher" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.BUTCHER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.BUTCHER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.BUTCHER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.BUTCHER_LEVEL_4;
                case MASTER -> VillagerTradeTags.BUTCHER_LEVEL_5;
            };
            case "cartographer" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.CARTOGRAPHER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.CARTOGRAPHER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.CARTOGRAPHER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.CARTOGRAPHER_LEVEL_4;
                case MASTER -> VillagerTradeTags.CARTOGRAPHER_LEVEL_5;
            };
            case "cleric" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.CLERIC_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.CLERIC_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.CLERIC_LEVEL_3;
                case EXPERT -> VillagerTradeTags.CLERIC_LEVEL_4;
                case MASTER -> VillagerTradeTags.CLERIC_LEVEL_5;
            };
            case "farmer" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.FARMER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.FARMER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.FARMER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.FARMER_LEVEL_4;
                case MASTER -> VillagerTradeTags.FARMER_LEVEL_5;
            };
            case "fisherman" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.FISHERMAN_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.FISHERMAN_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.FISHERMAN_LEVEL_3;
                case EXPERT -> VillagerTradeTags.FISHERMAN_LEVEL_4;
                case MASTER -> VillagerTradeTags.FISHERMAN_LEVEL_5;
            };
            case "fletcher" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.FLETCHER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.FLETCHER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.FLETCHER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.FLETCHER_LEVEL_4;
                case MASTER -> VillagerTradeTags.FLETCHER_LEVEL_5;
            };
            case "leatherworker" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.LEATHERWORKER_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.LEATHERWORKER_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.LEATHERWORKER_LEVEL_3;
                case EXPERT -> VillagerTradeTags.LEATHERWORKER_LEVEL_4;
                case MASTER -> VillagerTradeTags.LEATHERWORKER_LEVEL_5;
            };
            case "librarian" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.LIBRARIAN_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.LIBRARIAN_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.LIBRARIAN_LEVEL_3;
                case EXPERT -> VillagerTradeTags.LIBRARIAN_LEVEL_4;
                case MASTER -> VillagerTradeTags.LIBRARIAN_LEVEL_5;
            };
            case "mason" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.MASON_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.MASON_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.MASON_LEVEL_3;
                case EXPERT -> VillagerTradeTags.MASON_LEVEL_4;
                case MASTER -> VillagerTradeTags.MASON_LEVEL_5;
            };
            case "shepherd" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.SHEPHERD_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.SHEPHERD_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.SHEPHERD_LEVEL_3;
                case EXPERT -> VillagerTradeTags.SHEPHERD_LEVEL_4;
                case MASTER -> VillagerTradeTags.SHEPHERD_LEVEL_5;
            };
            case "toolsmith" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.TOOLSMITH_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.TOOLSMITH_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.TOOLSMITH_LEVEL_3;
                case EXPERT -> VillagerTradeTags.TOOLSMITH_LEVEL_4;
                case MASTER -> VillagerTradeTags.TOOLSMITH_LEVEL_5;
            };
            case "weaponsmith" -> switch (villagerLevel) {
                case NOVICE -> VillagerTradeTags.WEAPONSMITH_LEVEL_1;
                case APPRENTICE -> VillagerTradeTags.WEAPONSMITH_LEVEL_2;
                case JOURNEYMAN -> VillagerTradeTags.WEAPONSMITH_LEVEL_3;
                case EXPERT -> VillagerTradeTags.WEAPONSMITH_LEVEL_4;
                case MASTER -> VillagerTradeTags.WEAPONSMITH_LEVEL_5;
            };
            default ->
                    throw new IllegalArgumentException(
                            "Villager profession " + villagerProfession.identifier().getNamespace() +
                                    ':' + villagerProfession.identifier().getPath() + "illegal");
        };
    }

    public void bootstrap(BootstrapContext<VillagerTrade> context, String namespace,
                          int paymentAmount, int productAmount, int maxUses, int xp, float reputationDiscount,
                          final Optional<LootItemCondition> merchantPredicate,
                          final List<LootItemFunction> givenItemModifiers) {
        context.register(key(namespace), buildTrade(paymentAmount, productAmount, maxUses, xp, reputationDiscount,
                merchantPredicate, givenItemModifiers));
    }

    public void bootstrap(BootstrapContext<VillagerTrade> context, String namespace,
                          int paymentAmount, int maxUses, int xp, float reputationDiscount,
                          final Optional<LootItemCondition> merchantPredicate,
                          final List<LootItemFunction> givenItemModifiers) {
        context.register(key(namespace), buildTrade(paymentAmount, maxUses, xp, reputationDiscount,
                merchantPredicate, givenItemModifiers));
    }

    public void bootstrap(BootstrapContext<VillagerTrade> context, String namespace,
                          int paymentAmount, int maxUses, int xp, float reputationDiscount) {
        context.register(key(namespace), buildTrade(paymentAmount, maxUses, xp, reputationDiscount));
    }

    public void bootstrap(BootstrapContext<VillagerTrade> context, String namespace,
                          int paymentAmount, int maxUses, int xp) {
        context.register(key(namespace), buildTrade(paymentAmount, maxUses, xp));
    }

    public void bootstrap(BootstrapContext<VillagerTrade> context, String namespace,
                          int paymentAmount, int xp) {
        context.register(key(namespace), buildTrade(paymentAmount, xp));
    }

    public VillagerTrade buildTrade(int paymentAmount, int productAmount, int maxUses, int xp, float reputationDiscount,
                                    final Optional<LootItemCondition> merchantPredicate,
                                    final List<LootItemFunction> givenItemModifiers) {
        return new VillagerTrade(
                new TradeCost(this.payment, paymentAmount),
                new ItemStackTemplate(product.asItem(), productAmount),
                maxUses, xp, reputationDiscount,
                merchantPredicate, givenItemModifiers
        );
    }

    public VillagerTrade buildTrade(int paymentAmount, int maxUses, int xp, float reputationDiscount,
                                    final Optional<LootItemCondition> merchantPredicate,
                                    final List<LootItemFunction> givenItemModifiers) {
        return new VillagerTrade(
                new TradeCost(this.payment, paymentAmount),
                new ItemStackTemplate(product.asItem(), 1),
                maxUses, xp, reputationDiscount,
                merchantPredicate, givenItemModifiers
        );
    }

    public VillagerTrade buildTrade(int paymentAmount, int maxUses, int xp, float reputationDiscount) {
        return buildTrade(paymentAmount, maxUses, xp, reputationDiscount,
                Optional.empty(), List.of());
    }

    public VillagerTrade buildTrade(int paymentAmount, int productAmount, int maxUses, int xp, float reputationDiscount) {
        return buildTrade(paymentAmount, productAmount, maxUses, xp, reputationDiscount,
                Optional.empty(), List.of());
    }

    public VillagerTrade buildTrade(int paymentAmount, int maxUses, int xp) {
        return buildTrade(paymentAmount, maxUses, xp, 0.05F);
    }

    public VillagerTrade buildTrade(int paymentAmount, int xp) {
        return buildTrade(paymentAmount, 12, xp, 0.05F);
    }





}
