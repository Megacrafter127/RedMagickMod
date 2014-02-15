package com.matt.mod.blocks;

import com.matt.lib.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import com.matt.mod.blocks.tileentity.TileEntityGOL;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

public class BlockGOL extends Block implements ITileEntityProvider {
	@SideOnly(Side.CLIENT)
	private Icon alive;
	@SideOnly(Side.CLIENT)
	private Icon dead;
	public static boolean halted;
	private boolean b;

	public BlockGOL(int par1) {
		super(par1, Material.circuits);
		setTextureName(Ref.NAME.toLowerCase() + ":cellactive");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		super.registerIcons(r);
		alive=r.registerIcon(Ref.NAME.toLowerCase() + ":cellactive");
		dead=r.registerIcon(Ref.NAME.toLowerCase() + ":cellinactive");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess a,int x,int y,int z,int side) {
		try{
			if(((TileEntityGOL)a.getBlockTileEntity(x, y, z)).isAlive()) {
				return alive;
			}
			else {
				return dead;
			}
		}
		catch(ClassCastException ex) {
			return alive;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGOL();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int metadata, float what, float these, float are) {
		b=!b;
		if(b) {
			return false;
		}
		try{
			((TileEntityGOL)world.getBlockTileEntity(x,y,z)).switchAlive();
			System.out.println("Switched");
			world.markBlockForRenderUpdate(x, y, z);
		}
		catch(ClassCastException ex) {}
		catch(NullPointerException ex) {}
		return false;
	}
}
