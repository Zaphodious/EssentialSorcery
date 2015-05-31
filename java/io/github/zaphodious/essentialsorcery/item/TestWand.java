package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.Essence;
import io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class TestWand extends Item implements UsesEssence {

	Element element;
	private ItemStack[] inventory;
	
	public TestWand(String unlocalizedName, int maxPool, Element element) {
		this.element = element;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.maxStackSize = 1;
		this.setMaxDamage(maxPool);
		inventory = new ItemStack[6];
	}

	
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onCreated(net.minecraft.item.ItemStack, net.minecraft.world.World, net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		super.onCreated(stack, worldIn, playerIn);
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound compound = new NBTTagCompound();
		new ItemStack(Items.apple).writeToNBT(compound);
		stack.getTagCompound().setTag("apple", compound);
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
		
		if (!worldIn.isRemote) {
			worldIn.spawnEntityInWorld(new TargetingProjectile(worldIn, playerIn));
		}

		if (itemStackIn.hasTagCompound()) {
			Set<String> keySet = new HashSet<String>();
			keySet = (itemStackIn.getTagCompound().getKeySet());
			System.out.println(keySet);
		}
		
		/*ItemStack appleStack;
		try {
			 appleStack = (ItemStack) ItemStack.loadItemStackFromNBT(itemStackIn.getTagCompound().getCompoundTag("apple"));
		} catch (Exception e) {
			onCreated(itemStackIn, worldIn, playerIn);
			appleStack = (ItemStack) ItemStack.loadItemStackFromNBT(itemStackIn.getTagCompound().getCompoundTag("apple"));
		}
		
		
		System.out.println(appleStack);
		
		boolean canUse = false;
		if (!playerIn.capabilities.isCreativeMode) {
			canUse = useEssence(2, itemStackIn);
		} else {
			canUse = true;
		}

		//canUse = !playerIn.isSneaking();
		
		if (canUse) {
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote) {
				worldIn.spawnEntityInWorld(new EntitySnowball(worldIn, playerIn));
			}

			playerIn.triggerAchievement(StatList.objectUseStats[Item
					.getIdFromItem(this)]);
		}*/

		return itemStackIn;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		try {

			if (!useTap(worldIn, pos, stack, playerIn)) {

				// this.onItemRightClick(stack, worldIn, playerIn);

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;

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

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return this.element;
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

	

}