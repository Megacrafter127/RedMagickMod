package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.items.ItemSwaggishWand;

import cpw.mods.fml.common.registry.GameRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand("swaggishwand").setFull3D();
public static final Block blockMagicalBlock = new SwagBlock("magicalwall").setBlockUnbreakable();
public static final Block blockMagicalBlockBlue = new SwagBlock("magicalwallb").setBlockUnbreakable();
public static final Block blockMagicalBlockRed = new SwagBlock("magicalwallre").setBlockUnbreakable();
public static final Block blockMagicalBlockYellow = new SwagBlock("magicalwallyel").setBlockUnbreakable();
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlock, "Magical Wall");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockRed, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockBlue, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlockYellow, "Magical Wall - Colored");
	FutureCraftRegistry.setLocalizedName("en_US", swaggishWand, "Swaggish Wand");
}
}
