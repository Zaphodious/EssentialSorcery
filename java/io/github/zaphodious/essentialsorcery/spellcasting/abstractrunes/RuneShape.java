package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.item.Item;

public abstract class RuneShape extends Item implements Rune {

	protected int id;
	protected String name;
	
	protected RuneShape(int id, String name) {
		this.setCreativeTab(Reference.tabEssential);
		this.setUnlocalizedName(name);
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	

}
