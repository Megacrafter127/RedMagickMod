package com.matt.mod.blocks.tileentity;

import com.matt.mod.power.Powerable;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityPowerPipe extends TileEntity implements Powerable {
	private int storedPower=0;
	public static int maxPower=70;
	static int powerToProvide = 10;
	public static void run(TileEntity caster) {
		if(caster instanceof TileEntitySmelter) {
			transmit((TileEntitySmelter)caster);
		}
	}
	public static void transmit(TileEntitySmelter tileEntitySmelter) {
		provide(tileEntitySmelter.getWorldObj(),tileEntitySmelter.xCoord,tileEntitySmelter.yCoord,tileEntitySmelter.zCoord);
	}

	public static void provide(World w, int x, int y, int z) {
		if(w.getBlockTileEntity(x, y, z) instanceof TileEntitySmelter ) {
			TileEntitySmelter e = (TileEntitySmelter)w.getBlockTileEntity(x, y, z);
			e.addPower(powerToProvide);
		}
		
	}
	
	public void receive(World w, int x, int y, int z) {
		// TODO Auto-generated method stub
		
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
	
	public void transmit(World w,int x,int y,int z,int x2,int y2,int z2) {
		TileEntity t1=w.getBlockTileEntity(x, y, z);
		TileEntity t2=w.getBlockTileEntity(x2, y2, z2);
		if(t1 instanceof TileEntityPowerPipe&&t2 instanceof Powerable) {
			TileEntityPowerPipe p1=(TileEntityPowerPipe)t1;
			Powerable p2=(Powerable)t2;
			int power=p1.removePower(powerToProvide);
			power=p2.addPower(power);
			power=p1.addPower(power);
			if(power>0) {
				System.out.println("Lost "+power+" power units.");
			}
		}
	}
}

