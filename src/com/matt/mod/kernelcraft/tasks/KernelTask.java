package com.matt.mod.kernelcraft.tasks;

import net.minecraft.nbt.NBTTagCompound;

import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;
/**
 * @author Megacrafter127
 *
 */
public abstract class KernelTask {
	public static KernelTask loadTaskFromNBT(NBTTagCompound nbt) {
		try{
			Class c=Class.forName(nbt.getString("type"));
			KernelTask instance=(KernelTask)c.newInstance();
			instance.readFromNBT(nbt);
			return instance;
		}
		catch(Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	
	protected int ticksPassed;
	protected int ticksLeft;
	protected int x;
	protected int y;
	protected int z;
	
	public KernelTask() {}
	public KernelTask(int ticksLeft,int x,int y,int z) {
		this.ticksLeft=ticksLeft;
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/**
	 * (Re-)Loads this task(from scratch).
	 * @author Megacrafter127
	 * @param nbt - the tag compound to read from
	 */
	public void readFromNBT(NBTTagCompound nbt) {
		if(!getClass().getName().equals(nbt.getString("type"))) System.err.println("type mismatch: tasktype: "+getClass().getName()+" read-type: "+nbt.getString("type"));
		ticksLeft=nbt.getInteger("ticksLeft");
		ticksPassed=nbt.getInteger("ticksPassed");
		x=nbt.getInteger("x");
		y=nbt.getInteger("y");
		z=nbt.getInteger("z");
	}
	
	/**
	 * Stores all information required to completely rebuild this task.
	 * @author Megacrafter127
	 * @param nbt - the tag compound to write to
	 */
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setString("type", getClass().getName());
		nbt.setInteger("ticksLeft", ticksLeft);
		nbt.setInteger("x", x);
		nbt.setInteger("y", y);
		nbt.setInteger("z", z);
	}
	/**
	 * @author Megacrafter127
	 * @return true, if the task is finished, false, if not.
	 */
	public boolean finished() {
		return ticksLeft==0;
	}
	
	public final void run(TileEntityKernelCore executor) {
		if(!finished()) {
			runTaskTick(executor);
			ticksPassed++;
			ticksLeft--;
		}
	}
	
	/**
	 * @author Megacrafter127
	 * Runs a single tick of the task(no task should have only one tick).
	 * If {@link finished()} returns true, this method will not be invoked anymore.
	 */
	public abstract void runTaskTick(TileEntityKernelCore executor);
}
