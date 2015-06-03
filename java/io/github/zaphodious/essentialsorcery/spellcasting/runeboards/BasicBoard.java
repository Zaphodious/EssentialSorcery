package io.github.zaphodious.essentialsorcery.spellcasting.runeboards;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.Essence;
import io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.MaterialLevel;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class BasicBoard extends Item implements UsesEssence {

	

	Element element;
	MaterialLevel materialLevel;
	
	
	private ItemStack[] inventory;
	
	protected BasicBoard(String unlocalizedName, MaterialLevel materialLevel, Element element) {
		this.element = element;
		this.setUnlocalizedName(unlocalizedName);
		//this.setCreativeTab(Reference.tabEssential);
		this.maxStackSize = 1;
		this.materialLevel = materialLevel;
		this.setMaxDamage(Reference.MANA_COST_ARRAY[materialLevel.getLevel()]);
		inventory = new ItemStack[6];
	}
	
	
	
	/**
	 * @return the materialLevel
	 */
	public MaterialLevel getMaterialLevel() {
		return materialLevel;
	}



	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack, net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		if (stack.hasTagCompound()) {
			Set<String> keySet = new HashSet<String>();
			keySet = (stack.getTagCompound().getKeySet());
			NBTTagCompound nbttc = stack.getTagCompound();
			//System.out.println(keySet);
			for (String string : keySet) {
				//System.out.println(string);
				ItemStack newStack = (ItemStack) ItemStack.loadItemStackFromNBT(stack.getTagCompound().getCompoundTag(string));
				if (newStack != null) {
					tooltip.add(newStack.toString());
				}
				
				newStack = null;
			}
		}
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		
		
	}



	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		playerIn.swingItem();
		if ((itemStackIn.getMaxDamage() - itemStackIn.getItemDamage()) < this.getCost(itemStackIn) && !playerIn.capabilities.isCreativeMode){

			System.out.println("the first check didn't work. Essence available should be = " + (itemStackIn.getMaxDamage() - itemStackIn.getItemDamage()));
			System.out.println("the price of the spell is " + this.getCost(itemStackIn));
			
			return itemStackIn;

		}
			
		
		try {
			if (!worldIn.isRemote) {
			if (itemStackIn.hasTagCompound()) {
				ItemStack newStack = (ItemStack) ItemStack.loadItemStackFromNBT(itemStackIn.getTagCompound().getCompoundTag("shape"));
				RuneShape shapeRune = (RuneShape) newStack.getItem();
				try {
					Map<String, ItemStack> runeMap = RuneHelper.getRuneMap(itemStackIn);
					if (!playerIn.capabilities.isCreativeMode){ itemStackIn.damageItem(this.getCost(itemStackIn), playerIn); }
					shapeRune.deployTargetingEntity(runeMap, worldIn, playerIn);
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		}
		} catch (Exception e) {
			System.out.println("Oops, the projectile didn't fire. Error is: " + e);
		}
		return itemStackIn;
	}
	

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public void setElement(Element element) {
		// TODO Auto-generated method stub
		this.element = element;
	}

	@Override
	public boolean useEssence(int req, ItemStack stack) {
		if (stack.getItemDamage() + req > stack.getMaxDamage()) {
			return false;
		}
		
		stack.setItemDamage(stack.getItemDamage() + req);
		
		return true;
	}
	
	@Override
	public boolean useTap(World worldIn, BlockPos pos, ItemStack stack,
			EntityPlayer playerIn) {
		GivesEssence giver = null;
		// get the specific block
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		try { // If this block doesn't implement the GivesEssence interface, the
				// function stops.
			giver = (GivesEssence) block;
		} catch (Exception e) {
			System.out.println("Didn't pass the GivesEssence test.");
			return false;
		}

		if (giver.getElement(worldIn, pos) != this.element
				&& this.element != Element.NEUTRAL) {
			System.out.println("Didn't pass the element test.");
			return false; // If this block doesn't give the right type of
							// essence, the function stops.
		}

		if (giver.canTap(worldIn, pos)) {

			Essence newEssence = giver.getEssence(worldIn, pos);

			System.out.println("This Damage: " + stack.getItemDamage()
					+ " New Essence amount :" + newEssence.getAmount()
					+ " while this Damage Limit = " + this.getMaxDamage());

			if (newEssence.getAmount() > this.getDamage(stack)) {
				System.out.println("Didn't pass the amount test.");
				return false; // If this will add more essence then the max, the
								// function stops.
			}

			//stack.setItemDamage(stack.getItemDamage() - newEssence.getAmount());
			//DragonTap.dragonToSpent(worldIn, pos);
			// stack.damageItem(newEssence.getAmount(), playerIn);
			// this.setDamage(stack, this.getDamage(stack) -
			// newEssence.getAmount());
			return true;
		}

		System.out.println("Didn't pass the canTap test."); // If this block
															// cannot be tapped,
															// the function
															// skips to the end.
		return false;

	}
	
	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence#getCost()
	 */
	@Override
	public int getCost(ItemStack stack) {
		if (stack.hasTagCompound()) {
			
			try {
				return Reference.MANA_COST_ARRAY[(RuneHelper.totalPowerLevelIn(RuneHelper.getRuneMap(stack)))];
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return 0;
	}

	

}
