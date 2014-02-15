package com.matt.mod.swag.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.lib.Ref;
import com.matt.mod.swag.SwagHelper;
import com.matt.mod.swag.lib.IWandAble;

public class SwagBlock extends Block implements IWandAble {

	public SwagBlock(int id, String str) {
		super(id, Material.sand);
		setTextureName(Ref.NAME.toLowerCase() + ":" + str);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
		if(!player.isSneaking()) {
		if(player.inventory.currentItem == SwagHelper.swaggishWand.itemID) {
			onWandRightClick(player,world,x,y,z);
			return true;
		} else if(player.inventory.currentItem == SwagHelper.swaggishWandT2.itemID) {
			onWandRightClick(player,world,x,y,z);
			return true;
		} else if(player.inventory.currentItem == SwagHelper.swaggishWandT3.itemID){
			onWandRightClick(player,world,x,y,z);
			return true;
		}
		}else {
			if(player.inventory.currentItem == SwagHelper.swaggishWand.itemID){
				onWandSneakRightClick(player,world,x,y,z);
				return true;
			}else if(player.inventory.currentItem == SwagHelper.swaggishWandT2.itemID){
				onWandSneakRightClick(player,world,x,y,z);
				return true;
			}else if(player.inventory.currentItem == SwagHelper.swaggishWandT3.itemID){
				onWandSneakRightClick(player,world,x,y,z);
				return true;
			}

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
		w.setBlockToAir(x, y, z);
			p.inventory.addItemStackToInventory(new ItemStack(this));
	}
	public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y, int z) {
		
	}

}
