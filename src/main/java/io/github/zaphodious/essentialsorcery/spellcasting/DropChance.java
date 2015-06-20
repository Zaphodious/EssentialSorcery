package io.github.zaphodious.essentialsorcery.spellcasting;

public enum DropChance {
	COMMON(.5), UNCOMMON(.3), RARE(.1), ULTRARARE(.01), SUPERRARE(.001);

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