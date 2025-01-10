package dev.vini2003.girlfriend.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class ClientUtils {
	public static MinecraftClient getInstance() {
		return MinecraftClient.getInstance();
	}
	
	public static ClientPlayerEntity getPlayer() {
		return getInstance().player;
	}
}
