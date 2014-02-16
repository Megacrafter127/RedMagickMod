package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.item.ItemStack;



public interface KernelOptionalModule {
	/**
	 * Called when the kernel accepted this module
	 * @param kernel 	The kernel this module was assigned to
	 */
	public void onAssignedToKernel(TileEntityKernelModule kernel);
	
	/**
	 * Called whenever the kernel emits an item
	 * @param output 	the item
	 * @return if not all items in the stack could be dealt with, the remaining items, null if all items were parsed.
	 */
	public ItemStack onItemOutput(ItemStack output);
	
	/**
	 * Called whenever the kernel requires an item and removes the required items from this module.
	 * @param input 	the item the kernel requires
	 * @return the itemstack this module can provide, null if it cannot provide a stack of the given item
	 */
	public ItemStack onItemInput(ItemStack input);
	
	/**
	 * Tests if this module can provide an item.
	 * @param item 	the item to provide
	 * @return the amount of items of the given type, this module cannot provide
	 */
	public int canProvideItem(ItemStack item);
	
	/**
	 * Called whenever the kernel has to print a line of text.
	 * @param s 	the text
	 */
	public void onStringOutput(String s);
	
	/**
	 * Tests, if this module can provide the kernel with coordinates.
	 * @return true if it can provide coordinates, false if not
	 */
	public boolean canProvideCoords();
	
	/**
	 * Returns the provided coordinates.
	 * @return the provided coordinates ([0]=x;[1]=y;[2]=z); null if there are no coordinates to provide
	 */
	public int[] getProvidedCoords();
	
	/**
	 * Returns the amount of power this module has used since the last call of this method.
	 * This method is called every tick of the kernel.
	 * @return the amount of used power(negative if this module generated power)
	 */
	public int powerUsed();
	
	/**
	 * Called, when the kernel is destroyed, while this module is assigned to it.
	 * @Note onUnassignedFromKernel(TileEntityKernelModule) is also called after this method is called.
	 * @param kernel 	the destroyed kernel
	 */
	public void onKernelDestroyed(TileEntityKernelModule kernel);
	
	/**
	 * Called, when this module is unassigned from the given kernel.
	 * @param kernel 	the kernel this module was unassigned from
	 */
	public void onUnassignedFromKernel(TileEntityKernelModule kernel);
}
