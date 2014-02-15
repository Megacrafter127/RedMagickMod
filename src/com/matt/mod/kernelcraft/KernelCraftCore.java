package com.matt.mod.kernelcraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;
import com.matt.lib.Ref;
import com.matt.mod.TabFuture;
import com.matt.mod.kernelcraft.blocks.*;
import com.matt.mod.kernelcraft.items.*;
import com.matt.mod.kernelcraft.tileentities.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class KernelCraftCore implements IFutureCraftPlugin {
	public static String toTextureName(String name) {
		return Ref.NAME.toLowerCase()+":"+name;
	}
	public static final CreativeTabs kernelCraft = new TabFuture(CreativeTabs.getNextID(), "KernelCraft","kernel");
	//IDs
		//base extenders
		public static int DriveID=911;
		public static int BatteryID=912;
		public static int IOExpanderID=913;
		public static int OverclockerID=914;
		//end base extenders
		//base
		public static int ModuleID=900;
		public static int StorageID=901;
		public static int USVID=902;
		public static int IOFaceID=903;
		public static int CPUID=904;
		//end base
	//end IDs
	//Blocks
		//base extenders
		public static Block Drive;
		public static Block Battery;
		public static Block IOExpander;
		public static Block Overclocker;
		//end base extenders
		//base
		public static BlockKernelModule Module;
		public static BlockKernelStorage Storage;
		public static BlockKernelUSV  USV;
		public static BlockKernelIOFace IOFace;
		public static BlockKernelCPU CPU;
		//end base
	public static void loadIDs() {
		FutureCraft.config.load();
		//base extenders
		DriveID=FutureCraft.config.getBlock("kernelDrive", DriveID).getInt();
		BatteryID=FutureCraft.config.getBlock("kernelBattery", BatteryID).getInt();
		IOExpanderID=FutureCraft.config.getBlock("kernelIOExpander", IOExpanderID).getInt();
		OverclockerID=FutureCraft.config.getBlock("kernelOverclocker", OverclockerID).getInt();
		//end base extenders
		//base
		ModuleID=FutureCraft.config.getBlock("kernelModule", ModuleID).getInt();
		StorageID=FutureCraft.config.getBlock("kernelStorage", StorageID).getInt();
		USVID=FutureCraft.config.getBlock("kernelUSB", USVID).getInt();
		IOFaceID=FutureCraft.config.getBlock("kernelIOFace", IOFaceID).getInt();
		CPUID=FutureCraft.config.getBlock("kernelCPU", CPUID).getInt();
		//end base
		FutureCraft.config.save();
	}
	
	public static void registerBlocks() {
		//base extenders
		//end base extenders
		//base
		Module=new BlockKernelModule(ModuleID);
		GameRegistry.registerBlock(Module, "kernelModule");
		Storage=new BlockKernelStorage(StorageID);
		GameRegistry.registerBlock(Storage, "kernelStorage");
		USV=new BlockKernelUSV(USVID);
		GameRegistry.registerBlock(USV, "kernelUSV");
		IOFace=new BlockKernelIOFace(IOFaceID);
		GameRegistry.registerBlock(IOFace, "kernelIOFace");
		CPU=new BlockKernelCPU(CPUID);
		GameRegistry.registerBlock(CPU, "kernelCPU");
		//TODO add blocks
	}
	
	public static void registerCreativeTabs() {
		Module.setCreativeTab(kernelCraft);
		Storage.setCreativeTab(kernelCraft);
		USV.setCreativeTab(kernelCraft);
		IOFace.setCreativeTab(kernelCraft);
		CPU.setCreativeTab(kernelCraft);
	}
	
	public static void registerItems() {}
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityKernelModule.class, "tile.kernelModule");
		GameRegistry.registerTileEntity(TileEntityKernelStorage.class, "tile.kernelStorage");
		GameRegistry.registerTileEntity(TileEntityKernelUSV.class, "tile.kernelUSV");
		GameRegistry.registerTileEntity(TileEntityKernelIOFace.class, "tile.kernelIOFace");
		GameRegistry.registerTileEntity(TileEntityKernelCPU.class, "tile.kernelCPU");
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
