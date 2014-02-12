package com.matt.mod.item;

import com.matt.lib.Ref;
import com.matt.mod.ModItems;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.EnumHelper;

public class ItemEnderiumPickaxe extends ItemPickaxe {
	public static final EnumToolMaterial material=EnumHelper.addToolMaterial("Enderium",3,1024,10.0F,4.0F,40);
	static{
		material.customCraftingMaterial=ModItems.endh;
	}

	public ItemEnderiumPickaxe(int par1) {
		super(par1, material);
		setTextureName(Ref.NAME.toLowerCase() + "pickaxeenderium");
	}

}
