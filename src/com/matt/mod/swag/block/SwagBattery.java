package com.matt.mod.swag.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.swag.SwagHelper;
import com.matt.mod.swag.block.tile.TileEntityWandRecharger;
import com.matt.mod.swag.items.ItemFlyingCatalist;
import com.matt.mod.swag.items.logic.ItemLogic;
import com.matt.mod.swag.lib.IWandAble;

public class SwagBattery extends SwagBlock implements IWandAble, ITileEntityProvider {

	public SwagBattery(int id, String str) {
		super(id, str);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
				
				if(!world.isRemote) {
					if(!player.isSneaking()) {
				System.out.println("Activated SwagBlock!");
				if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID) {
					onWandRightClick(player,world,x,y,z);
					return true;
				} else if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID) {
					onWandRightClick(player,world,x,y,z);
					return true;
				} else if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID){
					onWandRightClick(player,world,x,y,z);
					return true;
				} 
					}
				}
				if(player.inventory.getCurrentItem().itemID == SwagHelper.swaggishFlyer.itemID) {
					ItemFlyingCatalist f = (ItemFlyingCatalist)player.inventory.getCurrentItem().getItem();
					ItemLogic logic = f.getLogic();
					TileEntityWandRecharger r = (TileEntityWandRecharger)world.getBlockTileEntity(x, y, z);
					r.run(player,world,x,y,z);
				}
				return false;
		
	}

	@Override
	public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z) {
		
	}
	@Override
	public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y, int z) {
		
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWandRecharger();
	}
	
}
