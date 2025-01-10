package dev.vini2003.girlfriend.client.prompt;

public class Choice {
	private String prompt;
	
	private String left;
	private String top;
	private String right;
	
	private Choice leftChoice;
	private Choice topChoice;
	private Choice rightChoice;
	
	private Choice() {}
	
	public Choice(String prompt, String left, String top, String right) {
		this.prompt = prompt;
		this.left = left;
		this.top = top;
		this.right = right;
	}
	
	public String prompt() {
		return prompt;
	}
	
	public Choice prompt(String prompt) {
		this.prompt = prompt;
		return this;
	}
	
	public String left() {
		return left;
	}
	
	public Choice left(String left) {
		this.left = left;
		return this;
	}
	
	public String top() {
		return top;
	}
	
	public Choice top(String top) {
		this.top = top;
		return this;
	}
	
	public String right() {
		return right;
	}
	
	public Choice right(String right) {
		this.right = right;
		return this;
	}
	
	public Choice replies(String left, String top, String right) {
		left(left);
		top(top);
		right(right);
		return this;
	}
	
	public Choice leftChoice() {
		if (this.leftChoice == null) this.leftChoice = new Choice();
		return leftChoice;
	}
	
	public Choice leftChoice(Choice leftChoice) {
		this.leftChoice = leftChoice;
		return this;
	}
	
	public Choice topChoice() {
		if (this.topChoice == null) this.topChoice = new Choice();
		return topChoice;
	}
	
	public Choice topChoice(Choice topChoice) {
		this.topChoice = topChoice;
		return this;
	}
	
	public Choice rightChoice() {
		if (this.rightChoice == null) this.rightChoice = new Choice();
		return rightChoice;
	}
	
	public Choice rightChoice(Choice rightChoice) {
		this.rightChoice = rightChoice;
		return this;
	}
	
	public Choice choice(Choice choice) {
		choices(choice, choice, choice);
		return this;
	}
	
	public Choice choices(Choice leftChoice, Choice topChoice, Choice rightChoice) {
		leftChoice(leftChoice);
		topChoice(topChoice);
		rightChoice(rightChoice);
		return this;
	}
}
