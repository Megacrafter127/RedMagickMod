package com.matt.generic.helpers;

import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ReportedException;

public class EntityPlayerHelper {
static final public EntityPlayerHelper instance = new EntityPlayerHelper();
		/**
		 * com.matt.generic.helpers.EntityPlayerHelper.isArmorEquipped <br>
		 * See EntityPlayer.getCurrentArmor
		 * @param p the entity player 
		 * @param armorId the armor id
		 * @param armorType  the armor type. <br>
		 * Armor Types : <br>
		 * <bold>0</bold> for helmet <br>
		 * <bold>1</bold> for chestplate <br>
		 * <bold>2</bold> for leggings<br>
		 * <bold>3</bold> for boots <br>
		 *
		 * @return True if the armor in slot armorType has the same id as armorID.
		 */
		public static boolean isArmorEquipped(EntityPlayer p, int armorId, int armorType) {
			return p.getCurrentArmor(armorType).itemID == armorId;
		}
		/**
		 * Writes a string to a player's NBTTagCompound.
		 * @param p the entity player
		 * @param k the key
		 * @param v the value
		 */
		public static void writeStringTagToEntityPlayer(EntityPlayer p, String k, String v) {
			Entity base = (Entity)p;
			if(base.getEntityData() != null) {
				base.getEntityData().setString(k,v);
			}else {
				throw new ReportedException(new CrashReport("Tried to add a string into a null nbt", null));
			}
			
		}
		
}
