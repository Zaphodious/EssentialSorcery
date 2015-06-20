package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.gen.GenTest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Trowel extends ItemSpade {

	public Trowel(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#onItemUse(net.minecraft.item.ItemStack,
	 * net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World,
	 * net.minecraft.util.BlockPos, net.minecraft.util.EnumFacing, float, float,
	 * float)
	 */
	@Override
	public boolean onItemUse(
			ItemStack stack,
			EntityPlayer playerIn,
			World worldIn,
			BlockPos pos,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ) {
		// TODO Auto-generated method stub
		// GenTest.makeASimpleBuilding(stack, playerIn, worldIn, pos, side,
		// hitX, hitY, hitZ, 22, 33, 44);
		GenTest.genTestStructure(
				stack,
				playerIn,
				worldIn,
				pos,
				side,
				hitX,
				hitY,
				hitZ);
		return super.onItemUse(
				stack,
				playerIn,
				worldIn,
				pos,
				side,
				hitX,
				hitY,
				hitZ);

	}

}
