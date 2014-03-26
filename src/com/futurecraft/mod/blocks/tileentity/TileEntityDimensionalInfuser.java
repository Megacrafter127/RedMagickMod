package com.futurecraft.mod.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

import com.futurecraft.mod.ModHelper;

public class TileEntityDimensionalInfuser extends TileEntity {
	static {
		TileEntity.addMapping(TileEntityDimensionalInfuser.class,"TileEntityDimensionalInfuser");
	}
	public void run(World w, EntityPlayer p) {
		if(p.inventory.getCurrentItem()==null) return;
		if(p.inventory.getCurrentItem().getItem()==null) return;
		if(p.inventory.getCurrentItem().getItem().itemID==Item.ingotIron.itemID) {
			int i;
			switch(w.provider.dimensionId) {
				case -1:	System.out.println("DIMENSIONAL INFUSER : NETHER");
					i=p.inventory.getCurrentItem().stackSize;
					p.inventory.getCurrentItem().splitStack(i);
					p.inventory.addItemStackToInventory(new ItemStack(ModHelper.neth,i));
					return;
				case 0:
					p.addChatMessage("You can't dimensional-infuse iron in the overworld! You would get iron back!");
					return;
				case 1:
					System.out.println("DIMENSIONAL INFUSER : THE END");
					i=p.inventory.getCurrentItem().stackSize;
					p.inventory.getCurrentItem().splitStack(i);
					p.inventory.addItemStackToInventory(new ItemStack(ModHelper.endh,i));
					return;
			}
		}
	}
}
