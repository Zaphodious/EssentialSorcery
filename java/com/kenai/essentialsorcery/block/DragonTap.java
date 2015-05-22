package com.kenai.essentialsorcery.block;

import java.util.List;
import java.util.Random;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.kenai.essentialsorcery.block.states.TapState;
import com.kenai.essentialsorcery.core.Reference;
import com.kenai.essentialsorcery.item.IMetaBlockName;
import com.kenai.essentialsorcery.item.ModItems;
import com.kenai.essentialsorcery.spellcasting.Caster;
import com.kenai.essentialsorcery.spellcasting.Element;
import com.kenai.essentialsorcery.spellcasting.Essence;
import com.kenai.essentialsorcery.spellcasting.GivesEssence;

public class DragonTap extends BasicBlock implements IMetaBlockName,
		GivesEssence {

	public static final PropertyEnum TYPE = PropertyEnum.create("type",
			com.kenai.essentialsorcery.block.states.TapState.class);

	public DragonTap(String unlocalizedName) {
		super(unlocalizedName);

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
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getCurrentEquippedItem();
		Item item = stack.getItem();
		Caster caster = null;
		GivesEssence giver = (GivesEssence) worldIn.getBlockState(pos).getBlock();

		if ( item == ModItems.tapSetter) {
			this.dragonToSet(worldIn, pos);
			return true;
		}

		try { // If this block doesn't implement the GivesEssence interface, the
				// function stops.
			caster = (Caster) item;
		} catch (Exception e) {
			System.out.println(item.toString() + "Didn't pass the caster test.");
			return false;
		}

		if (caster.getElement() != this.getElement(worldIn, pos)
				&& caster.getElement() != Element.NEUTRAL) {
			System.out.println(item.toString() + "Didn't pass the element test.");
			return false; // If this block doesn't give the right type of
							// essence, the function stops.
		}
		
		
		if (giver.canTap(worldIn, pos)) {

			Essence newEssence = this.getEssence(worldIn, pos);

			System.out.println("This Damage: " + stack.getItemDamage()
					+ " New Essence amount :" + newEssence.getAmount()
					+ " while this Damage Limit = " + caster.getMaxDamage());

			if (newEssence.getAmount() > caster.getDamage(stack)) {
				System.out.println("Didn't pass the amount test.");
				return false; // If this will add more essence then the max, the
								// function stops.
			}

			stack.setItemDamage(stack.getItemDamage() - newEssence.getAmount());
			DragonTap.dragonToSpent(worldIn, pos);
			// stack.damageItem(newEssence.getAmount(), playerIn);
			// this.setDamage(stack, this.getDamage(stack) -
			// newEssence.getAmount());
			return true;
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
		
		System.out.println("The special name for" + stack.toString() + " is " + toReturn);

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
		worldIn.setBlockState(pos, ModBlocks.dragon_tap.blockState
				.getBaseState().withProperty(TYPE, TapState.SET));
	}

	public static void dragonToSpent(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, ModBlocks.dragon_tap.blockState
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




    public String getUnlocalizedName(ItemStack itemStack) {
 
        String name;
        switch(itemStack.getItemDamage()) {
 
            case 0:
                name = "firstMeta";
                break;
            case 1:
                name = "secondMeta";
                break;
            case 2:
                name = "thirdMeta";
                break;
            case 3:
                name = "forthMeta";
                break;
            case 4:
                name = "fifthMeta";
                break;
            default:
                name = "noMeta";
        }
        return getUnlocalizedName() + "." + name;
    }
}
