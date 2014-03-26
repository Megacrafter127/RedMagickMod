/**
 * 
 */
package com.futurecraft.mod.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.futurecraft.mod.ModHelper;

import cpw.mods.fml.common.IWorldGenerator;

/**
 * @author Matheus
 * FutureCraft world handler
 */
public class WorldHandlerFuture implements IWorldGenerator {

	/**
	 * 
	 */
	public WorldHandlerFuture() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.IWorldGenerator#generate(java.util.Random, int, int, net.minecraft.world.World, net.minecraft.world.chunk.IChunkProvider, net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		 switch(world.provider.dimensionId) {
		 case -1:
			 generateNether(world, random, chunkX * 16, chunkZ * 16);
			    break;
		 case 0:
			 generateSurface(world,random,chunkX * 16, chunkZ * 16);
			 break;
		 case 1:
			 generateEnd(world,random,chunkX * 16,chunkZ * 16);
			    
		 }

	}
    /**
     * 	 Generates ores in the Overworld
     * @param world
     * @param random
     * @param i
     * @param j
     */
	private void generateSurface(World world, Random random, int i, int j) {
		// TODO Generate IndiumOre and RoentgeniumOre
		for(int k = 0; k < 10; k++) {
			int indiumX = i + random.nextInt(16);
			int indiumY = random.nextInt(30);
			int indiumZ = j + random.nextInt(16);
			int roentgeniumX = i + random.nextInt(16);
			int roentgeniumY = random.nextInt(15);
			int roentgeniumZ = j + random.nextInt(16);
			(new WorldGenMinable(ModHelper.oreIndium.blockID, 13)).generate(world, random, indiumX, indiumY,indiumZ);
			(new WorldGenMinable(ModHelper.oreRoent.blockID, 13)).generate(world, random, roentgeniumX, roentgeniumY,roentgeniumZ);
		}
	}
	/**
	 *  Generates ores in the nether
	 * @param world
	 * @param random
	 * @param i
	 * @param j
	 */
	private void generateNether(World world, Random random, int i, int j) {
		// USELESS
		
	}
	/**
	 * Generates ores in the end
	 * @param world
	 * @param random
	 * @param i
	 * @param j
	 */
	private void generateEnd(World world, Random random, int i, int j) {
		
	}

}
