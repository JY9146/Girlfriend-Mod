package dev.vini2003.girlfriend.mixin.client;

import dev.vini2003.girlfriend.GF;
import dev.vini2003.girlfriend.client.screen.GirlfriendScreen;
import dev.vini2003.girlfriend.client.util.ClientUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(at = @At("HEAD"), method = "interact", cancellable = true)
	private void gf_interact(Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
		if (entity.getUuid().equals(GF.GIRLFRIEND_UUID)) {
			if (entity.world.isClient) {
				var instance = ClientUtils.getInstance();
				
				instance.openScreen(new GirlfriendScreen());
			}
		}
	}
}
