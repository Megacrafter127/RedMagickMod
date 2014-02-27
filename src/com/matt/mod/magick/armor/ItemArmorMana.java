package com.matt.mod.magick.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;

import com.matt.lib.Ref;
import com.matt.mod.magick.ArmorHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorMana extends ItemArmor {
	  public static final String[] armorNames = new String[] {"manaHelm", "manaChest", "manaLegs", "manaBoots"};
	public static final EnumArmorMaterial mana = EnumHelper.addArmorMaterial("Mana", 100000, new int[]{300,800,600,300}, 1000);
	public ItemArmorMana(int par1, 
			int par3, int par4) {
		super(par1, mana, 0, par4);
		
	}
	public ItemArmorMana(int id) {
		super(id,mana,0,0);
	}
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        if(this.armorType == 0) {
	        	this.itemIcon = par1IconRegister.registerIcon(Ref.NAME.toLowerCase() + ":" + "helm");
	        } else if(this.armorType == 1) {
	        	this.itemIcon = par1IconRegister.registerIcon(Ref.NAME.toLowerCase() + ":" + "chest");
	        } else if(this.armorType == 2) {
	        	this.itemIcon = par1IconRegister.registerIcon(Ref.NAME.toLowerCase() + ":" + "legs");
	        } else if(this.armorType == 3) {
	        	this.itemIcon = par1IconRegister.registerIcon(Ref.NAME.toLowerCase() + ":" + "boots");
	        }
	       
	        		
	    }
	 @Override
	 public int getColor(ItemStack par1ItemStack) {
		return 11751612;
		 
	 }
	 
	 @Override
	 public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemstack) {
		 ItemStack[] armor = new ItemStack[4];
		 armor[0] = player.getCurrentArmor(0);
		 armor[1] = player.getCurrentArmor(1);
		 armor[2] = player.getCurrentArmor(2);
		 armor[3] = player.getCurrentArmor(3);
		 
		 for(ItemStack stack : armor) {
			if(stack != null && world.isRemote) {
			 if(stack.itemID == ArmorHelper.manaHelm.itemID) {
				 boolean isHelm = stack.itemID == ArmorHelper.manaHelm.itemID;
				 if(isHelm) {
					 player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),1,0));
					 
				 }else{
					 player.removePotionEffect(Potion.nightVision.getId());
				 }
				 
			 }
			 if(stack.itemID == ArmorHelper.manaChest.itemID) {
				 boolean isPlate = stack.itemID == ArmorHelper.manaChest.itemID;
				if(isPlate) {
					player.setHealth(player.getMaxHealth() *2);
				
				}else{
					player.setHealth(player.getMaxHealth());
				}	
			 }
			 if(stack.itemID == ArmorHelper.manaLegs.itemID) {
				 boolean isLeg = stack.itemID == ArmorHelper.manaLegs.itemID;
				 if(isLeg) {
					 player.capabilities.setPlayerWalkSpeed(2.0F);
				 }else{
					 player.capabilities.setPlayerWalkSpeed(0.1F);
				 }
			 }	
			 if(stack.itemID == ArmorHelper.manaBoots.itemID) {
				 boolean isBoot = stack.itemID == ArmorHelper.manaBoots.itemID;
				 if(isBoot) {
					 player.fallDistance = 0.0F;
					

				 }else{
					 player.fallDistance = player.fallDistance;
				 }
			 }		
		 }
		 }
		 
	 }
	 }
	 

