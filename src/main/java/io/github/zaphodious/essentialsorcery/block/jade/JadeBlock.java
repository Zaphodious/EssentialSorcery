package io.github.zaphodious.essentialsorcery.block.jade;

import io.github.zaphodious.essentialsorcery.block.BasicBlock;
import io.github.zaphodious.essentialsorcery.item.IMetaBlockName;
import io.github.zaphodious.essentialsorcery.item.ItemBlockMeta;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class JadeBlock extends BasicBlock implements IMetaBlockName {

	private static final PropertyEnum ELEMENT = PropertyEnum.create(
			"element",
			io.github.zaphodious.essentialsorcery.spellcasting.Element.class);

	public JadeBlock(String unlocalizedName) {
		super(unlocalizedName, Material.iron, 2F, 100F);

		this.setHarvestLevel("pickaxe", 2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(
				ELEMENT,
				Element.FIRE));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getLightValue()
	 */
	@Override
	public int getLightValue() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World,
	 * net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState,
	 * net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumFacing,
	 * float, float, float)
	 */
	@Override
	public boolean onBlockActivated(
			World worldIn,
			BlockPos pos,
			IBlockState state,
			EntityPlayer playerIn,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ) {
		return this.activate(worldIn, pos, playerIn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.block.Block#onEntityCollidedWithBlock(net.minecraft.world
	 * .World, net.minecraft.util.BlockPos, net.minecraft.entity.Entity)
	 */
	@Override
	public void onEntityCollidedWithBlock(
			World worldIn,
			BlockPos pos,
			Entity entityIn) {
		this.activate(worldIn, pos, entityIn);
	}

	private boolean activate(World worldIn, BlockPos pos, Entity entityIn) {

		int strengthFactor = this.blocksDeep(worldIn, pos);

		int duration = ((strengthFactor / 3) + 1) * 100;
		int effectLevel = (strengthFactor) / 2 + 1;
		boolean particles = false;

		if (entityIn instanceof EntityLivingBase) {
			EntityLivingBase livingEntity = (EntityLivingBase) entityIn;
			Element element =
					(Element) worldIn.getBlockState(pos).getValue(ELEMENT);
			switch (element) {
			case AIR:
				livingEntity.addPotionEffect(new PotionEffect(Potion.jump
						.getId(), duration, effectLevel, false, particles));
				break;
			case EARTH:
				livingEntity.addPotionEffect(new PotionEffect(Potion.resistance
						.getId(), duration, effectLevel, false, particles));
				break;
			case FIRE:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;
			case NEUTRAL:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;
			case WATER:
				livingEntity.addPotionEffect(new PotionEffect(
						Potion.waterBreathing.getId(),
						duration,
						effectLevel,
						false,
						particles));
				break;
			case WOOD:
				livingEntity.addPotionEffect(new PotionEffect(
						Potion.regeneration.getId(),
						duration,
						effectLevel,
						false,
						particles));
				break;
			default:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;
			}

			livingEntity.addPotionEffect(new PotionEffect(Potion.nightVision
					.getId(), duration * 2, effectLevel, false, particles));
		}

		return false;
	}

	/*
	 * @Override public Item getItemDropped(IBlockState state, Random rand, int
	 * fortune) {
	 * 
	 * Element element = (Element) state.getValue(ELEMENT);
	 * 
	 * switch (element) { case AIR: return ModItems.jadeBlockBluePlacer; case
	 * EARTH: return ModItems.jadeBlockWhitePlacer; case FIRE: return
	 * ModItems.jadeBlockRedPlacer; case NEUTRAL: return
	 * ModItems.jadeBlockRedPlacer; case WATER: return
	 * ModItems.jadeBlockBlackPlacer; case WOOD: return
	 * ModItems.jadeBlockGreenPlacer; default: return
	 * ModItems.jadeBlockRedPlacer;
	 * 
	 * } }
	 */

	public boolean checkElement(World worldIn, BlockPos pos) {

		if (worldIn.getBlockState(pos).getBlock() instanceof JadeBlock) {
			JadeBlock thisToCheck =
					(JadeBlock) worldIn.getBlockState(pos).getBlock();
			Element element =
					(Element) worldIn.getBlockState(pos).getValue(ELEMENT);
			if (Element.getElementForID(thisToCheck.getMetaFromState(worldIn
					.getBlockState(pos))) == element) {
				return true;
			}
		}
		return false;
	}

	public int blocksDeep(World worldIn, BlockPos pos) {
		BlockPos checkPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		int toReturn = 0;
		JadeBlock thisToCheck = null;

		while (this.checkElement(worldIn, checkPos)) {
			checkPos = checkPos.down();
		}
		checkPos = checkPos.up();
		while (this.checkElement(worldIn, checkPos)) {
			checkPos = checkPos.up();
			toReturn++;

		}
		return toReturn;
	}

	@Override
	public String getSpecialName(ItemStack stack) {

		return Element.getElementForID(stack.getMetadata()).getStateName();

	}

	public Element getElement(ItemStack stackIn) {
		if (stackIn.getItem() instanceof ItemBlockMeta) {
			Element toReturn = Element.FIRE;
			for (Element element : Element.values()) {
				if (element.getID() == stackIn.getItemDamage()) {
					toReturn = element;
				}
			}
			return toReturn;
		} else {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getStateFromMeta(int)
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		// TODO Auto-generated method stub
		return getDefaultState().withProperty(
				ELEMENT,
				Element.getElementForID(meta));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.block.Block#getMetaFromState(net.minecraft.block.state.
	 * IBlockState)
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		// TODO Auto-generated method stub
		Element element = (Element) state.getValue(ELEMENT);
		return element.getID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getSubBlocks(net.minecraft.item.Item,
	 * net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			list.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { ELEMENT });
	}

	@Override
	public ItemStack getPickBlock(
			MovingObjectPosition target,
			World world,
			BlockPos pos) {
		return new ItemStack(
				Item.getItemFromBlock(this),
				1,
				this.getMetaFromState(world.getBlockState(pos)));
	}

}
