package com.matt.generic.helpers;

import net.minecraft.entity.player.EntityPlayer;

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
		public boolean isArmorEquipped(EntityPlayer p, int armorId, int armorType) {
			return p.getCurrentArmor(armorType).itemID == armorId;
		}
}
