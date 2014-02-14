package com.matt.mod.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import com.matt.mod.ModHelper;

public class DimensionalBeaconTileEntity extends TileEntityBeacon {
	static {
		TileEntity.addMapping(TileEntityDimensionalInfuser.class,"TileEntityDimensionalInfuser");
	}
	public static final int[] permittedIDs=new int[]{ModHelper.endh.itemID,ModHelper.neth.itemID};
	@Override
	public boolean isItemValidForSlot(int slot,ItemStack item) {
		if(slot!=0) return false;
		if(super.isItemValidForSlot(slot, item)) return true;
		int id=item.itemID;
		for(int i:permittedIDs) {
			if(id==i) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}
}
