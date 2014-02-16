package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;


public class TileEntityKernelModule extends TileEntity {
	protected int distance=2;
	protected TileEntityKernelStorage storage;
	protected TileEntityKernelUSV power;
	protected TileEntityKernelIOFace range;
	protected TileEntityKernelCPU speed;
	protected boolean active=false;
	protected long tick=0;
	protected long tickRate=5;

	
	public void update(World w) {
		if(w.isRemote) {
			return;
		}
		storage=null;
		power=null;
		range=null;
		speed=null;
		for(int i=0;i<4;i++) {
			TileEntity t=w.getBlockTileEntity(i%2==0?xCoord+distance:xCoord-distance, yCoord, i/2==0?zCoord+distance:zCoord-distance);
			if(t!=null) {
				if(t instanceof TileEntityKernelStorage) {
					storage=(TileEntityKernelStorage)t;
				}
				if(t instanceof TileEntityKernelUSV) {
					power=(TileEntityKernelUSV)t;
				}
				if(t instanceof TileEntityKernelIOFace) {
					range=(TileEntityKernelIOFace)t;
				}
				else if(t instanceof TileEntityKernelCPU) {
					speed=(TileEntityKernelCPU)t;
				}
			}
		}
		active=storage!=null&&power!=null&&range!=null&&speed!=null;
		if(active) {
			System.out.println("active kernel");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("distance", distance);
		}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		distance=nbt.getInteger("distance");
	}
	@Override
	public void updateEntity() {
		tick++;
		if(tick>tickRate) {
			tick=0;
			update(getWorldObj());
		}
	}
	public boolean isActive() {
		return active;
	}
	
	@Override
	public boolean canUpdate() {
		return true;
	}
}
