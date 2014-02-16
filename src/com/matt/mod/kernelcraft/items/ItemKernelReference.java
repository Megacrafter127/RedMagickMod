package com.matt.mod.kernelcraft.items;

import net.minecraft.item.Item;

import com.matt.mod.kernelcraft.KernelCraftCore;

public class ItemKernelReference extends Item {
	public static int linkX;
	public static int linkY;
	public static int linkZ;
	
	public ItemKernelReference(int par1) {
		super(par1);
		super.setTextureName(KernelCraftCore.toTextureName("kernelreference"));
		super.setUnlocalizedName("Kernel Reference");
	}
}
