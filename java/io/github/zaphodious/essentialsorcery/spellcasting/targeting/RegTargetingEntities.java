package io.github.zaphodious.essentialsorcery.spellcasting.targeting;

import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class RegTargetingEntities {

	public static void Reg() {
		
		EntityRegistry.registerModEntity(TargetingProjectileFire.class, "FireProjectile", 3, EssentialSorcery.instance, 50, 1, true);
		EntityRegistry.registerModEntity(TargetingProjectileWater.class, "WaterProjectile", 4, EssentialSorcery.instance, 50, 1, true);
		EntityRegistry.registerModEntity(TargetingProjectileEarth.class, "EarthProjectile", 5, EssentialSorcery.instance, 50, 1, true);
		EntityRegistry.registerModEntity(TargetingProjectileAir.class, "AirProjectile", 6, EssentialSorcery.instance, 50, 1, true);
		EntityRegistry.registerModEntity(TargetingProjectileWood.class, "WoodProjectile", 7, EssentialSorcery.instance, 50, 1, true);
	}
	
}
