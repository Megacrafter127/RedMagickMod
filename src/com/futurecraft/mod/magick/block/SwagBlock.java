package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;
import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.lib.IWandAble;

public class SwagBlock extends Block implements IWandAble {

	public SwagBlock(int id, String str) {
		super(id, Material.sand);
		setTextureName(Ref.NAME.toLowerCase() + ":" + str);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
		try {
		if(!world.isRemote) {
			if(!player.isSneaking()) {
		System.out.println("Activated SwagBlock!");
		if(player.inventory.getCurrentItem().itemID ==MagickHelper.magickWand.itemID && player.inventory.getCurrentItem().getItemDamage() == 0) {
			onWandRightClick(player,world,x,y,z);
			return true;
		} else if(player.inventory.getCurrentItem().itemID ==MagickHelper.magickWand.itemID && player.inventory.getCurrentItem().getItemDamage() == 1 ) {
			onWandRightClick(player,world,x,y,z);
			return true;
		} else if(player.inventory.getCurrentItem().itemID ==MagickHelper.magickWand.itemID && player.inventory.getCurrentItem().getItemDamage() == 2 ){
			onWandRightClick(player,world,x,y,z);
			return true;
		} 
			} else {
				System.out.println("Activated SwagBlock! - Sneak!");
				/*if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID) {
					onWandSneakRightClick(player,world,x,y,z);
					return true;
				} else if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID) {
					onWandSneakRightClick(player,world,x,y,z);
					return true;
				} else if(player.inventory.getCurrentItem().itemID ==SwagHelper.swaggishWandT3.itemID){
					onWandSneakRightClick(player,world,x,y,z);
					return true;
				} */
			}
		} 
		}catch(NullPointerException e) {
			System.out.println("[Futurecraft][ERRORHANDLER42] " + e.getStackTrace());
		}
		
		return false;	 
	}
	
	@Override
	/** Sets this block to air,
	 *  Removes 10 xp,
	 * 	Adds a stack of this to inventory.
	 * @param p
	 * @param w
	 * @param x
	 * @param y
	 * @param z
	 */
	public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z) {
		System.out.println("Debug!");
		w.setBlockToAir(x, y, z);
			p.inventory.addItemStackToInventory(new ItemStack(this));
	}
	public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y, int z) {
		
	}
	

}
