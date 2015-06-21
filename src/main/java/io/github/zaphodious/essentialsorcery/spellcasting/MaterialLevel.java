package io.github.zaphodious.essentialsorcery.spellcasting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum MaterialLevel {

	WOOD(3, Item.getItemFromBlock(Blocks.planks)), STONE(4, Item.getItemFromBlock(Blocks.stone)), LEATHER(
			6,
			Items.leather),

	IRON(8, Item.getItemFromBlock(Blocks.iron_block)), GOLD(10, Item.getItemFromBlock(Blocks.gold_block)), DIAMOND(
			14,
			Item.getItemFromBlock(Blocks.diamond_block));

	private int level;
	private Item item;

	private MaterialLevel(int level, Item item) {
		this.level = level;
		this.item = item;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return the block
	 */
	public Item getItem() {
		return item;
	}

}
