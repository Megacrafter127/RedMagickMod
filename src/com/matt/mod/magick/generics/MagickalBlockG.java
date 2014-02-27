package com.matt.mod.magick.generics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ReportedException;

import com.matt.lib.Ref;

public class MagickalBlockG extends Block {
	protected static int id = 0;
	protected static Material mat = Material.iron;
	public MagickalBlockG(int par1, Material par2Material) {
		super(id,mat);
		
	}
	public MagickalBlockG() {
		super(id,mat);
	}
	public static Block setIdAndMaterial(int id, Material material) {
		if(id != 0) { 
			if(material != null) {
			return new MagickalBlockG(id,material);
		} 
		}else{
			CrashReport r = new CrashReport("futureCraftNull", new NullPointerException());
			throw new ReportedException(r);
		}
		return null;
	}
	public Block setTextureFile(String file) {
		return setTextureName(getTextureFileForThis(file)) ;
	}
	public static String getTextureFileForThis(String s) {
		return Ref.NAME.toLowerCase() + ":" + s;
	}
}
