package com.futurecraft.mod.magick.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;

import com.futurecraft.mod.magick.itemblocks.ItemBlockProtectedStone;
/**
 * The protected block's tile entity.
 * @author Matheus
 *
 */
public class TileEntityProtected extends TileEntity {
	public static String owner;
	public TileEntityProtected() {
		
	}
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
