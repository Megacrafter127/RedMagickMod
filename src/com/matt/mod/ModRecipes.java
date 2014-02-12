package com.matt.mod;

import com.matt.mod.recipes.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
public class ModRecipes {

	public static ItemStack dirtStack = new ItemStack(Block.dirt);
	public static ItemStack seedStack = new ItemStack(Item.seeds);
	public  static ItemStack grasStack = new ItemStack(Block.grass);
	public static ItemStack ironStack = new ItemStack(Item.ingotIron,1);
	public static ItemStack diamondStack = new ItemStack(Item.diamond,1);
	public static ItemStack goldStack = new ItemStack(Item.ingotGold,1);
	public static ItemStack bFutureStackCraft = new ItemStack(ModBlocks.basicFutureBlock,8);
	public static ItemStack gFutureStackCraft = new ItemStack(ModBlocks.goldenFutureBlock,8);
	public static ItemStack bFutureStack = new ItemStack(ModBlocks.basicFutureBlock);
	public static ItemStack gFutureStack = new ItemStack(ModBlocks.goldenFutureBlock);
	public static void registerRecipesShapeless() {
		GameRegistry.addShapelessRecipe(grasStack,dirtStack, seedStack);
	}
	public static void registerRecipesShaped() {
		GameRegistry.addRecipe(bFutureStackCraft, 
     			"xxx", "xyx", "xxx", 
     			'x',ironStack,'y',diamondStack);
		GameRegistry.addRecipe(bFutureStackCraft, 
     			"xxx", "xyx", "xxx", 
     			'x',goldStack,'y',diamondStack);
		GameRegistry.addRecipe(new PickRecipe(new ItemStack(ModItems.endh,1),new ItemStack(Item.stick,1),new ItemStack(ModItems.endpick,1)));
	}
}
