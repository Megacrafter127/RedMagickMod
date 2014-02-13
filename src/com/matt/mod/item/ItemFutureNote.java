package com.matt.mod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.FutureCraft;

public class ItemFutureNote extends Item {

	public ItemFutureNote() {
	super(FutureCraft.loreBookId);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		player.openGui(FutureCraft.instance, 0, w, x, y, z);
		return true;
	}
}
