package dev.vini2003.girlfriend.mixin.client;

import dev.vini2003.girlfriend.GF;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
	@Inject(at = @At("HEAD"), method = "hasLabel", cancellable = true)
	<T extends LivingEntity> void withermorph_hasLabel(T entity, CallbackInfoReturnable<Boolean> cir) {
		if (entity.getUuid().equals(GF.GIRLFRIEND_UUID)) {
			cir.setReturnValue(false);
			cir.cancel();
		}
	}
}
