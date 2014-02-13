package com.matt.mod.blocks;

import com.matt.lib.Ref;

import net.minecraft.block.BlockBeacon;
import com.matt.mod.blocks.tileentity.DimensionalBeaconTileEntity;
import net.minecraft.world.World;

public class BlockDimensionalBeacon extends BlockBeacon {

	public BlockDimensionalBeacon(int par1) {
		super(par1);
		setCreativeTab(Ref.getRecommendedTab("block"));
		setUnlocalizedName("Dimensional Beacon");
		// TODO add textures
	}
	
	@Override
	public DimensionalBeaconTileEntity createNewTileEntity(World w) {
		return new DimensionalBeaconTileEntity();
	}

}
