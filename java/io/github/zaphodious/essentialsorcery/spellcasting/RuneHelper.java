package io.github.zaphodious.essentialsorcery.spellcasting;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;

public class RuneHelper {

	public static Map<String, ItemStack> getRuneMap(ItemStack itemStackIn)
			throws Exception {
		Map<String, ItemStack> runeMap = new HashMap<String, ItemStack>();
		if (itemStackIn.hasTagCompound()) {
			Set<String> keySet = (itemStackIn.getTagCompound().getKeySet());
			for (String key : keySet) {
				ItemStack newStack = (ItemStack) ItemStack
						.loadItemStackFromNBT(itemStackIn.getTagCompound()
								.getCompoundTag(key));
				runeMap.put(key, newStack);
			}

		}

		runeMap.remove("display");

		if (runeMap.isEmpty()) {
			throw new Exception("The ItemStack " + itemStackIn.toString()
					+ " had nothing in NBT.");
		}

		return runeMap;
	}

	public static int totalRunesIn(Map<String, ItemStack> runeMap) {
		int runeNumber = 0;

		for (String key : runeMap.keySet()) {
			ItemStack runeStack = runeMap.get(key);
			Rune rune = (Rune) runeStack.getItem();
			runeNumber += runeStack.stackSize * rune.getPowerLevel();
		}

		return runeNumber;

	}

	public static int totalEffectRunesIn(ItemStack runeStack) {
		int runeNumber = 0;

		Rune rune = (Rune) runeStack.getItem();
		runeNumber += runeStack.stackSize * rune.getPowerLevel();

		return runeNumber;

	}

}
