package com.matt.mod.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityColuumQuarry extends TileEntity {
	public static int height;
	public static int clickcount;
	public static int bedrockLayer = 5;
	public static void run(EntityPlayer p,World w,int x,int y,int z) {
		if(!p.isSneaking()) {
		height = w.getActualHeight();
		for(int i = bedrockLayer; i <= clickcount - height; i++) {
			ItemStack j = new ItemStack(0,1,0);
			j.itemID = w.getBlockId(x,y,z);
			j.stackSize = 0;
			p.inventory.addItemStackToInventory(j);
			w.setBlock(x, y, z, 2);
		}
			
		}else {
		clickcount++;
		System.out.println(clickcount);
		}
	}
	
		
		
	
}
