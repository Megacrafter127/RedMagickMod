package com.futurecraft.magick.alchemy;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.items.INBTItem;
import com.futurecraft.mod.magick.lib.MagickLib;

public class AlchemicalStone extends Item implements  INBTItem {
	public AlchemicalStone() {
		super(MagickLib.getIdFor("Alchemical Stone",5000));
	}

	@Override
	public void writeToNbt(ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromNbt(ItemStack stack) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
		if(entityPlayer.inventory.hasItem(MagickHelper.manaDust.itemID)) {
			entityPlayer.inventory.consumeInventoryItem(MagickHelper.manaDust.itemID);
			if(world.getBlockId(x,y,z) == Block.grass.blockID) {
				world.setBlock(x,y,z,Block.dirt.blockID);

			}else if(world.getBlockId(x,y,z) == Block.dirt.blockID) {
				world.setBlock(x,y,z,Block.grass.blockID);
			}
		}
		return true;
	}
	
	
}
