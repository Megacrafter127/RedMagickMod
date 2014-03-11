package com.futurecraft.mod.magick.infusion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileInfuser extends TileEntity{
	private static int lastID;
	private static int nextIDRequired;
	private static int[] idsRequired;
	private static int idClicked;
	private static Item[] currentlyCrafted;
	public int find(int[] array, int value) {
	    for(int i=0; i<array.length; i++) 
	         if(array[i] == value)
	             return i;
		return 0;
	}
	public TileInfuser() {
		
	}
	public TileEntity onCreated() {
		lastID = 0;
		nextIDRequired = 0;
		idsRequired = new int[Integer.MAX_VALUE];
		currentlyCrafted = new Item[Integer.MAX_VALUE];
		idClicked = 0;
		return null;
		
	}
	public boolean onRun(World w, EntityPlayer p, int x,int y, int z) {
		for(int current : idsRequired) {
			if(current == nextIDRequired) {
				lastID = current;
				idClicked = current;
				if(idClicked == find(idsRequired,idClicked)) {
					nextIDRequired = idsRequired[find(idsRequired,idClicked) + 1];
					p.inventory.addItemStackToInventory(new ItemStack(Item.itemsList[find(idsRequired,idClicked)]));
				}
			}
			
		}
		return false;
	}

}
