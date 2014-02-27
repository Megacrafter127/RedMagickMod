package com.matt.mod.magick;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.matt.mod.magick.generics.MagickalBlockG;

public class GenericFactory {
public static Block getGenericBlock(int id, Material m) {
	if(m != null) {
		if(id != 0) {
			return new MagickalBlockG().setIdAndMaterial(id,m);
		}
		return new MagickalBlockG().setIdAndMaterial(id, Material.dragonEgg);
	}
	return null;
}
/**
 * Is used for creating a block, with no TileEntity.
 * Returns a new block with the ID id.
 * @param id - The block's id.
 * @return A new block.
 */
public static Block getGenericBlockForID(int id) {
 return new MagickalBlockG().setIdAndMaterial(id,Material.dragonEgg);
}
public static Block getGenericBlockForIDAndTexure(int id,String s) {
	 return new MagickalBlockG().setIdAndMaterial(id,Material.dragonEgg).setTextureName(MagickalBlockG.getTextureFileForThis(s));
	}
}
