package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.BiomeSorter;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class Reference {
	
	/*
	 * 
	 * Our global variables. Keeps everything in check.
	 * 
	 */

	public static final String MODID = "essentialsorcery";
    public static final String MODNAME = "Essential Sorcery";
    public static final String VERSION = "0.0.1";
    public static final String CLIENT_PROXY = "io.github.zaphodious.essentialsorcery.core.ClientProxy";
    public static final String SERVER_PROXY = "io.github.zaphodious.essentialsorcery.core.ServerProxy";

    public static final BiomeSorter SORTER = new BiomeSorter();
    
    public static final EssentialTab tabEssential = new EssentialTab("tabEssential");
    
    public static final int[] MANA_COST_ARRAY = makeManaCosts();
    
    


private static int[] makeManaCosts() {
	
	/*
	 * 
	 * This makes our mana cost series. All mana costs and essence
	 * amounts are derived from this series (either hard-coded or
	 * referencing MANA_COST_ARRAY.)
	 * 
	 * Interestingly enough, the Fibbi number of 49 is so large we
	 * can't store it as a 32-bit signed integer (it goes negative).
	 * 
	 * I like 42 a lot more, and I like having a bit of wiggle
	 * room. Besides, a mana cost of Fibbi(42) is very unlikely to ever
	 * actually be made, let alone used. It's really quite high.
	 * (If I am proven comically incorrect in the future, you can all
	 * point to this and laugh.)
	 * 
	 */
	
	
	int[] manaCostAt = new int[43];
    manaCostAt[0] = 0;
    manaCostAt[1] = 1;
    
    for (int i = 2; i <= 42; i++) {
        manaCostAt[i] = manaCostAt[(i-1)] + manaCostAt[(i-2)];
    }
    
    System.out.println(manaCostAt);
    
    return manaCostAt;
}



}