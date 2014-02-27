package com.matt.mod.magick.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.generic.helpers.ChatHelper;
import com.matt.mod.magick.items.logic.FlyingCatalistLogic;
import com.matt.mod.magick.items.logic.ItemLogic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlyingCatalist extends Item{
public ItemFlyingCatalist() {
	super(FutureCraft.swag_catalist_id);
	setTextureName(Ref.NAME.toLowerCase() + ":catalist1");
	setUnlocalizedName("Catalist of Flying");
	setMaxStackSize(1);
	getLogic().setManaLevel(100);
}
@Override
public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
	System.out.println(getLogic().getManaLevel());
	return FlyingCatalistLogic.run(entityPlayer);
	
}
public static ItemLogic getLogic() {
	return new FlyingCatalistLogic();
}
@Override
@SideOnly(Side.CLIENT)
public void addInformation(ItemStack par1ItemStack,
          EntityPlayer par2EntityPlayer,
          List par3List,
          boolean par4) {
	 par3List.add(ChatHelper.htt("Flying, Because, Why not?", Keyboard.KEY_LSHIFT, new EnumChatFormatting[]{EnumChatFormatting.GOLD,EnumChatFormatting.UNDERLINE}));
}
}
