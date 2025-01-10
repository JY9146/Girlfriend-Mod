package dev.vini2003.girlfriend.registry.client;

import dev.vini2003.girlfriend.client.screen.GirlfriendScreen;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

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
	}
}
