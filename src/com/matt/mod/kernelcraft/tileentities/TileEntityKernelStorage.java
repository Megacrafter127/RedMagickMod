package com.matt.mod.kernelcraft.tileentities;

import com.matt.mod.kernelcraft.KernelCraftCore;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityKernelStorage extends TileEntity {
	protected int level;
	//TODO add a real use for this here
	
	public TileEntityKernelStorage(World w) {
		update(w);
	}
	
	public void update(World w) {
		level=1;
		while(w.getBlockId(xCoord, yCoord+level, zCoord)==KernelCraftCore.IOExpanderID) {
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
	
	public int getStorageCapacity() {
		return 512+128*level;
	}
}
