package dev.vini2003.girlfriend;

import dev.vini2003.girlfriend.registry.common.GFNetworks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class GF implements ModInitializer {
	public static final String ID = "girlfriend";
	
	public static final UUID GIRLFRIEND_UUID = UUID.fromString("15331286-6cb2-4f9e-bae9-4da8b246a00f");
	
	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}
	
	@Override
	public void onInitialize() {
		GFNetworks.init();
	}
}
