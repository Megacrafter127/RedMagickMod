package com.matt.mod.kernelcraft.tasks;

import net.minecraft.nbt.NBTTagCompound;

import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class KernelMiningTask extends KernelTask {
	private int ticksPerBlock;
	private int x2,y2,z2,ax,ay,az;
	private boolean finished=false;
	private boolean first=true;

	public KernelMiningTask() {}
	public KernelMiningTask(int x,int y,int z,int x2,int y2,int z2,int ticksPerBlock) {
		super(Math.abs(ticksPerBlock*(x2-x)*(y2-y)*(z2-z)),x>x2?x2:x,y>y2?y2:y,z>z2?z2:z);
		this.x2=x>x2?x:x2;
		this.y2=y>y2?y:y2;
		this.z2=z>z2?z:z2;
		ax=this.x;
		ay=this.y;
		az=this.z;
		this.ticksPerBlock=ticksPerBlock;
	}

	@Override
	public void runTaskTick(TileEntityKernelCore executor) {
		if(executor.getWorldObj().isRemote) return;
		if(finished) {
			System.out.println("IllegalCall");
			return;
		}
		if(ticksPerBlock<=0) ticksPerBlock=1;
		if(super.ticksPassed%(ticksPerBlock*10)==0) {
			if(first) {
				executor.addBlockAffectEffect(ax, ay, az, ticksPerBlock);
				first=false;
				return;
			}
			executor.destroyBlock(ax, ay, az);
			do{
				increment();
			} while(executor.getWorldObj().getBlockId(ax, ay, az)==0&&ay<=y2);
			if(ay>y2) {
				finished=true;
				System.out.println("Task finished");
				return;
			}
			executor.addBlockAffectEffect(ax, ay, az, ticksPerBlock);
		}
	}
	
	@Override
	public boolean finished() {
		return finished;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		ticksPerBlock=nbt.getInteger("ticksPerBlock");
		x2=nbt.getInteger("x2");
		y2=nbt.getInteger("y2");
		z2=nbt.getInteger("z2");
		ax=nbt.getInteger("ax");
		ay=nbt.getInteger("ay");
		az=nbt.getInteger("az");
		finished=nbt.getBoolean("finished");
		first=nbt.getBoolean("first");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("ticksPerBlock", ticksPerBlock);
		nbt.setInteger("x2", x2);
		nbt.setInteger("y2", y2);
		nbt.setInteger("z2", z2);
		nbt.setInteger("ax", ax);
		nbt.setInteger("ay", ay);
		nbt.setInteger("az", az);
		nbt.setBoolean("finished", finished);
		nbt.setBoolean("first", first);
	}
	
	private void increment() {
		ax++;
		if(ax>x2) {
			ax=x;
			az++;
		}
		
		if(az>z2) {
			az=z;
			ay++;
		}
	}
}
