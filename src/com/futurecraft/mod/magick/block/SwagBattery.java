package com.futurecraft.mod.magick.block;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.items.ItemMagickWand;
import com.futurecraft.mod.magick.lib.IWandAble;

public class SwagBattery extends SwagBlock implements IWandAble {

	public SwagBattery(int id, String str) {
		super(id, str);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
				
				if(!world.isRemote) {
					System.out.println("Entity walked on block!");
					if(player instanceof EntityPlayer) {
						
						if(player.inventory.getCurrentItem().itemID == MagickHelper.magickWand.itemID) {
							ItemMagickWand wand = (ItemMagickWand) player.inventory.getCurrentItem().getItem();
							if(wand.isInWandRecharger) {
								wand.isInWandRecharger = false;
									
								} else {
									wand.isInWandRecharger = true;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
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
	 public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
	}
}
