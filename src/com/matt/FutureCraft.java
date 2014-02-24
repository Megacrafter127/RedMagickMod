package com.matt;

import java.io.File;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.matt.generic.helpers.FutureCraftConfig;
import com.matt.lib.Ref;
import com.matt.mod.ModHelper;
import com.matt.mod.TabFuture;
import com.matt.mod.handlers.MultiPacketHandler;
import com.matt.mod.handlers.WorldHandlerFuture;
import com.matt.mod.magick.items.logic.WandTickHandler;
import com.matt.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * The futurecraft mod!
 * @author Matheus and Mega
 *
 */
@Mod(modid = Ref.ID, name = Ref.NAME, version = Ref.VERSION + Ref.ALPHA + Ref.BUILD)
@NetworkMod( channels = {"KernelCoreUpdate"}, clientSideRequired = true, serverSideRequired = true, packetHandler=MultiPacketHandler.class )
public class FutureCraft {
	 @Instance(Ref.ID)
	    public static FutureCraft instance;
	 @SidedProxy(clientSide="com.matt.proxy.client.ClientProxy", serverSide="com.matt.proxy.CommonProxy")
        public static CommonProxy proxy;
	
	 public static HashMap<String, Object> pluginHash = new HashMap<String, Object>();
	 public static File configPatch;
	 public static File swagConfig;
	public static  Configuration config;
	 // Block IDs
		public static int basicFBlockID = 538;
		public static int goldenFBlockID = 539;
		public static int basicFurnaceID = 540;
		public static int powerGenPassiveID = 541;
		public static int powerGenAgressiveID = 542;
		public static int oreIndiumID = 543;
		public static int oreRoentgeniumID = 544;
		public static int dimTransID = 545;
		public static int dimBeaconID = 546;
		public static int altarCoreID = 547;
		public static int blockGOLID = 548;
		public static int blockGOLControlerID = 549;
		//Item IDs
		public static int netheriumIngotId = 590;
		public static int enderiumIngotId = 591;
		public static int ingotIndiumId = 592;
		public static int ingotRoentgeniumId = 593;
		public static int jetpackId = 594;
		public static int netheriumPickaxeId = 600;
		public static int enderiumPickaxeId = 601;
		public static int indiumPickaxeId = 602;
		public static int roentgeniumPickaxeId = 603;
		public static int loreBookId = 650;
		// FutureCraft Swag
		public static boolean enable_swag = false;
		public static int swag_default_id = 750;
		public static int swag_wall_id = 751;
		public static int swag_wall1_id = 752;
		public static int swag_wall2_id = 753;
		public static int swag_wall3_id = 754;
		public static int swag_wand_id = 801;
		public static int swag_wand_idt2 = 802;
		public static int swag_wand_idt3 = 803;
		public static int swag_catalist_id = 804;
		public static int netheraldId = 755;
		public static int manaBatteryId = 756;
		public static int altarCoreId = 757;
		public static int swagChestId = 758;
		public static int blockEnhancerId = 759;
		public static int swagDecoID = 760;
		public static boolean enable_debug_wands;
		// ItemStacks -- For crafting.
		public static ItemStack dirtStack = new ItemStack(Block.dirt);
		public static ItemStack seedStack = new ItemStack(Item.seeds);
		public static ItemStack grasStack = new ItemStack(Block.grass);
		public static ItemStack ironStack = new ItemStack(Item.ingotIron,1);
		public static ItemStack diamondStack = new ItemStack(Item.diamond,1);
		public static ItemStack goldStack = new ItemStack(Item.ingotGold,1);
		public static ItemStack bFutureStackCraft = new ItemStack(ModHelper.basicFutureBlock,8);
		public static ItemStack gFutureStackCraft = new ItemStack(ModHelper.goldenFutureBlock,8);
		public static ItemStack bFutureStack = new ItemStack(ModHelper.basicFutureBlock);
		public static ItemStack gFutureStack = new ItemStack(ModHelper.goldenFutureBlock);
		
		// Creative Tabs
		 public static CreativeTabs tabFCraft = new TabFuture(CreativeTabs.getNextID(), "FutureCraft","block");
		 public static CreativeTabs tabFCraftItems = new TabFuture(CreativeTabs.getNextID(), "FutureCraft Items","item");
		
		
		
		 
		@EventHandler
     public void preInit(FMLPreInitializationEvent event) {
             System.out.println("[FC]This is FutureCraft " + Ref.VERSION);
             configPatch = event.getSuggestedConfigurationFile();
             System.out.println("Config File:"+configPatch.getAbsolutePath());
             /**
              * FutureCraft Config file
              */
             config = new Configuration(FutureCraft.configPatch);     
             FutureCraftConfig.cfg = config;
             config.load();
             		basicFBlockID = config.getBlock("basicMachineHandler", 538).getInt();
             		goldenFBlockID = config.getBlock("advancedMachineHandler", 539).getInt();
             		basicFurnaceID = config.getBlock("basicFurnace", 540).getInt();
             		powerGenPassiveID = config.getBlock("powerPipe", 541).getInt();
             		netheriumIngotId = config.getItem("netheriumIngot", 590).getInt();
             		enderiumIngotId = config.getItem("enderiumIngot", 591).getInt();
             		oreIndiumID = config.getBlock("oreIndium", 543).getInt();
            		oreRoentgeniumID = config.getBlock("oreRoentgenium", 544).getInt();
            		dimTransID = config.getBlock("dimensionalTransmutator", 545).getInt();
            		dimBeaconID = config.getBlock("dimensionalBeacon", 546).getInt();
            		netheriumPickaxeId  = config.getBlock("netheriumPick", 600).getInt();
            		enderiumPickaxeId  = config.getBlock("enderiumPick", 601).getInt();
            		indiumPickaxeId  = config.getBlock("indiumPick", 602).getInt();
            		roentgeniumPickaxeId = config.getBlock("roentgeniumPick", 603).getInt();
            		jetpackId = config.getItem("jetpack", 594).getInt();
            		loreBookId = config.getItem("loreBook", 650).getInt();
            		altarCoreID = config.getBlock("Altar Core", 547).getInt();
            		blockGOLID = config.getBlock("Magick","Warded Stone", 548).getInt();
            		blockGOLControlerID = config.getBlock("GOLControler", 549).getInt();
            		
            		//enable_swag = FutureCraft.config.get("Module", "Enable Magick", true).getBoolean(true);
            		enable_debug_wands = FutureCraft.config.get("Debug", "Enable Magick - Wands Debug", false).getBoolean(false);
            		swag_wand_id = FutureCraft.config.getItem("Swaggish Wand - Tier 1", 801 ).getInt();

            		swag_wand_idt2 = FutureCraft.config.getItem("Swaggish Wand - Tier 2", 802 ).getInt();

            		swag_wand_idt3 = FutureCraft.config.getItem("Swaggish Wand - Tier 3", 803 ).getInt();
            		swag_wall_id  = FutureCraft.config.getBlock("magicWall", 751).getInt();
            		
            		swag_wall1_id = FutureCraft.config.getBlock("magicWall1", 752 ).getInt();
            		
            		swag_wall2_id = FutureCraft.config.getBlock("magicWall2", 753 ).getInt();
            	
            		swag_wall3_id = FutureCraft.config.getBlock("magicWall3", 754 ).getInt();
            		
            		swag_catalist_id = FutureCraft.config.getItem("Flying Catalist", 804).getInt();
            		
            		netheraldId = FutureCraft.config.getBlock("Netherium Block", 755).getInt();
            		manaBatteryId = FutureCraft.config.getBlock("Mana Battery", 756).getInt();
            		altarCoreId = FutureCraft.config.getBlock("Altar Core", 757).getInt();
            		swagChestId = FutureCraft.config.getBlock("Swag Chest", 758).getInt();
            		blockEnhancerId = FutureCraft.config.getBlock("Altar Enhancer", 759).getInt();
            		swagDecoID = FutureCraft.config.getBlock("Swag Decoration Block", 760).getInt();
         	 	System.out.println("[FC]Saving futurecraft config!");
         	 	System.out.println();
             config.save();
             
     }
     @EventHandler // used in 1.6.2
     //@Init       // used in 1.5.2
     public void load(FMLInitializationEvent event) {
             proxy.registerRenderers();
             System.out.println("Registering FutureCraft blocks!");
             ModHelper.registerAll();
         	System.out.println("Registering FutureCraft worldgenerator handler!");
         	GameRegistry.registerWorldGenerator(new WorldHandlerFuture());
         	NetworkRegistry.instance().registerGuiHandler(this, this.proxy);
         	TickRegistry.registerTickHandler(new WandTickHandler(),Side.CLIENT);
     }
 /*@EventHandler
 public void serverLoad(FMLServerStartingEvent event)
 {
   event.registerServerCommand(new FutureCraftCommand());
 }*/
     
     @EventHandler // used in 1.6.2
     public void postInit(FMLPostInitializationEvent event) {
    	 
     }
}
