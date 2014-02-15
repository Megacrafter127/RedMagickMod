package com.matt.mod.swag.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.swag.SwagHelper;
import com.matt.mod.swag.items.ItemFlyingCatalist;
import com.matt.mod.swag.items.logic.FlyingCatalistLogic;
import com.matt.mod.swag.items.logic.ItemLogic;

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
		if(p.inventory.getCurrentItem().itemID == SwagHelper.swaggishFlyer.itemID) {
			FlyingCatalistLogic logic = (FlyingCatalistLogic)ItemFlyingCatalist.getLogic();
			if(manalevel <= 10) {
				manalevel = manalevel - 10;
					logic.setMana(10);
			}
		}
		}else {
			if(p.inventory.getCurrentItem().itemID == SwagHelper.swaggishFlyer.itemID) {
				ItemFlyingCatalist f = (ItemFlyingCatalist)p.inventory.getCurrentItem().getItem();
				ItemLogic logic = f.getLogic();
				deposite(logic);
			}
		}
	}

}
