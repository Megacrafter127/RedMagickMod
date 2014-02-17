package com.matt.mod.blocks.tileentity;

import com.matt.FutureCraft;
import com.matt.mod.ModHelper;
import com.matt.mod.blocks.BlockGOL;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.LinkedList;

public class TileEntityGOL extends TileEntity {
	private static class Switcher extends Thread {
		public void run() {
			while(true) {
				try{
					Thread.sleep(timeBetweenFrames);
				}
				catch(InterruptedException ex) {}
				change=!change;
			}
		}
	}
	static {
		TileEntity.addMapping(TileEntityGOL.class,"TileEntityGOL");
		new Switcher().start();
	}
	
	public static int countActiveCells(IBlockAccess blocks,int x,int y,int z) {
		int ret=0;
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				for(int k=-1;k<2;k++) {
					if(i==0&&j==0&&k==0) {}
					else {
						if(blocks.getBlockId(x+i, y+j, z+k)==ModHelper.gameOfLifeBlock.blockID) {
							ret++;
						}
					}
				}
			}
		}
		return ret;
	}
	
	private static void apply(World w) {
		int x,y,z;
		for(int[] i:activeCoords) {
			x=i[0];
			y=i[1];
			z=i[2];
			if(Block.blocksList[w.getBlockId(x, y, z)]==null) {
				w.setBlock(x, y, z, ModHelper.gameOfLifeBlock.blockID);
			}
		}
		activeCoords.clear();
		for(int[] i:inactiveCoords) {
			x=i[0];
			y=i[1];
			z=i[2];
			if(w.getBlockId(x, y, z)==ModHelper.gameOfLifeBlock.blockID) {
				w.setBlockToAir(x, y, z);
				w.removeBlockTileEntity(x, y, z);
			}
		}
		inactiveCoords.clear();
	}
	
	private static LinkedList<int[]> activeCoords=new LinkedList<int[]>();
	private static LinkedList<int[]> inactiveCoords=new LinkedList<int[]>();
	private boolean lastChange=true;
	private static boolean change=false;
	public static final long timeBetweenFrames=250;
	public static final int minPop=2;
	public static final int switchPop=6;
	public static final int maxPop=8;
	

	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
	}
	
	public void run(World w) {
		if(BlockGOL.halted||w.isRemote) {
			return;
		}
		lastChange=change;
		if(change) {
			apply(w);
		}
		else {
			for(int i=-1;i<2;i++) {
				for(int j=-1;j<2;j++) {
					for(int k=-1;k<2;k++) {
						int active=countActiveCells(w,xCoord+i,yCoord+j,zCoord+k);
						if(active>maxPop||active<minPop) {
							inactiveCoords.add(new int[]{xCoord+i,yCoord+j,zCoord+k});
						}
						else if(active<switchPop) {
							activeCoords.add(new int[]{xCoord+i,yCoord+j,zCoord+k});
						}
					}
				}
			}
		}
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(canUpdate()) run(getWorldObj());
	}
	
	@Override
	public boolean canUpdate() {
		return lastChange!=change;
	}
}
