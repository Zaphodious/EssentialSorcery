package io.github.zaphodious.essentialsorcery.spellcasting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSorter {

	Map<Integer, Element> biomes;
	
	
	
	
	public BiomeSorter() {
		biomes = new HashMap<Integer, Element>();
	}
	
	public void printMap() {
		for (int biomeID : biomes.keySet()) {
			System.out.println("Biome ID: " + biomeID + " Element: " + biomes.get(biomeID));
		}
	}
	
	public void fillBiomeList() {
		// http://minecraft.gamepedia.com/Biome#Biome_IDs
		// The IDs were gathered using information in that link.
		// The elemental affiliation is based on the following:
		// https://docs.google.com/forms/d/1Sf2FAivFflC51FnJGPDhD0R5mnqsININeWGu22L-tlk/viewanalytics?usp=form_confirm
		// (Note - the results might have changed since adding the biomes. If you notify the head of this repo
		// about it, he'll change it accordingly.)
		
		// To-Do: add Biomes Aplenty biome IDs
		
		addBiome(0, Element.WATER); // Ocean
		addBiome(1, Element.EARTH); // Plains
		addBiome(2, Element.FIRE); // Desert
		addBiome(3, Element.EARTH); // Extreme Hills
		addBiome(4, Element.WOOD); // Forest
		addBiome(5, Element.AIR); // Taiga
		addBiome(6, Element.WATER); // Swampland
		addBiome(7, Element.WATER); // River
		addBiome(8, Element.FIRE); // Hell
		addBiome(9, Element.AIR); // The End
		addBiome(10, Element.AIR); // FrozenOcean
		addBiome(11, Element.AIR); // FrozenRiver
		addBiome(12, Element.AIR); // Ice Plains
		addBiome(13, Element.AIR); // Ice Mountains
		addBiome(14, Element.EARTH); // MushroomIsland
		addBiome(15, Element.EARTH); // MushroomIslandShore
		addBiome(16, Element.WATER); // Beach
		addBiome(17, Element.FIRE); // DesertHills
		addBiome(18, Element.WOOD); // ForestHills
		addBiome(19, Element.AIR); // TaigaHills
		addBiome(20, Element.EARTH); // Extreme Hills Edge
		addBiome(21, Element.WOOD); // Jungle
		addBiome(22, Element.WOOD); // JungleHills
		addBiome(23, Element.WOOD); // JungleEdge
		addBiome(24, Element.WATER); // Deep Ocean
		addBiome(25, Element.EARTH); // Stone Beach
		addBiome(26, Element.AIR); // Cold Beach
		addBiome(27, Element.WOOD); // Birch Forest
		addBiome(28, Element.WOOD); // Birch Forest Hills
		addBiome(29, Element.WOOD); // Roofed Forest
		addBiome(30, Element.AIR); // Cold Taiga
		addBiome(31, Element.AIR); // Cold Taiga Hills
		addBiome(32, Element.AIR); // Mega Taiga
		addBiome(33, Element.AIR); // Mega Taiga Hills
		addBiome(34, Element.EARTH); // Extreme Hills+
		addBiome(35, Element.FIRE); // Savanna
		addBiome(36, Element.FIRE); // Savanna Plateau
		addBiome(37, Element.FIRE); // Mesa
		addBiome(38, Element.FIRE); // Mesa Plateau F
		addBiome(39, Element.FIRE); // Mesa Plateau
		
		addBiome(129, Element.AIR); // Sunflower Plains
		addBiome(130, Element.FIRE); // Desert M
		addBiome(131, Element.EARTH); // Extreme Hills vM
		addBiome(132, Element.WOOD); // Flower Forest
		addBiome(133, Element.AIR); // Taiga M
		addBiome(134, Element.WATER); // Swampland M
		
		addBiome(140, Element.AIR); // Ice Plains Spikes
		addBiome(149, Element.WOOD); // Jungle M
		
		addBiome(151, Element.WOOD); // JungleEdge M
		
		addBiome(155, Element.WOOD); // Birch Forest M
		addBiome(156, Element.WOOD); // Birch Forest Hills M
		addBiome(157, Element.WOOD); // Roofed Forest M
		addBiome(158, Element.AIR); // Cold Taiga M
		
		addBiome(160, Element.WOOD); // Mega Spruce Taiga
		addBiome(161, Element.WOOD); // Redwood Taiga Hills M
		addBiome(162, Element.EARTH); // Extreme Hills+ M
		addBiome(163, Element.FIRE); // Savanna M
		addBiome(164, Element.FIRE); // Savanna Plateau M
		addBiome(165, Element.FIRE); // Mesa (Bryce)
		addBiome(166, Element.FIRE); // Mesa Plateau F M
		addBiome(167, Element.FIRE); // Mesa Plateau M
	}

	public void addBiome(int biomeID, Element element) {
		this.biomes.put(biomeID, element);
	}

	public int getBiomeID(World worldIn, BlockPos pos) {
		BiomeGenBase biome = worldIn.getBiomeGenForCoords(pos);
		System.out.println("Biome: " + biome.biomeName + " ID: " + biome.biomeID);
		return biome.biomeID;
	}
	
	public Element getBiomeElement(World worldIn, BlockPos pos) {
		int biomeID = this.getBiomeID(worldIn, pos);
		
		return biomes.get(biomeID);
	}

	/**
	 * @return the biomes
	 */
	public Map<Integer, Element> getBiomes() {
		return biomes;
	}


	
	
}
