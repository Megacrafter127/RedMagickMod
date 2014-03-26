package com.futurecraft.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class QuadSymetricRecipe extends ShapedRecipes {

	public QuadSymetricRecipe(ItemStack result,ItemStack edge, ItemStack side, ItemStack center) {
		super(3, 3, new ItemStack[]{edge,side,edge,side,center,side,edge,side,edge}, result);
	}

}
