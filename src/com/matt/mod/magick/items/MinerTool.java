package com.matt.mod.magick.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MinerTool extends Item {

	public MinerTool(int par1) {
		super(par1);
	}
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	for(int i = x; i <= x+3; i++) {
    		for(int j = y; j <= y+3; i++) {
    			try {
    				world.setBlockToAir(i,j,z);
    			}catch(OutOfMemoryError e) {
    				e.printStackTrace();
    			}
    		
    		}
    	}
        return false;
    }
}
