package com.futurecraft.mod.blocks;

import com.futurecraft.mod.blocks.tileentity.TileEntityColuumQuarry;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockColuumQuarry extends Block implements ITileEntityProvider {

	public BlockColuumQuarry(int par1, String textureName) {
		super(par1, Material.iron);
	this.setTextureName(textureName);
	this.setUnlocalizedName("Coluum Quarry");
	this.setHardness(0.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityColuumQuarry();
	}
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9)
	{
		TileEntityColuumQuarry q = (TileEntityColuumQuarry)w.getBlockTileEntity(x,y,z);
		q.run(p, w, x, y, z);
		return false;
	}


}
