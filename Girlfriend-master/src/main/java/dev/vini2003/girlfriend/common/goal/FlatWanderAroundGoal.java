package dev.vini2003.girlfriend.common.goal;

import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class FlatWanderAroundGoal extends WanderAroundGoal {
	public FlatWanderAroundGoal(PathAwareEntity mob, double speed) {
		super(mob, speed);
	}
	
	public FlatWanderAroundGoal(PathAwareEntity mob, double speed, int chance) {
		super(mob, speed, chance);
	}
	
	public FlatWanderAroundGoal(PathAwareEntity entity, double speed, int chance, boolean canDespawn) {
		super(entity, speed, chance, canDespawn);
	}
	
	@Nullable
	@Override
	protected Vec3d getWanderTarget() {
		return NoPenaltyTargeting.find(this.mob, 10, 0);
	}
}
