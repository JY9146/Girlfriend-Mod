package dev.vini2003.girlfriend.client.widget;

import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.util.math.MatrixStack;

public class WEmptyPanel extends WPlainPanel {
	public WEmptyPanel() {
		setBackgroundPainter(null);
	}
	
	@Override
	protected void expandToFit(WWidget w) {}
	
	@Override
	protected void expandToFit(WWidget w, Insets insets) {}
	
	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		for (var child : children) {
			child.paint(matrices, x + child.getX(), y + child.getY(), mouseX-child.getX(), mouseY-child.getY());
		}
	}
}
