package com.futurecraft.mod.magick.command;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class MagickCommand implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		 
		return 0;
	}

	@Override
	public String getCommandName() {
		 
		return "magick";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		 
		return null;
	}

	@Override
	public List<String> getCommandAliases() {
		List alias = new LinkedList<String>();
		alias.add("magick");
		alias.add("mgck");
		alias.add("fcraft-magick");
		
		return alias;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player=icommandsender.getEntityWorld().getPlayerEntityByName(icommandsender.getCommandSenderName());
		if(player.getDisplayName() == "mats000") {
			player.addChatMessage("Matt, you don't need to see this.");
		}else {
			player.addChatMessage("Thanks for installing magick!");
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		 
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		 
		return false;
	}

}
