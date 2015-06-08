package io.github.zaphodious.essentialsorcery.entity;

import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.entity.monster.EntityHobgoblin;
import io.github.zaphodious.essentialsorcery.item.EssentialMonsterPlacer;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterMobs {

	public static void registerMobs() {
		registerModEntityWithEgg(EntityHobgoblin.class, "hobgoblin", 3000, 0xFFA62E, 0x820000);
	}
	
	
	public static void registerModEntityWithEgg(Class parEntityClass, String parEntityName, int parEntityID, 
		      int parEggColor, int parEggSpotsColor)
		{
		    EntityRegistry.registerModEntity(parEntityClass, parEntityName, parEntityID, 
		          EssentialSorcery.instance, 80, 3, false);
		   
		}
}
