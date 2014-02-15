package com.matt.mod.blocks;

import com.matt.lib.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGOLControler extends Block {
	@SideOnly(Side.CLIENT)
	private Icon on;
	@SideOnly(Side.CLIENT)
	private Icon off;
	

	public BlockGOLControler(int par1) {
		super(par1,Material.circuits);
		setTextureName(Ref.NAME.toLowerCase() + ":golcontroleron");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		super.registerIcons(r);
		on=r.registerIcon(Ref.NAME.toLowerCase() + ":golcontroleron");
		off=r.registerIcon(Ref.NAME.toLowerCase() + ":golcontroleroff");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess a,int x,int y,int z,int side) {
		if(BlockGOL.halted) {
			return on;
		}
		else {
			return off;
		}
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int metadata, float what, float these, float are) {
		Minecraft.getMinecraft().renderGlobal.markBlockForRenderUpdate(x, y, z);
		if(world.isRemote) {
			return true;
		}
		BlockGOL.halted=!BlockGOL.halted;
		if(BlockGOL.halted) {
			System.out.println("Halted GOL-blocks");
		}
		else {
			System.out.println("Resumed GOL");
		}
		return false;
	}
}
