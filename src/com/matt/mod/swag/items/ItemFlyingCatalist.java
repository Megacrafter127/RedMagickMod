package com.matt.mod.swag.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.swag.items.logic.FlyingCatalistLogic;

public class ItemFlyingCatalist extends Item{
public ItemFlyingCatalist() {
	super(FutureCraft.swag_catalist_id);
	setTextureName(Ref.NAME.toLowerCase() + ":catalist1");
	setUnlocalizedName("Catalist of Flying");
	setMaxStackSize(1);
}
@Override
public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
	return FlyingCatalistLogic.run(entityPlayer);
	
}
}
