package com.matt.mod.blocks.tileentity;

import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.item.ItemStack;
import com.matt.mod.ModHelper;

public class DimensionalBeaconTileEntity extends TileEntityBeacon {
	private int[] permittedIDs=new int[]{ModHelper.endh.itemID,ModHelper.neth.itemID};
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
}
