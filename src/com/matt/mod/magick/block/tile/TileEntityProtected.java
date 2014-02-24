package com.matt.mod.magick.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.matt.mod.magick.itemblocks.ItemBlockProtectedStone;

public class TileEntityProtected extends TileEntity {
	public static String owner;
	
	@Override
	public void writeToNBT(NBTTagCompound c) {
		super.writeToNBT(c);
		c.setString("owner",owner);
	}
	@Override
	public void readFromNBT(NBTTagCompound c) {
		super.readFromNBT(c);
		owner = c.getString("owner");
	}
}
