package com.matt.mod.magick.armor;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

import com.matt.mod.magick.ArmorHelper;
import com.matt.mod.magick.SwagHelper;

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
public static ShapedRecipes recipeHead = new ShapedRecipes(3, 3, new ItemStack[]{foscos,foscos,foscos,foscos,headPieceL,foscos,foscos,foscos,foscos}, headPiece);
public static ShapedRecipes recipeChest = new ShapedRecipes(3, 3, new ItemStack[]{foscos,foscos,foscos,foscos,chestPieceL,foscos,foscos,foscos,foscos}, chestPiece);
public static ShapedRecipes recipeLegs = new ShapedRecipes(3, 3, new ItemStack[]{foscos,foscos,foscos,foscos,legPieceL,foscos,foscos,foscos,foscos}, legPiece);
public static ShapedRecipes recipeBoots = new ShapedRecipes(3, 3, new ItemStack[]{foscos,foscos,foscos,foscos,bootPieceL,foscos,foscos,foscos,foscos}, bootPiece);

public static ShapedRecipes recipeCatalyst = new ShapedRecipes(3,3, new ItemStack[]{foscos,diamond,foscos,diamond,feather,diamond,foscos,diamond,foscos},catalyst);
public static void init() {	
	
	GameRegistry.addShapelessRecipe(foscos, new ItemStack[]{coal,redstone,glowstone,lapis});
	
	GameRegistry.addRecipe(recipeCatalyst);
	GameRegistry.addRecipe(recipeHead);
	GameRegistry.addRecipe(recipeChest);
	GameRegistry.addRecipe(recipeLegs);
	GameRegistry.addRecipe(recipeBoots);
	
}
}
