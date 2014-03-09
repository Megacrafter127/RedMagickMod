package com.matt.mod.magick.armor;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;

import org.lwjgl.input.Keyboard;

import com.matt.lib.Ref;
import com.matt.mod.generic.helpers.ChatHelper;
import com.matt.mod.magick.ArmorHelper;
import com.matt.mod.magick.MagickHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorMana extends ItemArmor {
	 private float walkSpeed = 0.1F;
	  public static final String[] armorNames = new String[] {"manaHelm", "manaChest", "manaLegs", "manaBoots"};
	public static final EnumArmorMaterial mana = EnumHelper.addArmorMaterial("Mana", 100000, new int[]{300,800,600,300}, 1000);
	public ItemArmorMana(int par1, 
			int par3, int par4) {
		super(par1, mana, 0, par4);
		
	}
	public ItemArmorMana(int id) {
		super(id,mana,0,0);
		setCreativeTab(Ref.getRecommendedTab("item"));
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
		 if(player.inventory.hasItem(MagickHelper.manaDust.itemID)) {
		 for(ItemStack stack : armor) {
			if(stack != null && !world.isRemote) {
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
					player.setAbsorptionAmount(20.0F);
				
				}else{
					player.setAbsorptionAmount(0F);
				}	
			 }
			 if(stack.itemID == ArmorHelper.manaLegs.itemID) {
				 boolean isLeg = stack.itemID == ArmorHelper.manaLegs.itemID;
				 if(isLeg) {
					
						 player.capabilities.setPlayerWalkSpeed(0.5F);
					 }else {
						 player.capabilities.setPlayerWalkSpeed(walkSpeed);
					 }
					
				 }else{
					 player.capabilities.setPlayerWalkSpeed(walkSpeed);
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
		 
	 
	 @Override
	 @SideOnly(Side.CLIENT)
     public void addInformation(ItemStack par1ItemStack,
               EntityPlayer par2EntityPlayer,
               List par3List,
               boolean par4) {
		
		if(par1ItemStack.getItem() instanceof ItemArmorMana) {
			ItemArmorMana m = (ItemArmorMana) par1ItemStack.getItem();
			if(m.armorType == 0) {
				par3List.add(ChatHelper.customHTT("Magical Helmet? Night Vision? F. Yea.",Ref.STRING_WITTY_COMMENT,Keyboard.KEY_LSHIFT,EnumChatFormatting.GOLD));
				
			}else if(m.armorType == 1) {
				par3List.add(ChatHelper.customHTT("Magical Chestplate? Invulnerable? F. Yea.",Ref.STRING_WITTY_COMMENT,Keyboard.KEY_LSHIFT,EnumChatFormatting.GOLD));
				
				
			}else if(m.armorType == 2) {
				
				par3List.add(ChatHelper.customHTT("Magical Legs? Run super fast? F. Yea.",Ref.STRING_WITTY_COMMENT,Keyboard.KEY_LSHIFT,EnumChatFormatting.GOLD));
			}else if(m.armorType == 3) {
				par3List.add(ChatHelper.customHTT("Magical Boots? Never take fall damage? F. Yea.",Ref.STRING_WITTY_COMMENT,Keyboard.KEY_LSHIFT,EnumChatFormatting.GOLD));
				
				
			}
			
		}
			
	
	 }
	 /**
	  * Callback for item usage
	  */
	 @Override
	
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
		 ItemStack tomeStack = new ItemStack(Item.writableBook);
		 NBTTagList bookPages = new NBTTagList("pages");
		 bookPages.appendTag(new NBTTagString("1", "The Mana Armor, a very powerful armor, is crafted from Mageia Skoni, and can be upgraded using runes.."));
		 bookPages.appendTag(new NBTTagString("2", "This armor makes you run super fast, and basically invulnerable, if you have Skoni on your inventory. ."));
		 bookPages.appendTag(new NBTTagString("3", "The runic upgrade also protects you from withering."));
		 tomeStack.setTagInfo("pages", bookPages);
		 tomeStack.setTagInfo("author", new NBTTagString("author", "The Creator"));
		 tomeStack.setTagInfo("title", new NBTTagString("title", "Mana Armor! - All about it."));
		 tomeStack.itemID = Item.writtenBook.itemID;
		 if( !(par2EntityPlayer.inventory.hasItemStack(tomeStack))){
		 
		 par2EntityPlayer.inventory.addItemStackToInventory(tomeStack);
		 return false;
		 }
		 return true;
	 	}
	 
	 }
	 

