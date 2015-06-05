package io.github.zaphodious.essentialsorcery.spellcasting.runeboards;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.BoardSlots;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.Essence;
import io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.MaterialLevel;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;

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
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public abstract class BasicBoard extends Item implements UsesEssence {

	Element element;
	MaterialLevel materialLevel;

	private ItemStack[] inventory;

	protected BasicBoard(String unlocalizedName, MaterialLevel materialLevel,
			Element element) {
		this.element = element;
		this.setUnlocalizedName(unlocalizedName);
		// this.setCreativeTab(Reference.tabEssential);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#isRepairable()
	 * 
	 * @Override public boolean isRepairable() { return false; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack,
	 * net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {

		if (stack.hasTagCompound()) {

			try {
				tooltip.add("Essence: "
						+ (stack.getTagCompound().getIntArray(
								"essenceContained")[0])
						+ "/"
						+ (stack.getTagCompound().getIntArray(
								"essenceContained")[1]));
				tooltip.add("fak");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				tooltip.add("Error getting essence. please make a new spell.");
			}

			tooltip.add("     Mana cost to cast is " + this.getCost(stack));
			tooltip.add("Effect Runes Affixed:");

			Set<String> keySet = (stack.getTagCompound().getKeySet());
			NBTTagCompound nbttc = stack.getTagCompound();
			for (String string : keySet) {
				// System.out.println(string);
				ItemStack newStack = ItemStack.loadItemStackFromNBT(stack
						.getTagCompound().getCompoundTag(string));
				try {
					RuneEffect effectRune = (RuneEffect) newStack.getItem();
					String newString = "    "
							+ newStack.stackSize
							+ " "
							+ StatCollector.translateToLocal(effectRune
									.getUnlocalizedName() + ".name");
					tooltip.add(newString);
				} catch (Exception e) {

				}

			}

		} else {
			tooltip.add("This is not a spell.");
		}
		super.addInformation(stack, playerIn, tooltip, advanced);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		playerIn.swingItem();
		int essenceRemaining = this.getEssenceArray(itemStackIn)[0];
		int essenceCap = this.getEssenceArray(itemStackIn)[1];
		if (essenceRemaining == -1) {
			return itemStackIn;
		}
		
		
		

		try {
			if (!worldIn.isRemote) {
				if (itemStackIn.hasTagCompound()) {
					ItemStack newStack = ItemStack
							.loadItemStackFromNBT(itemStackIn.getTagCompound()
									.getCompoundTag(BoardSlots.SHAPE.getSlotname()));
					RuneShape shapeRune = (RuneShape) newStack.getItem();
					try {
						Map<String, ItemStack> runeMap = RuneHelper
								.getRuneMap(itemStackIn);
						if (playerIn.capabilities.isCreativeMode || this.useEssence(this.getCost(itemStackIn),
									itemStackIn)) {
							shapeRune.deployTargetingEntity(runeMap, worldIn,
								playerIn);
						}
						

					} catch (Exception e) {
						System.out.println(e);
					}

				}
			}
		} catch (Exception e) {
			System.out.println("Oops, the projectile didn't fire. Error is: "
					+ e);
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
		if (stack.hasTagCompound()) {
			int amount = getEssenceArray(stack)[0];
			int total = getEssenceArray(stack)[1];
			if (req > amount) {
				return false;
			}
			
			return this.changeEssenceValue(-(req), stack);
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

			// stack.setItemDamage(stack.getItemDamage() -
			// newEssence.getAmount());
			// DragonTap.dragonToSpent(worldIn, pos);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.zaphodious.essentialsorcery.spellcasting.UsesEssence#getCost()
	 */
	@Override
	public int getCost(ItemStack stack) {
		if (stack.hasTagCompound()) {

			try {
				return Reference.MANA_COST_ARRAY[(RuneHelper
						.totalPowerLevelIn(RuneHelper.getRuneMap(stack)))];
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return 0;
	}

	public static boolean isThisAnInstanceOfMe(ItemStack stack) {
		BasicBoard toReturn = null;

		try {
			toReturn = (BasicBoard) stack.getItem();
			System.out.println("It's passed line 246");
		} catch (Exception e) {

		}

		if (toReturn != null) {
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.Item#showDurabilityBar(net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.Item#getDurabilityForDisplay(net.minecraft.item.ItemStack
	 * )
	 */
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if (stack.hasTagCompound()) {
			double amount = getEssenceArray(stack)[0];
			double total = getEssenceArray(stack)[1];
			//System.out.println("The percentage that should be showing for " + stack + " is: " + ((amount) / (total)));
			return (total-amount) / (total);
			
		}
		return 0;
	}

	private int[] getEssenceArray(ItemStack stackIn) {
		int[] toReturn = new int[2];
		if (stackIn.hasTagCompound()) {
			toReturn[0] = stackIn.getTagCompound().getIntArray(
				BoardSlots.ESSENCE_CONTAINED.getSlotname())[0];
		toReturn[1] = stackIn.getTagCompound().getIntArray(
				BoardSlots.ESSENCE_CONTAINED.getSlotname())[1];
		} else {
			toReturn[0] = -1;
			toReturn[1] = -1;
		}
		

		return toReturn;
	}

	private boolean changeEssenceValue(int toAdd, ItemStack stackIn) {
		if (stackIn.hasTagCompound()) {
			stackIn.getTagCompound().getIntArray(
					BoardSlots.ESSENCE_CONTAINED.getSlotname())[0] += toAdd;
			return true;
		}
		
		
		return false;
	}
	
	
	
	public boolean takeInEssence(Essence essence, ItemStack stackIn) {
		if (stackIn.getItem() instanceof UsesEssence && stackIn.hasTagCompound()) {
			UsesEssence essenceUser = (UsesEssence) stackIn.getItem();
			if (essenceUser.getElement() == essence.getElement()) {
				return this.addEssence(essence.getAmount(), stackIn);
			}
		}
		
		
		return false;
	}
	
	private boolean addEssence(int req, ItemStack stack) {
		if (stack.hasTagCompound()) {
			int amount = getEssenceArray(stack)[0];
			int total = getEssenceArray(stack)[1];
			if (req + amount > total) {
				return false;
			}
			
			return this.changeEssenceValue(req, stack);
		}

		return false;

		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#getMaxDamage()
	 * 
	 * @Override public int getMaxDamage() { // TODO Auto-generated method stub
	 * return super.getMaxDamage(); }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#getMaxDamage(net.minecraft.item.ItemStack)
	 * 
	 * @Override public int getMaxDamage(ItemStack stack) { // TODO
	 * Auto-generated method stub return stack.getItem().getMaxDamage(); }
	 */

}
