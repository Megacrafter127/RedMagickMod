package com.matt.mod.kernelcraft.tileentities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class TileEntityKernelCore extends TileEntityBeacon {
	public static final HashMap<Integer,int[]> kernelHash=new HashMap<Integer,int[]>();
	private static int id=-1;
	public static int getNextID() {
		return id++;
	}
	protected static void writeHashToNBT(NBTTagCompound nbt) {
		int size=kernelHash.size();
		Iterator<Integer> keys=kernelHash.keySet().iterator();
		nbt.setInteger("size", size);
		for(int i=0;i<size;i++) {
			Integer key=keys.next();
			nbt.setInteger("key."+i, key);
			nbt.setIntArray("val."+i, kernelHash.get(key));
		}
		nbt.setInteger("hashID", id);
	}
	protected static void readHashFromNBT(NBTTagCompound nbt) {
		Set<Integer> keys=((HashMap<Integer,int[]>)kernelHash.clone()).keySet();
		int size=nbt.getInteger("size");
		for(int i=0;i<size;i++) {
			int key=nbt.getInteger("key."+i);
			keys.remove(key);
			kernelHash.put(key, nbt.getIntArray("val."+i));
		}
		Iterator<Integer> i=keys.iterator();
		while(i.hasNext()) {
			kernelHash.remove(i.next());
		}
		id=nbt.getInteger("hashID");
	}
	
	
	private int affectX,affectY,affectZ,affectRemaining;
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
		@Override
		public void setDead() {
			super.setDead();
			//super.worldObj.addWeatherEffect(new EntityLightningBolt(worldObj,posX,posY,posZ));
		}
		
	}
	static{
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityKernelCore.class, TileEntityRenderer.instance.getSpecialRendererForClass(TileEntityBeacon.class));
	}
	
	public TileEntityKernelCore() {
	}
	@Override
	public void updateEntity() {
		addPermanentParticles();
		addAffectionParticles();
	}
	
	private void addPermanentParticles() {
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
			spawnParticle(new StraightEnchant(getWorldObj(),xCoord+0.5,yCoord+0.5,zCoord+0.5,x*0.05,y*0.05,z*0.05,(int)Math.round(distance)*20));
			spawnParticle(new StraightEnchant(getWorldObj(),xCoord+x+0.5,yCoord+y+0.5,zCoord+z+0.5,-x*0.05,-y*0.05,-z*0.05,(int)Math.round(distance)*20));
		}
	}
	
	private void spawnParticle(EntityFX e) {
		Minecraft.getMinecraft().effectRenderer.addEffect(e);
	}
	
	private void addAffectionParticles() {
		if(affectRemaining>0) {
			affectRemaining--;
			int dX=affectX-xCoord;
			int dY=affectY-yCoord;
			int dZ=affectZ-zCoord;
			double distance=Math.sqrt(dX*dX+dY*dY+dZ*dZ);
			spawnParticle(new StraightEnchant(getWorldObj(),0.5+xCoord,0.5+yCoord,0.5+zCoord,0.1*dX/distance,0.1*dY/distance,0.1*dZ/distance,(int)Math.round(affectRemaining>10*distance?10*distance:affectRemaining)));
		}
	}
	
	@Override
	public boolean canUpdate() {
		return true;
	}
	
	/**
	 * Activates the block affection effect
	 * @param x 
	 * @param y
	 * @param z
	 * @param time
	 * @return true if effect was activated; false if not
	 */
	public boolean addBlockAffectEffect(int x,int y,int z,int time) {
		if(!getWorldObj().isRemote&&affectRemaining==0) {
			affectRemaining=time;
			affectX=x;
			affectY=y;
			affectZ=z;
			return true;
		}
		return false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("affectX", affectX);
		nbt.setInteger("affectY", affectY);
		nbt.setInteger("affectZ", affectZ);
		nbt.setInteger("affectRemaining", affectRemaining);
		NBTTagCompound hash=new NBTTagCompound();
		writeHashToNBT(hash);
		nbt.setCompoundTag("hash", hash);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		affectX=nbt.getInteger("affectX");
		affectY=nbt.getInteger("affectY");
		affectZ=nbt.getInteger("affectZ");
		affectRemaining=nbt.getInteger("affectRemaining");
		readHashFromNBT(nbt.getCompoundTag("hash"));
	}
}
