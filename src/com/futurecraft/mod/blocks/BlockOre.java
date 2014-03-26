package com.futurecraft.mod.blocks;

import com.futurecraft.lib.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOre extends Block {
 public BlockOre(int id,String texturename) {
	 super(id, Material.iron);
	 this.setTextureName(Ref.NAME.toLowerCase() + ":" + textureName);	 
 }
}
