package dev.vini2003.girlfriend.registry.client;

import dev.vini2003.girlfriend.client.screen.GirlfriendScreen;
import dev.vini2003.girlfriend.registry.common.GFNetworks;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;

public class GFCommands {
	public static void init() {
		ClientCommandManager.DISPATCHER.register(
			ClientCommandManager.literal("gf").executes(context -> {
				MinecraftClient.getInstance().send(() -> {
					MinecraftClient.getInstance().openScreen(new GirlfriendScreen());
				});
				
				return 1;
			})
		);

		ClientCommandManager.DISPATCHER.register(
			ClientCommandManager.literal("summongf").executes(context -> {
				ClientPlayNetworking.send(GFNetworks.SUMMON_GF, new PacketByteBuf(Unpooled.buffer()));
				return 1;
			})
		);
	}
}