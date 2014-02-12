package com.matt.mod.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.ModHelper;
import com.matt.mod.power.IPowerReceiver;
/**
 * Tile entity for the Compression Smeltery block.
 * @author Matheus
 *
 */
public class TileEntitySmelter extends TileEntity implements IPowerReceiver{
	int currentPower;
	int powerUsage = 10;
	/**
	 * Runs when right-clicked.
	 * @param p player that clicked
	 * @param w world object
	 * @param x x coord
	 * @param y y coord
	 * @param z z coord
	 * @return True if operation was sucessful, false if not
	 */
	public boolean run(EntityPlayer p,World w,int x,int y,int z) {
		receive(w, x, y, z);
		if(w.getBlockId(x, y + 1, z) == Block.oreIron.blockID && w.getBlockId(x,y -1,z) == Block.oreCoal.blockID) {
			w.setBlockToAir(x, y + 1, z);
			w.setBlockToAir(x,y -1,z);
			p.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron,2) );
			System.out.println("Smelted iron");
			return true;
		} else if(w.getBlockId(x,y + 1,z) == Block.oreGold.blockID && w.getBlockId(x,y -1,z) == Block.oreCoal.blockID) {
			w.setBlockToAir(x, y + 1, z);
			w.setBlockToAir(x,y -1,z);
			p.inventory.addItemStackToInventory(new ItemStack(Item.ingotGold,2));
			System.out.println("Smelted gold");
			return true;
		} else if(w.getBlockId(x,y + 1,z) == Block.oreCoal.blockID && w.getBlockId(x,y -1,z) == Block.oreCoal.blockID) {
			w.setBlockToAir(x, y + 1, z);
			w.setBlockToAir(x,y -1,z);
			p.inventory.addItemStackToInventory(new ItemStack(Item.coal,2));
			System.out.println("Smelted coal");
			return true;
		} else if(w.getBlockId(x, y + 1, z) == Block.oreIron.blockID && currentPower >= powerUsage) {
			currentPower = currentPower - powerUsage; // Removes power from storage
			w.setBlockToAir(x, y + 1, z);
			p.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron,2) );
			System.out.println("Smelted iron using power");
			System.out.println(currentPower);
			return true;
		}else if(w.getBlockId(x, y + 1, z) == Block.oreGold.blockID && currentPower >= powerUsage) {
			currentPower = currentPower - powerUsage; // Removes power from storage
			w.setBlockToAir(x, y + 1, z); // Removes block above from storage
			p.inventory.addItemStackToInventory(new ItemStack(Item.ingotGold,2) ); // Adds stack to inventory
			System.out.println("Smelted gold using power");
			System.out.println(currentPower);
			return true;
		}else if(w.getBlockId(x, y + 1, z) == Block.oreCoal.blockID && currentPower >= powerUsage) {
			currentPower = currentPower - powerUsage; // Removes power from storage
			w.setBlockToAir(x, y + 1, z); // Removes block above
			p.inventory.addItemStackToInventory(new ItemStack(Item.coal,2) ); // Adds stack to inventory 
			System.out.println("Smelted coal using power");
			System.out.println(currentPower);
			return true; 
		}else if(w.getBlockId(x, y + 1, z) == ModHelper.getInstance().oreRoent.blockID && currentPower >= powerUsage) {
			currentPower = currentPower - powerUsage; // Removes power from storage
			w.setBlockToAir(x, y + 1, z);// Removes block above
			p.inventory.addItemStackToInventory(new ItemStack(ModHelper.getInstance().ingotRoentgenium,2) ); // Adds stack to inventory 
			System.out.println("Smelted coal using power"); 
			System.out.println(currentPower); 	
			return true;
		}else if(w.getBlockId(x, y + 1, z) == ModHelper.getInstance().oreIndium.blockID && currentPower >= powerUsage) {
			currentPower = currentPower - powerUsage; // Removes power from storage
			w.setBlockToAir(x, y + 1, z);// Removes block above
			p.inventory.addItemStackToInventory(new ItemStack(ModHelper.getInstance().ingotIndium,2) ); // Adds stack to inventory
			System.out.println("Smelted indium using power");
			System.out.println(currentPower);
			return true;
			} else {
				p.addChatMessage("You're using an invalid block, or don't have enought power.");
				int idToString = w.getBlockId(x,y+1,z);
				p.addChatMessage("Debug message : Block ID : "+ idToString );
				p.addChatMessage("Debug message : Block power ammount : "+ this.currentPower );
				
			}
		
		return false;
	}

	@Override
	public void receive(World w,int x,int y,int z) {
		TileEntityPowerPipe pipe;
		if(w.getBlockTileEntity(x+1,y,z) instanceof TileEntityPowerPipe)  {
			pipe = (TileEntityPowerPipe) w.getBlockTileEntity(x-1,y,z);
			pipe.transmit(this);
		}else if(w.getBlockTileEntity(x-1,y,z) instanceof TileEntityPowerPipe) {
			pipe = (TileEntityPowerPipe) w.getBlockTileEntity(x-1,y,z);
			pipe.transmit(this);
		} else if(w.getBlockTileEntity(x-1,y,z) instanceof TileEntityPowerPipe) {
			pipe = (TileEntityPowerPipe) w.getBlockTileEntity(x+1,y,z);
			pipe.transmit(this);
		} else if(w.getBlockTileEntity(x,y,z+1) instanceof TileEntityPowerPipe) {
			pipe = (TileEntityPowerPipe) w.getBlockTileEntity(x,y,z+1);
			pipe.transmit(this);
		} else if(w.getBlockTileEntity(x,y,z-1) instanceof TileEntityPowerPipe) {
			pipe = (TileEntityPowerPipe) w.getBlockTileEntity(x,y,z-1);
			pipe.transmit(this);
		}
		
	}

	@Override
	public int consume(int ammountToConsume) {
		currentPower = currentPower - ammountToConsume;
		return 0;
	}

	@Override
	public int consume(World w, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.currentPower = nbt.getInteger("currentPower");
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("currentPower",currentPower);
		
	}
}
