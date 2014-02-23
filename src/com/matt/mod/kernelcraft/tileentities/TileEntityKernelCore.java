package com.matt.mod.kernelcraft.tileentities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.tasks.KernelTask;

public class TileEntityKernelCore extends TileEntity {
	private LinkedList<int[]> affectList=new LinkedList<int[]>();
	private LinkedList<KernelTask> tasks=new LinkedList<KernelTask>();
	
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
	
	private TileEntityKernelModule module;
	
	public TileEntityKernelCore() {
	}
	@Override
	public void updateEntity() {
		try{
			if(module==null) module=(TileEntityKernelModule)getWorldObj().getBlockTileEntity(xCoord, yCoord-1, zCoord);
		}
		catch(ClassCastException ex) {
			System.err.println(ex);
		}
		addPermanentParticles();
		addAffectionParticles();
		while(!tasks.isEmpty()) {
			KernelTask t=tasks.element();
			if(t.finished()) {
				tasks.removeFirst();
			}
			else {
				t.run(this);
				break;
			}
		}
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
		for(int i=0;i<4;i++) {
			int dX=i%2==0?-2:2;
			int dZ=i/2==0?-2:2;
			distance=Math.sqrt(dX*dX+dZ*dZ+1);
			spawnParticle(new StraightEnchant(getWorldObj(),0.5+xCoord,0.5+yCoord,0.5+zCoord,0.1*dX/distance,-0.1/distance,0.1*dZ/distance,(int)Math.round(10*distance)));
		}
	}
	
	private void spawnParticle(EntityFX e) {
		Minecraft.getMinecraft().effectRenderer.addEffect(e);
	}
	
	private void addAffectionParticles() {
		LinkedList<int[]> toRemove=new LinkedList<int[]>();
		for(int[] affect:affectList) {
			if(affect[3]>0) {
				affect[3]--;
				int dX=affect[0]-xCoord;
				int dY=affect[1]-yCoord;
				int dZ=affect[2]-zCoord;
				double distance=Math.sqrt(dX*dX+dY*dY+dZ*dZ);
				spawnParticle(new StraightEnchant(getWorldObj(),0.5+xCoord,0.5+yCoord,0.5+zCoord,0.1*dX/distance,0.1*dY/distance,0.1*dZ/distance,(int)Math.round(affect[3]>10*distance?10*distance:affect[3])));
			}
			else toRemove.add(affect);
		}
		affectList.removeAll(toRemove);
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
		if(!getWorldObj().isRemote&&time>0) {
			affectList.add(new int[]{x,y,z,time});
			return true;
		}
		return false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("affectsize",affectList.size());
		int c=0;
		for(int[] i:affectList) {
			nbt.setIntArray("affect."+c, i);
			c++;
		}
		nbt.setInteger("tasksize", tasks.size());
		c=0;
		for(KernelTask t:tasks) {
			NBTTagCompound taskNBT=new NBTTagCompound();
			t.writeToNBT(taskNBT);
			nbt.setCompoundTag("task."+c, taskNBT);
			c++;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		LinkedList<int[]> replacement=new LinkedList<int[]>();
		int max=nbt.getInteger("affectsize");
		for(int i=0;i<max;i++) {
			replacement.add(nbt.getIntArray("affect."+i));
		}
		LinkedList<KernelTask> taskReplacement=new LinkedList<KernelTask>();
		max=nbt.getInteger("tasksize");
		replacement=new LinkedList<int[]>();
		for(int i=0;i<max;i++) {
			KernelTask t=KernelTask.loadTaskFromNBT(nbt.getCompoundTag("task."+i));
			if(t!=null) {
				taskReplacement.add(t);
			}
		}
		tasks=taskReplacement;
	}
	
	public void enqueueTask(KernelTask t) {
		if(t==null) return;
		if(t.finished()) return;
		tasks.add(t);
	}
	
	public void destroyBlock(int x,int y,int z,Boolean silk) {
		if(getWorldObj().isRemote) return;
		ItemStack[] ret=new ItemStack[0];
		Block b=Block.blocksList[getWorldObj().getBlockId(x, y, z)];
		if(silk==null) {
			try{
				ret=new ItemStack[]{b.getPickBlock(null, getWorldObj(), x, y, z)};
			}
			catch(NullPointerException ex) {
				ret=new ItemStack[]{new ItemStack(b.idPicked(getWorldObj(), x, y, z),1,getWorldObj().getBlockMetadata(x, y, z))};
			}
		}
		else if(silk) {
			ArrayList<ItemStack> list=b.getBlockDropped(getWorldObj(), x, y, z, getWorldObj().getBlockMetadata(x, y, z), new Random().nextInt());
			ret=list.toArray(new ItemStack[list.size()]);
		}
		else {
			ret=new ItemStack[]{new ItemStack(getWorldObj().getBlockId(x, y, z),1,getWorldObj().getBlockMetadata(x, y, z))};
		}
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				for(int k=-2;k<2;k++) {
					try{
						IInventory inv=(IInventory)getWorldObj().getBlockTileEntity(xCoord+i, yCoord+k, zCoord+j);
						for(ItemStack stack:ret) {
							for(int l=0;l<inv.getSizeInventory();l++) {
								if(stack==null) break;
								if(inv.isItemValidForSlot(l, stack)) {
									ItemStack stack2=inv.getStackInSlot(l);
									if(stack2.itemID==stack.itemID&&stack2.getItemDamage()==stack.getItemDamage()) {
										stack2.stackSize+=stack.stackSize;
										if(stack2.stackSize>stack2.getMaxStackSize()) {
											stack.stackSize=stack2.stackSize-stack2.getMaxStackSize();
											stack2.stackSize=stack2.getMaxStackSize();
										}
										else {
											stack=null;
										}
									}
								}
							}
						}
					}
					catch(ClassCastException ex) {}
					catch(NullPointerException ex) {}
				}
			}
		}
		for(ItemStack stack:ret) {
			if(stack!=null) getWorldObj().spawnEntityInWorld(new EntityItem(getWorldObj(),x+0.5,y+0.5,z+0.5,stack));
		}
		getWorldObj().setBlockToAir(x, y, z);
	}
}
