package com.matt.mod.swag.items.tools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import com.matt.FutureCraft;
import com.matt.generic.helpers.FutureCraftConfig;
import com.matt.generic.helpers.FutureCraftToolMaterials;

public class ItemSwaggishPickaxe extends ItemTool {

	protected ItemSwaggishPickaxe(int par1, float par2,
			EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(FutureCraftConfig.get(FutureCraftConfig.cfg,FutureCraft.swag_default_id,"Swag Pickaxe","SwagTools"), par2,FutureCraftToolMaterials.mana, par4ArrayOfBlock);
		Item writtenBook2 = Item.writtenBook;
	}

}
