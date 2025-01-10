package dev.vini2003.girlfriend.client.util;

import dev.vini2003.girlfriend.registry.client.GFSounds;
import net.minecraft.client.sound.PositionedSoundInstance;

public class SoundUtils {
	public static void playKeyTyped() {
		ClientUtils.getInstance().getSoundManager().play(PositionedSoundInstance.master(GFSounds.KEY_TYPED, 0.5F));
	}
}
