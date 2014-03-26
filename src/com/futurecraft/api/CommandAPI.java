package com.futurecraft.api;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;


public class CommandAPI extends CommandBase {

	@Override
	public String getCommandName() {
		return "fapi";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		if(icommandsender instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)icommandsender;
			player.addChatMessage("use like this : /fapi <command> <arg...> ");
			
		}
		return "This is futurecraft api command.";
		
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) {		
		if(icommandsender instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)icommandsender;
			player.addChatMessage(args[1]);
			Entity e;
		}
	}

}
