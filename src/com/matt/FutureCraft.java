package com.matt;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.matt.lib.Ref;
import com.matt.mod.ModBlocks;
import com.matt.mod.ModItems;
import com.matt.mod.ModRecipes;
import com.matt.mod.ModTileEntities;
import com.matt.mod.TabFuture;
import com.matt.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = Ref.ID, name = Ref.NAME, version = "0.0.1a1")
@NetworkMod( channels = {""}, clientSideRequired = true, serverSideRequired = true )
public class FutureCraft {
	 @Instance(Ref.ID)
	    public static FutureCraft instance;
	 @SidedProxy(clientSide="com.matt.proxy.client.ClientProxy", serverSide="com.matt.proxy.CommonProxy")
        public static CommonProxy proxy;
	
	 public static File configPatch;
	 // Block IDs
		public static int basicFBlockID = 538;
		public static int goldenFBlockID = 539;
		public static int basicFurnaceID = 540;
		public static int powerPipeID = 541;
		
		//Item IDs
		public static int netheriumIngotId = 590;
		public static int enderiumIngotId = 591;
		
		// ItemStacks -- For crafting.
		public static ItemStack dirtStack = new ItemStack(Block.dirt);
		public static ItemStack seedStack = new ItemStack(Item.seeds);
		public  static ItemStack grasStack = new ItemStack(Block.grass);
		public static ItemStack ironStack = new ItemStack(Item.ingotIron,1);
		public static ItemStack diamondStack = new ItemStack(Item.diamond,1);
		public static ItemStack goldStack = new ItemStack(Item.ingotGold,1);
		public static ItemStack bFutureStackCraft = new ItemStack(ModBlocks.basicFutureBlock,8);
		public static ItemStack gFutureStackCraft = new ItemStack(ModBlocks.goldenFutureBlock,8);
		public static ItemStack bFutureStack = new ItemStack(ModBlocks.basicFutureBlock);
		public static ItemStack gFutureStack = new ItemStack(ModBlocks.goldenFutureBlock);
		
		// Creative Tabs
		 public static CreativeTabs tabFCraft = new TabFuture(CreativeTabs.getNextID(), "FutureCraft");
		
		
		
		@EventHandler
     public void preInit(FMLPreInitializationEvent event) {
             System.out.println("[FC]This is FutureCraft " + Ref.VERSION);
             configPatch = event.getSuggestedConfigurationFile();
             Configuration config = new Configuration(FutureCraft.configPatch);
             System.out.println("[FC]Loading futurecraft config!");
             config.load();
             		basicFBlockID = config.getBlock("basicMachineHandler", 538).getInt();
             		goldenFBlockID = config.getBlock("advancedMachineHandler", 539).getInt();
             		basicFurnaceID = config.getItem("basicFurnace", 540).getInt();
             		powerPipeID = config.getBlock("powerPipe", 541).getInt();
             		netheriumIngotId = config.getItem("netheriumIngot", 590).getInt();
             		enderiumIngotId = config.getItem("enderiumIngot", 591).getInt();
         	 	System.out.println("[FC]Saving futurecraft config!");
         	 	System.out.println();
             config.save();
             
             
     }
     @EventHandler // used in 1.6.2
     //@Init       // used in 1.5.2
     public void load(FMLInitializationEvent event) {
             proxy.registerRenderers();
             System.out.println("Registering FutureCraft blocks!");
             ModBlocks.registerBlocks();
             ModBlocks.registerBlockNames();
             ModBlocks.registerMiningTools();
             System.out.println("Registering FutureCraft items!");
             ModItems.registerAllItems();
             System.out.println("Registering FutureCraft SHAPELESS recipes!");
             ModRecipes.registerRecipesShapeless();
         	System.out.println("Registering FutureCraft SHAPED recipes!");
         	ModRecipes.registerRecipesShapeless();
         	System.out.println("Registering FutureCraft TILE ENTITIES!");
         	ModTileEntities.registerTileEntities();
          	System.out.println("Registering FutureCraft CREATIVE TABS!!");
         	ModBlocks.setCreativeTabs();
         	
         	
         	
     }
     
     @EventHandler // used in 1.6.2
     //@PostInit   // used in 1.5.2
     public void postInit(FMLPostInitializationEvent event) {
             // Stub Method
     }
}
