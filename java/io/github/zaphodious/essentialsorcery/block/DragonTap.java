package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.block.states.TapState;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.IMetaBlockName;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.EssenceAccepter;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.Essence;
import io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cyano.basemetals.init.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * 
 *  The backbone of early casting.
 *  
 *  The base, cobble-stone-made block is placed in the world, and then
 *  if the player has a dragon wand equipped and ten experience built up+6
 *  upon right click it switches to a thing that gives essence.
 *  
 *  TO-DO: Configure this thing so that it visually indicates what element
 *  it gives off.
 *  
 */

public class DragonTap extends BasicBlock implements IMetaBlockName,
		GivesEssence {

	private static final PropertyEnum TYPE = PropertyEnum.create("type",
			io.github.zaphodious.essentialsorcery.block.states.TapState.class);
	private int xpLevelCostToSet;

	public DragonTap(String unlocalizedName) {
		super(unlocalizedName);
		
		this.xpLevelCostToSet = 10;
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE,
				TapState.PLACED));
		this.setTickRandomly(true);
	}

	public DragonTap setState(TapState newState) {
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE,
				newState));
		return this;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getCurrentEquippedItem();
		
		/*
		 * 
		 * We really, *really* don't want to try and manipulate
		 * ItemStacks that aren't there. It crashes the game.
		 * So, we check to see if this is such an ItemStack
		 * 
		 */
		
		if (stack == null) {
			return false;
		}
		
		
		
		Item item = stack.getItem();
		UsesEssence caster = null;
		GivesEssence giver = (GivesEssence) worldIn.getBlockState(pos)
				.getBlock();

		/*
		 * 
		 * this block checks to see if the player is holding a tap setter
		 * (called a Dragon Wand in the lang file), and if they are
		 * *and* the player has ten levels, takes those ten levels
		 * and "sets" the tap. If the player is in creative mode, it lets
		 * them do it anyway. Unless the player is in creative mode,
		 * a "spent" tap cannot be "set".
		 * 
		 */
		
		if (item == ModItems.tapSetter
				&& (state.equals(this.getStateFromMeta(0)) || playerIn.capabilities.isCreativeMode)) {
			
			if (this.xpLevelCostToSet > playerIn.experienceLevel && !playerIn.capabilities.isCreativeMode) {
				return false;
			}
			if (!playerIn.capabilities.isCreativeMode) playerIn.addExperienceLevel(-10);
			this.dragonToSet(worldIn, pos);
			return true;
		}
		
		/*
		 * 
		 * If the player isn't holding a tap setter (checked
		 * for in the last block), this checks to see if they are holding 
		 * an item that implements the "UsesEssence" interface. If not, 
		 * we cannot continue.
		 * 
		 */

		/*try { // If this block doesn't implement the GivesEssence interface, the
				// function stops.
			caster = (UsesEssence) item;
		} catch (Exception e) {
			System.out
					.println(item.toString() + "Didn't pass the caster test.");
			return false;
		}

		if (caster.getElement() != this.getElement(worldIn, pos)
				&& caster.getElement() != Element.NEUTRAL) {
			System.out.println(item.toString()
					+ "Didn't pass the element test.");
			return false; // If this block doesn't give the right type of
							// essence, the function stops.
		}*/

		if (giver.canTap(worldIn, pos)) {

			Essence newEssence = this.getEssence(worldIn, pos);

			if (stack.getItem() instanceof UsesEssence) {
				UsesEssence thisEssenceUser = (UsesEssence) stack.getItem();
				if (thisEssenceUser.takeInEssence(newEssence, stack)) {
					DragonTap.dragonToSpent(worldIn, pos);
					return true;
				}
			}
			
			/*System.out.println("This Damage: " + stack.getItemDamage()
					+ " New Essence amount :" + newEssence.getAmount()
					+ " while this Damage Limit = " + caster.getMaxDamage());

			if (newEssence.getAmount() > caster.getDamage(stack)) {
				System.out.println("Didn't pass the amount test.");
				return false; // If this will add more essence then the max, the
								// function stops.
			}

			stack.setItemDamage(stack.getItemDamage() - newEssence.getAmount());
			
			// stack.damageItem(newEssence.getAmount(), playerIn);
			// this.setDamage(stack, this.getDamage(stack) -
			// newEssence.getAmount());
			return true;*/
		}

		return false;// super.onBlockActivated(worldIn, pos, state, playerIn,
						// side, hitX, hitY, hitZ);
		//

	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { TYPE });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState toReturn = null;
		if (meta == 1) {
			toReturn = getDefaultState().withProperty(TYPE, TapState.SET);
		} else if (meta == 2) {
			toReturn = getDefaultState().withProperty(TYPE, TapState.SPENT);
		} else {
			toReturn = getDefaultState().withProperty(TYPE, TapState.PLACED);
		}
		return toReturn;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		TapState type = (TapState) state.getValue(TYPE);
		return type.getID();
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		list.add(new ItemStack(itemIn, 1, 0)); // Meta 0
		list.add(new ItemStack(itemIn, 1, 1)); // Meta 1
		list.add(new ItemStack(itemIn, 1, 2)); // Meta 2
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world,
			BlockPos pos) {
		return new ItemStack(Item.getItemFromBlock(this), 1,
				this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		String toReturn = "placed";

		if (stack.getItemDamage() == 1) {
			toReturn = "set";
		} else if (stack.getItemDamage() == 2) {
			toReturn = "spent";
		}

		/*System.out.println("The special name for" + stack.toString() + " is "
				+ toReturn);*/

		return toReturn;
	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state,
			Random rand) {
		System.out.println(worldIn.getCelestialAngle(1.0F));
		if (state.equals(this.getStateFromMeta(2))) { // && worldIn.getC)
			float angle = worldIn.getCelestialAngle(1.0F);
			if (angle > 0.7F && angle < 0.85F) {
				System.out.println("and it got through at "
						+ worldIn.getWorldTime());
				this.refreshTap(worldIn, pos);
			}

		}
	}

	public static void dragonToSet(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, ModBlocks.dragon_tap.getBlockState()
				.getBaseState().withProperty(TYPE, TapState.SET));
	}

	public static void dragonToSpent(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, ModBlocks.dragon_tap.getBlockState()
				.getBaseState().withProperty(TYPE, TapState.SPENT));
	}

	public void refreshTap(World worldIn, BlockPos pos) {
		this.dragonToSet(worldIn, pos);
	}

	public void refreshAllTaps(World worldIn) {

	}

	@Override
	public Essence getEssence(World worldIn, BlockPos pos) {

		return new Essence(1, this.getElement(worldIn, pos));
	}

	@Override
	public Element getElement(World worldIn, BlockPos pos) {

		return Reference.SORTER.getBiomeElement(worldIn, pos);
	}

	@Override
	public Boolean canTap(World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		int meta = block.getMetaFromState(iblockstate);
		System.out.println("This block's meta is " + meta);
		if (meta == 1) {
			return true;
		}

		return false;
	}

	public Boolean tap(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos) == this.getStateFromMeta(1)) {
			this.dragonToSpent(worldIn, pos);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getItemDropped(net.minecraft.block.state.
	 * IBlockState, java.util.Random, int)
	 */
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return ModItems.dragonTapPlacer;
	}
	
	
	 
	

	public boolean renderAsNormalBlock()
	{
	    return false;
	}
	
	public boolean isFullCube()
    {
        return false;
    }
	
	public int getLightOpacity(World world, int x, int y, int z) 
	{
	    return 0;
	}
	
	

	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#getLightValue(net.minecraft.world.IBlockAccess, net.minecraft.util.BlockPos)
	 */
	@Override
	public int getLightValue(IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos).equals(this.getStateFromMeta(1))) {
			return 5;
		}
		
		return 0;
	}

}
