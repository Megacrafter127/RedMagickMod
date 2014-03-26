package com.futurecraft.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.blocks.tileentity.TileEntityEnchantAltar;

public class BlockEnchantmentAltarCore extends Block implements
		ITileEntityProvider{

	public BlockEnchantmentAltarCore() {
		super(FutureCraft.altarCoreID, Material.dragonEgg);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityEnchantAltar();
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityEnchantAltar a = (TileEntityEnchantAltar)world.getBlockTileEntity(x,y,z);
		return a.run(player, world, x, y, z);
	}
		
		
    


}
