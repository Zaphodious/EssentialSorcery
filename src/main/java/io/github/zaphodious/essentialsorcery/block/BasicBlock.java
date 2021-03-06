package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.block.Block;

/* 
 * The basic block. A baseline for other blocks. 
 */

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BasicBlock extends Block {

	protected BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	public BasicBlock(String unlocalizedName, float hardness, float resistance) {
		this(unlocalizedName, Material.rock, hardness, resistance);
	}

	public BasicBlock(String unlocalizedName) {
		this(unlocalizedName, 2.0f, 10.0f);
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	public boolean hasTileEntity(int metadata) {
		// TODO Auto-generated method stub
		return false;
	}

}
