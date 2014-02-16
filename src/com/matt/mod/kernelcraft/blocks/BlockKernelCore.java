package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.BlockBeacon;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKernelCore extends BlockBeacon {
	private Icon icon;

	public BlockKernelCore(int par1) {
		super(par1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		icon=r.registerIcon(KernelCraftCore.toTextureName("kernelcore"));
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override
	public boolean isBlockNormalCube(World w,int x,int y,int z) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess access,int x,int y,int z,int side) {
		return icon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side,int meta) {
		return icon;
	}
	
	@Override
	public int getRenderType() {
		return 0;
	}
	
	@Override
	public boolean onBlockActivated(World w,int x,int y,int z,EntityPlayer player,int meta,float hitx,float hity,float hitz) {
		return false;
	}
	
	@Override
	public TileEntityKernelCore createNewTileEntity(World w) {
		return new TileEntityKernelCore();
	}
}
