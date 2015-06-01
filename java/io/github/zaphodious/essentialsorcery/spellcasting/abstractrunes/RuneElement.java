package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import net.minecraft.item.Item;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.EssenceAccepter;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;

public abstract class RuneElement extends Item implements Rune {

	protected Element element;
	protected int id;
	protected String name;
	
	protected RuneElement(int id, String name, Element element) {
		this.element = element;
		this.name = name;
		this.id = id;
		this.setCreativeTab(Reference.tabEssential);
		this.setUnlocalizedName(name);
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

	public Element getElement() {
		return this.element;
	}
	
	public int getPowerLevel() {
		return 1;
	}
}
