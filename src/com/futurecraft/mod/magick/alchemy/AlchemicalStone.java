package com.futurecraft.mod.magick.alchemy;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.futurecraft.api.BookHelper;
import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.items.INBTItem;
import com.futurecraft.mod.magick.lib.MagickLib;

public class AlchemicalStone extends Item implements INBTItem {
	
	private static final int[] transmutable = new int[]{
		Block.dirt.blockID,
		Block.grass.blockID,
		Block.sand.blockID,
		Block.stone.blockID,
		Block.cobblestone.blockID
	};

	public AlchemicalStone() {
		super(MagickLib.getIdFor("Alchemical Stone",5000));
	}

	@Override
	public void writeToNbt(ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromNbt(ItemStack stack) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
		if(!entityPlayer.isSneaking()) {
		
			if(entityPlayer.inventory.hasItem(MagickHelper.rune.itemID) ) {
				if(world.getBlockId(x,y,z) == transmutable[0]) {
					world.setBlock(x,y,z,transmutable[1]);
				}else if(world.getBlockId(x,y,z) == transmutable[1]) {
					world.setBlock(x,y,z,transmutable[2]);
				}else if(world.getBlockId(x,y,z) == transmutable[2]) {
					world.setBlock(x,y,z,transmutable[3]);
				}else if(world.getBlockId(x,y,z) == transmutable[3]) {
					world.setBlock(x,y,z,transmutable[4]);
				}else if(world.getBlockId(x,y,z) == transmutable[4]) {
					world.setBlock(x,y,z,transmutable[0]);
				}
				entityPlayer.inventory.consumeInventoryItem(MagickHelper.rune.itemID);
			}else if(entityPlayer.inventory.hasItem(MagickHelper.alchemyFuel.itemID)) {
				if(world.getBlockId(x,y,z) == transmutable[0]) {
					world.setBlock(x,y,z,transmutable[1]);
				}else if(world.getBlockId(x,y,z) == transmutable[1]) {
					world.setBlock(x,y,z,transmutable[2]);
				}else if(world.getBlockId(x,y,z) == transmutable[2]) {
					world.setBlock(x,y,z,transmutable[3]);
				}else if(world.getBlockId(x,y,z) == transmutable[3]) {
					world.setBlock(x,y,z,transmutable[4]);
				}else if(world.getBlockId(x,y,z) == transmutable[4]) {
					world.setBlock(x,y,z,transmutable[0]);
					
				}
				entityPlayer.inventory.consumeInventoryItem(MagickHelper.alchemyFuel.itemID);
			}else if(entityPlayer.inventory.hasItem(MagickHelper.manaDust.itemID)) {
				if(world.getBlockId(x,y,z) == transmutable[0]) {
					world.setBlock(x,y,z,transmutable[1]);
				}else if(world.getBlockId(x,y,z) == transmutable[1]) {
					world.setBlock(x,y,z,transmutable[2]);
				}else if(world.getBlockId(x,y,z) == transmutable[2]) {
					world.setBlock(x,y,z,transmutable[3]);
				}else if(world.getBlockId(x,y,z) == transmutable[3]) {
					world.setBlock(x,y,z,transmutable[4]);
				}else if(world.getBlockId(x,y,z) == transmutable[4]) {
					world.setBlock(x,y,z,transmutable[0]);
				}
				entityPlayer.inventory.consumeInventoryItem(MagickHelper.manaDust.itemID);
			}
		
		}else{
			entityPlayer.inventory.addItemStackToInventory(BookHelper.instance.createBookFromString(new String[]{"Transmutation stone, the greatest advance in magic ever! It requires fuel to function, but can change blocks into another blocks! "},"The Creator","Alchemy 101"));
		}
		return true;
	}
	
	@Override 
	public void addInformation(ItemStack stack,
	          EntityPlayer player,
	          List list,
	          boolean par4) {
		if(stack.stackTagCompound != null) {
			list.add(ChatHelper.acf("The Stone.. of alchemy!",EnumChatFormatting.LIGHT_PURPLE));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("The Stone.. of alchemy!",EnumChatFormatting.LIGHT_PURPLE));
		}
	}
}
