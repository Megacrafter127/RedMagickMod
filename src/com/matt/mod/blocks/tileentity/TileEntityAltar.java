package com.matt.mod.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

import com.matt.generic.helpers.IFutureCraft;
import com.matt.mod.ModHelper;

public class TileEntityAltar extends TileEntity implements IFutureCraft {

	
	public boolean run(EntityPlayer p, World w, int x, int y, int z) {
		int idZP = w.getBlockId(x, y, z+1);
		int idZM = w.getBlockId(x, y, z-1);
		int idYP = w.getBlockId(x,y+1,z);
		int idYM = w.getBlockId(x,y-1,z);
		int idXP = w.getBlockId(x+1,y,z);
		int idXM = w.getBlockId(x-1,y,z);
		boolean hasChest = false;
		boolean hasCore = false;
		//Define hasChest
		if(idZP == Block.chest.blockID) {
			hasChest = true;
		}else if(idZM == Block.chest.blockID) {
			hasChest = true;
		}
		if(idYP == Block.enchantmentTable.blockID) {
			hasCore = true;
		}else if(idZM == Block.chest.blockID) {
			hasCore = true;
		}
		if(hasChest && hasCore) {
			//We've got a set-up
			if(w.getBlockTileEntity(x, y, z+1) instanceof TileEntityChest) {
				
			}else if(w.getBlockTileEntity(x, y, z-1) instanceof TileEntityChest) {
				//We've got a non-corrupted chest!
				TileEntityChest chest = (TileEntityChest) w.getBlockTileEntity(x, y, z-1);
				if(chest.getStackInSlot(1).itemID == Item.pickaxeDiamond.itemID) {
					if(chest.getStackInSlot(2).itemID == ModHelper.endh.itemID) {
						chest.getStackInSlot(1).addEnchantment(Enchantment.efficiency,1);
						return true;
					}
				}else if(chest.getStackInSlot(1).itemID == Item.axeDiamond.itemID) {
					if(chest.getStackInSlot(2).itemID == ModHelper.endh.itemID) {
						chest.getStackInSlot(1).addEnchantment(Enchantment.efficiency,1);
						return true;
					}
				}else if(chest.getStackInSlot(1).itemID == Item.shovelDiamond.itemID) {
					if(chest.getStackInSlot(2).itemID == ModHelper.endh.itemID) {
						chest.getStackInSlot(1).addEnchantment(Enchantment.efficiency,1);
						return true;
					}
				}else if(chest.getStackInSlot(1).itemID == Item.swordDiamond.itemID) {
					if(chest.getStackInSlot(2).itemID == ModHelper.endh.itemID) {
						chest.getStackInSlot(1).addEnchantment(Enchantment.efficiency,1);
						return true;
					}
				
				
			}
		}
		return hasChest == hasCore;
	}
		return false; }
}


	
	
	

