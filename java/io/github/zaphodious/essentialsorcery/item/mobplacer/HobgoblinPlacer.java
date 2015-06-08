package io.github.zaphodious.essentialsorcery.item.mobplacer;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.entity.monster.EntityHobgoblin;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class HobgoblinPlacer extends Item {

	public HobgoblinPlacer(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
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
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			EntityHobgoblin entityHobgoblin = new EntityHobgoblin(worldIn);

			entityHobgoblin.setLocationAndAngles(pos.getX(), pos.getY()+1,
					pos.getZ(), playerIn.rotationYaw, 0.0F);

			worldIn.spawnEntityInWorld(entityHobgoblin);
			if (!playerIn.capabilities.isCreativeMode) {
				--stack.stackSize;
			}
			return true;
		}

	}

}
