package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import net.minecraft.item.Item;
import io.github.zaphodious.essentialsorcery.spellcasting.AcceptsEssence;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;

public abstract class RuneElement extends AcceptsEssence implements Rune {

	protected Element element;
	protected int id;
	protected String name;
	
	protected RuneElement(int id, String name, Element element, int maxCapacity) {
		super(maxCapacity, element);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
