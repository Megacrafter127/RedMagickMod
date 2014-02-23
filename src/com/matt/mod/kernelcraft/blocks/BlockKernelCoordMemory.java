package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCoordMemory;

public class BlockKernelCoordMemory extends ColumnBlock implements ITileEntityProvider {
	
	public BlockKernelCoordMemory(int par1) {
		super(par1,Material.iron, "coordmemorytop", "coordmemorybottom", "coordmemoryside", "Kernel Coordinate Memory");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityKernelCoordMemory();
	}
	
	@Override
	public boolean onBlockActivated(World w,int x,int y,int z,EntityPlayer player,int meta,float hitx,float hity,float hitz) {
		if(w.isRemote) return false;
		if(player.inventory.getCurrentItem()!=null) {
			if(player.inventory.getCurrentItem().itemID==KernelCraftCore.CoordReference.itemID) {
				if(!player.inventory.getCurrentItem().hasTagCompound()) return false;
				int[] coords=player.inventory.getCurrentItem().stackTagCompound.getIntArray("coords");
				TileEntityKernelCoordMemory t=(TileEntityKernelCoordMemory)w.getBlockTileEntity(x, y, z);
				t.setCoords(coords);
				player.inventory.getCurrentItem().stackSize=0;
				player.inventory.inventoryChanged=true;
				player.addChatMessage("Transmitted: "+coords[0]+", "+coords[1]+", "+coords[2]);
			}
			else {
				ItemStack i=new ItemStack(KernelCraftCore.CoordReference,1);
				i.stackTagCompound=new NBTTagCompound();
				player.inventory.addItemStackToInventory(i);
			}
		}
		else {
			ItemStack i=new ItemStack(KernelCraftCore.CoordReference,1);
			i.stackTagCompound=new NBTTagCompound();
			player.inventory.addItemStackToInventory(i);
		}
		return true;
	}
}
