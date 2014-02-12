package com.matt.mod.generic.helpers;

import com.matt.lib.Ref;

import net.minecraft.block.material.Material;

public class BlockProperties {
static Material m;
static int id;
static String unlocname;
static boolean hasEffects;
static String textureName;
public static Material getMaterial() {
	return m;
}
public static int getId() {
	return id;
}
public static String getName() {
	return unlocname;
}
public static Boolean getEffects() {
	return hasEffects;
}
public static String getTexture() {
	return textureName;
}
public BlockProperties(Material par1material, int par2id, String par3unlocname,boolean effects, String texture) {
	m = par1material;
	id = par2id;
	unlocname = par3unlocname;
	textureName = Ref.NAME.toLowerCase() + ":" + texture;
	hasEffects = effects;
}

}
