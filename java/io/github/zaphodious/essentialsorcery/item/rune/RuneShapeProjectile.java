package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneShapeProjectile extends RuneShape {

	public RuneShapeProjectile(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Thrown";
	}
	
	public boolean deployTargetingEntity(Map<String,ItemStack> runeMapIn, World worldIn,
			EntityPlayer playerIn) {
		
		if (!worldIn.isRemote) {
			
			TargetingProjectile targetingProjectile = new TargetingProjectile(worldIn, playerIn);
			targetingProjectile.setRuneMap(runeMapIn);
			
			worldIn.spawnEntityInWorld(targetingProjectile);
			//worldIn.spawnEntityInWorld(new EntitySnowball(worldIn, playerIn));
		}
		
		
		
		return bFull3D;
		
	}

}
