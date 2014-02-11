package com.matt.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.blocks.BlockDimensionalTransmutator;
import com.matt.mod.blocks.BlockFutureBasic;
import com.matt.mod.blocks.BlockFutureFurnace;
import com.matt.mod.blocks.BlockFutureGold;
import com.matt.mod.blocks.BlockOre;
import com.matt.mod.blocks.BlockPowerPipe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;




public class ModBlocks {
	public static final Block basicFutureBlock = new BlockFutureBasic(FutureCraft.basicFBlockID, Material.ground,"blueblockfuture");
	public static final Block goldenFutureBlock = new BlockFutureGold(FutureCraft.goldenFBlockID, Material.ground,"goldfutureblock");
	public static final Block basicFutureFurnace = new BlockFutureFurnace(FutureCraft.basicFurnaceID,"compressionSmelter");
	public static final Block blockPowerPipe = new BlockPowerPipe(FutureCraft.powerGenPassiveID,"powerpipe");
	public static final Block dimensionalInfuser = new BlockDimensionalTransmutator(FutureCraft.dimTransID);
	public static final Block oreIndium = new BlockOre(FutureCraft.oreIndiumID,"oreindium").setTextureName(Ref.NAME.toLowerCase() + ":oreindium");
	public static final Block oreRoentgenium = new BlockOre(FutureCraft.oreRoentgeniumID,"oreroentgenium").setTextureName(Ref.NAME.toLowerCase() + ":oreroentgenium");
	public static void registerBlocks() {
		GameRegistry.registerBlock(basicFutureBlock, "basicFutureBlock");
		GameRegistry.registerBlock(goldenFutureBlock, "goldenFutureBlock");
		GameRegistry.registerBlock(basicFutureFurnace,"basicFutureFurnace");
		GameRegistry.registerBlock(blockPowerPipe,"blockPowerPipe");
		GameRegistry.registerBlock(oreIndium, "oreIndium");
		GameRegistry.registerBlock(oreRoentgenium, "oreRoentgenium");
		GameRegistry.registerBlock(dimensionalInfuser, "dimensionalInfuser");
		}
	public static void registerBlockNames() {
		LanguageRegistry.addName(basicFutureBlock, "Iron Machine Handler");
		LanguageRegistry.addName(goldenFutureBlock, "Golden Machine Handler");
		LanguageRegistry.addName(basicFutureFurnace, "Basic Compression Smelter");
		LanguageRegistry.addName(blockPowerPipe, "Power Generator ( Passive ) ");
		LanguageRegistry.addName(oreIndium, "Indium Ore");
		LanguageRegistry.addName(oreRoentgenium, "Roentgenium Ore");
		LanguageRegistry.addName(dimensionalInfuser, "Dimensional Infuser");
	}
	public static void registerMiningTools() {
		MinecraftForge.setBlockHarvestLevel(basicFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(goldenFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(basicFutureFurnace, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(oreIndium, "pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(oreRoentgenium, "pickaxe",3);
		
	}
	public static void setCreativeTabs() {
		blockPowerPipe.setCreativeTab(Ref.getRecommendedTab("block"));
		basicFutureBlock.setCreativeTab(Ref.getRecommendedTab("block"));
		goldenFutureBlock.setCreativeTab(Ref.getRecommendedTab("block"));
		basicFutureFurnace.setCreativeTab(Ref.getRecommendedTab("block"));
		oreIndium.setCreativeTab(Ref.getRecommendedTab("block"));
		oreRoentgenium.setCreativeTab(Ref.getRecommendedTab("block"));
		dimensionalInfuser.setCreativeTab(Ref.getRecommendedTab("block"));
	}
}
