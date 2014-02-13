package com.matt.mod.power;

import net.minecraft.world.World;

public interface Powerable {
	public void transmit(World w,int ownX,int ownY,int ownZ,int otherX,int otherY,int otherZ);
	public int removePower(int amount);
	public int addPower(int amount);
}
