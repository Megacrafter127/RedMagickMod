package com.matt.mod.magick;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagickRecipes {
	static List foscosList;
	public static final ItemStack foscos = new ItemStack(SwagHelper.manaDust,1,0);
	public static final ItemStack headPiece = new ItemStack(ArmorHelper.manaHelm,1,0);
	public static final ItemStack headPieceL = new ItemStack(Item.helmetLeather,1,0);
	public static final ItemStack chestPiece = new ItemStack(ArmorHelper.manaChest,1,0);
	public static final ItemStack chestPieceL = new ItemStack(Item.plateLeather,1,0);
	public static final ItemStack legPiece = new ItemStack(ArmorHelper.manaLegs,1,0);
	public static final ItemStack legPieceL = new ItemStack(Item.legsLeather,1,0);
	public static final ItemStack bootPiece = new ItemStack(ArmorHelper.manaBoots,1,0);
	public static final ItemStack bootPieceL = new ItemStack(Item.bootsLeather,1,0);
	public static final ItemStack coal = new ItemStack(Item.coal,1,0);
	public static final ItemStack redstone = new ItemStack(Item.redstone,1,0);
	public static final ItemStack glowstone = new ItemStack(Item.glowstone,1,0);
	public static final ItemStack lapis = new ItemStack(Item.dyePowder,1,4);
	public static final ItemStack diamond = new ItemStack(Item.diamond,1,0);
	public static final ItemStack catalyst = new ItemStack(SwagHelper.swaggishFlyer,1,0);
	public static final ItemStack feather = new ItemStack(Item.feather,1,0);
	public static final ItemStack dia =  new ItemStack(SwagHelper.manaDiamond,1,0);
	public static ShapedRecipes recipeHead = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,headPieceL,dia,foscos,dia,foscos}, headPiece);
public static ShapedRecipes recipeChest = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,chestPieceL,dia,foscos,dia,foscos}, chestPiece);
public static ShapedRecipes recipeLegs = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,legPieceL,dia,foscos,dia,foscos}, legPiece);
public static ShapedRecipes recipeBoots = new ShapedRecipes(3, 3, new ItemStack[]{foscos,dia,foscos,dia,bootPieceL,dia,foscos,dia,foscos}, bootPiece);
public static ShapedRecipes recipeDiamond = new ShapedRecipes(3,3,new ItemStack[]{foscos,foscos,foscos,foscos,diamond,foscos,foscos,foscos,foscos},dia);
public static ShapedRecipes recipeCatalyst = new ShapedRecipes(3,3, new ItemStack[]{foscos,dia,foscos,dia,feather,dia,foscos,dia,foscos},catalyst);
public static void init() {	
	
	GameRegistry.addShapelessRecipe(foscos, new ItemStack[]{coal,redstone,glowstone,lapis});
	
	GameRegistry.addRecipe(recipeCatalyst);
	GameRegistry.addRecipe(recipeHead);
	GameRegistry.addRecipe(recipeChest);
	GameRegistry.addRecipe(recipeLegs);
	GameRegistry.addRecipe(recipeBoots);
	GameRegistry.addRecipe(recipeDiamond);
	
}
}
