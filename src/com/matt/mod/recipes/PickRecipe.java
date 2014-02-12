package com.matt.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class PickRecipe extends ShapedRecipes {

	public PickRecipe(ItemStack material,ItemStack stick,ItemStack result) {
		super(3,3, new ItemStack[]{material,material,material,null,stick,null,null,stick,null}, result);
	}

}
