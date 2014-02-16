package com.matt.mod.kernelcraft.tileentities;

import com.matt.mod.kernelcraft.KernelCraftCore;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityKernelCPU extends TileEntity {
	protected int level;
	
	public void update(World w) {
		level=1;
		while(w.getBlockId(xCoord, yCoord+level, zCoord)==KernelCraftCore.OverclockerID) {
			level++;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("level", level);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		level=nbt.getInteger("level");
	}
	@Override
	public boolean canUpdate() {
		return true;
	}
	
	public int getSpeed() {
		return (int)Math.round(1000*Math.pow(1.1, 1-level));
	}
	
	public int getPowerConspumption() {
		return 10*level;
	}
}