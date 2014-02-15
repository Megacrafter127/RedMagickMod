package com.matt.mod.kernelcraft;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;
import com.matt.lib.Ref;

public class KernelCraftCore implements IFutureCraftPlugin {
	public static String toTextureName(String name) {
		return Ref.NAME.toLowerCase()+":"+name;
	}
	
	public static int DriveID=911;
	public static int BatteryID=912;
	public static int IOExpanderID=913;
	public static int OverclockerID=914;
	
	public static void loadIDs() {
		FutureCraft.config.load();
		DriveID=FutureCraft.config.getBlock("kernelDrive", DriveID).getInt();
		BatteryID=FutureCraft.config.getBlock("kernelBattery", BatteryID).getInt();
		IOExpanderID=FutureCraft.config.getBlock("kernelIOExpander", IOExpanderID).getInt();
		OverclockerID=FutureCraft.config.getBlock("kernelOverclockere", OverclockerID).getInt();
		FutureCraft.config.save();
	}
	
	public static void registerBlocks() {
		//TODO add blocks
	}
	public static void registerItems() {}
	public static void registerTileEntities() {
		//TODO add tileentities
	}
	
	public static void registerRecipes() {
		//TODO make crafting recipes
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "KernelCraft";
	}

	@Override
	public void register() {
		loadIDs();
		registerBlocks();
		registerItems();
		registerTileEntities();
		registerRecipes();
	}
}
