package io.github.zaphodious.essentialsorcery.spellcasting;

public class Essence {

	Element element;
	int amount;
	public Essence(int amount, Element element) {
		super();
		this.element = element;
		this.amount = amount;
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
