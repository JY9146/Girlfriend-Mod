package dev.vini2003.girlfriend.registry.common;

import dev.vini2003.girlfriend.GF;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class GFNetworks {
	public static final Identifier FIRE = GF.id("fire");
	public static final Identifier SUMMON_GF = GF.id("summon_gf");

	private static void fire(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
		server.execute(() -> {
			Vec3d rotation = player.getRotationVector();
			
			WitherSkullEntity witherSkullEntity = new WitherSkullEntity(player.world, player, rotation.getX(), rotation.getY(), rotation.getZ());
			witherSkullEntity.setPos(witherSkullEntity.getX(), witherSkullEntity.getY() + player.getStandingEyeHeight(), witherSkullEntity.getZ());
			witherSkullEntity.setOwner(player);
			
			player.world.spawnEntity(witherSkullEntity);
		});
	}

	private static void summonGF(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
		server.execute(() -> {
			VillagerEntity girlfriend = new VillagerEntity(EntityType.VILLAGER, player.world);
			girlfriend.setCustomName(new LiteralText("Girlfriend"));
			girlfriend.setUuid(GF.GIRLFRIEND_UUID);
			girlfriend.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
			player.world.spawnEntity(girlfriend);
		});
	}
	
	public static void init() {
		ServerPlayNetworking.registerGlobalReceiver(FIRE, GFNetworks::fire);
		ServerPlayNetworking.registerGlobalReceiver(SUMMON_GF, GFNetworks::summonGF);
	}
}
