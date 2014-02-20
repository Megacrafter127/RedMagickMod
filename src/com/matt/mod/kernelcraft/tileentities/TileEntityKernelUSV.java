package com.matt.mod.kernelcraft.tileentities;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.power.Powerable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityKernelUSV extends TileEntity implements Powerable {
	protected int level;
	protected int currentPower;
	
	
	public void update(World w) {
		try{
			level=1;
			while(w.getBlockId(xCoord, yCoord+level, zCoord)==KernelCraftCore.Battery.blockID) {
				level++;
			}
		}
		catch(NullPointerException ex) {}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("level", level);
		nbt.setInteger("currentPower", currentPower);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		level=nbt.getInteger("level");
		currentPower=nbt.getInteger("currentPower");
	}
	@Override
	public boolean canUpdate() {
		return false;
	}
	
	public int getStorageCapacity() {
		return 50+10*level;
	}
	
	@Override
	public int addPower(int amount) {
		currentPower+=amount;
		int overflow=currentPower-getStorageCapacity();
		if(overflow>0) {
			currentPower-=overflow;
			return overflow;
		}
		return 0;
	}
	
	@Override
	public int removePower(int amount) {
		if(currentPower==0) {
			return 0;
		}
		currentPower-=amount;
		if(currentPower<0) {
			amount+=currentPower;
			currentPower=0;
			return amount;
		}
		return amount;
	}
	
	@Override
	public void transmit(World w,int x,int y,int z) {
		System.out.println("A USV only emitts power to the kernel, not other devices");
	}
}