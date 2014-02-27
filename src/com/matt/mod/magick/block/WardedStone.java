package com.matt.mod.magick.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.lib.Ref;
import com.matt.mod.magick.MagickHelper;
import com.matt.mod.magick.block.tile.TileEntityProtected;
import com.matt.mod.magick.itemblocks.ItemBlockProtectedStone;

public class WardedStone extends Block implements ITileEntityProvider {

	public WardedStone(int par1) {
		super(par1, Material.iron);
		setUnlocalizedName(ItemBlockProtectedStone.name);
		setHardness(10.0F);	
		setTextureName(Ref.NAME.toLowerCase() + ":ward");
		setLightOpacity(25);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityProtected();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		if(par5EntityLivingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)par5EntityLivingBase;
			TileEntityProtected p = (TileEntityProtected)par1World.getBlockTileEntity(par2,par3,par4);
			p.owner = player.getDisplayName();
		}
		
	}

	/*@Override
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		if(par6EntityPlayer.capabilities.isCreativeMode) { 
			par1World.setBlock(par2,par3,par4,SwagHelper.blockProtectedStone.blockID);
			}
	}	
	*/
	
	@Override
	 public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	  /**
     * Gets the hardness of block at the given coordinates in the given world, relative to the ability of the given
     * EntityPlayer.
     */
	@Override
    public float getPlayerRelativeBlockHardness(EntityPlayer par1EntityPlayer, World par2World, int par3, int par4, int par5)
    {if(par1EntityPlayer.getDisplayName() == ((TileEntityProtected)par2World.getBlockTileEntity(par3,par3,par4)).owner)
	{
		return 0.1F;
	}else{
		setBlockUnbreakable();
		return -1.0F;
	}
    }
	
}
