package com.matt.mod.item;

import com.matt.lib.Ref;
import com.matt.mod.ModItems;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ItemNetheriumPickaxe extends ItemPickaxe {
	private static final EnumToolMaterial material=EnumHelper.addToolMaterial("Netherium",0,4096,10.0F,3.0F,10);
	static{
		material.customCraftingMaterial=ModItems.neth;
	}

	public ItemNetheriumPickaxe(int par1) {
		super(par1,material);
		setTextureName(Ref.NAME.toLowerCase() + ":pickaxenetherium");
		setUnlocalizedName("Netherium Pickaxe");
	}

}
