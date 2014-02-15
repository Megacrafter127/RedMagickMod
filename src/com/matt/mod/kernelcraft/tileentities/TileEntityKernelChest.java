package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityKernelChest extends TileEntityChest  {
	static{
		TileEntity.addMapping(TileEntityKernelChest.class, "TileEntityKernel");
	}
	
}
