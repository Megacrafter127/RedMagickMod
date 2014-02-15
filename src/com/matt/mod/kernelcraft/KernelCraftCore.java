package com.matt.mod.kernelcraft;

import com.matt.FutureCraft;

public class KernelCraftCore {
	static{
		loadIDs();
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
}
