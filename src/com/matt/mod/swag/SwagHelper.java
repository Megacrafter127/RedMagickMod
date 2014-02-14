package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.items.ItemFlyingCatalist;
import com.matt.mod.swag.items.ItemSwaggishWand;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand(FutureCraft.swag_wand_id,"swaggishwand").setFull3D().setUnlocalizedName("Swaggish Wand").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable().setUnlocalizedName("Magical Block").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockNetherald = new SwagBlock(FutureCraft.swag_default_id,"netheriumblock").setUnlocalizedName("Netherium Block");
public static final Item swaggishFlyer = new ItemFlyingCatalist();
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	GameRegistry.registerItem(swaggishFlyer, "Swaggish Flyer");
	/*LanguageRegistry.addName(blockMagicalBlock, "Magical Wall");
	LanguageRegistry.addName(blockMagicalBlockBlue, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockRed, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockYellow, "Magical Wall - Colored");
	LanguageRegistry.addName(blockNetherald, "Netherium Block"); */
}
}
