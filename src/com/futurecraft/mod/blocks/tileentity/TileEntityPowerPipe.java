package com.futurecraft.mod.blocks.tileentity;


import com.futurecraft.mod.power.Powerable;



import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityPowerPipe extends TileEntity implements Powerable {
	private int storedPower=0;
	public static int maxPower=70;
	static int powerToProvide = 10;
	static int powerToGenerate = 10;
	public void run(World w) {
		int overflow=addPower(powerToGenerate);
		int[] coords=new int[]{xCoord,yCoord,zCoord};
		for(int i=0;i<coords.length;i++) {
			coords[i]--;
			transmit(w,coords[0],coords[1],coords[2]);
			coords[i]+=2;
			transmit(w,coords[0],coords[1],coords[2]);
			coords[i]--;
		}
		addPower(overflow);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		storedPower=nbt.getInteger("storedPower");
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("storedPower", storedPower);
	}
	
	public int removePower(int amount) {
		storedPower-=amount;
		if(storedPower<0) {
			int i=storedPower;
			storedPower=0;
			return amount+i;
		}
		return amount;
	}
	
	public int addPower(int amount) {
		storedPower+=amount;
		if(storedPower>maxPower) {
			int overflow=maxPower-storedPower;
			storedPower=maxPower;
			return overflow;
		}
		return 0;
	}
	
	public void transmit(World w,int x,int y,int z) {
		TileEntity t=w.getBlockTileEntity(x, y, z);
		if(t instanceof Powerable) {
			Powerable p=(Powerable)t;
			int power=removePower(powerToProvide);
			power=p.addPower(power);
			power=addPower(power);
			if(power>0) {
				System.out.println("Lost "+power+" power units.");
			}
		}
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		run(getWorldObj());
	}
	@Override
	public boolean canUpdate() {
		return true;
	}
}

