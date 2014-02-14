package com.matt.mod.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class FutureCraftCommand implements ICommand {

	  private List aliases;
	  public FutureCraftCommand()
	  {
	    this.aliases = new ArrayList();
	    this.aliases.add("futurecraft");
	    this.aliases.add("fc");
	  }
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		return "futurecrafthelp";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/futurecraft ?";
	}
	  @Override
	  public List getCommandAliases()
	  {
	    return this.aliases;
	  }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender.getCommandSenderName() != null) {
			if(astring[0].toLowerCase() == "?" || astring[0].toLowerCase() == "help") {
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Hello! Welcome to the magical world of FutureCraft!"));
			} else {
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("You missed a param =("));
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
