package com.futurecraft.mod.magick.infusion;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.MagickRecipes;
import com.futurecraft.mod.magick.runic.ItemRune;

public class TileInfuser extends TileEntity implements IInventory{
	 private static final TileInfuser referenceInstance = new TileInfuser();
	public static ItemStack[] inv = new ItemStack[13];
	InventoryCrafting invCrafting = InfusionAltar.thisCraftingInventory;
	public static List<RecipeShapedRunicInfusion> infusionShapedList;
	
	public TileInfuser() {
	
		}
   
    @Override
    public int getSizeInventory() {
            return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
            return inv[slot];
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
            inv[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
                    }
            }
            return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    
    @Override
    public int getInventoryStackLimit() {
            return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {
    	
    	
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inv.length) {
                            inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
                            
            NBTTagList itemList = new NBTTagList();
            for (int i = 0; i < inv.length; i++) {
                    ItemStack stack = inv[i];
                    if (stack != null) {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            }
            tagCompound.setTag("Inventory", itemList);
    }

            @Override
            public String getInvName() {
                    return "mgck.InfusorTile";
            }

			@Override
			public boolean isInvNameLocalized() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isItemValidForSlot(int i, ItemStack itemstack) {
				if(i == 9 || i == 10 || i == 11) {
					if(itemstack.getItem() instanceof ItemRune) {
						return true;
					}else {
						return false;
					}
				}
				if(i == 12) {
					return false;
				}
				
				return false;
			}

			public void run(EntityPlayer p) {
				if(getStackInSlot(9) == MagickRecipes.rune) {
						if(getStackInSlot(0) == MagickRecipes.stoneStack) {
							setInventorySlotContents(12,new ItemStack(MagickHelper.blockMagicalBlock));
						
					}
				}
			}
			
			@Override
			public void updateEntity() {
				try {
				for(RecipeShapedRunicInfusion r : infusionShapedList) {
					if(r.matches(invCrafting,this.worldObj)) {
						inv[12] = r.getRecipeOutput();
					}
				}
				}catch(Throwable t) {
					t.printStackTrace();
				}
				
				
			}

}
