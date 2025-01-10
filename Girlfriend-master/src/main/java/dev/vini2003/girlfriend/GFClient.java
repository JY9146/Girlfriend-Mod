package dev.vini2003.girlfriend;

import dev.vini2003.girlfriend.registry.client.GFCommands;
import dev.vini2003.girlfriend.registry.client.GFKeybinds;
import dev.vini2003.girlfriend.registry.client.GFSounds;
import net.fabricmc.api.ClientModInitializer;

public class GFClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		GFCommands.init();
		GFSounds.init();
		GFKeybinds.init();
	}
}
