package com.futurecraft.mod.magick;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class WandRecipe extends ShapedRecipes {
	public WandRecipe(ItemStack result,ItemStack core, ItemStack rod) {
		super(3, 3, new ItemStack[]{null,core,null,null,rod,null,null,core,null}, result);
	}
	

}
