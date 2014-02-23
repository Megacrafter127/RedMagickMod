package com.matt.mod.kernelcraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;
import com.matt.lib.Ref;
import com.matt.mod.ModHelper;
import com.matt.mod.TabFuture;
import com.matt.mod.kernelcraft.blocks.BlockKernelCPU;
import com.matt.mod.kernelcraft.blocks.BlockKernelCore;
import com.matt.mod.kernelcraft.blocks.BlockKernelIOFace;
import com.matt.mod.kernelcraft.blocks.BlockKernelModule;
import com.matt.mod.kernelcraft.blocks.BlockKernelStorage;
import com.matt.mod.kernelcraft.blocks.BlockKernelToolMaker;
import com.matt.mod.kernelcraft.blocks.BlockKernelUSV;
import com.matt.mod.kernelcraft.items.ItemKernelTool;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCPU;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelIOFace;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelModule;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelStorage;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelUSV;
import com.matt.mod.recipes.QuadSymetricRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class KernelCraftCore implements IFutureCraftPlugin {
	public static String toTextureName(String name) {
		return Ref.NAME.toLowerCase()+":"+name;
	}
	protected static CreativeTabs kernelCraft = new TabFuture(CreativeTabs.getNextID(),"KernelCraft","kernel");
	//IDs
		//base extenders
		private static int DriveID=912;
		private static int BatteryID=913;
		private static int IOExpanderID=914;
		private static int OverclockerID=915;
		//end base extenders
		//base
		private static int KernelID=900;
		private static int ModuleID=901;
		private static int StorageID=902;
		private static int USVID=903;
		private static int IOFaceID=904;
		private static int CPUID=905;
		//end base
		//misc
		private static int KernelToolMakerID=911;
		//end misc
		//items
		private static int KernelToolID=951;
		//end items
	//end IDs
	//Instances
		//base extenders
		public static Block Drive;
		public static Block Battery;
		public static Block IOExpander;
		public static Block Overclocker;
		
		//end base extenders
		//base
		public static BlockKernelCore Kernel;
		public static BlockKernelModule Module;
		public static BlockKernelStorage Storage;
		public static BlockKernelUSV  USV;
		public static BlockKernelIOFace IOFace;
		public static BlockKernelCPU CPU;
		//end base
		//misc
		public static BlockKernelToolMaker KernelToolMaker;
		//end misc
		//items
		public static ItemKernelTool KernelTool;
		//end items
	//end Instances
	public static void loadIDs() {
		FutureCraft.config.load();
		//base extenders
		DriveID=FutureCraft.config.getBlock("kernelDrive", DriveID).getInt();
		BatteryID=FutureCraft.config.getBlock("kernelBattery", BatteryID).getInt();
		IOExpanderID=FutureCraft.config.getBlock("kernelIOExpander", IOExpanderID).getInt();
		OverclockerID=FutureCraft.config.getBlock("kernelOverclocker", OverclockerID).getInt();
		//end base extenders
		//base
		KernelID=FutureCraft.config.getBlock("kernelCore", KernelID).getInt();
		ModuleID=FutureCraft.config.getBlock("kernelModule", ModuleID).getInt();
		StorageID=FutureCraft.config.getBlock("kernelStorage", StorageID).getInt();
		USVID=FutureCraft.config.getBlock("kernelUSV", USVID).getInt();
		IOFaceID=FutureCraft.config.getBlock("kernelIOFace", IOFaceID).getInt();
		CPUID=FutureCraft.config.getBlock("kernelCPU", CPUID).getInt();
		//end base
		//misc
		KernelToolMakerID=FutureCraft.config.getBlock("kernelToolMaker", KernelToolMakerID).getInt();
		//end misc
		//items
		KernelToolID=FutureCraft.config.getItem("kernelTool", KernelToolID).getInt();
		//end items
		FutureCraft.config.save();
	}
	
	public static void registerBlocks() {
		//base extenders
		//end base extenders
		//base
		Kernel=new BlockKernelCore(KernelID);
		GameRegistry.registerBlock(Kernel, "kernelCore");
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
		//end base
		//misc
		KernelToolMaker=new BlockKernelToolMaker(KernelToolMakerID);
		GameRegistry.registerBlock(KernelToolMaker, "kernelToolMaker");
		//end misc
		//languages
		LanguageRegistry.addName(Kernel, "Kernel Core");
		
		LanguageRegistry.addName(Module, "Kernel Module");
		
		LanguageRegistry.addName(Storage, "Kernel Storage");
		
		LanguageRegistry.addName(USV, "Kernel USV");
		
		LanguageRegistry.addName(IOFace, "Kernel IOFace");
		
		LanguageRegistry.addName(CPU, "Kernel CPU");
		
		LanguageRegistry.addName(KernelToolMaker, "Kernel Tool Maker");
	}
	
	public static void registerCreativeTabs() {
		Module.setCreativeTab(kernelCraft);
		Storage.setCreativeTab(kernelCraft);
		USV.setCreativeTab(kernelCraft);
		IOFace.setCreativeTab(kernelCraft);
		CPU.setCreativeTab(kernelCraft);
		KernelToolMaker.setCreativeTab(kernelCraft);
	}
	
	public static void registerItems() {
		KernelTool=new ItemKernelTool(KernelToolID);
		GameRegistry.registerItem(KernelTool, "kernelTool");
		
		//langs
		LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.mineToolMeta), "Kernel Mining Tool");
		LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.fillToolMeta), "Kernel Filling Tool");
		LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.hoeToolMeta), "Kernel Hoeing Tool");
		LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.harvestToolMeta), "Kernel Harvesting Tool");
		//LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.countToolMeta), "Kernel Counting Tool");
		
		
		//end langs
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityKernelModule.class, "TileEntityKernelModule");
		GameRegistry.registerTileEntity(TileEntityKernelStorage.class, "TileEntityKernelStorage");
		GameRegistry.registerTileEntity(TileEntityKernelUSV.class, "TileEntityKernelUSV");
		GameRegistry.registerTileEntity(TileEntityKernelIOFace.class, "TileEntityKernelIOFace");
		GameRegistry.registerTileEntity(TileEntityKernelCPU.class, "TileEntityKernelCPU");
		GameRegistry.registerTileEntity(TileEntityKernelCore.class, "TileEntityKernelCore");
	}
	
	public static void registerRecipes() {
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(Module,1),ModHelper.netheriumStack,ModHelper.enderiumStack,ModHelper.netherstarStack));
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(Storage,1),ModHelper.netheriumStack,ModHelper.enderiumStack,new ItemStack(Item.emerald,1)));
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(USV,1),ModHelper.netheriumStack,ModHelper.enderiumStack,new ItemStack(Item.netherQuartz,1)));
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(IOFace,1),ModHelper.netheriumStack,ModHelper.enderiumStack,new ItemStack(Item.eyeOfEnder,1)));
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(CPU,1),ModHelper.netheriumStack,ModHelper.enderiumStack,ModHelper.diamondStack));
	}

	@Override
	public String getName() {
		return "KernelCraft";
	}

	@Override
	public void register() {
		loadIDs();
		registerBlocks();
		registerItems();
		registerTileEntities();
		registerRecipes();
		registerCreativeTabs();
	}
}
