package com.kenai.essentialsorcery.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {

	protected BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        //this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
	}

	public BasicBlock(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.rock, hardness, resistance);
    }

    public BasicBlock(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
}
