package io.github.zaphodious.essentialsorcery.spellcasting;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class RuneHelper {

	public static final List<RuneDropObject> RuneDrops = new ArrayList<RuneDropObject>();

	public static Map<String, ItemStack> getRuneMap(ItemStack itemStackIn) throws Exception {
		Map<String, ItemStack> runeMap = new HashMap<String, ItemStack>();
		if (itemStackIn.hasTagCompound()) {
			Set<String> keySet = (itemStackIn.getTagCompound().getKeySet());
			for (String key : keySet) {
				ItemStack newStack = ItemStack.loadItemStackFromNBT(itemStackIn.getTagCompound().getCompoundTag(key));
				runeMap.put(key, newStack);
			}

		}

		runeMap.remove("display");
		runeMap.remove("essenceContained");

		if (runeMap.isEmpty()) {
			throw new Exception("The ItemStack " + itemStackIn.toString() + " had nothing in NBT.");
		}

		return runeMap;
	}

	public static int totalRunesIn(Map<String, ItemStack> runeMap) {
		int runeNumber = 0;

		for (String key : runeMap.keySet()) {
			ItemStack runeStack = runeMap.get(key);
			Rune rune = (Rune) runeStack.getItem();
			runeNumber += runeStack.stackSize + rune.getPowerLevel();
		}

		return runeNumber;

	}

	public static int totalEffectRunesIn(ItemStack runeStack) {
		int runeNumber = 0;

		Rune rune = (Rune) runeStack.getItem();
		runeNumber += runeStack.stackSize;

		return runeNumber;

	}

	public static int totalPowerLevelIn(Map<String, ItemStack> runeMap) {
		int runeNumber = 0;

		for (String key : runeMap.keySet()) {
			if (key.isEmpty() || key.equals("display") || key.equals(BoardSlots.ESSENCE_CONTAINED.getSlotname()))
				break;
			ItemStack runeStack = runeMap.get(key);
			Rune rune = (Rune) runeStack.getItem();
			if (key.contains("effect")) {
				runeNumber += runeStack.stackSize + rune.getPowerLevel();
			}

		}

		return runeNumber - 1;

	}

	public static int totalPowerLevelIn(ItemStack[] stackArray) {
		int length = stackArray.length;
		int powerLevel = 0;

		for (int i = 0; i < length; i++) {
			if (stackArray[i] != null) {
				try {
					RuneEffect effectRune = (RuneEffect) stackArray[i].getItem();
					powerLevel += effectRune.getPowerLevel() + stackArray[i].stackSize;
				} catch (Exception e) {

				}

			}
		}
		return powerLevel - 1;
	}

	public static void addRuneToDropList(Rune rune, DropChance dropChance) {
		RuneHelper.RuneDrops.add(new RuneDropObject(rune, dropChance));
	}

	public static ItemStack getRuneToDrop(HarvestDropsEvent event) {
		ItemStack toDrop = null;
		Random rand = new Random();

		int sizeOfRuneDropsList = RuneHelper.RuneDrops.size();

		int runePosition = rand.nextInt(sizeOfRuneDropsList + 1);

		if (runePosition == (RuneHelper.RuneDrops.size())) {

			for (RuneElement elementRune : ModItems.getElementRunes()) {
				Element biomeElement =
						Reference.SORTER.getBiomes().get(event.world.getBiomeGenForCoords(event.pos).biomeID);
				if (elementRune.getElement() == biomeElement && rand.nextFloat() < DropChance.UNCOMMON.getProbability()) {

					toDrop = new ItemStack(elementRune);
				}
			}
		} else {

			RuneDropObject thisRune = RuneHelper.RuneDrops.get(runePosition - 1);
			if (thisRune.getProbabilty() > rand.nextFloat()) {
				toDrop = new ItemStack(thisRune.getRuneAsItem());
			}

		}

		return toDrop;

	}

}

class RuneDropObject {

	Rune rune;
	float probabilty;

	public RuneDropObject(Rune rune, DropChance dropChance) {
		this.rune = rune;
		this.probabilty = (float) dropChance.getProbability();
	}

	/**
	 * @return the rune
	 */
	public Rune getRune() {
		return rune;
	}

	public Item getRuneAsItem() {
		Item runeAsItem = (Item) rune;
		return runeAsItem;
	}

	/**
	 * @param rune
	 *            the rune to set
	 */
	public void setRune(Rune rune) {
		this.rune = rune;
	}

	/**
	 * @return the probabilty
	 */
	public float getProbabilty() {
		return probabilty;
	}

	/**
	 * @param probabilty
	 *            the probabilty to set
	 */
	public void setProbabilty(float probabilty) {
		this.probabilty = probabilty;
	}

}