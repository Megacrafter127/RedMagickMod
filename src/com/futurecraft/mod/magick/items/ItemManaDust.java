package com.futurecraft.mod.magick.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;
import com.futurecraft.mod.generic.helpers.ChatHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemManaDust extends Item {
 public static final String name = "Magikos Peperi";
public ItemManaDust() {
	super(FutureCraft.manaDustID);
	setTextureName(Ref.NAME.toLowerCase() + ":mageiafoscos");
}
@Override
@SideOnly(Side.CLIENT)
public void addInformation(ItemStack par1ItemStack,
          EntityPlayer par2EntityPlayer,
          List par3List,
          boolean par4) {
	 par3List.add(ChatHelper.htt("The primordial source of all magick in this world..", Keyboard.KEY_LSHIFT, new EnumChatFormatting[]{EnumChatFormatting.GOLD,EnumChatFormatting.UNDERLINE}));
}

}
