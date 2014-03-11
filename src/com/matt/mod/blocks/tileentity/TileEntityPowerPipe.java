package com.matt.mod.blocks.tileentity;

import com.matt.mod.power.IPowerProvider;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityPowerPipe extends TileEntity  {

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
			e.currentPower = e.currentPower + powerToProvide;
		}
		
	}
	
	public void receive(World w, int x, int y, int z) {
		// TODO Auto-generated method stub
		
	}

}

