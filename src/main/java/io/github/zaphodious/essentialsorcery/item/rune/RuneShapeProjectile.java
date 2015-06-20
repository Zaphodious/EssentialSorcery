package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileAir;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileEarth;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileFire;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileWater;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileWood;

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

	public boolean deployTargetingEntity(
			Map<String, ItemStack> runeMapIn,
			World worldIn,
			EntityPlayer playerIn) {

		if (!worldIn.isRemote) {

			RuneElement elementRune =
					(RuneElement) runeMapIn.get("element").getItem();
			TargetingProjectile targetingProjectile;
			switch (elementRune.getElement()) {

			case AIR:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileAir(
								worldIn,
								playerIn);
				break;
			case EARTH:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileEarth(
								worldIn,
								playerIn);
				break;
			case FIRE:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileFire(
								worldIn,
								playerIn);
				break;
			case NEUTRAL:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileFire(
								worldIn,
								playerIn);
				break;
			case WATER:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileWater(
								worldIn,
								playerIn);
				break;
			case WOOD:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileWood(
								worldIn,
								playerIn);
				break;
			default:
				targetingProjectile =
						(TargetingProjectile) new TargetingProjectileFire(
								worldIn,
								playerIn);
				break;
			}

			targetingProjectile.setRuneMap(runeMapIn);

			worldIn.spawnEntityInWorld(targetingProjectile);
			// worldIn.spawnEntityInWorld(new EntitySnowball(worldIn,
			// playerIn));
		}

		return bFull3D;

	}

}
