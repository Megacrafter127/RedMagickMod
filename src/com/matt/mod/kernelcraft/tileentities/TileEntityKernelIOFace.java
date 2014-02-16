package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import com.matt.mod.kernelcraft.KernelCraftCore;

public class TileEntityKernelIOFace extends TileEntity {
	protected int level;
	
	
	public void update(World w) {
		level=0;
		for(int i=1;w.getBlockId(xCoord, yCoord+i, zCoord)==KernelCraftCore.IOExpanderID;i++,level++) {}
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
