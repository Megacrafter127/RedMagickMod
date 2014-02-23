package com.matt.mod.kernelcraft.tasks;

import net.minecraft.nbt.NBTTagCompound;

import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class KernelMiningTask extends KernelTask {
	private int ticksPerBlock;
	private int x2,y2,z2,ax,ay,az;
	private boolean finished=false;
	private boolean first=true;
	private boolean silk=false;
	private boolean forceSilk=false;

	public KernelMiningTask() {}
	public KernelMiningTask(int x,int y,int z,int x2,int y2,int z2,int ticksPerBlock, Boolean silk) {
		super(Math.abs(ticksPerBlock*(x2-x)*(y2-y)*(z2-z)),x,y,z);
	}

	@Override
	public void runTaskTick(TileEntityKernelCore executor) {
		if(ticksPerBlock<=0) ticksPerBlock=1;
		if(super.ticksPassed%ticksPerBlock==0) {
			if(first) {
				ax=x>x2?x2:x;
				ay=y>y2?y2:y;
				az=z>z2?z2:z;
				executor.addBlockAffectEffect(ax, ay, az, ticksPerBlock);
				return;
			}
			executor.destroyBlock(ax, ay, az, forceSilk?true:(silk?null:false));
			ax++;
			if(ax>x2&&x2>x) {
				ax=x;
				az++;
			}
			else if(ax>x) {
				ax=x2;
				az++;
			}
			if(az>z2&&z2>z) {
				az=z;
				ay++;
			}
			else if(az>z) {
				az=z2;
				ay++;
			}
			if(ay>y&&ay>y2) {
				finished=true;
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
		silk=nbt.getBoolean("silk");
		forceSilk=nbt.getBoolean("forceSilk");
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
		nbt.setBoolean("silk", silk);
		nbt.setBoolean("forceSilk", forceSilk);
	}
}
