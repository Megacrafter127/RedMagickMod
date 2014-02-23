package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.items.ItemKernelTool;

public class BlockKernelToolMaker extends Block {
	public static final int[] mineToolMaterial=new int[]{Item.pickaxeWood.itemID,Item.pickaxeStone.itemID,Item.pickaxeIron.itemID,Item.pickaxeGold.itemID,Item.pickaxeDiamond.itemID,Item.shovelWood.itemID,Item.shovelStone.itemID,Item.shovelIron.itemID,Item.shovelGold.itemID,Item.shovelDiamond.itemID};
	public static final int[] hoeToolMaterial=new int[]{Item.hoeWood.itemID,Item.hoeStone.itemID,Item.hoeIron.itemID,Item.hoeGold.itemID,Item.hoeDiamond.itemID};
	public static final int[] harvestToolMaterial=new int[]{Item.axeWood.itemID,Item.axeStone.itemID,Item.axeIron.itemID,Item.axeGold.itemID,Item.axeDiamond.itemID};
	public static final int[] countToolMaterial=new int[]{Item.comparator.itemID,Block.redstoneComparatorActive.blockID,Block.redstoneComparatorIdle.blockID};
	public BlockKernelToolMaker(int par1) {
		super(par1, Material.iron);
		super.setTextureName(KernelCraftCore.toTextureName("kerneltoolmaker"));
		super.setUnlocalizedName("Kernel Tool Maker");
	}
	
	@Override
	public boolean onBlockActivated(World w,int x,int y,int z,EntityPlayer player,int side,float hitx,float hity,float hitz) {
		ItemStack itemStack=player.inventory.getCurrentItem();
		if(itemStack!=null) {
			for(int i:mineToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool.itemID, 1, ItemKernelTool.mineToolMeta));
					return true;
				}
			}
			for(int i:hoeToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool.itemID, 1, ItemKernelTool.hoeToolMeta));
					return true;
				}
			}
			for(int i:harvestToolMaterial) {
				if(itemStack.itemID==i) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool.itemID, 1, ItemKernelTool.harvestToolMeta));
					return true;
				}
			}
			for(int i:countToolMaterial) {
				if(itemStack.itemID==i) {
					itemStack.stackSize--;
					if(itemStack.stackSize==0) player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool.itemID, 1, ItemKernelTool.countToolMeta));
					else player.inventory.setCurrentItem(KernelCraftCore.KernelTool.itemID, ItemKernelTool.mineToolMeta, true, true);
					return true;
				}
			}
			try{
				if(Block.blocksList[itemStack.itemID]!=null) {
					itemStack.stackSize--;
					if(itemStack.stackSize==0) player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(KernelCraftCore.KernelTool.itemID, 1, ItemKernelTool.fillToolMeta));
					else player.inventory.setCurrentItem(KernelCraftCore.KernelTool.itemID, ItemKernelTool.mineToolMeta, true, true);
					return true;
				}
			}
			catch(ArrayIndexOutOfBoundsException ex) {}
		}
		return false;
	}
}
