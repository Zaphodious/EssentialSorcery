package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import net.minecraft.item.Item;

public abstract class RuneShape extends Item implements Rune {

	protected int id;
	protected String name;
	
	protected RuneShape(int id, String name) {
		// TODO Auto-generated constructor stub
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
