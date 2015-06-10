package io.github.zaphodious.essentialsorcery.item.metal;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.util.Locale;

import cyano.basemetals.BaseMetals;
import cyano.basemetals.material.MetalMaterial;

public  class Jade extends MetalMaterial {

	String thisEnumName;
	
	public Jade(String name) {
		super(name, 20, 15, 20, 30);
		// Jade is harder then diamond, and significantly stronger and more magical.
		// It is rather uncommon in dungeon chests.
		
		thisEnumName = (Reference.MODID+"_"+name).toUpperCase(Locale.ENGLISH);
	}

	
	




	@Override
	public String getEnumName() {
		// TODO Auto-generated method stub
		return thisEnumName;
	}






	@Override
	public int getToolHarvestLevel() {
		// TODO Auto-generated method stub
		return 4;
	}



	@Override
	public float getToolEfficiency() {
		// TODO Auto-generated method stub
		return super.getToolEfficiency();
	}
	
	
	
	
	
}
