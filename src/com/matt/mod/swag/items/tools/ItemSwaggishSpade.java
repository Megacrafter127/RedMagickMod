package com.matt.mod.swag.items.tools;

import com.matt.generic.helpers.FutureCraftToolMaterials;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class ItemSwaggishSpade  extends ItemTool {

	protected ItemSwaggishSpade(int par1, float par2,
			EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(par1, par2, FutureCraftToolMaterials.mana, par4ArrayOfBlock);
		
	}

}
