package dev.vini2003.girlfriend.registry.client;

import dev.vini2003.girlfriend.GF;
import dev.vini2003.girlfriend.registry.common.GFNetworks;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

public class GFKeybinds {
	public static final KeyBinding KEY_FIRE = KeyBindingHelper.registerKeyBinding(new KeyBinding("Fire", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F, "Girlfriend"));

	public static void init() {
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			if (KEY_FIRE.wasPressed()) {
				if (client.player != null) {// && client.player.getUuid().equals(GF.GIRLFRIEND_UUID)) {
					ClientPlayNetworking.send(GFNetworks.FIRE, new PacketByteBuf(Unpooled.buffer()));
				}
			}
		});
	}
}
