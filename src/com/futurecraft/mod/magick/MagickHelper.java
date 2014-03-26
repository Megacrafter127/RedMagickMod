package com.futurecraft.mod.magick;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;
import com.futurecraft.mod.TabFuture;
import com.futurecraft.mod.magick.alchemy.AlchemicalStone;
import com.futurecraft.mod.magick.alchemy.ItemAlchemicalFuel;
import com.futurecraft.mod.magick.alchemy.ItemGrinder;
import com.futurecraft.mod.magick.alchemy.ItemMoonDust;
import com.futurecraft.mod.magick.alchemy.ItemSunDust;
import com.futurecraft.mod.magick.block.BlockManaBomb;
import com.futurecraft.mod.magick.block.BlockManaCollector;
import com.futurecraft.mod.magick.block.BlockManaCollector.TileEntityCollector;
import com.futurecraft.mod.magick.block.BlockOldwood;
import com.futurecraft.mod.magick.block.SwagBattery;
import com.futurecraft.mod.magick.block.SwagBlock;
import com.futurecraft.mod.magick.block.SwagDecoBlock;
import com.futurecraft.mod.magick.block.WardedStone;
import com.futurecraft.mod.magick.block.tile.TileEntityProtected;
import com.futurecraft.mod.magick.block.tile.TileEntityWandRecharger;
import com.futurecraft.mod.magick.infusion.InfusionAltar;
import com.futurecraft.mod.magick.infusion.RecipeShapedRunicInfusion;
import com.futurecraft.mod.magick.infusion.TileInfuser;
import com.futurecraft.mod.magick.itemblocks.ItemBlockProtectedStone;
import com.futurecraft.mod.magick.items.ItemFlyingCatalist;
import com.futurecraft.mod.magick.items.ItemMagickWand;
import com.futurecraft.mod.magick.items.ItemManaDust;
import com.futurecraft.mod.magick.items.ItemWandCore;
import com.futurecraft.mod.magick.items.MinerTool;
import com.futurecraft.mod.magick.lib.MagickLib;
import com.futurecraft.mod.magick.multiblock.BlockAltar;
import com.futurecraft.mod.magick.multiblock.TileEntityAltar;
import com.futurecraft.mod.magick.runic.ItemRune;
import com.futurecraft.mod.magick.runic.ItemRunicSword;
import com.futurecraft.mod.magick.runic.RunicEnchantHandler;
import com.futurecraft.mod.magick.runic.RunicHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
/**
 * 
 * @author Matheus
 *
 */
public class MagickHelper {
	public static final CreativeTabs tabMagick = new TabFuture(CreativeTabs.getNextID(), "FutureCraftMagick", "magick");
public static final Block blockMagicalBlock = new SwagBlock(FutureCraft.swag_wall_id,"magicalwall").setBlockUnbreakable().setUnlocalizedName("Magical Block").setCreativeTab(tabMagick).setLightOpacity(0);
public static final Block blockMagicalBlockBlue = new SwagBlock(FutureCraft.swag_wall1_id,"magicalwallb").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(tabMagick).setLightOpacity(0);;
public static final Block blockMagicalBlockRed = new SwagBlock(FutureCraft.swag_wall2_id,"magicalwallre").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(tabMagick).setLightOpacity(0);;
public static final Block blockMagicalBlockYellow = new SwagBlock(FutureCraft.swag_wall3_id,"magicalwallyel").setBlockUnbreakable().setUnlocalizedName("Magical Block - Colored").setCreativeTab(tabMagick).setLightOpacity(0);
public static final Block blockNetherald = new SwagBlock(FutureCraft.netheraldId,"netheriumblock").setUnlocalizedName("Netherium Block").setCreativeTab(tabMagick);
public static final Block manaBattery = new SwagBattery(FutureCraft.manaBatteryId,"manabattery").setUnlocalizedName("Mana Battery").setCreativeTab(tabMagick).setTextureName(MagickLib.toTextureName("nop"));
public static final Item magickWand = new ItemMagickWand(FutureCraft.swag_wand_id).setMaxStackSize(1).setCreativeTab(tabMagick);

public static final Item magickCore = new ItemWandCore(FutureCraft.swag_wand_idt2).setMaxStackSize(1).setCreativeTab(tabMagick);
public static final Block decorationKernelBlock = new SwagDecoBlock(FutureCraft.swagDecoID).setCreativeTab(tabMagick);
public static final Item swaggishFlyer = new ItemFlyingCatalist().setCreativeTab(tabMagick);
public static final Block blockAltarCore = new BlockAltar().setCreativeTab(tabMagick).setTextureName(MagickLib.toTextureName("nop"));
public static final Block blockProtectedStone = new WardedStone(FutureCraft.blockGOLID).setCreativeTab(tabMagick);
//public static Block blockMagicalLamp =  new MagickalBlockG(FutureCraft.blockGOLControlerID,Material.dragonEgg).setTextureFile("magickLamp");
public static final Item manaDust = new ItemManaDust().setUnlocalizedName("Mageia Skoni").setCreativeTab(tabMagick);
public static final Item minerTool = new MinerTool(FutureCraft.manaQuarryID).setUnlocalizedName("manaMiner").setTextureName(MagickLib.toTextureName("manaminer")).setCreativeTab(tabMagick);
public static final Item manaDiamond = new Item(FutureCraft.magickDiamondID).setUnlocalizedName("Mana Diamond").setTextureName(MagickLib.toTextureName("enderald")).setCreativeTab(tabMagick);
public static final Block blockOldwood = new BlockOldwood().setUnlocalizedName("Oldwood").setCreativeTab(tabMagick);
public static final Block manaColl = new BlockManaCollector().setUnlocalizedName("Collector").setCreativeTab(tabMagick).setTextureName(MagickLib.toTextureName("nop"));
public static final Block blockManaBomb = new BlockManaBomb().setTextureName(MagickLib.toTextureName("manabomb")).setCreativeTab(tabMagick);
public static final RunicHelper instanceRunic = new RunicHelper();
public static final Item rune = new ItemRune();
public static final Item runicSword = new ItemRunicSword();
public static final Block infusionAltar = new InfusionAltar().setTextureName(MagickLib.toTextureName("nop"));
public static final Item alchemyStone = new AlchemicalStone().setUnlocalizedName("Alchemical Stone").setTextureName(MagickLib.toTextureName("stonealch"));
public static final Item alchemyFuel = new ItemAlchemicalFuel().setUnlocalizedName("alchemicalStone");
public static final Item sunDust = new ItemSunDust();
public static final Item moonDust = new ItemMoonDust();
public static final Item dustCrafter = new ItemGrinder(MagickLib.getIdFor("Dust Crafter",5004)).setTextureName(MagickLib.toTextureName("grinder"));
//public static final Fluid fluidMagicka = new FluidMagicka("null");
public static void register() {
		
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	
	GameRegistry.registerBlock(blockMagicalBlockBlue,"magicalWallBlue");
	
	GameRegistry.registerBlock(blockMagicalBlockRed,"magicalWallRed");
	
	GameRegistry.registerBlock(blockMagicalBlockYellow,"magicalWallYellow");

	GameRegistry.registerItem(swaggishFlyer, "Swaggish Flyer");
	TileEntity.addMapping(TileInfuser.class,"Infuser");
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
	GameRegistry.registerBlock(blockAltarCore,"Altar Core");
	GameRegistry.registerBlock(infusionAltar,"Altar Core - WIP - WIth GUI");
	LanguageRegistry.addName(infusionAltar,"Altar Core - WIP - WIth GUI");
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
	GameRegistry.registerItem(runicSword,"Runic Sword");
	GameRegistry.registerItem(alchemyFuel,"alchemyFuel");
	LanguageRegistry.addName(alchemyFuel,"Alchemical Fuel");
	//FluidRegistry.registerFluid(fluidMagicka);
	LanguageRegistry.addName(runicSword,"Runic Sword");
	MinecraftForge.EVENT_BUS.register(new RunicEnchantHandler());
	GameRegistry.registerItem(alchemyStone,"Alchemical Stone");
	LanguageRegistry.addName(alchemyStone,"Alchemical Stone");
	GameRegistry.registerItem(sunDust,"sunDust");
	GameRegistry.registerItem(moonDust,"moonDust");
	GameRegistry.registerItem(dustCrafter,"grinder");
	LanguageRegistry.addName(dustCrafter,"Magic Pulveriser");
	 GameRegistry.registerCraftingHandler(new com.futurecraft.mod.handlers.CraftingHandler());
	try{
		TileInfuser.infusionShapedList.add(new RecipeShapedRunicInfusion(new ItemStack(MagickHelper.blockMagicalBlock),TileInfuser.inv, new ItemStack[]{new ItemStack(MagickHelper.rune)},3));
		}catch(Throwable t) {
			t.printStackTrace();
		}
	
	instanceRunic.init();
	//GameRegistry.registerItem(minerTool, Ref.toItemName("minerTool"));
	MagickRecipes.init();
	//TickRegistry.registerTickHandler(new ArmorTickHandler(), Side.CLIENT);
}
}	
