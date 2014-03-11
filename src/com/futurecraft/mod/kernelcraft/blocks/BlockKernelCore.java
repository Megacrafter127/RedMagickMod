package com.futurecraft.mod.kernelcraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.futurecraft.mod.kernelcraft.KernelCraftCore;
import com.futurecraft.mod.kernelcraft.items.ItemKernelTool;
import com.futurecraft.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class BlockKernelCore extends Block implements ITileEntityProvider {
	public static final int[] commandToolMaterial=new int[]{Item.compass.itemID,Item.pocketSundial.itemID,Item.nameTag.itemID};
	public static final int[] mineToolMaterial=new int[]{Item.pickaxeWood.itemID,Item.pickaxeStone.itemID,Item.pickaxeIron.itemID,Item.pickaxeGold.itemID,Item.pickaxeDiamond.itemID,Item.shovelWood.itemID,Item.shovelStone.itemID,Item.shovelIron.itemID,Item.shovelGold.itemID,Item.shovelDiamond.itemID};
	public static final int[] fillToolMaterial=new int[]{Item.brick.itemID,Block.brick.blockID,Item.netherrackBrick.itemID,Block.netherBrick.blockID};
	public static final int[] hoeToolMaterial=new int[]{Item.hoeWood.itemID,Item.hoeStone.itemID,Item.hoeIron.itemID,Item.hoeGold.itemID,Item.hoeDiamond.itemID};
	public static final int[] harvestToolMaterial=new int[]{Item.axeWood.itemID,Item.axeStone.itemID,Item.axeIron.itemID,Item.axeGold.itemID,Item.axeDiamond.itemID};
	public static final int[] countToolMaterial=new int[]{Item.comparator.itemID,Block.redstoneComparatorActive.blockID,Block.redstoneComparatorIdle.blockID};
	
	public BlockKernelCore(int par1) {
		super(par1,Material.dragonEgg);
		setBlockUnbreakable();
		setTextureName(KernelCraftCore.toTextureName("kernelcore"));
		setUnlocalizedName("Kernel Core");
	}
	
	@Override
	public int getLightValue(IBlockAccess access,int x,int y,int z) {
		return 15;
	}
	
	@Override
	public TileEntityKernelCore createNewTileEntity(World w) {
		return new TileEntityKernelCore();
	}
	
	@Override
	public boolean canPlaceBlockAt(World w,int x,int y,int z) {
		return w.getBlockId(x, y-1, z)==KernelCraftCore.Module.blockID;
	}
	
	@Override
	public int idDropped(int x,Random r,int z) {
		return 0;
	}
	
	@Override
	public int idPicked(World w,int x,int y,int z) {
		return 0;
	}
	
	@Override
	public boolean onBlockActivated(World w,int x,int y,int z,EntityPlayer player,int side,float hitx,float hity,float hitz) {
		ItemStack itemStack=player.inventory.getCurrentItem();
		if(itemStack!=null) {
			for(int i:commandToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.commandToolMeta));
					return true;
				}
			}
			for(int i:fillToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.fillToolMeta));
					return true;
				}
			}
			for(int i:mineToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.mineToolMeta));
					return true;
				}
			}
			for(int i:harvestToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.harvestToolMeta));
					return true;
				}
			}
			for(int i:hoeToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.hoeToolMeta));
					return true;
				}
			}
			for(int i:harvestToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.harvestToolMeta));
					return true;
				}
			}
			for(int i:countToolMaterial) {
				if(itemStack.itemID==i) {
					itemStack.stackSize--;
					if(itemStack.stackSize==0) player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool, 1, ItemKernelTool.countToolMeta));
					else player.inventory.setCurrentItem(KernelCraftCore.KernelTool.itemID, ItemKernelTool.mineToolMeta, true, true);
					player.inventory.inventoryChanged=true;
					return true;
				}
			}
		}
		return false;
	}
}
