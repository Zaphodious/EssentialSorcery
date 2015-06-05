package io.github.zaphodious.essentialsorcery.spellcasting;

public class Essence {

	private Element element;
	private int amount;
	private int max;
	public Essence(int amount, Element element) {
		this.max = amount;
		this.element = element;
		this.amount = amount;
	}
	
	
	public Essence(int amount, Element element, int max) {

		this.element = element;
		this.amount = amount;
		this.max = max;
	}


	public Element getElement() {
		return element;
	}

	public int getAmount() {
		return amount;
	}

	
	public boolean addEssence(Essence essenceToAdd) {
		if (essenceToAdd.getAmount() + this.amount > max || essenceToAdd.getElement() != this.element) {
			return false;
		}
		
		this.amount +=essenceToAdd.getAmount();
		return true;
	}
	
	
}
