package com.futurecraft.mod.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;
import com.futurecraft.mod.blocks.tileentity.TileEntityPowerPipe;

public class BlockPowerPipe extends Block implements ITileEntityProvider{

	public BlockPowerPipe(int par1, String textureName) {
		super(par1,Material.iron );
		setTextureName(Ref.NAME.toLowerCase() + ":" + textureName);
		setUnlocalizedName("Power Generator");
		this.setCreativeTab(Ref.getRecommendedTab("block"));
	}

	@Override
	public TileEntityPowerPipe createNewTileEntity(World world) {
		return new TileEntityPowerPipe();
	}
	
}
