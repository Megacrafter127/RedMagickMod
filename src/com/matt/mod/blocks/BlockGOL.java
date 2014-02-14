package com.matt.mod.blocks;

import com.matt.lib.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import com.matt.mod.blocks.tileentity.TileEntityGOL;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

public class BlockGOL extends Block implements ITileEntityProvider {
	private Icon alive;
	private Icon dead;
	public static boolean halted;

	public BlockGOL(int par1) {
		super(par1, Material.circuits);
		setTextureName(Ref.NAME.toLowerCase() + ":cellactive");
	}
	
	@Override
	public void registerIcons(IconRegister r) {
		super.registerIcons(r);
		alive=r.registerIcon(Ref.NAME.toLowerCase() + ":cellactive");
		dead=r.registerIcon(Ref.NAME.toLowerCase() + ":cellinactive");
	}
	
	@Override
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
	public void updateTick(World w,int x,int y,int z,Random r) {
		if(!halted) {
			try{
				((TileEntityGOL)w.getBlockTileEntity(x, y, z)).run(w);
			}
			catch(ClassCastException ex) {}
			catch(NullPointerException ex) {}
		}
	}
	
	@Override
	public int tickRate(World w) {
		return 5;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int metadata, float what, float these, float are) {
		try{
			((TileEntityGOL)world.getBlockTileEntity(x,y,z)).switchAlive();
			System.out.println("Switched");
		}
		catch(ClassCastException ex) {}
		catch(NullPointerException ex) {}
		return false;
	}
}
