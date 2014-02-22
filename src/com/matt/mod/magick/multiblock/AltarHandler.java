package com.matt.mod.magick.multiblock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AltarHandler {
public static void handleAltar(EntityPlayer p, World w, int x,int y, int z) {
	if(w.getBlockTileEntity(x,y,z) instanceof TileEntityAltar) {
		if(w.isRemote) {
			return;
		}
		
	}
}
}
