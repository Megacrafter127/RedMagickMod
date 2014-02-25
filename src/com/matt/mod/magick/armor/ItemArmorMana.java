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
	 /*
	 @Override
	 public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemstack) {
		 
		ItemStack helmPiece = player.getCurrentArmor(0);
		ItemStack chestPiece = player.getCurrentArmor(1);
		ItemStack legPiece = player.getCurrentArmor(2);
		ItemStack bootPiece = player.getCurrentArmor(3);
		if(bootPiece != null) {
			System.out.println("Helm piece id" + helmPiece.itemID);
			if(bootPiece.itemID == ArmorHelper.manaBoots.itemID) {
				System.out.println("Armor Tick - Bootpiece was called!");
				player.fallDistance = 0;
				} else {
					return;
				}
			
		}
		if(legPiece != null) {
			System.out.println("Leg piece id" + legPiece.itemID);
			if(legPiece.itemID == ArmorHelper.manaLegs.itemID) {
				System.out.println("Armor Tick - Legpiece was called!");
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 0, 200)); 
			} else {
				return;
			}
		}
		if(chestPiece != null) {
			System.out.println("Chest piece id" + chestPiece.itemID);
			if(chestPiece.itemID == ArmorHelper.manaChest.itemID) {
				System.out.println("Armor Tick - Chestpiece was called!");
				player.capabilities.allowFlying = true;
				} else {
					player.capabilities.allowFlying = false;
				}
		}
		if(helmPiece != null) {
			System.out.println("Helm piece id" + helmPiece.itemID);
			if(helmPiece.itemID == ArmorHelper.manaHelm.itemID) {
				if(player.isInWater()) {
					System.out.println("Armor Tick - Helmpiece was called!");
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),0,1));
				}else{
					player.removePotionEffect(Potion.nightVision.getId());
				}
				} else {
					
				} */
		
}
	 

