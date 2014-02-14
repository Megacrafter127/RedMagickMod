package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.items.ItemSwaggishWand;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand(FutureCraft.swag_wand_id,"swaggishwand").setFull3D();
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable();
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable();
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable();
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable();
public static final Block blockNetherald = new SwagBlock(FutureCraft.swag_default_id,"netheriumblock");
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	LanguageRegistry.addName(blockMagicalBlock, "Magical Wall");
	LanguageRegistry.addName(blockMagicalBlockBlue, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockRed, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockYellow, "Magical Wall - Colored");
	LanguageRegistry.addName(blockNetherald, "Netherium Block");
}
}
