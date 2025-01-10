package dev.vini2003.girlfriend.mixin.client;

import dev.vini2003.girlfriend.GF;
import net.minecraft.client.render.entity.WitherSkullEntityRenderer;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WitherSkullEntityRenderer.class)
public class WitherSkullEntityRendererMixin {
	private static final Identifier gf_TEXTURE = GF.id("textures/entity/wither/wither.png");
	
	@Overwrite
	public Identifier getTexture(WitherSkullEntity witherSkullEntity) {
		return gf_TEXTURE;
	}
}
