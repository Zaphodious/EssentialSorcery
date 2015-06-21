package io.github.zaphodious.essentialsorcery.item.rune;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;

public class RuneShapeSelf extends RuneShape {

	public RuneShapeSelf(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Self-Inflicted";
	}

	@Override
	public boolean deployTargetingEntity(Map<String, ItemStack> runeMap, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub

		for (String key : runeMap.keySet()) {
			if (key.contains("effect")) {
				RuneEffect effectRune = (RuneEffect) runeMap.get(key).getItem();
				effectRune.makeMagic(
						playerIn,
						worldIn,
						playerIn,
						runeMap,
						playerIn.getPosition(),
						new MovingObjectPosition(playerIn),
						key);
			}
		}

		return false;
	}

}
