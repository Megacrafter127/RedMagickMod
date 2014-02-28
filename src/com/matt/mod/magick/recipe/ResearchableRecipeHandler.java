package com.matt.mod.magick.recipe;

import java.util.HashMap;

import net.minecraft.item.crafting.ShapedRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ResearchableRecipeHandler {
	public static HashMap<String,ShapedRecipes> recipeMap;
	public static HashMap<String,Boolean> unlockedFor;
	public ResearchableRecipeHandler() {
		recipeMap = new HashMap<String,ShapedRecipes>();
		unlockedFor = new HashMap<String,Boolean>();
	}
	public boolean hasPlayerGotRecipe(String recipeID) {
		if(unlockedFor.get(recipeID) != false) {
			return unlockedFor.get(recipeID);
		}
		return false;
	}
	public void registerRecipe(String key, ShapedRecipes recipe) {
		if(key != null) {
			if(recipe != null) {
				recipeMap.put(key,recipe);
				unlockedFor.put(key,false);
			}else{
				return;
			}
		}else{
			return;
		}
	}
	public void unlockRecipe(String key) {
		if(hasPlayerGotRecipe(key) ) {
			return;
		}else{
			if(unlockedFor.get(key) != null) {
				unlockedFor.remove(key);
				unlockedFor.put(key,true);
				}else {
					unlockedFor.put(key,true);	
				}
			
		}
	}
	public void registerRecipeInForge(String key) {
		if(unlockedFor.get(key) == true) {
			GameRegistry.addRecipe(recipeMap.get(key));
		}else{
			return;
		}
	}
}	
