package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;


public class TileEntityKernelModule extends TileEntity {
	static{
		TileEntity.addMapping(TileEntityKernelModule.class, "TileEntityKernelModule");
	}
	protected int distance=3;
	protected TileEntityKernelStorage storage;
	protected TileEntityKernelUSV power;
	protected TileEntityKernelIOFace range;
	protected TileEntityKernelCPU speed;
	private boolean update;

	public TileEntityKernelModule(World w) {
		update(w);
	}
	
	public void update(World w) {
		update=true;
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
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("distance", distance);
		nbt.setBoolean("update", update);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		distance=nbt.getInteger("distance");
		if(nbt.getBoolean("update")) {
			update(getWorldObj());
			update=false;
		}
	}
}
