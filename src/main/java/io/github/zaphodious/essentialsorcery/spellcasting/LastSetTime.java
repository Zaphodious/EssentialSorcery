package io.github.zaphodious.essentialsorcery.spellcasting;

import net.minecraft.world.World;

public class LastSetTime {

	float lastCelestialAngle;
	World world;
	
	public LastSetTime(float celestialAngle, World world){
		this.world = world;
	}
	
}
