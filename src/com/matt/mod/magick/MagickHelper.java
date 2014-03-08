package com.matt.mod.magick;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.magick.block.BlockManaBomb;
import com.matt.mod.magick.block.BlockManaCollector;
import com.matt.mod.magick.block.BlockManaCollector.TileEntityCollector;
import com.matt.mod.magick.block.BlockOldwood;
import com.matt.mod.magick.block.SwagBattery;
import com.matt.mod.magick.block.SwagBlock;
import com.matt.mod.magick.block.SwagDecoBlock;
import com.matt.mod.magick.block.WardedStone;
import com.matt.mod.magick.block.tile.TileEntityProtected;
import com.matt.mod.magick.block.tile.TileEntityWandRecharger;
import com.matt.mod.magick.itemblocks.ItemBlockProtectedStone;
import com.matt.mod.magick.items.ItemFlyingCatalist;
import com.matt.mod.magick.items.ItemMagickWand;
import com.matt.mod.magick.items.ItemManaDust;
import com.matt.mod.magick.items.ItemWandCore;
import com.matt.mod.magick.items.MinerTool;
import com.matt.mod.magick.items.runic.ItemRune;
import com.matt.mod.magick.items.runic.RunicEnchantHandler;
import com.matt.mod.magick.items.runic.RunicHelper;
import com.matt.mod.magick.lib.MagickLib;
import com.matt.mod.magick.multiblock.BlockAltar;
import com.matt.mod.magick.multiblock.TileEntityAltar;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
/**
 * 
 * @author Matheus
 *
 */
public class MagickHelper {
	
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable().setUnlocalizedName("Magical Block").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);;
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(Ref.getRecommendedTab("block")).setLightOpacity(0);
public static final Block blockNetherald = new SwagBlock(FutureCraft.netheraldId,"netheriumblock").setUnlocalizedName("Netherium Block").setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block manaBattery = new SwagBattery(FutureCraft.manaBatteryId,"manabattery").setUnlocalizedName("Mana Battery").setCreativeTab(Ref.getRecommendedTab("item"));
public static final Item magickWand = new ItemMagickWand(FutureCraft.swag_wand_id).setMaxStackSize(1).setCreativeTab(Ref.getRecommendedTab("item"));
public static final Item magickCore = new ItemWandCore(FutureCraft.swag_wand_idt2).setMaxStackSize(1).setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block decorationKernelBlock = new SwagDecoBlock(FutureCraft.swagDecoID).setCreativeTab(Ref.getRecommendedTab("item"));
public static final Item swaggishFlyer = new ItemFlyingCatalist().setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block blockAltarCore = new BlockAltar().setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block blockProtectedStone = new WardedStone(FutureCraft.blockGOLID).setCreativeTab(Ref.getRecommendedTab("item"));
//public static Block blockMagicalLamp =  new MagickalBlockG(FutureCraft.blockGOLControlerID,Material.dragonEgg).setTextureFile("magickLamp");
public static final Item manaDust = new ItemManaDust().setUnlocalizedName("Mageia Skoni").setCreativeTab(Ref.getRecommendedTab("item"));
public static final Item minerTool = new MinerTool(FutureCraft.manaQuarryID).setUnlocalizedName("manaMiner").setTextureName(MagickLib.toTextureName("manaminer")).setCreativeTab(Ref.getRecommendedTab("item"));
public static final Item manaDiamond = new Item(FutureCraft.magickDiamondID).setUnlocalizedName("Mana Diamond").setTextureName(KernelCraftCore.toTextureName("enderald")).setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block blockOldwood = new BlockOldwood().setUnlocalizedName("Oldwood").setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block manaColl = new BlockManaCollector().setUnlocalizedName("Collector").setCreativeTab(Ref.getRecommendedTab("item"));
public static final Block blockManaBomb = new BlockManaBomb().setTextureName(MagickLib.toTextureName("manabomb")).setCreativeTab(Ref.getRecommendedTab("item"));
public static final RunicHelper instanceRunic = new RunicHelper();
public static final Item rune = new ItemRune();
public static void register() {
		
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");

	GameRegistry.registerItem(swaggishFlyer, "Swaggish Flyer");
	
	GameRegistry.registerBlock(blockNetherald,"netheriumBlock");
	GameRegistry.registerBlock(manaBattery,"Mana Battery");
	
	GameRegistry.registerItem(magickWand,"Magical Wand");
	GameRegistry.registerItem(magickCore,"Magical Core");
	decorationKernelBlock.setUnlocalizedName("Kernel Deco Block");
	GameRegistry.registerTileEntity(TileEntityWandRecharger.class, "tile.FutureCraftBattery");
	((ItemFlyingCatalist)swaggishFlyer).getLogic().setManaLevel(1000);
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
	LanguageRegistry.addName(manaDust,"Mageia Skoni");
	LanguageRegistry.addName(manaDiamond,"Mageia Diamanti");
	LanguageRegistry.addName(swaggishFlyer,"Mageia Aeroporos");
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,0),new ItemStack(magickCore,1,0),new ItemStack(Item.stick,1,0)));
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,1),new ItemStack(magickCore,1,1),new ItemStack(Item.stick,1,0)));
	GameRegistry.addRecipe(new WandRecipe(new ItemStack(magickWand,1,2),new ItemStack(magickCore,1,2),new ItemStack(Item.stick,1,0)));
	GameRegistry.registerBlock(blockProtectedStone,ItemBlockProtectedStone.class,"Warded Stone");
	LanguageRegistry.addName(blockProtectedStone,"Protected Stone");
	TileEntity.addMapping(TileEntityProtected.class, "Protected Block");
	ArmorHelper.register();
	GameRegistry.registerItem(manaDust, ItemManaDust.name);
	GameRegistry.registerItem(manaDiamond, Ref.toItemName("manadiamond"));
	GameRegistry.registerBlock(blockOldwood,"futurecraft.block.oldWood");
	LanguageRegistry.addName(blockOldwood,"Oldwood");
	GameRegistry.registerBlock(manaColl,"collector");
	GameRegistry.registerTileEntity(TileEntityCollector.class,"tileEntityCollector");
	LanguageRegistry.addName(minerTool,"Mana Omniminer");
	GameRegistry.registerBlock(blockManaBomb,"MANABOMB");
	LanguageRegistry.addName(blockManaBomb,"Nova Catalyst");
	GameRegistry.registerItem(rune,((ItemRune) rune).getName());
	LanguageRegistry.addName(rune,"Piece of Runic Scribblings");
	MinecraftForge.EVENT_BUS.register(new RunicEnchantHandler());
	instanceRunic.init();
	//GameRegistry.registerItem(minerTool, Ref.toItemName("minerTool"));
	MagickRecipes.init();
	//TickRegistry.registerTickHandler(new ArmorTickHandler(), Side.CLIENT);
}
}	
