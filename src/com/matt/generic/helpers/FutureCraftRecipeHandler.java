package com.matt.generic.helpers;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.mod.swag.infusion.InfusionRecipe;

public class FutureCraftRecipeHandler {
	 FutureCraftRecipeHandler instance = new  FutureCraftRecipeHandler();
private static HashMap<Block,Item> smelterRecipe = new HashMap<Block,Item>();
private static HashMap<Block,Item> crusherRecipe = new HashMap<Block,Item>();
private static InfusionRecipe[] infusionRecipes = new InfusionRecipe[100000];
public static HashMap getSmelterRecipes() {
	return smelterRecipe;
}
public static HashMap getCrusherRecipe() {
	return crusherRecipe;
}
public static InfusionRecipe[] getInfusion() {
	return infusionRecipes;
}
public FutureCraftRecipeHandler instance() {
	return instance;
}
public void registerSmelterRecipe(Block b, Item i) {
	if(b != null) {
		if(i != null) {
			smelterRecipe.put(b,i);
		}
	}
}
public void registerCrusherRecipe(Block b, Item i) {
	if(b != null) {
		if(i != null) {
			crusherRecipe.put(b,i);
		}
	}
}
public void registerInfusionRecipe(Block[] b, Item i[]) {
	InfusionRecipe ir = new InfusionRecipe(b,i);
 		if(ir != null) {
	 	infusionRecipes[infusionRecipes.length + 1] = ir;
 		}
	}
}
