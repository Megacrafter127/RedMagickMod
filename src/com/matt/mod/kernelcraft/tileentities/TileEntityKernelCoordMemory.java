package com.matt.mod.kernelcraft.tileentities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityKernelCoordMemory extends TileEntity {
	public static final HashMap<Integer,int[]> coords=new HashMap<Integer,int[]>();
	private static int id=-1;
	public static int getNextID() {
		return id++;
	}
	protected static void writeHashToNBT(NBTTagCompound nbt) {
		int size=coords.size();
		Iterator<Integer> keys=coords.keySet().iterator();
		nbt.setInteger("size", size);
		for(int i=0;i<size;i++) {
			Integer key=keys.next();
			nbt.setInteger("key."+i, key);
			nbt.setIntArray("val."+i, coords.get(key));
		}
		nbt.setInteger("hashID", id);
	}
	protected static void readHashFromNBT(NBTTagCompound nbt) {
		Set<Integer> keys=((HashMap<Integer,int[]>)coords.clone()).keySet();
		int size=nbt.getInteger("size");
		for(int i=0;i<size;i++) {
			int key=nbt.getInteger("key."+i);
			keys.remove(key);
			coords.put(key, nbt.getIntArray("val."+i));
		}
		Iterator<Integer> i=keys.iterator();
		while(i.hasNext()) {
			coords.remove(i.next());
		}
		id=nbt.getInteger("hashID");
	}
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
		NBTTagCompound hashNBT=new NBTTagCompound();
		writeHashToNBT(hashNBT);
		nbt.setCompoundTag("hash", hashNBT);
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
		readHashFromNBT(nbt.getCompoundTag("hash"));
	}
}
