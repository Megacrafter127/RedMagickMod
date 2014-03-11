package com.futurecraft.mod.blocks;

import com.futurecraft.lib.Ref;
import com.futurecraft.mod.blocks.tileentity.TileEntityGOL;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

public class BlockGOL extends Block implements ITileEntityProvider {
	public static boolean halted;

	public BlockGOL(int par1) {
		super(par1, Material.iron);
		setTextureName(Ref.NAME.toLowerCase() + ":gol");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGOL();
	}
	
	@Override
	public void onBlockAdded(World w,int x,int y,int z) {
		w.setBlockTileEntity(x, y, z, createNewTileEntity(w));
	}
}
