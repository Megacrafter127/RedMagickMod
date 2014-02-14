package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.items.ItemSwaggishWand;

import cpw.mods.fml.common.registry.GameRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand(FutureCraft.config.getItem("swaggishWand", FutureCraft.swag_wand_id).getInt(),"swaggishwand").setFull3D();
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.config.getBlock("swagWall", FutureCraft.swag_wall_id).getInt(),"magicalwall").setBlockUnbreakable();
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.config.getBlock("swagWall1", FutureCraft.swag_wall1_id).getInt(),"magicalwallb").setBlockUnbreakable();
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.config.getBlock("swagWall2", FutureCraft.swag_wall2_id).getInt(),"magicalwallre").setBlockUnbreakable();
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.config.getBlock("swagWall3", FutureCraft.swag_wall3_id).getInt(),"magicalwallyel").setBlockUnbreakable();
public static final Block blockNetherald = new SwagBlock(FutureCraft.config.getBlock("blocknetherium", FutureCraft.swag_default_id).getInt(),"netheriumblock");
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlock, "Magical Wall");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockRed, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockBlue, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockYellow, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", blockNetherald, "Netherium Block");

	FutureCraftRegistry.setLocalizedName("en_US", swaggishWand, "Swaggish Wand");
}
}
