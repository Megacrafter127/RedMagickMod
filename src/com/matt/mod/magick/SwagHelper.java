package com.matt.mod.magick;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.magick.block.SwagBattery;
import com.matt.mod.magick.block.SwagBlock;
import com.matt.mod.magick.block.SwagDecoBlock;
import com.matt.mod.magick.block.WardedStone;
import com.matt.mod.magick.block.tile.TileEntityProtected;
import com.matt.mod.magick.block.tile.TileEntityWandRecharger;
import com.matt.mod.magick.generics.MagickalBlockG;
import com.matt.mod.magick.itemblocks.ItemBlockProtectedStone;
import com.matt.mod.magick.items.ItemFlyingCatalist;
import com.matt.mod.magick.items.ItemMagickWand;
import com.matt.mod.magick.items.ItemManaDust;
import com.matt.mod.magick.items.ItemWandCore;
import com.matt.mod.magick.multiblock.BlockAltar;
import com.matt.mod.magick.multiblock.TileEntityAltar;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SwagHelper {
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable().setUnlocalizedName("Magical Block").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockNetherald = new SwagBlock(FutureCraft.netheraldId,"netheriumblock").setUnlocalizedName("Netherium Block");
public static final Block manaBattery = new SwagBattery(FutureCraft.manaBatteryId,"manabattery").setUnlocalizedName("Mana Battery");
public static final Item magickWand = new ItemMagickWand(FutureCraft.swag_wand_id).setMaxStackSize(1);
public static final Item magickCore = new ItemWandCore(FutureCraft.swag_wand_idt2).setMaxStackSize(1);
public static final Block decorationKernelBlock = new SwagDecoBlock(FutureCraft.swagDecoID);
public static final ItemFlyingCatalist swaggishFlyer = new ItemFlyingCatalist();
public static final Block blockAltarCore = new BlockAltar();
public static final Block blockProtectedStone = new WardedStone(FutureCraft.blockGOLID);
//public static Block blockMagicalLamp =  new MagickalBlockG(FutureCraft.blockGOLControlerID,Material.dragonEgg).setTextureFile("magickLamp");
public static final Item manaDust = new ItemManaDust().setUnlocalizedName("Mageia Foscos");
public static void register() {
		
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");

	GameRegistry.registerItem(swaggishFlyer, "Swaggish Flyer");
	
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	GameRegistry.registerBlock(manaBattery,"Mana Battery");
	GameRegistry.registerBlock(decorationKernelBlock, Ref.NAME.toLowerCase() + ".decoBlock1");
	GameRegistry.registerItem(magickWand,"Magical Wand");
	GameRegistry.registerItem(magickCore,"Magical Core");
	decorationKernelBlock.setUnlocalizedName("Kernel Deco Block");
	GameRegistry.registerTileEntity(TileEntityWandRecharger.class, "tile.FutureCraftBattery");
	swaggishFlyer.getLogic().setManaLevel(1000);
	GameRegistry.registerBlock(decorationKernelBlock, Ref.BLOCKPREFIX + "decorationKernelBlock");
	GameRegistry.registerTileEntity(TileEntityAltar.class, "tile.altarCore");
	LanguageRegistry.addName(blockMagicalBlock, "Magical Wall");
	LanguageRegistry.addName(blockMagicalBlockBlue, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockRed, "Magical Wall - Colored");
	LanguageRegistry.addName(blockMagicalBlockYellow, "Magical Wall - Colored");
	LanguageRegistry.addName(blockNetherald, "Netherium Block");
	LanguageRegistry.addName(new ItemStack(magickWand,1,0), ItemMagickWand.names[0]);
	LanguageRegistry.addName(new ItemStack(magickWand,1,1), ItemMagickWand.names[1]);
	LanguageRegistry.addName(new ItemStack(magickWand,1,2), ItemMagickWand.names[2]);
	LanguageRegistry.addName(new ItemStack(magickCore,1,0), ItemWandCore.getNames()[0]);
	LanguageRegistry.addName(new ItemStack(magickCore,1,1), ItemWandCore.getNames()[1]);
	LanguageRegistry.addName(new ItemStack(magickCore,1,2), ItemWandCore.getNames()[2]);
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,0),new ItemStack(magickCore,1,0),new ItemStack(Item.stick,1,0)));
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,1),new ItemStack(magickCore,1,1),new ItemStack(Item.stick,1,0)));
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,2),new ItemStack(magickCore,1,2),new ItemStack(Item.stick,1,0)));
	GameRegistry.registerBlock(blockProtectedStone,ItemBlockProtectedStone.class,"Warded Stone");
	LanguageRegistry.addName(blockProtectedStone,"Protected Stone");
	TileEntity.addMapping(TileEntityProtected.class, "Protected Block");
	ArmorHelper.register();
	GameRegistry.registerItem(manaDust, ItemManaDust.name);
}
}	
