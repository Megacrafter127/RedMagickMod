package com.matt.mod.magick.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.magick.MagickHelper;
import com.matt.mod.magick.items.ItemFlyingCatalist;
import com.matt.mod.magick.items.logic.FlyingCatalistLogic;
import com.matt.mod.magick.items.logic.ItemLogic;

public class TileEntityWandRecharger extends TileEntity {

	public static int manalevel;
	public static void deposite(ItemLogic l) {
		if(manalevel <= 10) {
			manalevel = manalevel - 10;
				l.setManaLevel(manalevel -10);
		}
	}
	public void run(EntityPlayer p, World w, int x, int y, int z) {
		if(!p.isSneaking()) {
		if(p.inventory.getCurrentItem().itemID == MagickHelper.swaggishFlyer.itemID) {
			FlyingCatalistLogic logic = (FlyingCatalistLogic)ItemFlyingCatalist.getLogic();
			if(manalevel <= 10) {
				manalevel = manalevel - 10;
					logic.setMana(10);
			}
		}
		}else {
			if(p.inventory.getCurrentItem().itemID == MagickHelper.swaggishFlyer.itemID) {
				ItemFlyingCatalist f = (ItemFlyingCatalist)p.inventory.getCurrentItem().getItem();
				ItemLogic logic = f.getLogic();
				deposite(logic);
			}
		}
	}
	@Override
	 public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    { 
		manalevel = par1NBTTagCompound.getInteger("manaLevel");
    }
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    { 
		par1NBTTagCompound.setInteger("manaLevel", manalevel);
    }

}
