package com.futurecraft.mod.magick.infusion;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
/**
 * 
 * @author Megacrafter127
 *
 */
public class RecipeShapedRunicInfusion implements IRecipe {
	protected ItemStack[] matrix;
	protected ItemStack[] runes;
	protected ItemStack result;
	protected int width,height;
	//private boolean checkMeta;
	/**
	 * 
	 * @param result - the crafting result
	 * @param matrix - the matrix state
	 * @param runes - the required runes
	 * @param width - the width of the matrix
	 */
	public RecipeShapedRunicInfusion(ItemStack result,ItemStack[] matrix,ItemStack[] runes,int width) {
		this.result=result;
		this.matrix=matrix;
		this.runes=runes;
		this.width=width;
		height=matrix.length/width+(matrix.length%width>0?1:0);
	}
	@Override
	public boolean matches(InventoryCrafting f,World w) {
		if(width>3||height>3||runes.length>3) return false;
		boolean matrixmatch=false;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(checkMatrixMatch(f,i,j)) {
					matrixmatch=true;
					break;
				}
			}
		}
		if(!matrixmatch) return false;
		boolean[] exclude=new boolean[runes.length];
		for(int i=9;i<12;i++) {
			ItemStack s=f.getStackInSlot(i);
			if(s==null) continue;
			for(int j=0;j<runes.length;j++) {
				if(exclude[j]) continue;
				if(runes[j]==null) exclude[j]=true;
				else if(s.isItemEqual(runes[j])) {
					exclude[j]=true;
					break;
				}
			}
		}
		for(boolean b:exclude) {
			if(!b) return false;
		}
		return true;
	}
	
	private boolean checkMatrixMatch(InventoryCrafting f,int xoff,int yoff) {
		if(xoff+width>3||yoff+height>3) {
			return false;
		}
		for(int i=xoff*3+yoff,j=0;i<matrix.length;i++,j++) {
			ItemStack s=f.getStackInSlot(i);
			if(s!=null&&matrix[j]!=null) {
				if(!matrix[j].isItemEqual(s)) return false;
			}
			else if(s==null&&matrix==null) {}
			else return false;
		}
		return true;
	}
	@Override
	public ItemStack getCraftingResult(InventoryCrafting f) {
		if(matches(f,null)) return result;
		return null;
	}
	@Override
	public int getRecipeSize() {
		return width;
	}
	@Override
	public ItemStack getRecipeOutput() {
		return result;
	}
}
