package io.github.zaphodious.essentialsorcery.core;

import cyano.basemetals.BaseMetals;
import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.defaultconfigs.OreSpawnJSON;
import io.github.zaphodious.essentialsorcery.crafting.RecRegister;
import io.github.zaphodious.essentialsorcery.entity.RegisterMobs;
import io.github.zaphodious.essentialsorcery.event.Events;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.item.metal.EssentialMaterials;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.RegTargetingEntities;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile;
import io.github.zaphodious.essentialsorcery.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public interface Proxy {

	public void preInit(FMLPreInitializationEvent e);

	public void init(FMLInitializationEvent e);

	public void postInit(FMLPostInitializationEvent e);

}
