package com.matt.mod.kernelcraft.tileentities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityKernelCoordMemory extends TileEntity {
	
	private int storedX,storedY,storedZ;
	private boolean valid=false;
	
	public void setCoords(int[] coords) {
		if(coords==null || coords.length!=3) {
			valid=false;
		}
		else {
			valid=true;
			storedX=coords[0];
			storedY=coords[1];
			storedZ=coords[2];
		}
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("valid", valid);
		if(valid) {
			nbt.setInteger("storedX", storedX);
			nbt.setInteger("storedY", storedY);
			nbt.setInteger("storedZ", storedZ);
		}
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		valid=nbt.getBoolean("valid");
		if(valid) {
			storedX=nbt.getInteger("storedX");
			storedY=nbt.getInteger("storedY");
			storedZ=nbt.getInteger("storedZ");
		}
	}
}
