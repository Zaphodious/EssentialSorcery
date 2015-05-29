package io.github.zaphodious.essentialsorcery.gui;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.util.ResourceLocation;
import cyano.poweradvantage.api.simple.SimpleMachineGUI;
import cyano.poweradvantage.math.Integer2D;

public class RuneTableGUI extends SimpleMachineGUI {

	
	protected int guiHeight;
	
	public RuneTableGUI() {
		super(	new ResourceLocation(Reference.MODID + ":textures/client/gui/rune_table_advantage.png"),
				Integer2D.fromCoordinates(19,19, 148,18, 100,8, 80,8, 60,8, 60,28, 80,28, 100,28));
		
		
		System.out.println(this.guiDisplayImage);
		// TODO Auto-generated constructor stub
		
		
	}

	

}
