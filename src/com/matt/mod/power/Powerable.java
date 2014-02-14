package com.matt.mod.power;

import net.minecraft.world.World;

public interface Powerable {
	
	/**
	 * Transmits power from this powerable to the block in w at x, y, z.
	 * @param w		the world, that contains the block to transmit power to.
	 * @param x		the x coordinate of the block to transmit power to.
	 * @param y		the y coordinate of the block to transmit power to.
	 * @param z		the z coordinate of the block to transmit power to.
	 */
	public void transmit(World w,int x,int y,int z);
	
	/**
	 * Removes power from this powerable.
	 * @param amount	the amount of power to remove from this block
	 * @return the actual amount of removed power(if not enough power was stored)
	 */
	public int removePower(int amount);
	
	/**
	 * Adds power to this powerable.
	 * @param amount	the amount of power to add to this block
	 * @return the power overflow, if not all power could be stored/processed
	 */
	public int addPower(int amount);
}
