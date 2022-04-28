package com.kuuma.vanillagolems.entity.custom;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.level.Level;

public class FireGolemEntity extends SnowGolem {
    public FireGolemEntity(EntityType<? extends SnowGolem> p_29902_, Level p_29903_) {
        super(p_29902_, p_29903_);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D).build();
    }

    public boolean isOnFire() {
        return false;
    }

    public float getBrightness() {
        return 10.0F;
    }

    protected ParticleOptions getParticleType() {
        return ParticleTypes.SMOKE;
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

}
