package com.matt.generic.helpers;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.mod.swag.infusion.InfusionRecipe;

public class FutureCraftRecipeHandler {
private static HashMap<Block,Item> smelterRecipe = new HashMap<Block,Item>();
private static HashMap<Block,Item> crusherRecipe = new HashMap<Block,Item>();
private static HashMap<InfusionRecipe,Item> infusionRecipes = new HashMap<InfusionRecipe,Item>();
public static HashMap getSmelterRecipes() {
	return smelterRecipe;
}
public static HashMap getCrusherRecipe() {
	return crusherRecipe;
}
public static HashMap getInfusion() {
	return infusionRecipes;
}
}
