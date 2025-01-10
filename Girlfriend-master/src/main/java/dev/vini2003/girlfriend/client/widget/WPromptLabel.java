package dev.vini2003.girlfriend.client.widget;

import dev.vini2003.girlfriend.client.util.ClientUtils;
import dev.vini2003.girlfriend.client.util.DelayUtils;
import dev.vini2003.girlfriend.client.util.SoundUtils;
import io.github.cottonmc.cotton.gui.client.LibGui;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class WPromptLabel extends WLabel implements WTickable, WFinishable {
	private long ticks = 0;
	
	public WPromptLabel(String text) {
		super(text);
	}
	
	@Override
	public long getTicks() {
		return ticks;
	}
	
	@Override
	public void setTicks(long ticks) {
		this.ticks = ticks;
	}
	
	@Override
	public boolean isFinished() {
		return ticks == getText().getString().length();
	}
	
	@Override
	public void tick() {
		if (!isFinished()) {
			if (getTicks() % 2 == 0) {
				SoundUtils.playKeyTyped();
			}
			
			setTicks(getTicks() + 1);

			if (isFinished()) {
				DelayUtils.setDelay(20);
			}
		}
	}
	
	@Override
	public WLabel setText(Text text) {
		setTicks(0);
		
		return super.setText(text);
	}
	
	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		var instance = ClientUtils.getInstance();
		
		var renderer = instance.textRenderer;
		
		var yOffset = switch (verticalAlignment) {
			case CENTER -> height / 2 - renderer.fontHeight / 2;
			case BOTTOM -> height - renderer.fontHeight;
			default -> 0;
		};
		
		var text = getText();
		
		var letters = Math.min(ticks, text.getString().length());
		
		var exposedLabel = new LiteralText(text.getString().substring(0, (int) (letters)));
		
		ScreenDrawing.drawString(matrices, exposedLabel.asOrderedText(), horizontalAlignment, x, y + yOffset, this.getWidth(), LibGui.isDarkMode() ? darkmodeColor : color);
		
		var hoveredTextStyle = getTextStyleAt(mouseX, mouseY);
		
		ScreenDrawing.drawTextHover(matrices, hoveredTextStyle, x + mouseX, y + mouseY);
	}
}
