package com.matt.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class ShovelRecipe extends ShapedRecipes {

	public ShovelRecipe(ItemStack result,ItemStack material, ItemStack stick) {
		super(1, 3, new ItemStack[]{material,stick,stick}, result);
	}

}
