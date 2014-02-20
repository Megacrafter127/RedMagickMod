package com.matt.mod.kernelcraft.tileentities;

import com.matt.mod.kernelcraft.KernelCraftCore;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityKernelStorage extends TileEntity {
	protected int level;
	//TODO add a real use for this here
	
	
	public void update(World w) {
		try{
			level=1;
			while(w.getBlockId(xCoord, yCoord+level, zCoord)==KernelCraftCore.IOExpander.blockID) {
				level++;
			}
		}
		catch(NullPointerException ex) {}
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
		return false;
	}
	
	public int getStorageCapacity() {
		return 512+128*level;
	}
}
