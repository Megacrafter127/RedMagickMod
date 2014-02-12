package com.matt.mod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.matt.mod.recipes.PickRecipe;

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
	
	public static final ItemStack stickStack = new ItemStack(Item.stick);
	public static final ItemStack enderpearlStack = new ItemStack(Item.enderPearl);
	public static final ItemStack enderiumStack = new ItemStack(ModItems.endh);
	public static final ItemStack netheriumStack = new ItemStack(ModItems.neth);
	public static final ItemStack indiumStack = new ItemStack(ModItems.ingotIndium);
	public static final ItemStack roentgeniumStack = new ItemStack(ModItems.ingotRoentgenium);
	
	public static void registerRecipesShapeless() {
		GameRegistry.addShapelessRecipe(grasStack,dirtStack, seedStack);
	}
	public static void registerRecipesShaped() {
		GameRegistry.addRecipe(bFutureStackCraft, 
     			"xxx", "xyx", "xxx", 
     			'x',ironStack,'y',diamondStack);
		GameRegistry.addRecipe(gFutureStackCraft, 
     			"xzx", "zyz", "xzx", 
     			'x',goldStack,'y',diamondStack, 'z', enderiumStack );
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dimensionalInfuser,1),"xxx","xyx","xxx",'x',ironStack,'y',enderpearlStack);
		GameRegistry.addRecipe(new PickRecipe(enderiumStack,stickStack,new ItemStack(ModItems.endpick,1)));
		GameRegistry.addRecipe(new PickRecipe(netheriumStack,stickStack,new ItemStack(ModItems.nethpick,1)));
		GameRegistry.addRecipe(new PickRecipe(indiumStack,stickStack,new ItemStack(ModItems.indiumPick,1)));
	}
}
