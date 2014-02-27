package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import org.lwjgl.input.Keyboard;

import com.matt.lib.Ref;
import com.matt.mod.magick.MagickHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagickWand extends Item {
	public static boolean isInWandRecharger = false;
	int tickCount;
	static int[] mana = new int[10];
	public static int currentCharge = 1;
	public static String[] names=new String[10];
	/**
	 * @author Megacrafter127
	 */
	static{
		names[0] = "Iron-Cored Birch Magical Staff";
		names[1] = "Golden-Cored Oak Magical Staff";
		names[2] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";
	}

	public static final String[] stnames = new String[]{"Lesser","Medium","Greater"};
	public ItemMagickWand(int par1) {
		super(par1);
		//names = new String[10]; why should the static variable be overritten by a constructor, that might be called multiple times
		/*names[0] = "Iron-Cored Birch Magical Staff";
		names[1] = "Golden-Cored Oak Magical Staff";
		names[2] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";*/
		
		this.setUnlocalizedName(getUnlocalizedName(new ItemStack(this)));
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(Ref.getRecommendedTab("block"));
	}
	@SideOnly(Side.CLIENT)
	Icon[] icons;
	@SideOnly(Side.CLIENT)
	
	/**
	 * @author Matheus
	 * @param par1 - The item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		return this.icons[par1];
		//return this.icons[getLevel(par1)];
	}
	
	public String getUnlocalizedName(ItemStack par1ItemStack){
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(),0,15);
		return super.getUnlocalizedName() + "." + names[i];
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tabs, List list){
		
		for(int i = 0; i < 3; ++i){
			list.add(new ItemStack(itemID, 1, i));
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		icons = new Icon[4];
		for(int i = 0;i < icons.length; i++) {
			String[] texturenames = new String[]{"iron","gold","nethend","shizzle"};
			Icon ic = r.registerIcon(Ref.NAME.toLowerCase() + ":" + texturenames[i]);
			icons[i] = ic;
			
		}
	}
	@SideOnly(Side.CLIENT)
	public Icon getItemIconFromDamage(int par1IconIndex) {
		return this.getIconFromDamage(par1IconIndex);
	}
	public int getMagickStorage(int par1ItemDamage) {
		if(par1ItemDamage == 0 ) {
			return 100;
		} else if(par1ItemDamage == 1) {
			return 1000;
		} else if(par1ItemDamage == 2 ) {
			return 10000;
		}
		return par1ItemDamage;
		
	}
	/* @Override
	        @SideOnly(Side.CLIENT)
	        public void addInformation(ItemStack par1ItemStack,
	                  EntityPlayer par2EntityPlayer,
	                  List par3List,
	                  boolean par4) {
	        	 super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	        	 NBTTagList nbttaglist = (NBTTagList)par1ItemStack.stackTagCompound.getTag("info");
	             if (nbttaglist != null)
	             {
	                 for (int i = 0; i < nbttaglist.tagCount(); ++i)
	                 {
	                     short short1 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("id");
	                     short short2 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("lvl");

	                     if (Enchantment.enchantmentsList[short1] != null)
	                     {
	                         par3List.add(Enchantment.enchantmentsList[short1].getTranslatedName(short2));
	                     }
	                 
	            	 int i = (((NBTTagCompound) nbttaglist.tagAt(1)).getInteger("storage"));
	            	 par3List.add(stnames[i]);
	             }
	        }*/
	        @Override
	        public boolean hasEffect(ItemStack par1ItemStack) {
	        	return true;
	        }
	        /*Deprecated
	        @Override
	        public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
	        {
				return bFull3D;
	        	/*try {
	        	//The pokemon master!
	        	writeToNBT(par1ItemStack);
	        	readFromNBT(par1ItemStack);
	        	return true;
	        	}catch(Throwable t) {
	        		t.printStackTrace();
	        		return false;
	        	} *
	        }	    */ 
	      //called when the item is used (right click) return true if something happens, false if nothing happens (if something happens the animation will trigger)
	       /* public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10) {
	        	if(par3World.getBlockId(x,y,z) == SwagHelper.manaBattery.blockID) {
	        		tickCount++;
	            	// Get a static entity
	            	//Get current biome
	        		Entity e = (Entity)par2EntityPlayer;
	            	BiomeGenBase b = par3World.provider.worldChunkMgr.getBiomeGenAt((int)e.posX, (int)e.posZ);
	            	//Increments mana by niome
	            	if(tickCount == 1) {
	            			Type[] t = BiomeDictionary.getTypesForBiome( b );
	            			for(Type type : t) {
	            				if(type == Type.WATER) {
	            					mana[5]++;
	            				} else if(type == Type.DESERT) {
	            					mana[4]++;
	            				} else if(type == Type.HILLS){
	            					mana[6]++;
	            				} else if( type == Type.FOREST) {
	            					mana[6] = mana[6] + 2;
	            				} else if( type == Type.SWAMP ) {
	            					mana[6]++;
	            					mana[5]++;
	            				} else if ( type == Type.NETHER){
	            					mana[4]+=5;
	            				
	            				} else if(type == Type.END) {
	            					mana[2]+=10;
	            				} else {
	            					mana[3]++;
	            				}
	            			}
	            			if(par3World.isDaytime()) {	      
        						mana[0]++;
        						//mana[2]++;
        					}else{
        						mana[1]++;
        						//mana[3]++;
        					}
	            			mana[8]+=1;
	            			par1ItemStack.stackTagCompound.setInteger("light",mana[0]);
	    	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2]);
	    	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4]);
	    	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6]);
	    	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8]);
	    	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9]);
	          
	            		tickCount = 0;
	            	}
	        	}
	        	return false; 
	        	
	        } */

	        /**
	             * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	             * update it's contents.
	             */
	            public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
	            	tickCount++;
	            	
	            	Entity e = par3Entity;
	            	BiomeGenBase b = par2World.provider.worldChunkMgr.getBiomeGenAt((int)e.posX, (int)e.posZ);
	            	
	            	if(isInWandRecharger) {
	            		try {
		            		if(par1ItemStack.stackTagCompound != null) {
		            		mana[0] = 0;
		            		mana[1] = 0;
		            		mana[2] = 0;
		            		mana[3] = 0;
		            		mana[4] = 0;
		            		mana[5] = 0;
		            		mana[6] = 0;
		            		mana[7] = 0;
		            		mana[8] = 0;
		            		mana[9] = 0;
		            		// Load all manas
		            	mana[0] = par1ItemStack.stackTagCompound.getInteger("light");
		            	mana[1] = par1ItemStack.stackTagCompound.getInteger("dark");
		            	mana[2] = par1ItemStack.stackTagCompound.getInteger("magic");
		            	mana[3] = par1ItemStack.stackTagCompound.getInteger("null");
		            	mana[4] = par1ItemStack.stackTagCompound.getInteger("fire");
		            	mana[5] = par1ItemStack.stackTagCompound.getInteger("water");
		            	mana[6] = par1ItemStack.stackTagCompound.getInteger("air");
		            	mana[7] = par1ItemStack.stackTagCompound.getInteger("earth");
		            	mana[8] = par1ItemStack.stackTagCompound.getInteger("life");
		            	mana[9] = par1ItemStack.stackTagCompound.getInteger("death");
		            	//Tick
		            	tickCount++;
		            	// Get a static entity
		            	
		            	//Get current biome
		            	
		            	//Increments mana by niome
		            	
		            	if(tickCount == 10) {
		            			Type[] t = BiomeDictionary.getTypesForBiome(b);
		            			for(Type type : t) {
		            				if(type == Type.WATER) {
		            					mana[5]++;
		            				} else if(type == Type.DESERT) {
		            					mana[4]++;
		            				} else if(type == Type.HILLS){
		            					mana[6]++;
		            				} else if( type == Type.FOREST) {
		            					mana[6] = mana[6] + 2;
		            				} else if( type == Type.SWAMP ) {
		            					mana[6]++;
		            					mana[5]++;
		            				} else if ( type == Type.NETHER){
		            					mana[4]+=5;
		            				
		            				} else if(type == Type.END) {
		            					mana[2]+=10;
		            				} else {
		            					mana[3]++;
		            				}
		            			}
		            			if(par2World.isDaytime()) {	      
	        						mana[0]++;
	        						//mana[2]++;
	        					}else{
	        						mana[1]++;
	        						//mana[3]++;
	        					}
		            			mana[8]+=1;
		            			par1ItemStack.stackTagCompound.setInteger("light",mana[0]);
		    	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1]); 
		    	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2]);
		    	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3]); 
		    	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4]);
		    	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5]); 
		    	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6]);
		    	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7]); 
		    	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8]);
		    	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9]);
		          
		            		tickCount = 0;
		            	}
		            		}}catch(Throwable t) {
		            			
		            		}}else {
	            	
	            	try {
	            		if(par1ItemStack.stackTagCompound != null) {
	            		mana[0] = 0;
	            		mana[1] = 0;
	            		mana[2] = 0;
	            		mana[3] = 0;
	            		mana[4] = 0;
	            		mana[5] = 0;
	            		mana[6] = 0;
	            		mana[7] = 0;
	            		mana[8] = 0;
	            		mana[9] = 0;
	            		// Load all manas
	            	mana[0] = par1ItemStack.stackTagCompound.getInteger("light");
	            	mana[1] = par1ItemStack.stackTagCompound.getInteger("dark");
	            	mana[2] = par1ItemStack.stackTagCompound.getInteger("magic");
	            	mana[3] = par1ItemStack.stackTagCompound.getInteger("null");
	            	mana[4] = par1ItemStack.stackTagCompound.getInteger("fire");
	            	mana[5] = par1ItemStack.stackTagCompound.getInteger("water");
	            	mana[6] = par1ItemStack.stackTagCompound.getInteger("air");
	            	mana[7] = par1ItemStack.stackTagCompound.getInteger("earth");
	            	mana[8] = par1ItemStack.stackTagCompound.getInteger("life");
	            	mana[9] = par1ItemStack.stackTagCompound.getInteger("death");
	            	//Tick
	            	tickCount++;
	            	// Get a static entity
	            	
	            	//Get current biome
	            	
	            	//Increments mana by niome
	            	
	            	if(tickCount == 1000) {
	            			Type[] t = BiomeDictionary.getTypesForBiome(b);
	            			for(Type type : t) {
	            				if(type == Type.WATER) {
	            					mana[5]++;
	            				} else if(type == Type.DESERT) {
	            					mana[4]++;
	            				} else if(type == Type.HILLS){
	            					mana[6]++;
	            				} else if( type == Type.FOREST) {
	            					mana[6] = mana[6] + 2;
	            				} else if( type == Type.SWAMP ) {
	            					mana[6]++;
	            					mana[5]++;
	            				} else if ( type == Type.NETHER){
	            					mana[4]+=5;
	            				
	            				} else if(type == Type.END) {
	            					mana[2]+=10;
	            				} else {
	            					mana[3]++;
	            				}
	            			}
	            			if(par2World.isDaytime()) {	      
        						mana[0]++;
        						//mana[2]++;
        					}else{
        						mana[1]++;
        						//mana[3]++;
        					}
	            			mana[8]+=1;
	            			par1ItemStack.stackTagCompound.setInteger("light",mana[0]);
	    	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2]);
	    	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4]);
	    	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6]);
	    	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8]);
	    	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9]);
	          
	            		tickCount = 0;
	            	}
	            	par1ItemStack.stackTagCompound = new NBTTagCompound();
	            	par1ItemStack.stackTagCompound.setInteger("light",mana[0]);
	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1]); 
	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2]);
	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3]); 
	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4]);
	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5]); 
	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6]);
	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7]); 
	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8]);
	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9]);
	            		}else {
	            			par1ItemStack.stackTagCompound = new NBTTagCompound();
	    	            	par1ItemStack.stackTagCompound.setInteger("light",mana[0]);
	    	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2]);
	    	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4]);
	    	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6]);
	    	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7]); 
	    	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8]);
	    	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9]);
	            		} 
	            	
	            		}catch(Throwable t){
	            	t.printStackTrace();
	            }finally {
	            	return;
	            }
	            	}
	            		
	            		} 	            	
	            		
	            	

	            

	        /**
	             * Called when item is crafted/smelted. Used only by maps so far.
	             */
	            public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	            	super.onCreated(par1ItemStack,par2World, par3EntityPlayer);
	            	par1ItemStack.stackTagCompound = new NBTTagCompound();
	            	
	            	par1ItemStack.stackTagCompound.setInteger("light",mana[0] + 1);
	            	par1ItemStack.stackTagCompound.setInteger("dark",mana[1] + 1); 
	            	par1ItemStack.stackTagCompound.setInteger("magic",mana[2] + 1);
	            	par1ItemStack.stackTagCompound.setInteger("null",mana[3] + 1); 
	            	par1ItemStack.stackTagCompound.setInteger("fire",mana[4] + 1);
	            	par1ItemStack.stackTagCompound.setInteger("water",mana[5] + 1); 
	            	par1ItemStack.stackTagCompound.setInteger("air",mana[6] + 1);
	            	par1ItemStack.stackTagCompound.setInteger("earth",mana[7] + 1); 
	            	par1ItemStack.stackTagCompound.setInteger("life",mana[8] + 1);
	            	par1ItemStack.stackTagCompound.setInteger("death",mana[9] + 1);
	            }

	        /**
	             * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	             */
	            public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {}

	        /**
	             * allows items to add custom lines of information to the mouseover description
	             */
	            public void addInformation(ItemStack itemStack, EntityPlayer player,
                        
	            		List list, boolean par4) {
	            	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
	            	   if (itemStack.stackTagCompound != null) { 
	            		 
	            		   list.add(EnumChatFormatting.BLUE + "Current Fos level :  " +itemStack.stackTagCompound.getInteger("light"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Skotadi level :  " +itemStack.stackTagCompound.getInteger("dark"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Mageia level:  " +itemStack.stackTagCompound.getInteger("magic"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Akyrosi level :  " +itemStack.stackTagCompound.getInteger("null"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Fotia power :  " +itemStack.stackTagCompound.getInteger("fire"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Nero power :  " +itemStack.stackTagCompound.getInteger("water"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Aeras power :  " +itemStack.stackTagCompound.getInteger("air"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Gaias power :  " +itemStack.stackTagCompound.getInteger("earth"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Zoi power :  " +itemStack.stackTagCompound.getInteger("life"));
	            		   list.add(EnumChatFormatting.BLUE + "Current Deisidaimonia power :  " +itemStack.stackTagCompound.getInteger("death"));
	            		   
	            		   if(itemStack.getItemDamage() == 0) {
	            			   list.add(EnumChatFormatting.GREEN + "Maximum discharge : 10");
	            			  
	            		   }else  if(itemStack.getItemDamage() == 1) {
	            			   list.add(EnumChatFormatting.GREEN + "Maximum discharge : 100");
	            		   } if(itemStack.getItemDamage() == 2) {
	            			   list.add(EnumChatFormatting.GREEN + "Maximum discharge : 500");
	            		   }
	            		  // list.add(EnumChatFormatting.GRAY + "Tick count : " + tickCount);
	            		
	            	   }} else
	            	   {
	            		   if (itemStack.stackTagCompound != null) { 
	            			   list.add(EnumChatFormatting.GRAY + "Hold shift to see details");
	            		   }
	            	   }
	            	
	            }

	        /**
	             * Returns true if players can use this item to affect the world (e.g. placing blocks, placing ender eyes in portal)
	             * when not in creative
	             */
	            public boolean canItemEditBlocks() {
					return false; }

	        /**
	             * This is called when the item is used, before the block is activated.
	             * @param stack The Item Stack
	             * @param player The Player that used the item
	             * @param world The Current World
	             * @param x Target X Position
	             * @param y Target Y Position
	             * @param z Target Z Position
	             * @param side The side of the target hit
	             * @return Return true to prevent any further processing.
	             */
	            public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
					return true;
	            	
} }

