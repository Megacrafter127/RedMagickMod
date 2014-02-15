package com.matt.mod.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.ModHelper;
import com.matt.mod.power.Powerable;
import java.util.HashMap;
/**
 * Tile entity for the Compression Smeltery block.
 * @author Matheus
 *
 */
public class TileEntitySmelter extends TileEntity implements Powerable{
	private int currentPower=0;
	static int powerUsage = 10;
	public int smeltResult;
	public static final HashMap<Integer,Item> smeltHash=new HashMap<Integer,Item>();
	static{
		smeltHash.put(Block.oreIron.blockID, Item.ingotIron);
		smeltHash.put(Block.oreGold.blockID, Item.ingotGold);
	}
	
	public TileEntitySmelter(int smeltResult) {
		this.smeltResult=smeltResult;
	}
	public TileEntitySmelter() {
		this(2);
	}
	/**
	 * Runs when right-clicked.
	 * @param p player that clicked
	 * @param w world object
	 * @return True if operation was successful, false if not
	 */
	public boolean run(EntityPlayer p,World w) {
		if(currentPower<powerUsage) {
			p.addChatMessage("Not Enough Power");
			return false; 
		}
		Item i=smeltHash.get(w.getBlockId(xCoord, yCoord+1, zCoord));
		if(i==null) {
			p.addChatMessage("The block cannot be smelted.");
			return false;
		}
		currentPower-=powerUsage;
		p.inventory.addItemStackToInventory(new ItemStack(i,smeltResult));
		w.setBlockToAir(xCoord, yCoord+1, zCoord);
		return true;
	}

	

	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.currentPower = nbt.getInteger("currentPower");
		this.smeltResult = nbt.getInteger("smeltResult");
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("currentPower",currentPower);
		nbt.setInteger("smeltResult",smeltResult);
		
	}
	
	public int addPower(int amount) {
		currentPower+=amount;
		return 0;
	}
	public int removePower(int amount) {
		return 0;
	}
	public void transmit(World w,int x,int y,int z) {
		System.out.println("A Smelter won't give away power");
	}
	
}
