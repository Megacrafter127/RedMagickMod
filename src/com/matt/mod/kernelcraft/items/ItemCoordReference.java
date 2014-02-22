package com.matt.mod.kernelcraft.items;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCoordMemory;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemCoordReference extends Item {

	public ItemCoordReference(int par1) {
		super(par1);
		super.setMaxStackSize(1);
		super.setTextureName(KernelCraftCore.toTextureName("coordreference"));
		super.setNoRepair();
		super.setUnlocalizedName("Coordinate Reference");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hitX,float hitY,float hitZ) {
		if(player.isSneaking()) {
			EnumFacing face=EnumFacing.getFront(side);
			x+=face.getFrontOffsetX();
			y+=face.getFrontOffsetY();
			z+=face.getFrontOffsetZ();
		}
		TileEntityKernelCoordMemory.coords.put(stack.getItemDamage(), new int[]{x,y,z});
		player.addChatMessage("Saved: "+x+", "+y+", "+z);
		return true;
	}
}
