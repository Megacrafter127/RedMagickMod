package com.futurecraft.mod.witchery.block;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.alchemy.IManaContainer;

import cpw.mods.fml.common.FMLCommonHandler;

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
		if(!FMLCommonHandler.instance().getEffectiveSide().isServer()) return;
		EntityLivingBase e=event.entityLiving;
		float oDMG=event.ammount,tDMG=oDMG;
		if(e.getDistanceSq(xCoord, yCoord+0.5, zCoord)>10000) return;
		DamageSource d=event.source;
		EntityPlayer p=getWorldObj().getPlayerEntityByName(source);
		if(d.isMagicDamage()) {
			if(event.ammount<=magickStored) {
				magickStored-=event.ammount;
				event.ammount=0;
				event.setCanceled(true);
				if(p!=null) p.addChatMessage("Stored mana absorbed all damage("+ChatHelper.acf(""+oDMG, EnumChatFormatting.RED)+")\n"+ChatHelper.acf(""+magickStored, ChatHelper.ENUMARRAY_NUMBER)+" mana remaining.");
				return;
			}
			else {
				event.ammount-=magickStored;
				magickStored=0;
				if(p==null) return;
				p.addChatMessage("Stored mana absorbed "+ChatHelper.acf(""+(oDMG-event.ammount), EnumChatFormatting.RED)+" damage. "+ChatHelper.acf(""+event.ammount, EnumChatFormatting.RED)+" damage remaining.");
				oDMG=event.ammount;
				ItemStack[] inv=p.inventory.armorInventory;
				for(ItemStack s:inv) {
					if(s==null) continue;
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
								p.addChatMessage("Your armor's mana absorbed all damage("+ChatHelper.acf(""+oDMG, EnumChatFormatting.RED)+")");
								return;
							}
						}
					}
				}
				p.addChatMessage("Your defensive mana absorbed "+ChatHelper.acf(""+(oDMG-event.ammount), EnumChatFormatting.RED)+" damage. "+ChatHelper.acf(""+event.ammount, EnumChatFormatting.RED)+" damage remaining.");
				oDMG=event.ammount;
				inv=p.inventory.mainInventory;
				for(ItemStack s:inv) {
					if(s==null) continue;
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
								p.addChatMessage("Your mana absorbed all damage("+ChatHelper.acf(""+oDMG, EnumChatFormatting.RED)+")");
								return;
							}
						}
					}
				}
				p.addChatMessage("Your magick prevented "+ChatHelper.acf(""+(tDMG-event.ammount),EnumChatFormatting.RED)+" damage; "+ChatHelper.acf(""+event.ammount,EnumChatFormatting.RED)+" damage remains");
				p.addPotionEffect(new PotionEffect(Potion.blindness.id,10*(int)event.ammount,6*(int)event.ammount));
				p.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,10*(int)event.ammount,(int)event.ammount));
				p.addPotionEffect(new PotionEffect(Potion.digSlowdown.id,10*(int)event.ammount,(int)event.ammount));
				p.addPotionEffect(new PotionEffect(Potion.weakness.id,10*(int)event.ammount,(int)event.ammount));
				if(p.getHealth()>0&&!p.isEntityEqual(e)) {
					p.attackEntityFrom(DamageSource.generic, event.ammount);
					event.setCanceled(true);
				}
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
		return (!(protection&&magickStored>0))||p.username.equals(source);
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
	
	public boolean claim(EntityPlayer p) {
		if(protection&&magickStored>0) return false;
		source=p.username;
		protection=true;
		return true;
	}

	public float getMana() {
		return magickStored;
	}
}
