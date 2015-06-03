package io.github.zaphodious.essentialsorcery.spellcasting;

public enum DropChance {
	COMMON(.1),
	UNCOMMON(.05),
	RARE(.001),
	ULTRARARE(.0001);
	
	double probability;
	
	DropChance(double probability) {
		this.probability = probability;
	}

	/**
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}
	
	
}