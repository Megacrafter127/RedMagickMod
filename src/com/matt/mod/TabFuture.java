package com.matt.mod;

import com.matt.FutureCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFuture extends CreativeTabs {

	public TabFuture(int i, String label) {
		super(i,label);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
	// Here you make the Icon of the creative Tab
	return FutureCraft.bFutureStack;
	}
	public String getTranslatedTabLabel(){
	// Here the Name
	return "FutureCraft";
	}
}
