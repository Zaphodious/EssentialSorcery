package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.gui.Gui_Enum;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class TestingTable extends Block {

	protected TestingTable(String name) {
		super(Material.cloth);
		super.setUnlocalizedName(name);
		this.setHardness(0.1F);
		this.setResistance(0.1F);
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		
		if (worldIn.isRemote) {
			System.out.println("You've activated this block!");
			playerIn.openGui(Reference.MODID, Gui_Enum.TESTING_TABLE.getID(),worldIn, pos.getX(), pos.getY(), pos.getZ());

		}
				

		return true;
	}

}