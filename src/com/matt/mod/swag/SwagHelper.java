package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.swag.block.SwagBattery;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.block.SwagDecoBlock;
import com.matt.mod.swag.block.tile.TileEntityWandRecharger;
import com.matt.mod.swag.items.ItemFlyingCatalist;
import com.matt.mod.swag.items.ItemSwaggishWand;
import com.matt.mod.swag.items.ItemSwaggishWand.tier;
import com.matt.mod.swag.multiblock.BlockAltar;
import com.matt.mod.swag.multiblock.TileEntityAltar;

import cpw.mods.fml.common.registry.GameRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand(FutureCraft.swag_wand_id,"swaggishwand",tier.BASIC).setFull3D().setUnlocalizedName("Swaggish Wand").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Item swaggishWandT2 = new ItemSwaggishWand(FutureCraft.swag_wand_idt2,"swaggishwand",tier.NETHERIUM).setFull3D().setUnlocalizedName("Swaggish Wand - T2").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Item swaggishWandT3 = new ItemSwaggishWand(FutureCraft.swag_wand_idt3,"swaggishwand",tier.ENDERIUM).setFull3D().setUnlocalizedName("Swaggish Wand - T3").setCreativeTab(Ref.getRecommendedTab("block"));
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable().setUnlocalizedName("Magical Block").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockNetherald = new SwagBlock(FutureCraft.netheraldId,"netheriumblock").setUnlocalizedName("Netherium Block");
public static final Block manaBattery = new SwagBattery(FutureCraft.manaBatteryId,"manabattery").setUnlocalizedName("Mana Battery");
public static final Block decorationKernelBlock = new SwagDecoBlock(FutureCraft.swagDecoID);
//public static final Block blockMagicalLighter = new SwagLighter(FutureCraft.swag_default_id,"netheriumblock");
public static final ItemFlyingCatalist swaggishFlyer = new ItemFlyingCatalist();
public static final Block blockAltarCore = new BlockAltar();
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");

	GameRegistry.registerItem(swaggishFlyer, "Swaggish Flyer");
	
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	//Register wand 
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	//Register wand t2
	GameRegistry.registerItem(swaggishWandT2, "Swaggish Wand T2");
	//Register wand t3
	GameRegistry.registerItem(swaggishWandT3, "Swaggish Wand T3");
	//Register mana battery
	GameRegistry.registerBlock(manaBattery,"Mana Battery");
	GameRegistry.registerBlock(decorationKernelBlock, Ref.NAME.toLowerCase() + ".decoBlock1");
	
	GameRegistry.registerBlock(blockAltarCore,Ref.NAME.toLowerCase() + Ref.ID.toLowerCase() + ".altarCore");
	blockAltarCore.setUnlocalizedName("Altar Core");
	decorationKernelBlock.setUnlocalizedName("Kernel Deco Block");
	//Register mana battery tile
	GameRegistry.registerTileEntity(TileEntityWandRecharger.class, "tile.FutureCraftBattery");
	swaggishFlyer.getLogic().setManaLevel(1000);
	GameRegistry.registerBlock(decorationKernelBlock, Ref.BLOCKPREFIX + "decoBlock1");
	GameRegistry.registerTileEntity(TileEntityAltar.class, "tile.altarCore");
	/*LanguageRegistry.addName(blockMagicalBlock, "Magical Wall");
	LanguageRegistry.addName(blockMagicalBlockBlue, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockRed, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockYellow, "Magical Wall - Colored");
	LanguageRegistry.addName(blockNetherald, "Netherium Block"); */
}
}
