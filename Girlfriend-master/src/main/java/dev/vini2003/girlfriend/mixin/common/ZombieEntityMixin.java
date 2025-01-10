package dev.vini2003.girlfriend.mixin.common;

import dev.vini2003.girlfriend.common.goal.FlatWanderAroundGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends MobEntity {
	protected ZombieEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V")
	private void gf_init(EntityType<? extends ZombieEntity> entityType, World world, CallbackInfo ci) {
		setPersistent();
	}
	
	@Inject(at = @At("RETURN"), method = "initCustomGoals")
	private void gf_initCustomGoals(CallbackInfo ci) {
		this.goalSelector.getGoals().removeIf(it -> it.getGoal() instanceof WanderAroundGoal);
		this.goalSelector.add(7, new FlatWanderAroundGoal((ZombieEntity) (Object) this, 1.0D));
	}
	
	@Overwrite
	public boolean burnsInDaylight() {
		return false;
	}
}
