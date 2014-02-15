package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;

public class ColumnBlock extends Block {
	private Icon top;
	private String topName;
	private Icon bottom;
	private String bottomName;
	private Icon side;
	private String sideName;

	public ColumnBlock(int par1, Material par2Material,String top,String bottom,String side,String name) {
		super(par1, par2Material);
		topName=top;
		bottomName=bottom;
		sideName=side;
	}
	
	@Override
	public void registerIcons(IconRegister r) {
		top=r.registerIcon(topName);
		bottom=r.registerIcon(bottomName);
		side=r.registerIcon(sideName);
	}
	
	@Override
	public Icon getIcon(int side,int meta) {
		if(side==0) {
			return top;
		}
		if(side==1) {
			return bottom;
		}
		return this.side;
	}
}
