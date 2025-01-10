package dev.vini2003.girlfriend.client.widget;

import dev.vini2003.girlfriend.client.util.DelayUtils;
import dev.vini2003.girlfriend.client.util.SoundUtils;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class WChoiceButton extends WButton implements WTickable, WFinishable {
	private long ticks = 0;
	
	private WPromptLabel answer;
	private WChoiceButton choice;
	
	private boolean hovered = false;
	
	@Override
	public void setTicks(long ticks) {
		this.ticks = ticks;
	}
	
	@Override
	public long getTicks() {
		return ticks;
	}
	
	@Override
	public boolean isFinished() {
		return ticks == getLabel().getString().length();
	}
	
	public boolean isHovered() {
		return hovered;
	}
	
	@Override
	public void tick() {
		if (!isFinished() && DelayUtils.getDelay() > 0 && ((choice != null && choice.isFinished()) || (answer != null && answer.isFinished()))) {
			DelayUtils.setDelay(DelayUtils.getDelay() - 1);
			
			return;
		}
		
		if (!isFinished() && ((answer != null && answer.isFinished()) || (choice != null && choice.isFinished()))) {
			if (getTicks() % 2 == 0) {
				SoundUtils.playKeyTyped();
			}
			
			setTicks(getTicks() + 1);
			
			if (isFinished()) {
				DelayUtils.setDelay(20 + getLabel().getString().length() / 2);
			}
		}
	}
	
	public void setAnswer(WPromptLabel answer) {
		this.answer = answer;
	}
	
	public void setChoice(WChoiceButton choice) {
		this.choice = choice;
	}
	
	@Override
	public WButton setLabel(Text label) {
		setTicks(0);
		
		return super.setLabel(label);
	}
	
	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		hovered = (mouseX>=0 && mouseY>=0 && mouseX<getWidth() && mouseY<getHeight());
		
		var enabled = isEnabled();

		var label = getLabel();
		
		var letters = Math.min(ticks, label.getString().length());
		
		var exposedLabel = new LiteralText(label.getString().substring(0, (int) (letters)));
		
		var percentage = ((float) letters) / (float) label.getString().length();
		
		if (percentage >= 0.01) {
			if (hovered) {
				ScreenDrawing.coloredRect(matrices, (int) (x + (getWidth() / 2) - (getWidth() / 2 * percentage)), y, (int) (getWidth() * percentage), getHeight(), 0x7E000000);
			} else {
				ScreenDrawing.coloredRect(matrices, (int) (x + (getWidth() / 2) - (getWidth() / 2 * percentage)), y, (int) (getWidth() * percentage), getHeight(), 0x3F000000);
			}
		}
		
		var color = 0xE0E0E0;
		
		if (!enabled) {
			color = 0xA0A0A0;
		}
		
		ScreenDrawing.drawStringWithShadow(matrices, exposedLabel.asOrderedText(), alignment, x, y + ((20 - 8) / 2), width, color);
	}
}
