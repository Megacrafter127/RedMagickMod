package com.matt.mod.kernelcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class ItemKernelReference extends Item {
	public static int linkX;
	public static int linkY;
	public static int linkZ;
	
	public ItemKernelReference(int par1) {
		super(par1);
		super.setTextureName(KernelCraftCore.toTextureName("kernelreference"));
		super.setUnlocalizedName("Kernel Reference");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hitX,float hitY,float hitZ) {
		try{
			TileEntityKernelCore source=(TileEntityKernelCore)world.getBlockTileEntity(linkX, linkY+1, linkZ);
			EnumFacing face=EnumFacing.getFront(side);
			source.addBlockAffectEffect(x+face.getFrontOffsetX(), y+face.getFrontOffsetY(), z+face.getFrontOffsetZ(), 1200);
		}
		catch(Exception ex) {
			while(player.inventory.hasItem(itemID)) player.inventory.consumeInventoryItem(itemID);
		}
		return true;
	}
}
