package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class TileEntityKernelCore extends TileEntityBeacon {
	private int tick;
	private static final int maxTick=10;
	private static class StraightEnchant extends EntityEnchantmentTableParticleFX {

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
		
	}
	static{
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityKernelCore.class, TileEntityRenderer.instance.getSpecialRendererForClass(TileEntityBeacon.class));
	}
	
	private EntityAuraFX entity;

	public TileEntityKernelCore() {
	}
	@Override
	public void updateEntity() {
		tick++;
		if(tick>maxTick) {
			tick=0;
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+1,zCoord+0.5,0,0.1,0));
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord-1,zCoord+0.5,0,-0.1,0));
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+1,yCoord+0.5,zCoord+0.5,0.1,0,0));
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord,yCoord+0.5,zCoord+0.5,-0.1,0,0));
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord+1,0,0,0.1));
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord,0,0,-0.1));
		}
		
		double d=Math.random()*2*Math.PI;
		double d2=Math.random()*Math.PI/2;
		double distance=20*Math.random()*Math.random();
		double[] startcoords=new double[]{Math.sin(d)*Math.cos(d2)*distance,Math.sin(d2)*distance,Math.cos(d)*Math.cos(d2)*distance};
		for(int i=0;i<6;i++) {
			double x,y,z;
			if(i%3==0) {
				x=startcoords[0];
				y=startcoords[1]*(i%2==0?1:-1);
				z=startcoords[2];
			}
			else if(i%3==1) {
				x=startcoords[1]*(i%2==0?1:-1);
				y=startcoords[2];
				z=startcoords[0];
			}
			else {
				x=startcoords[2];
				y=startcoords[0];
				z=startcoords[1]*(i%2==0?1:-1);
			}
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord+0.5,x*0.05,y*0.05,z*0.05,(int)Math.round(distance)*20));
			Minecraft.getMinecraft().effectRenderer.addEffect(new StraightEnchant(getWorldObj(),xCoord+x+0.5,yCoord+y+0.5,zCoord+z+0.5,-x*0.05,-y*0.05,-z*0.05,(int)Math.round(distance)*20));
		}
	}
	@Override
	public boolean canUpdate() {
		return true;
	}
}
