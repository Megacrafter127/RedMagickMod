package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.EnumHelper;

import org.lwjgl.input.Keyboard;

import com.matt.mod.ModHelper;
import com.matt.mod.generic.helpers.ChatHelper;

public class MinerTool extends ItemTool {
	static int earthMana;
	static int magick;
	static Block[] arrayOfBlocks = new  Block[]{Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, 
		Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, 
		Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis,
		Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator, 
		Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, 
		Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, 
		Block.mycelium, Block.bedrock,Block.netherBrick,Block.blockRedstone,Block.netherFence,
		Block.fenceGate,ModHelper.oreRoent, ModHelper.oreIndium};
	static final EnumToolMaterial Magick = EnumHelper.addToolMaterial("magickMaterial", 5, Integer.MAX_VALUE, 70.5F, 50.0F, 100);
	public MinerTool(int par1) {
		super(par1,1000F, Magick, Block.blocksList);
	}
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(!player.isSneaking()) {
    		if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
    	for(int i = x; i < x + 3; i++) {
    		for(int j = y; j < y + 3; j++) {
    			for(int k = z; k < z + 3; k++) {
    				try {
    					for(Block b : arrayOfBlocks) {
    						
	    						if(world.getBlockId(i,j,k) == b.blockID) {
	    							player.inventory.addItemStackToInventory(new ItemStack(Block.blocksList[world.getBlockId(i,j,k)]));
	    		    				world.setBlockToAir(i,j,k);
	    		    				stack.damageItem(9,player);
	    						}else {
	    							
	    						}
    						
    					}
    				
    				System.out.println("Coord X " + i + " Coord Y " + j + "Coord Z " + k);
    				}catch(Throwable t) {
    					System.out.println("Error on futurecraft's MinerTool. Line : 42. Error : " + t.getMessage());
    				}
    			}
    			
    		}
    	}
    		}else {
    			for(Block b : arrayOfBlocks) {
					
					if(world.getBlockId(x,y,z) == b.blockID) {
						player.inventory.addItemStackToInventory(new ItemStack(Block.blocksList[world.getBlockId(x,y,z)]));
	    				world.setBlockToAir(x,y,z);
	    				stack.damageItem(9,player);
					}else {
						
					}
				
    		}
    		}}else {
    		if(player.inventory.hasItemStack(new ItemStack(Block.glowStone)) ) {
    			world.setBlock(x,y,z,Block.glowStone.blockID);
    			player.inventory.consumeInventoryItem(Block.glowStone.blockID);
    		}
    	}
    	
    	
  
    	
    	
    	
        return false;
    }
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(par1ItemStack != null) {
    		par3List.add("Can mine almost every block.");
    		par3List.add("Wont mine normally, just with right-click.");
    	 	par3List.add(ChatHelper.acf("When shift+right click, will consume and place glowstone.",EnumChatFormatting.YELLOW));
    		par3List.add(ChatHelper.acf("On right click, will mine in a 3x3x3 wall.",EnumChatFormatting.RED));
    		par3List.add(ChatHelper.acf("The wall starts from the bottom right corner",EnumChatFormatting.RED));
    		par3List.add(ChatHelper.customHTT("!!WARNING!! THIS TOOL DOES NOT DROP ITEMS!","Press shift to see IMPORTANT details.", Keyboard.KEY_LSHIFT, ChatHelper.ENUMARRAY_WARNING));
    			par3List.add(ChatHelper.acf("Gaias Magick Count : " + earthMana, EnumChatFormatting.GREEN));
    		par3List.add(ChatHelper.acf("Mageia Magick Count : " + magick, EnumChatFormatting.DARK_PURPLE));
    		par3List.add(ChatHelper.acf("!!WARNING!!",ChatHelper.ENUMARRAY_WARNING));
    		par3List.add(ChatHelper.acf("This is what can be considered a GLITCHFEST",ChatHelper.ENUMARRAY_WARNING));
    		
    	}
    	
    	
    }
    
    public void rBItT(EntityPlayer p, World w, int x, int y, int z) {
    	p.inventory.addItemStackToInventory(new ItemStack(Block.blocksList[w.getBlockId(x,y,z)]));
    	w.setBlockToAir(x,y,z);
    }
    public void readFromNBT(ItemStack stack) {
    	if(stack.stackTagCompound != null) {
    		earthMana = stack.stackTagCompound.getInteger("earthMana");
    		magick = stack.stackTagCompound.getInteger("magickEnergy");
    	}else {
    		stack.stackTagCompound = new NBTTagCompound();
    		earthMana = stack.stackTagCompound.getInteger("earthMana");
    		magick = stack.stackTagCompound.getInteger("magickEnergy");
    	}
    }
    public void writeToNBT(ItemStack stack) {
    	if(stack.stackTagCompound != null) {
    		stack.stackTagCompound.setInteger("earthMana",earthMana);
    		 stack.stackTagCompound.setInteger("magickEnergy",magick);
    	}else {
    		stack.stackTagCompound = new NBTTagCompound();
    		stack.stackTagCompound.setInteger("earthMana",earthMana);
   		 stack.stackTagCompound.setInteger("magickEnergy",magick);
    	}
    }
    @Override
    /**
     * Callback for futurecraft item usage
     */
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
    	incrementMana(world.provider.worldChunkMgr.getBiomeGenAt((int)entity.posX, (int)entity.posZ));
    	writeToNBT(stack);
    	readFromNBT(stack);
    	
    }
    public void incrementMana(BiomeGenBase b) {
    	for(Type t : BiomeDictionary.getTypesForBiome(b)) {
    		if(t == Type.HILLS) {
    			earthMana++;
    			
    		}else if(t == Type.FOREST) {
    			earthMana++;
    			magick++;
    		}else {
    			break;
    		}
    		
    	}
    }
    @Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
    	return 100.0F;
    }
    
}
