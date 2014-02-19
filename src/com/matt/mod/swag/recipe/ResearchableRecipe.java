package com.matt.mod.swag.recipe;

import java.util.LinkedList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * A recipe, that can be unlocked. It was developed for research purposes.
 * @author Megacrafter127
 * @version 0.0.1
 */
public abstract class ResearchableRecipe implements IRecipe {
	/**
	 * A list of all entities, that have unlocked the recipe.
	 */
	private LinkedList<String> learnedBy=new LinkedList<String>();
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("size", learnedBy.size());
		int i=0;
		for(String s:learnedBy) {
			nbt.setString("name."+i, s);
			i++;
		}
	}
	public void readFromNBT(NBTTagCompound nbt) {
		LinkedList<String> replacement=new LinkedList<String>();
		int size=nbt.getInteger("size");
		for(int i=0;i<size;i++) {
			replacement.add(nbt.getString("name."+i));
		}
	}
	
	/**
	 * Test if a player has unlocked this recipe.
	 * @param player 	the player to test
	 * @return if the player has unlocked the recipe
	 */
	public boolean hasUnlocked(EntityPlayer player) {
		return learnedBy.contains(player.username);
	}
	/**
	 * Unlocks the recipe for the player.
	 * @param player 	the player, who unlocked the recipe
	 * @return true, if the recipe could be unlocked, false, if otherwise(double unlocking, etc.)
	 */
	public boolean unlock(EntityPlayer player) {
		if(!learnedBy.contains(player.username)) {
			learnedBy.add(player.username);
			return true;
		}
		return false;
	}
	
	/**
	 * If called, checks if a player, who has learned the recipe, is using it. If so, calls the matchesRecipe method to check if the recipe is legal.
	 */
	@Override
	public final boolean matches(InventoryCrafting inv,World w) {
		for(String name:learnedBy) {
			if(inv.isUseableByPlayer(w.getPlayerEntityByName(name))) return matchesRecipe(inv,w);
		}
		return false;
	}
	
	/**
	 * Tests if this recipe matches the given inventory(does not check, if the player has unlocked the recipe)
	 * @param inv
	 * @param w
	 * @return true, if matches, false, if not
	 */
	protected abstract boolean matchesRecipe(InventoryCrafting inv,World w);
}
