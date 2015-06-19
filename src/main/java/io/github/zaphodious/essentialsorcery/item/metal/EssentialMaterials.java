package io.github.zaphodious.essentialsorcery.item.metal;

import cyano.basemetals.init.Materials;
import cyano.basemetals.material.MetalMaterial;

public class EssentialMaterials extends Materials {

	public static MetalMaterial Jade;
	
	public static void initMaterials() {
		Materials.registerMaterial("Jade", Jade);
	}
	
}
