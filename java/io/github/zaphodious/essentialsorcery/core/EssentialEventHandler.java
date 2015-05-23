package io.github.zaphodious.essentialsorcery.core;

import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

public class EssentialEventHandler {

	public void resetTapsAfterSleep(PlayerWakeUpEvent e) {
		World world = e.entityPlayer.getEntityWorld();
		System.out.println(e.entityPlayer.getName() + " slept!");
	}
	
}
