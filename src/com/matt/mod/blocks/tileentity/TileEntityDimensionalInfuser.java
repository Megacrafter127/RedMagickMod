package com.matt.mod.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.lib.Ref;
import com.matt.mod.ModItems;

public class TileEntityDimensionalInfuser extends TileEntity {
	public void run(World w, EntityPlayer p, int x, int y, int z) {
		if(p.inventory.hasItem(Item.ingotIron.itemID)) {
		switch(w.provider.dimensionId) {
		case -1:
			System.out.println("DIMENSIONAL INFUSER : NETHER");
			p.inventory.consumeInventoryItem(Item.ingotIron.itemID);
			p.inventory.addItemStackToInventory(new ItemStack(ModItems.neth));
			this.getBlockType().setTextureName(Ref.NAME.toLowerCase() + ":diminfuserneth");
			break;
		case 0:
			p.addChatMessage("You can't dimensional-infuse iron in the overworld! You would get iron back!");
		case 1:
			System.out.println("DIMENSIONAL INFUSER : THE END");
			p.inventory.consumeInventoryItem(Item.ingotIron.itemID);
			p.inventory.addItemStackToInventory(new ItemStack(ModItems.endh));
			
			this.getBlockType().setTextureName(Ref.NAME.toLowerCase() + ":diminfuserend");
			break;
		} 
		
		}
		
	}
}
