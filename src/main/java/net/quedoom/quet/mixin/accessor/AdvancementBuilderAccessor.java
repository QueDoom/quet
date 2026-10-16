package net.quedoom.quet.mixin.accessor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Optional;

@Mixin(Advancement.Builder.class)
public interface AdvancementBuilderAccessor {
    @Accessor("criteria")
    ImmutableMap.Builder<String, Criterion<?>> quet$getCriteria();

    @Accessor("requirementsStrategy")
    AdvancementRequirements.Strategy quet$getRequirementsStrategy();

    @Accessor("requirementsStrategy")
    void quet$setRequirementsStrategy(AdvancementRequirements.Strategy strategy);

    @Accessor("requirements")
    Optional<AdvancementRequirements> quet$getRequirements();

    @Accessor("requirements")
    void quet$setRequirements(Optional<AdvancementRequirements> requirements);

    @Accessor("parent")
    Optional<Identifier> quet$getParent();

    @Accessor("display")
    Optional<DisplayInfo> quet$getDisplay();

    @Accessor("rewards")
    AdvancementRewards quet$getRewards();
}