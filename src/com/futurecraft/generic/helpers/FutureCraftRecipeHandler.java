package com.futurecraft.generic.helpers;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.futurecraft.mod.magick.infusion.InfusionRecipe;

public class FutureCraftRecipeHandler {
	 public static final FutureCraftRecipeHandler instance = new  FutureCraftRecipeHandler();
	 private HashMap<Block,Item> smelterRecipe = new HashMap<Block,Item>();
	 private HashMap<Block,Item> crusherRecipe = new HashMap<Block,Item>();
	 private InfusionRecipe[] infusionRecipes = new InfusionRecipe[100000];
	 public HashMap getSmelterRecipes() {
		 return smelterRecipe;
	 }
	 public HashMap getCrusherRecipe() {
		 return crusherRecipe;
	 }
	 public InfusionRecipe[] getInfusion() {
		 return infusionRecipes;
	 }
	 /**
	  * the variable, this method returns is public and final, this method makes no sense.
	  * @return the standard FutureCraftRecipeHandler
	  */
	 @Deprecated
	 public static FutureCraftRecipeHandler instance() {
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

}