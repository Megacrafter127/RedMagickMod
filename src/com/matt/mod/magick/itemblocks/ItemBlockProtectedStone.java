package com.matt.mod.magick.itemblocks;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class ItemBlockProtectedStone extends ItemBlock {
	public static String name = "Robber's Stone";
	public ItemBlockProtectedStone(int par1) {
		super(par1);
		
	}
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	super.onCreated(par1ItemStack,par2World, par3EntityPlayer);
    	if(par1ItemStack.stackTagCompound != null) {
    		par1ItemStack.stackTagCompound.setString("itemOwner",par3EntityPlayer.getDisplayName());
    	}
    	
	}
	@Override
	 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
		if(par1ItemStack.stackTagCompound != null) {
			par3List.add(EnumChatFormatting.RED + "Owner : " + par1ItemStack.stackTagCompound.getString("itemOwner"));
		}
		}else{
			if(par1ItemStack.stackTagCompound != null) {
				par3List.add(EnumChatFormatting.GRAY + "Press shift to see details");
			}
		}
	}
	/**
	 * @return the name
	 */
	public static String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
