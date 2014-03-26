package com.futurecraft.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColumnBlock extends Block {
	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private String topName;
	@SideOnly(Side.CLIENT)
	private Icon bottom;
	@SideOnly(Side.CLIENT)
	private String bottomName;
	@SideOnly(Side.CLIENT)
	private Icon side;
	@SideOnly(Side.CLIENT)
	private String sideName;

	public ColumnBlock(int par1, Material par2Material,String top,String bottom,String side,String name) {
		super(par1, par2Material);
		topName=top;
		bottomName=bottom;
		sideName=side;
		super.setUnlocalizedName(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		top=r.registerIcon(topName);
		bottom=r.registerIcon(bottomName);
		side=r.registerIcon(sideName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side,int meta) {
		if(side==1) {
			return top;
		}
		if(side==0) {
			return bottom;
		}
		return this.side;
	}
}
