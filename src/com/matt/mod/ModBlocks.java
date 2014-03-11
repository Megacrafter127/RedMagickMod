package com.matt.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import com.matt.FutureCraft;
import com.matt.mod.blocks.BlockFutureBasic;
import com.matt.mod.blocks.BlockFutureFurnace;
import com.matt.mod.blocks.BlockFutureGold;
import com.matt.mod.blocks.BlockPowerPipe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;




public class ModBlocks {
	public static final Block basicFutureBlock = new BlockFutureBasic(FutureCraft.basicFBlockID, Material.ground,"blueblockfuture");
	public static final Block goldenFutureBlock = new BlockFutureGold(FutureCraft.goldenFBlockID, Material.ground,"goldfutureblock");
	public static final Block basicFutureFurnace = new BlockFutureFurnace(FutureCraft.basicFurnaceID,"compressionSmelter");
	public static final Block blockPowerPipe = new BlockPowerPipe(FutureCraft.powerPipeID,"powerpipe");
	public static void registerBlocks() {
		GameRegistry.registerBlock(basicFutureBlock, "basicFutureBlock");
		GameRegistry.registerBlock(goldenFutureBlock, "goldenFutureBlock");
		GameRegistry.registerBlock(basicFutureFurnace,"basicFutureFurnace");
		GameRegistry.registerBlock(blockPowerPipe,"blockPowerPipe");
		}
	public static void registerBlockNames() {
		LanguageRegistry.addName(basicFutureBlock, "Iron Machine Handler");
		LanguageRegistry.addName(goldenFutureBlock, "Golden Machine Handler");
		LanguageRegistry.addName(basicFutureFurnace, "Basic Compression Smelter");
		LanguageRegistry.addName(blockPowerPipe, "Power Generator ( Passive ) ");
	}
	public static void registerMiningTools() {
		MinecraftForge.setBlockHarvestLevel(basicFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(goldenFutureBlock, "pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(basicFutureFurnace, "pickaxe",1);
	}
	public static void setCreativeTabs() {
		blockPowerPipe.setCreativeTab(FutureCraft.tabFCraft);
		basicFutureBlock.setCreativeTab(FutureCraft.tabFCraft);
		goldenFutureBlock.setCreativeTab(FutureCraft.tabFCraft);
		basicFutureFurnace.setCreativeTab(FutureCraft.tabFCraft);
	}
}
