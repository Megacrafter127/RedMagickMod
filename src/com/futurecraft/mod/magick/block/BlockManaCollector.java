package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.generic.helpers.ChatHelper;

public class BlockManaCollector extends Block implements ITileEntityProvider {

	private static class StraightEnchant extends EntityEnchantmentTableParticleFX {
		public boolean enlight;

		public StraightEnchant(World par1World, double par2, double par4,
				double par6, double par8, double par10, double par12) {
			super(par1World, par2, par4, par6, par8, par10, par12);
			this.particleMaxAge*=100;
		}
		public StraightEnchant(World w, double par2, double par4,
				double par6, double par8, double par10, double par12, int lifeTime) {
			super(w, par2, par4, par6, par8, par10, par12);
			this.particleMaxAge=lifeTime;
		}
		
		@Override
		public void onUpdate()
	    {
	        this.prevPosX = this.posX;
	        this.prevPosY = this.posY;
	        this.prevPosZ = this.posZ;
	        this.posX += this.motionX;
	        this.posY += this.motionY;
	        this.posZ += this.motionZ;

	        if (this.particleAge++ >= this.particleMaxAge)
	        {
	            this.setDead();
	        }
	    }
		@Override
		public void setDead() {
			super.setDead();
			if(enlight) super.worldObj.addWeatherEffect(new EntityLightningBolt(worldObj,posX,posY,posZ));
		}
		
	}
	public class TileEntityCollector extends TileEntity {
		public void onUpdate() {
			Minecraft.getMinecraft().thePlayer.addChatMessage(ChatHelper.acf("ManaCollector Updated", EnumChatFormatting.RED));
		}
	}

	public BlockManaCollector() {
		super(FutureCraft.manaColllectorID,Material.iron);
	
	}
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
		 System.out.println("[Debugger]");
		 Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(par1World,par2,par3,par4,10,0,10));
		 return true;
	    }
	 

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCollector();
	}

}
