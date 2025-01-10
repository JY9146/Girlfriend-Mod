package dev.vini2003.girlfriend.client.screen;

import dev.vini2003.girlfriend.GF;
import dev.vini2003.girlfriend.client.prompt.Choice;
import dev.vini2003.girlfriend.client.util.ClientUtils;
import dev.vini2003.girlfriend.client.widget.WPromptLabel;
import dev.vini2003.girlfriend.client.widget.WChoiceButton;
import dev.vini2003.girlfriend.client.widget.WEmptyPanel;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class GirlfriendScreen extends CottonClientScreen {
	public GirlfriendScreen() {
		super(new Description());
	}
	
	@Override
	public void renderBackground(MatrixStack matrices) {}
	
	@Override
	public void removed() {}
	
	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		var description = (Description) this.description;
		
		for (var choice : description.CHOICES) {
			if (choice.isHovered() && choice.getTicks() >= choice.getLabel().getString().length() - 1) {
				choice.onClick(0, 0, 0);
			}
		}
		
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public boolean isPauseScreen() {
		return false;
	}
	
	private static class Description extends LightweightGuiDescription {
		public WChoiceButton choiceLeft = new WChoiceButton();
		public WChoiceButton choiceTop = new WChoiceButton();
		public WChoiceButton choiceRight = new WChoiceButton();
		
		public final WChoiceButton[] CHOICES = new WChoiceButton[] { choiceLeft, choiceTop, choiceRight };
		
		public WPromptLabel prompt = new WPromptLabel("");
		
		public WSprite arrows = new WSprite(GF.id("textures/gui/arrows.png"));
		
		private Choice choice = createInitialChoice();
		
		public Choice createInitialChoice() {
			var _1 = new Choice(
					"Hi!",
					"Hey!",
					"Hi!",
					"Yo!");
			
			var _2 = new Choice(
					"What's up?",
					"Not much, what about you?",
					"Just being really awesome and surrounded by women, you?",
					"It's... well, it's going - and you?"
			);
			
			_1.choice(_2);
			
			var _3 = new Choice(
					"I'm fine, been hanging out with my friends a lot lately.",
					"friends... yeah, must be fun.",
					"My friends are likely better.",
					"That's amazing; they must be cool!"
			);
			
			_2.choice(_3);
			
			var _4 = new Choice(
					"Uh, anyway, what's that you've got?",
					"That's tea, 'cus England is my city.",
					"I drink rich people juice like Orange Juice.",
					"That's none of your business."
			);
			
			_3.choice(_4);
			
			var _5 = new Choice(
					"Ah, I see... you drink that every day?",
					"Yeah, tho' it ain't my favorite.",
					"Stop interrogating me.",
					"Yes, but it's not quite on point."
			);
			
			_4.choice(_5);
			
			var _6 = new Choice(
					"Okay… Y'know, you should check out the new houses towards the East!",
					"I ain't ever been there; how's it?",
					"Literally I don’t care shut up.",
					"Okay! I will maybe probably not"
			);
			
			_5.choice(_6);
			
			var _7 = new Choice(
					"Well, friends tell me they’re the best houses in the world!",
					"Okay, cool!",
					"Your friends sound stupid.",
					"They must be kidding."
			);
			
			_6.choice(_7);
			
			var _8 = new Choice(
					"They wouldn't lie about that... let's move on, though.",
					"Okay… your friends sound like liars.",
					"Where do you live.",
					"Oh I’m sorry, I didn’t mean to upset you"
			);
			
			_7.choice(_8);
			
			var _9 = new Choice(
					"I'm from a large city, past the suburbs.",
					"Has it got any women?",
					"It is nice? Like you? You are nice.",
					"Don’t care never did"
			);
			
			_8.choice(_9);
			
			var _10 = new Choice(
					"I'm beginning to think we won't work out...",
					"Why?",
					"That makes no sense.",
					"No Woman. You are wrong."
			);
			
			_9.choice(_10);
			
			var _11 = new Choice(
					"You haven't been nice to me. You are not a nice person.",
					"I’m sorry. I really didn’t mean to.",
					"That’s not true no i’m not you’re just wrong",
					"Stop it"
			);
			
			_10.choice(_11);
			
			var _12 = new Choice(
					"Yes, yes you have, and it's annoying.",
					"You're telling me I'm annoying?",
					"Look, most people find me annoying at first.",
					"FUCK YOU!"
			);
			
			_11.choice(_12);
			
			var _13 = new Choice(
					"Look, this clearly won't work. Why don't you go meet new girls in the suburbs?",
					"Do you have women friends there?",
					"Bye bye Lady Woman.",
					"Have they got any women there?"
			);
			
			_12.choice(_13);
			
			var _14 = new Choice(
					"Let me tell you a story.",
					"Sure, go ahead.",
					"No. All the words you say I hate.",
					"I can tell a better one."
			);
			
			_13.choice(_14);
			
			var _15 = new Choice(
					"There once were two happy, young men...",
					"Are you talking about me and my friend?",
					"What'd they do?",
					"Stop talking."
			);
			
			_14.choice(_15);
			
			var _16 = new Choice(
					"They said they were funny, but they were lying.",
					"They are the funniest.",
					"What happened to them?",
					"Stop."
			);
			
			_15.choice(_16);
			
			var _17 = new Choice(
					"They died! - get out of here!",
					"Okay. You are terrible.",
					"No, I can’t leave you!",
					"I think you are ugly."
			);
			
			_16.choice(_17);
			
			var _18 = new Choice(
					"I’m gonna tell my friends about you. They don’t like mean people.",
					"I’m not mean you are just stupid",
					"I’m so sorry for what I’ve just done.",
					"Bye Bye."
			);
			
			_17.choice(_18);
			
			return _1;
		}
		
		private static Text t(String text) {
			return new LiteralText(text);
		}
		
		private static int w(WChoiceButton button) {
			return MinecraftClient.getInstance().textRenderer.getWidth(button.getLabel()) + 12;
		}
		
		private static int w(WPromptLabel label) {
			return MinecraftClient.getInstance().textRenderer.getWidth(label.getText());
		}
		
		private void left(String text) {
			var panelX = 0;
			var panelY = -18;
			
			var panelHeight = rootPanel.getHeight();
			
			choiceLeft.setLabel(t(text));
			choiceLeft.setSize(w(choiceLeft), 20);
			choiceLeft.setLocation(panelX - w(choiceLeft), 84 + panelY + panelHeight / 2 - 10);
		}
		
		private void top(String text) {
			var panelX = 0;
			var panelY = -18;
			
			var panelWidth = rootPanel.getWidth();
			
			choiceTop.setLabel(t(text));
			choiceTop.setSize(w(choiceTop), 20);
			choiceTop.setLocation(panelX + panelWidth / 2 - w(choiceTop) / 2, 84 + panelY - 20);
		}
		
		private void right(String text) {
			var panelX = 0;
			var panelY = -18;
			
			var panelWidth = rootPanel.getWidth();
			var panelHeight = rootPanel.getHeight();
			
			choiceRight.setLabel(t(text));
			choiceRight.setSize(w(choiceRight), 20);
			choiceRight.setLocation(panelX + panelWidth, 84 + panelY + panelHeight / 2 - 10);
		}
		
		private void prompt(String text) {
			var panelX = 0;
			var panelY = -18;
			
			var panelWidth = rootPanel.getWidth();
			
			prompt.setText(t(text));
			prompt.setSize(w(prompt), 20);
			prompt.setLocation(panelX + panelWidth / 2 - w(prompt) / 2, 36 + panelY);
		}
		
		public Description() {
			var panel = new WEmptyPanel();
			var panelWidth = 32;
			var panelHeight = 32;
			
			setRootPanel(panel);
			
			panel.setSize(panelWidth, panelHeight);
			
			var window = MinecraftClient.getInstance().getWindow();
			var windowWidth = window.getWidth();
			var windowHeight = window.getHeight();
			
			var panelX = windowWidth / 2 - panelWidth / 2;
			var panelY = windowHeight - (18 * 4) - panelHeight;
			
			panel.setLocation(panelX, panelY);
			
			panel.add(prompt, 0, 0);
			
			panel.add(choiceLeft, 0, 0);
			panel.add(choiceTop, 0, 0);
			panel.add(choiceRight, 0, 0);
			
			choiceLeft.setChoice(choiceTop);
			choiceTop.setAnswer(prompt);
			choiceRight.setChoice(choiceLeft);
			
			panel.setSize(panelWidth, panelHeight);
			
			prompt.setColor(0xFFFFFFFF);
			
			choiceLeft.setOnClick(() -> update(choiceLeft));
			choiceTop.setOnClick(() -> update(choiceTop));
			choiceRight.setOnClick(() -> update(choiceRight));
			
			panel.add(arrows, 0, 0);
			
			arrows.setSize(24, 24);
			arrows.setLocation(4, 88 - 18);
			
			panel.validate(this);
			
			panel.setBackgroundPainter(null);
			
			prompt(choice.prompt());
			left(choice.left());
			top(choice.top());
			right(choice.right());
		}
		
		private void update(WChoiceButton button) {
			if (button == choiceLeft) {
				choice = choice.leftChoice();
			} else if (button == choiceTop) {
				choice = choice.topChoice();
			} else {
				choice = choice.rightChoice();
			}
			
			if (choice.prompt() == null) {
				var instance = ClientUtils.getInstance();
				
				instance.currentScreen.onClose();
				
				return;
			}
			
			prompt(choice.prompt());
			
			if (choice.top() != null) {
				top(choice.top());
				choiceLeft.setChoice(choiceTop);
				choiceLeft.setAnswer(null);
			} else {
				top("");
				choiceLeft.setChoice(null);
				choiceLeft.setAnswer(prompt);
			}
			
			if (choice.left() != null) {
				left(choice.left());
				choiceRight.setChoice(choiceLeft);
				choiceRight.setAnswer(null);
			} else {
				left("");
				choiceRight.setChoice(null);
				choiceRight.setAnswer(prompt);
			}
			
			if (choice.right() != null) {
				right(choice.right());
			} else {
				right("");
			}
		}
	}
}
