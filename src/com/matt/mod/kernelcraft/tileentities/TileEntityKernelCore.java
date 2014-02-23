package com.matt.mod.kernelcraft.tileentities;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.tasks.KernelTask;

import cpw.mods.fml.common.network.PacketDispatcher;

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
		boolean send=false;
		while(!tasks.isEmpty()) {
			KernelTask t=tasks.element();
			if(t.finished()) {
				tasks.removeFirst();
				send=true;
			}
			else {
				t.run(this);
				break;
			}
		}
		if(send) {
			sendChangeToServer();
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
		sendChangeToServer();
	}
	
	public void destroyBlock(int x,int y,int z) {
		ItemStack ret=new ItemStack(getWorldObj().getBlockId(x, y, z),1,getWorldObj().getBlockMetadata(x, y, z));
		try{
			if(Item.itemsList[ret.itemID]==null) {
				return;
			}
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			return;
		}
		L:for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				for(int k=-2;k<2;k++) {
					try{
						IInventory inv=(IInventory)getWorldObj().getBlockTileEntity(xCoord+i, yCoord+k, zCoord+j);
						for(int l=0;l<inv.getSizeInventory();l++) {
							if(inv.isItemValidForSlot(l, ret)) {
								ItemStack stack2=inv.getStackInSlot(l);
								if(stack2.itemID==ret.itemID&&stack2.getItemDamage()==ret.getItemDamage()) {
									stack2.stackSize+=ret.stackSize;
									if(stack2.stackSize>stack2.getMaxStackSize()) {
										ret.stackSize=stack2.stackSize-stack2.getMaxStackSize();
										stack2.stackSize=stack2.getMaxStackSize();
									}
									else {
										ret=null;
										break L;
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
		if(ret!=null) getWorldObj().spawnEntityInWorld(new EntityItem(getWorldObj(),x+0.5,y+0.5,z+0.5,ret));
		getWorldObj().setBlockToAir(x, y, z);
		System.out.println("mining");
	}
	
	public void sendChangeToServer() {
		Packet250CustomPayload packet=new Packet250CustomPayload();
		packet.channel="KernelCoreUpdate";
		NBTTagCompound nbt=new NBTTagCompound();
		writeToNBT(nbt);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		DataOutputStream output=new DataOutputStream(out);
		try{
			output.writeInt(xCoord);
			output.writeInt(yCoord);
			output.writeInt(zCoord);
			byte[] b=CompressedStreamTools.compress(nbt);
			output.writeInt(b.length);
			output.write(b);
			output.close();
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
		packet.data=out.toByteArray();
		packet.length=out.size();
		PacketDispatcher.sendPacketToServer(packet);
	}
}
