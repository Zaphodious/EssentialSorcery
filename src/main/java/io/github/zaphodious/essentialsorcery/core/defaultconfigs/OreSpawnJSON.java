package io.github.zaphodious.essentialsorcery.core.defaultconfigs;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import cyano.basemetals.BaseMetals;

public class OreSpawnJSON {

	public static final void makeOreGenConfigFile(
			FMLPreInitializationEvent event) {
		Path oreSpawnFolder =
				Paths.get(event
						.getSuggestedConfigurationFile()
						.toPath()
						.getParent()
						.toString(), "orespawn");
		Path oreSpawnFile =
				Paths.get(oreSpawnFolder.toString(), Reference.MODID + ".json");
		if (Files.exists(oreSpawnFile) == false) {
			try {
				// FileInputStream location = (FileInputStream)
				// OreSpawnJSON.class.getResource("essentialsorcery:default_configs/orespawn.json").openStream();
				// FileInputStream in = new
				// FileInputStream("/assets/essentialsorcery/default_configs/orespawn.json");
				Files.createDirectories(oreSpawnFile.getParent());
				Files.write(
						oreSpawnFile,
						Arrays.asList(defaultOreSpawnJSON.split("\n")),
						Charset.forName("UTF-8"));
				// Files.copy(location, oreSpawnFile,
				// StandardCopyOption.REPLACE_EXISTING);
				BaseMetals.oreSpawnConfigFiles.add(oreSpawnFile);
			} catch (IOException e) {
				FMLLog.severe(Reference.MODID
						+ ": Error: Failed to write file "
						+ oreSpawnFile);
				e.printStackTrace();
			}

		}
	}

	public static final String defaultOreSpawnJSON =
			"{"
					+ "\n	\"dimensions\":["
					+ "\n		{"
					+ "\n			\"dimension\":\"+\","
					+ "\n			\"__comment\":\""
					+ "dimension 0 for overworld, -1 for the nether, 1 for the end, other numbers "
					+ "for dimensions added by other mods, and + for any dimension not already "
					+ "described by this file.\","
					+ "\n			\"ores\":["
					+ "\n				{"
					+ "\n					\"__comment\":\"These settings are roughly equivalent to the "
					+ "parameters of the CUSTOM world json: blockID = the unlocalized name of a "
					+ "block in the format 'ModID:blockName',blockMeta = the meta data value for "
					+ "the block (optional),size = number of blocks to spawn per ore deposit, "
					+ "variation = vary the size of deposits by +/- this amount, frequency = number "
					+ "of deposits per chunk (can be less than 1, e.g. 0.5 for 1 deposit every 2 "
					+ "chunks), minHeight = minimum spawn height, maxHeight = maximum spawn height, "
					+ "biomes = array of biomes to spawn this ore in (if empty or absent, the ore "
					+ "will spawn in all biomes). Note that the size values in the Minecraft CUSTOM "
					+ "world json do not represent the actual number of blocks spawned, where-as the "
					+ "size value here does represent actual number of blocks. \","
					+ "\n					\"blockID\":\"essentialsorcery:jade_ore\","
					+ "\n					\"size\":5,"
					+ "\n					\"variation\":4,"
					+ "\n					\"frequency\":100,"
					+ "\n					\"minHeight\":0,"
					+ "\n					\"maxHeight\":255"
					+ "\n				}"
					+ "\n			]"
					+ "\n		}"
					+ "\n		"
					+ "\n		"
					+ "\n	]"
					+ "\n}";

}
