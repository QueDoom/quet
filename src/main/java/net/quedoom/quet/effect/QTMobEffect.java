package net.quedoom.quet.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public abstract class QTMobEffect extends MobEffect {
    protected QTMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        return applyEffect(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return shouldAppleEffect(tickCount, amplification);
    }

    protected abstract boolean applyEffect(ServerLevel level, LivingEntity entity, int amplification);
    protected abstract boolean shouldAppleEffect(int tickCount, int amplification);
}
