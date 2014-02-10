package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.blocks.tileentity.TileEntityPowerPipe;

public class BlockPowerPipe extends Block implements ITileEntityProvider{

	public BlockPowerPipe(int par1, String textureName) {
		super(par1,Material.iron );
		setTextureName(Ref.NAME.toLowerCase() + ":" + textureName);
		setUnlocalizedName("powerPipe");
		this.setCreativeTab(Ref.getRecommendedTab("block"));
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPowerPipe();
	}

}
