package com.matt.mod.kernelcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class ItemKernelReference extends Item {
	public ItemKernelReference(int par1) {
		super(par1);
		super.setTextureName(KernelCraftCore.toTextureName("kernelreference"));
		super.setUnlocalizedName("Kernel Reference");
		super.setMaxStackSize(1);
		super.setHasSubtypes(true);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hitX,float hitY,float hitZ) {
		if(world.isRemote) return false;
		try{
			int[] coord=stack.stackTagCompound.getIntArray("coords");
			TileEntityKernelCore source=(TileEntityKernelCore)world.getBlockTileEntity(coord[0],coord[1],coord[2]);
			if(TileEntityKernelCore.linkable.contains(world.getBlockId(x, y, z))) {
				source.linkBlock(x, y, z);
				player.addChatMessage("Link established");
				return true;
			}
			else return false;
		}
		catch(Exception ex) {
			stack.stackSize=0;
			player.inventory.inventoryChanged=true;
			player.addChatMessage("Reference damaged; self destruction active!");
		}
		return true;
	}
}
