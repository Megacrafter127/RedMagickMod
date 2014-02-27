package com.matt.mod.kernelcraft;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;
import com.matt.lib.Ref;
import com.matt.mod.ModHelper;
import com.matt.mod.TabFuture;
import com.matt.mod.handlers.MultiPacketHandler;
import com.matt.mod.kernelcraft.blocks.BlockKernelCPU;
import com.matt.mod.kernelcraft.blocks.BlockKernelCore;
import com.matt.mod.kernelcraft.blocks.BlockKernelIOFace;
import com.matt.mod.kernelcraft.blocks.BlockKernelModule;
import com.matt.mod.kernelcraft.blocks.BlockKernelStorage;
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
	protected static final CreativeTabs kernelCraft = new TabFuture(CreativeTabs.getNextID(),"KernelCraft","kernel");
	protected static final KernelCoreUpdatePacketHandler handler=new KernelCoreUpdatePacketHandler();
	public static final File configFile=new File(FutureCraft.config.get("moduleConfigs", "KCCC", new File(FutureCraft.configPatch.getParentFile(),"kernelcraftconfig.cfg").getPath()).getString());
	public static final Configuration c=new Configuration(configFile);
	static{
		c.load();
	}
	//IDs
		//base extenders
		public static final int DriveID=c.getBlock("drive", 912).getInt();
		public static final int BatteryID=c.getBlock("battery", 913).getInt();
		public static final int IOExpanderID=c.getBlock("ioexpander", 914).getInt();
		public static final int OverclockerID=c.getBlock("overclocker", 915).getInt();
		//end base extenders
		//base
		public static final int KernelID=c.getBlock("kernelcore", 900).getInt();
		public static final int ModuleID=c.getBlock("module", 901).getInt();
		public static final int StorageID=c.getBlock("storage", 902).getInt();
		public static final int USVID=c.getBlock("usv", 903).getInt();
		public static final int IOFaceID=c.getBlock("ioface", 904).getInt();
		public static final int CPUID=c.getBlock("cpu", 905).getInt();
		//end base
		//misc
		//end misc
		//items
		public static final int KernelToolID=c.getItem("ktool", 951).getInt();
		//end items
	//end IDs
	//Instances
		//base extenders
		public static final Block Drive=new Block(DriveID,null);
		public static final Block Battery=new Block(BatteryID,null);
		public static final Block IOExpander=new Block(IOExpanderID,null);
		public static final Block Overclocker=new Block(OverclockerID,null);
		
		//end base extenders
		//base
		public static final BlockKernelCore Kernel=new BlockKernelCore(KernelID);
		public static final BlockKernelModule Module=new BlockKernelModule(ModuleID);
		public static final BlockKernelStorage Storage=new BlockKernelStorage(StorageID);
		public static final BlockKernelUSV  USV=new BlockKernelUSV(USVID);
		public static final BlockKernelIOFace IOFace=new BlockKernelIOFace(IOFaceID);
		public static final BlockKernelCPU CPU=new BlockKernelCPU(CPUID);
		//end base
		//misc
		//end misc
		//items
		public static final ItemKernelTool KernelTool=new ItemKernelTool(KernelToolID);
		//end items
	//end Instances
	public static void registerBlocks() {
		//base extenders
		//end base extenders
		//base
		GameRegistry.registerBlock(Kernel, "kernelCore");
		GameRegistry.registerBlock(Module, "kernelModule");
		GameRegistry.registerBlock(Storage, "kernelStorage");
		GameRegistry.registerBlock(USV, "kernelUSV");
		GameRegistry.registerBlock(IOFace, "kernelIOFace");
		GameRegistry.registerBlock(CPU, "kernelCPU");
		//end base
		//misc
		//end misc
		//languages
		LanguageRegistry.addName(Kernel, "Kernel Core");
		
		LanguageRegistry.addName(Module, "Kernel Module");
		
		LanguageRegistry.addName(Storage, "Kernel Storage");
		
		LanguageRegistry.addName(USV, "Kernel USV");
		
		LanguageRegistry.addName(IOFace, "Kernel IOFace");
		
		LanguageRegistry.addName(CPU, "Kernel CPU");
	}
	
	public static void registerCreativeTabs() {
		Module.setCreativeTab(kernelCraft);
		Storage.setCreativeTab(kernelCraft);
		USV.setCreativeTab(kernelCraft);
		IOFace.setCreativeTab(kernelCraft);
		CPU.setCreativeTab(kernelCraft);
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(KernelTool, "kernelTool");
		
		//langs
		LanguageRegistry.addName(new ItemStack(KernelTool,1,ItemKernelTool.commandToolMeta), "Kenel Command Tool");
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
		MultiPacketHandler.addPacketHandler(handler, "KCU", "KCEU", "KCTU");
		registerBlocks();
		registerItems();
		registerTileEntities();
		registerRecipes();
		registerCreativeTabs();
	}
}
