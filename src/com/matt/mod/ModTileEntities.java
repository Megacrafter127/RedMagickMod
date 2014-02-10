package com.matt.mod;

import com.matt.mod.blocks.tileentity.TileEntityPowerPipe;
import com.matt.mod.blocks.tileentity.TileEntitySmelter;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "tileEntitySmelter");
		GameRegistry.registerTileEntity(TileEntityPowerPipe.class, "tileeEntityPowerPipe");
	}

}
