package com.futurecraft.mod.magick.alchemy;

import net.minecraft.item.ItemStack;

public interface IManaContainer {
	/**
	 * @author Megacrafter127
	 * @param stack - the stack of the item
	 * @return the amount of different manatypes, that can be stored in this device
	 */
	public int getManaTypeCount(ItemStack stack);
	
	/**
	 * @author Megacrafter127
	 * @param stack - the stack of the item
	 * @param type - the type-index of the mana(between 0 and getManaTypeCount(stack)-1)
	 * @return the amount of mana, of this type, currently stored in this manacontainer
	 */
	public int getMana(ItemStack stack,int type);
	
	/**
	 * @author Megacrafter127
	 * @param stack - the stack of the item
	 * @param type - the type-index of the mana(between 0 and getManaTypeCount(stack)-1)
	 * @param amount - the amount of mana to be used
	 * @return the amount of mana, that actually was used
	 */
	public int useMana(ItemStack stack,int type,int amount);
}
