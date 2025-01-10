package dev.vini2003.girlfriend.registry.client;

import dev.vini2003.girlfriend.GF;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class GFSounds {
	public static final SoundEvent KEY_TYPED = Registry.register(Registry.SOUND_EVENT, GF.id("sound.girlfriend.key_typed"), new SoundEvent(GF.id("sound.girlfriend.key_typed")));
	
	public static void init() {}
}
