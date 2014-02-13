package com.matt.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.blocks.*;
import com.matt.mod.blocks.tileentity.*;
import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.item.*;
import com.matt.mod.recipes.*;
import com.matt.proxy.CommonProxy;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModHelper {
	
	//Blocks
	public static final Block basicFutureBlock = new BlockFutureBasic(FutureCraft.basicFBlockID, Material.ground,"blueblockfuture");
	public static final Block goldenFutureBlock = new BlockFutureGold(FutureCraft.goldenFBlockID, Material.ground,"goldfutureblock");
	public static final Block basicFutureFurnace = new BlockFutureFurnace(FutureCraft.basicFurnaceID,"compressionSmelter");
	public static final Block blockPowerPipe = new BlockPowerPipe(FutureCraft.powerGenPassiveID,"powerpipe");
	public static final Block dimensionalInfuser = new BlockDimensionalInfuser(FutureCraft.dimTransID);
	public static final Block oreIndium = new BlockOre(FutureCraft.oreIndiumID,"oreindium").setTextureName(Ref.NAME.toLowerCase() + ":oreindium");
	public static final Block oreRoent = new BlockOre(FutureCraft.oreRoentgeniumID,"oreroentgenium").setTextureName(Ref.NAME.toLowerCase() + ":oreroentgenium");
	public static final Block dimBeacon = new BlockDimensionalBeacon(FutureCraft.dimBeaconID);
	public static void registerBlocksInForge() {
		GameRegistry.registerBlock(basicFutureBlock, "basicFutureBlock");
		GameRegistry.registerBlock(goldenFutureBlock, "goldenFutureBlock");
		GameRegistry.registerBlock(basicFutureFurnace,"basicFutureFurnace");
		GameRegistry.registerBlock(blockPowerPipe,"blockPowerPipe");
		GameRegistry.registerBlock(oreIndium, "oreIndium");
		GameRegistry.registerBlock(oreRoent, "oreRoentgenium");
		GameRegistry.registerBlock(dimensionalInfuser, "dimensionalInfuser");
		GameRegistry.registerBlock(dimBeacon, "dimensionalBeacon");
		}
	public static void registerBlockNames() {
		LanguageRegistry.addName(basicFutureBlock, "Iron Machine Handler");
		LanguageRegistry.addName(goldenFutureBlock, "Golden Machine Handler");
		LanguageRegistry.addName(basicFutureFurnace, "Basic Compression Smelter");
		LanguageRegistry.addName(blockPowerPipe, "Power Generator ( Passive ) ");
		FutureCraftRegistry.setLocalizedName("en_US", oreIndium, "Indium Ore");
		FutureCraftRegistry.setLocalizedName("en_US", oreRoent, "Roentgenium Ore");
		FutureCraftRegistry.setLocalizedName("en_UK", oreIndium, "Indium Ore");
		FutureCraftRegistry.setLocalizedName("en_UK", oreRoent, "Roentgenium Ore");
		LanguageRegistry.addName(dimensionalInfuser, "Dimensional Infuser");
		FutureCraftRegistry.setLocalizedName("en_US", dimBeacon, "Dimensional Beacon");
		FutureCraftRegistry.setLocalizedName("en_UK", dimBeacon, "Dimensional Beacon");
	}
	public static void registerMiningTools() {
		MinecraftForge.setBlockHarvestLevel(basicFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(goldenFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(basicFutureFurnace, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(oreIndium, "pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(oreRoent, "pickaxe",3);
		MinecraftForge.setBlockHarvestLevel(dimensionalInfuser, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(dimBeacon, "pickaxe",1);
	}
	public static void setCreativeTabs() {
		blockPowerPipe.setCreativeTab(Ref.getRecommendedTab("block"));
		basicFutureBlock.setCreativeTab(Ref.getRecommendedTab("block"));
		goldenFutureBlock.setCreativeTab(Ref.getRecommendedTab("block"));
		basicFutureFurnace.setCreativeTab(Ref.getRecommendedTab("block"));
		oreIndium.setCreativeTab(Ref.getRecommendedTab("block"));
		oreRoent.setCreativeTab(Ref.getRecommendedTab("block"));
		dimensionalInfuser.setCreativeTab(Ref.getRecommendedTab("block"));
		dimBeacon.setCreativeTab(Ref.getRecommendedTab("block"));
	}
	public static void registerBlocks() {
		registerBlocksInForge();
		registerBlockNames();
		setCreativeTabs();
	}
	public static final ItemIngot neth = new ItemIngot(FutureCraft.netheriumIngotId,"ingotNetherium", CreativeTabs.tabMisc, "netheriumingot");
	public static final ItemIngot endh = new ItemIngot(FutureCraft.enderiumIngotId,"ingotEnderium", CreativeTabs.tabMisc, "enderiumingot");
	public static final ItemIngot ingotIndium = new ItemIngot(FutureCraft.ingotIndiumId,"ingotIndium", CreativeTabs.tabMisc, "indiumingot");
	public static final ItemIngot ingotRoentgenium = new ItemIngot(FutureCraft.ingotRoentgeniumId,"ingotRoentgenium", CreativeTabs.tabMisc, "roentgeniumingot");
	public static final ItemModPickaxe nethpick=new ItemModPickaxe(FutureCraft.netheriumPickaxeId,ItemModPickaxe.netherium);
	public static final ItemModPickaxe endpick=new ItemModPickaxe(FutureCraft.enderiumPickaxeId,ItemModPickaxe.enderium);
public static final ItemModPickaxe indiumPick=new ItemModPickaxe(FutureCraft.indiumPickaxeId,ItemModPickaxe.indium);
	public static final Item netheriumJetpack = new GenericItem(FutureCraft.jetpackId,"netheriumJetpack",Ref.getRecommendedTab("item"),"jetpack");
	public static final Item loreBook = new ItemFutureNote();
	public static void registerAllItems() {
		GameRegistry.registerItem(neth, "ingotNetherium");
		
		GameRegistry.registerItem(endh, "ingotEnderium");
		
		GameRegistry.registerItem(ingotIndium, "ingotIndium");
		
		GameRegistry.registerItem(ingotIndium, "ingotRoentgenium");
		
		GameRegistry.registerItem(nethpick, "pickaxeNetherium");
		
		GameRegistry.registerItem(endpick, "pickaxeEnderium");
		
		GameRegistry.registerItem(indiumPick, "pickaxeIndium");
		
		GameRegistry.registerItem(netheriumJetpack, "netheriumJetpack");
		GameRegistry.registerItem(loreBook, "LoreBook");
	}
	public static void registerItemNames() {
		LanguageRegistry.addName(neth, "Netherium Ingot");
		LanguageRegistry.addName(endh, "Enderium Ingot");
		LanguageRegistry.addName(ingotIndium, "Indium Ingot");
		LanguageRegistry.addName(ingotRoentgenium, "Roentgenium Ingot");
		LanguageRegistry.addName(nethpick, "Netherium Pickaxe");
		LanguageRegistry.addName(endpick, "Enderium Pickaxe");
		LanguageRegistry.addName(indiumPick, "Indium Pickaxe");
	}
	public static void registerItemCreativeTabs() {
		neth.setCreativeTab(Ref.getRecommendedTab("item"));
		endh.setCreativeTab(Ref.getRecommendedTab("item"));
		ingotIndium.setCreativeTab(Ref.getRecommendedTab("item"));
		ingotRoentgenium.setCreativeTab(Ref.getRecommendedTab("item"));
		nethpick.setCreativeTab(Ref.getRecommendedTab("item"));
		endpick.setCreativeTab(Ref.getRecommendedTab("item"));
		indiumPick.setCreativeTab(Ref.getRecommendedTab("item"));
	}
	//Recipes
	public static final ItemStack dirtStack = new ItemStack(Block.dirt);
	public static final ItemStack seedStack = new ItemStack(Item.seeds);
	public static final ItemStack grasStack = new ItemStack(Block.grass);
	public static final ItemStack ironStack = new ItemStack(Item.ingotIron,1);
	public static final ItemStack diamondStack = new ItemStack(Item.diamond,1);
	public static final ItemStack goldStack = new ItemStack(Item.ingotGold,1);
	public static final ItemStack bFutureStackCraft = new ItemStack(basicFutureBlock,8);
	public static final ItemStack gFutureStackCraft = new ItemStack(goldenFutureBlock,8);
	public static final ItemStack bFutureStack = new ItemStack(basicFutureBlock);
	public static final ItemStack gFutureStack = new ItemStack(goldenFutureBlock);
	
	public static final ItemStack stickStack = new ItemStack(Item.stick);
	public static final ItemStack enderpearlStack = new ItemStack(Item.enderPearl);
	public static final ItemStack enderiumStack = new ItemStack(endh);
	public static final ItemStack netheriumStack = new ItemStack(neth);
	public static final ItemStack indiumStack = new ItemStack(ingotIndium);
	public static final ItemStack roentgeniumStack = new ItemStack(ingotRoentgenium);
	public static final ItemStack netherstarStack = new ItemStack(Item.netherStar);
	public static final ItemStack beaconStack = new ItemStack(Block.beacon);
	public static final ItemStack dimbeaconStack = new ItemStack(dimBeacon);
	
	public static void registerRecipesShapeless() {
		GameRegistry.addShapelessRecipe(grasStack,dirtStack, seedStack);
		GameRegistry.addShapelessRecipe(netherstarStack,beaconStack);
		GameRegistry.addShapelessRecipe(netherstarStack,dimbeaconStack);
	}
	public static void registerRecipesShaped() {
		GameRegistry.addRecipe(new QuadSymetricRecipe(bFutureStackCraft,ironStack,netheriumStack,diamondStack));
		GameRegistry.addRecipe(new QuadSymetricRecipe(gFutureStackCraft,goldStack,enderiumStack,diamondStack));
		GameRegistry.addRecipe(new QuadSymetricRecipe(new ItemStack(dimensionalInfuser,1),ironStack,ironStack,enderpearlStack));
		GameRegistry.addRecipe(new PickRecipe(enderiumStack,stickStack,new ItemStack(endpick,1)));
		GameRegistry.addRecipe(new PickRecipe(netheriumStack,stickStack,new ItemStack(nethpick,1)));
		GameRegistry.addRecipe(new PickRecipe(indiumStack,stickStack,new ItemStack(indiumPick,1)));
		GameRegistry.addRecipe(new QuadSymetricRecipe(dimbeaconStack,netheriumStack,enderiumStack,beaconStack));
	}
	//Tile entities
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "tileEntitySmelter");
		GameRegistry.registerTileEntity(TileEntityPowerPipe.class, "tileeEntityPowerPipe");
		GameRegistry.registerTileEntity(DimensionalBeaconTileEntity.class, "tileEntityDimensionalBeacon");
		GameRegistry.registerTileEntity(TileEntityDimensionalInfuser.class, "tileEntityDimensionalInfuser");
	}
	public static void registerAll() {
		registerBlocks();
		registerItemNames();
		registerItemCreativeTabs();
		registerAllItems();
		registerRecipesShapeless();
		registerRecipesShaped();
		registerTileEntities();
		
	}
}
