package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class TileEntityKernelCore extends TileEntityBeacon {
	private static class StraightEnchant extends EntityEnchantmentTableParticleFX {

		public StraightEnchant(World par1World, double par2, double par4,
				double par6, double par8, double par10, double par12) {
			super(par1World, par2, par4, par6, par8, par10, par12);
			this.particleMaxAge*=100;
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
		
	}
	static{
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityKernelCore.class, TileEntityRenderer.instance.getSpecialRendererForClass(TileEntityBeacon.class));
	}
	
	private EntityAuraFX entity;

	public TileEntityKernelCore() {
	}
	@Override
	public void updateEntity() {
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+1,zCoord+0.5,0,0.1,0));
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord-1,zCoord+0.5,0,-0.1,0));
		
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+1,yCoord+0.5,zCoord+0.5,0.1,0,0));
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord,yCoord+0.5,zCoord+0.5,-0.1,0,0));
		
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord+1,0,0,0.1));
		Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord,0,0,-0.1));
	}
	@Override
	public boolean canUpdate() {
		return true;
	}
}
