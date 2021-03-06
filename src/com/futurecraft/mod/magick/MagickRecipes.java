package com.futurecraft.mod.magick;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;

import com.futurecraft.mod.magick.runic.RunicHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class MagickRecipes {
	static List foscosList;
	
	public static final ItemStack headPieceE = new ItemStack(ArmorHelper.manaHelm,1,0);
	
	public static final ItemStack chestPieceE = new ItemStack(ArmorHelper.manaChest,1,0);
	public static final ItemStack legPieceE = new ItemStack(ArmorHelper.manaLegs,1,0);
	public static final ItemStack bootPieceE = new ItemStack(ArmorHelper.manaBoots,1,0);
	public static final ItemStack foscos = new ItemStack(MagickHelper.manaDust,1,0);
	public static final ItemStack headPiece = new ItemStack(ArmorHelper.manaHelm,1,0);
	public static final ItemStack headPieceL = new ItemStack(Item.helmetDiamond,1,0);
	public static final ItemStack chestPiece = new ItemStack(ArmorHelper.manaChest,1,0);
	public static final ItemStack chestPieceL = new ItemStack(Item.plateDiamond,1,0);
	public static final ItemStack legPiece = new ItemStack(ArmorHelper.manaLegs,1,0);
	public static final ItemStack legPieceL = new ItemStack(Item.legsDiamond,1,0);
	public static final ItemStack bootPiece = new ItemStack(ArmorHelper.manaBoots,1,0);
	public static final ItemStack bootPieceL = new ItemStack(Item.bootsDiamond,1,0);
	public static final ItemStack coal = new ItemStack(Item.coal,1,0);
	public static final ItemStack redstone = new ItemStack(Item.redstone,1,0);
	public static final ItemStack glowstone = new ItemStack(Item.glowstone,1,0);
	public static final ItemStack lapis = new ItemStack(Item.dyePowder,1,4);
	public static final ItemStack diamond = new ItemStack(Item.diamond,1,0);
	public static final ItemStack diamondBlock = new ItemStack(Block.blockDiamond,1,OreDictionary.WILDCARD_VALUE);
	public static final ItemStack catalyst = new ItemStack(MagickHelper.swaggishFlyer,1,0);
	public static final ItemStack feather = new ItemStack(Item.feather,1,0);
	public static final ItemStack dia =  new ItemStack(MagickHelper.manaDiamond,1,0);
	public  static final ItemStack oak = new ItemStack(Block.planks,0,0);
	public static final ItemStack stoneStack = new ItemStack(Block.stone,0,0);
	public static final ItemStack rune = new ItemStack(MagickHelper.rune);
	private static final ItemStack stick = new ItemStack(Item.stick);
	private static final ItemStack runicSword = new ItemStack(MagickHelper.runicSword);
	public static final ItemStack enchantedSwordRunic = runicSword;
	public static ShapedRecipes recipeHead = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,headPieceL,dia,foscos,dia,foscos}, headPiece);
public static ShapedRecipes recipeChest = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,chestPieceL,dia,foscos,dia,foscos}, chestPiece);
public static ShapedRecipes recipeLegs = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,legPieceL,dia,foscos,dia,foscos}, legPiece);
public static ShapedRecipes recipeBoots = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,bootPieceL,dia,foscos,dia,foscos}, bootPiece);
public static ShapedRecipes recipeDiamond = new ShapedRecipes(3,3,new ItemStack[]{foscos,diamondBlock,foscos,diamondBlock,diamond,diamondBlock,foscos,diamondBlock,foscos},dia);
public static ShapedRecipes recipeCatalyst = new ShapedRecipes(3,3, new ItemStack[]{foscos,dia,foscos,dia,feather,dia,foscos,dia,foscos},catalyst);
public static ShapedRecipes recipeRune = new ShapedRecipes(3,3,new ItemStack[]{foscos,foscos,foscos,foscos,stoneStack,foscos,foscos,foscos,foscos,},new ItemStack(MagickHelper.rune));

public static ShapedRecipes recipeOldwood = new ShapedRecipes(3,3,new ItemStack[]{foscos,foscos,foscos,foscos,oak,foscos,foscos,foscos,foscos}, new ItemStack(MagickHelper.blockOldwood));
public static ShapedRecipes recipeEnchantH  = new ShapedRecipes(3,3,new ItemStack[]{foscos,rune,foscos,rune,headPiece,rune,foscos,rune,foscos},  headPieceE); 
public static ShapedRecipes recipeEnchantC   = new ShapedRecipes(3,3,new ItemStack[]{foscos,rune,foscos,rune,chestPiece,rune,foscos,rune,foscos},  chestPieceE);
public static ShapedRecipes recipeEnchantL   = new ShapedRecipes(3,3,new ItemStack[]{foscos,rune,foscos,rune,legPiece,rune,foscos,rune,foscos},  legPieceE);
public static ShapedRecipes recipeEnchantB   = new ShapedRecipes(3,3,new ItemStack[]{foscos,rune,foscos,rune,bootPiece,rune,foscos,rune,foscos}, bootPieceE);
public static ShapedRecipes recipeAlchemyStone = new ShapedRecipes(3,3,new ItemStack[] {
	foscos,diamondBlock,foscos,
	diamondBlock,foscos,diamondBlock,
	foscos,diamondBlock,foscos
}, new ItemStack(MagickHelper.alchemyStone));
public static ShapedRecipes recipeAlchemyFuel = new ShapedRecipes(3,3,new ItemStack[] {
		foscos,diamondBlock,foscos,
		diamondBlock,coal,diamondBlock,
		foscos,diamondBlock,foscos
	}, new ItemStack(MagickHelper.alchemyFuel));
	
public static ShapedRecipes recipeGrindStone= new ShapedRecipes(3,3,new ItemStack[] {
		null,null,new ItemStack(Item.ingotGold),
		null,new ItemStack(Item.ingotGold),foscos,
		new ItemStack(Item.ingotGold),foscos,rune
	
	}, new ItemStack(MagickHelper.dustCrafter));
	
public static ShapedRecipes recipeEnchantSword = new ShapedRecipes(3,3,new ItemStack[]{rune,rune,rune,rune,runicSword,rune,rune,rune,rune}, enchantedSwordRunic);
public static void init() {	
	headPieceE.addEnchantment(RunicHelper.eRunic,3);
	chestPieceE.addEnchantment(RunicHelper.eRunic,3);
	legPieceE.addEnchantment(RunicHelper.eRunic,3);
	bootPieceE.addEnchantment(RunicHelper.eRunic,3);
	enchantedSwordRunic.addEnchantment(RunicHelper.eNecrotic,3);
	GameRegistry.addShapelessRecipe(foscos, new ItemStack[]{coal,redstone,glowstone,lapis});
	GameRegistry.addShapelessRecipe(new ItemStack(MagickHelper.sunDust), new ItemStack[]{redstone,glowstone,lapis,new ItemStack(MagickHelper.dustCrafter),foscos});
	GameRegistry.addShapelessRecipe(new ItemStack(MagickHelper.moonDust), new ItemStack[]{coal,redstone,lapis,new ItemStack(MagickHelper.dustCrafter),foscos});
	GameRegistry.addRecipe(recipeCatalyst);
	GameRegistry.addRecipe(recipeHead);
	GameRegistry.addRecipe(recipeChest);
	GameRegistry.addRecipe(recipeLegs);
	GameRegistry.addRecipe(recipeBoots);
	GameRegistry.addRecipe(recipeDiamond);
	GameRegistry.addRecipe(recipeOldwood);
	GameRegistry.addRecipe(recipeRune);
	GameRegistry.addRecipe(recipeEnchantH);
	GameRegistry.addRecipe(recipeEnchantC);
	GameRegistry.addRecipe(recipeEnchantL);
	GameRegistry.addRecipe(recipeEnchantB);
	GameRegistry.addRecipe(recipeEnchantSword);
	GameRegistry.addRecipe(recipeAlchemyStone);
	GameRegistry.addRecipe(recipeAlchemyFuel);
	GameRegistry.addRecipe(recipeGrindStone);
}
}
