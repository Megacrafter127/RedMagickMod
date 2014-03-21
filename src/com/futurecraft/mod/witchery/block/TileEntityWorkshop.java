package com.futurecraft.mod.witchery.block;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.futurecraft.mod.magick.alchemy.IManaContainer;

public class TileEntityWorkshop extends TileEntity {
	private float magickStored;
	private String source="";
	private boolean protection;
	
	public TileEntityWorkshop() {
		validate();
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setFloat("magick", magickStored);
		nbt.setString("source", source);
		nbt.setBoolean("protection", protection);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		magickStored=nbt.getFloat("magick");
		source=nbt.getString("source");
		protection=nbt.getBoolean("protection");
	}
	
	@ForgeSubscribe
	public void preventDamage(LivingHurtEvent event) {
		EntityLivingBase e=event.entityLiving;
		if(e.getDistanceSq(xCoord, yCoord+0.5, zCoord)>10000) return;
		DamageSource d=event.source;
		if(d.isMagicDamage()) {
			if(event.ammount<=magickStored) {
				magickStored-=event.ammount;
				event.ammount=0;
				event.setCanceled(true);
				return;
			}
			else {
				event.ammount-=magickStored;
				magickStored=0;
				EntityPlayer p=getWorldObj().getPlayerEntityByName(source);
				if(p==null) return;
				ItemStack[] inv=p.inventory.armorInventory;
				for(ItemStack s:inv) {
					Item it=s.getItem();
					if(it instanceof IManaContainer) {
						int m=((IManaContainer)it).getManaTypeCount(s);
						for(int i=0;i<m;i++) {
							event.ammount-=((IManaContainer) it).useMana(s, i, (int)event.ammount+1);
							if(event.ammount<0) ((IManaContainer) it).useMana(s, i, -1);
							event.ammount=(int)event.ammount;
							if(event.ammount<=0) {
								event.setCanceled(true);
								event.ammount=0;
								p.inventory.inventoryChanged=true;
								return;
							}
						}
					}
				}
				inv=p.inventory.mainInventory;
				for(ItemStack s:inv) {
					Item it=s.getItem();
					if(it instanceof IManaContainer) {
						int m=((IManaContainer)it).getManaTypeCount(s);
						for(int i=0;i<m;i++) {
							event.ammount-=((IManaContainer) it).useMana(s, i, (int)event.ammount+1);
							if(event.ammount<0) ((IManaContainer) it).useMana(s, i, -1);
							event.ammount=(int)event.ammount;
							if(event.ammount<=0) {
								event.setCanceled(true);
								event.ammount=0;
								p.inventory.inventoryChanged=true;
								return;
							}
						}
					}
				}
				p.addExhaustion(event.ammount);
			}
		}
	}
	
	@Override
	public void invalidate() {
		MinecraftForge.EVENT_BUS.unregister(this);
		super.invalidate();
	}
	
	@Override
	public void validate() {
		MinecraftForge.EVENT_BUS.register(this);
		super.validate();
	}
	
	public boolean canSpend(EntityPlayer p) {
		return (!protection)||p.getEntityName().equals(source);
	}
	
	public void spend(int mana) {
		if(mana==0) return;
		if(magickStored+mana<0) {
			spend(mana/2);
			spend(mana/2);
			return;
		}
		magickStored+=mana;
	}
}
