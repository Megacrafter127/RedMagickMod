package com.matt.mod.blocks.tileentity;

import com.matt.FutureCraft;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TileEntityGOL extends TileEntity {
	private static class Switcher extends Thread {
		public void run() {
			while(true) {
				try{
					Thread.sleep(timeBetweenFrames);
				}
				catch(InterruptedException ex) {}
				change=!change;
			}
		}
	}
	static {
		TileEntity.addMapping(TileEntityGOL.class,"TileEntityGOL");
		new Switcher().start();
	}
	private boolean alive;
	private boolean next;
	private boolean lastChange=true;
	private static boolean change=false;
	public static final long timeBetweenFrames=500;
	public static final int minPop=2;
	public static final int switchPop=6;
	public static final int maxPop=8;
	

	public TileEntityGOL(boolean alive) {
		this.alive=alive;
	}
	public TileEntityGOL() {
		this(false);
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("cellalive", alive);
		nbt.setBoolean("futurecellalive", next);
	}
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		alive=nbt.getBoolean("cellalive");
		next=nbt.getBoolean("futurecellalive");
	}
	
	public void run(World w) {
		lastChange=change;
		if(change) {
			alive=next;
		}
		else {
			int count=0;
			for(int i=-1;i<2;i++) {
				for(int j=-1;j<2;j++) {
					for(int k=-1;k<2;k++) {
						try{
							if(((TileEntityGOL)w.getBlockTileEntity(xCoord+i, yCoord+j, zCoord+k)).alive) count++;
						}
						catch(ClassCastException ex) {}
						catch(NullPointerException ex) {}
					}
				}
			}
			if(alive) {
				count--;
			}
			if(count<minPop) {
				next=false;
			}
			else if(count<switchPop) {
				next=true;
			}
			else if(count>maxPop) {
				next=false;
			}
			w.setBlock(xCoord, yCoord, zCoord, FutureCraft.blockGOLID);
			validate();
			w.setBlockTileEntity(xCoord, yCoord, zCoord, this);
			validate();
		}
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void switchAlive() {
		alive=!alive;
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		run(getWorldObj());
	}
	
	@Override
	public boolean canUpdate() {
		return lastChange!=change;
	}
}
