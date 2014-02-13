package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.blocks.tileentity.TileEntitySmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
	
public class BlockFutureFurnace extends Block implements ITileEntityProvider{
	
	Icon bottom;
	Icon top;
	Icon sidei;
	Icon front;
	public BlockFutureFurnace(int par1, String texturename) {
		super(par1, Material.circuits);
		this.setCreativeTab(Ref.getRecommendedTab("block"));
		setUnlocalizedName("basicFutureFurnace");
	}


	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySmelter();
	}
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
		System.out.println("Clicked on smelter");
					if(world.getBlockTileEntity(x, y, z) instanceof TileEntitySmelter) {
						TileEntitySmelter smelt = (TileEntitySmelter) world.getBlockTileEntity(x,y,z);
						smelt.run(player, world, x, y, z);
						return true;
					}
					return false;
            }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) { 
		bottom = icon.registerIcon(Ref.NAME + ":compressionbottom");
		top = icon.registerIcon(Ref.NAME + ":compressionbottom");	
		sidei = icon.registerIcon(Ref.NAME +":compressionside");
		front = icon.registerIcon(Ref.NAME + ":compressionfront");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
	if(side == 0) {
	return bottom;
	} else if(side == 1) {
	return top;
	} else if ( side == 2 || side == 3) {
		return front;
	}
	else {
	return sidei;
	}
	}
		
}