package spellcasting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSorter {

	Map<BiomeGenBase, Element> biomes;
	
	
	
	
	public BiomeSorter() {
		biomes = new HashMap<BiomeGenBase, Element>();
		
	}
	
	private void populateMap() {
		
	}




	public BiomeGenBase getBiome(World worldIn, BlockPos pos) {
		BiomeGenBase biome = worldIn.getBiomeGenForCoords(pos);
		return biome;
	}
}
