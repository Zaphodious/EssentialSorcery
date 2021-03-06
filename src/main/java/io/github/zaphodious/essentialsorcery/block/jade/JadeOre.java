package io.github.zaphodious.essentialsorcery.block.jade;

import io.github.zaphodious.essentialsorcery.block.states.DragonTapState;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.block.BasicBlock;
import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ISmartBlockModel;

public class JadeOre extends BasicBlock {

	private static final PropertyEnum ELEMENT = PropertyEnum.create(
			"element",
			io.github.zaphodious.essentialsorcery.spellcasting.Element.class);
	private int genCounter;

	public JadeOre(String unlocalizedName) {
		super(unlocalizedName);

		this.setDefaultState(this.blockState.getBaseState().withProperty(ELEMENT, Element.NEUTRAL));

		this.genCounter = 0;
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

		Element thisElement = Element.NEUTRAL;
		try {
			thisElement = Reference.SORTER.getBiomeElement((World) world, pos);
		} catch (Exception e) {
			System.out.println(e);
		}

		List toReturn = new ArrayList<ItemStack>();
		toReturn.add(new ItemStack(Blocks.cobblestone));
		Random rng = new Random();
		int amount = (fortune >= 3) ? 9 : rng.nextInt(2) + 1 + (fortune * 2);
		// if fortune is 3, we just give them 9 bits of dust.
		// However, we *do not* want the output to be more then what it takes

		toReturn.add(new ItemStack(ModItems.jade_raw, amount, thisElement.getID()));

		return toReturn;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { ELEMENT });
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

		// state = this.getActualState(state, worldIn, pos);

		super.onBlockAdded(worldIn, pos, state);
		if (worldIn.setBlockState(pos, ModBlocks.jade_ore.getActualState(state, worldIn, pos))) {
			// System.out.println("Ore #" + genCounter++ + " spawned at " +
			// pos.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#onBlockPlaced(net.minecraft.world.World,
	 * net.minecraft.util.BlockPos, net.minecraft.util.EnumFacing, float, float,
	 * float, int, net.minecraft.entity.EntityLivingBase)
	 * 
	 * @Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos,
	 * EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
	 * EntityLivingBase placer) {
	 * 
	 * return super .onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta,
	 * placer).withProperty(ELEMENT, Reference.SORTER.getBiomeElement(worldIn,
	 * pos));
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getActualState(net.minecraft.block.state.
	 * IBlockState, net.minecraft.world.IBlockAccess,
	 * net.minecraft.util.BlockPos)
	 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		World thisWorld = (World) worldIn;

		Element thisElement = Reference.SORTER.getBiomeElement(thisWorld, pos);

		return state.withProperty(ELEMENT, thisElement);

	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return getDefaultState().withProperty(ELEMENT, Element.getElementForID(meta));

	}

	@Override
	public int getMetaFromState(IBlockState state) {
		Element element = (Element) state.getValue(ELEMENT);
		return element.getID();
	}
	/*
	 * @Override public IBlockState getStateFromMeta(int meta) { IBlockState
	 * toReturn = null; if (meta == 1) { toReturn =
	 * getDefaultState().withProperty(TYPE, TapState.SET); } else if (meta == 2)
	 * { toReturn = getDefaultState().withProperty(TYPE, TapState.SPENT); } else
	 * { toReturn = getDefaultState().withProperty(TYPE, TapState.PLACED); }
	 * return toReturn; }
	 * 
	 * @Override public int getMetaFromState(IBlockState state) { TapState type
	 * = (TapState) state.getValue(TYPE); return type.getID(); }
	 */

}
