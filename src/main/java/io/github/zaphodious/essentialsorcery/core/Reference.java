package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.gen.EssentialWorldGen;
import io.github.zaphodious.essentialsorcery.spellcasting.BiomeSorter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reference {

	public static final String MODID = "essentialsorcery";
	public static final String MODNAME = "Essential Sorcery";
	public static final String VERSION = "1.0.1";
	public static final String CLIENT_PROXY = "io.github.zaphodious.essentialsorcery.core.ClientProxy";
	public static final String SERVER_PROXY = "io.github.zaphodious.essentialsorcery.core.ServerProxy";
	public static final String DEPENDENCIES = "required-after:poweradvantage;required-after:basemetals";

	public static final BiomeSorter SORTER = new BiomeSorter();

	public static final EssentialTab tabEssential = new EssentialTab("tabEssential");
	
	public static final EssentialWorldGen worldGen = new EssentialWorldGen();

	public static final int[] MANA_COST_ARRAY = makeManaCosts();

	private static int[] makeManaCosts() {
		int[] manaCostAt = new int[43];
		manaCostAt[0] = 0;
		manaCostAt[1] = 1;

		for (int i = 2; i <= 42; i++) {
			manaCostAt[i] = manaCostAt[(i - 1)] + manaCostAt[(i - 2)];
		}

		return manaCostAt;
	}

	public static boolean doesBeginWithVowel(String word) {
		Set<Character> vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		if (vowelSet.contains(Character.toLowerCase(word.charAt(0)))) {
			return true;
		}

		return false;
	}

}