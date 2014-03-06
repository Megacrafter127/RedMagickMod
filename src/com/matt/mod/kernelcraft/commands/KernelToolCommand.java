package com.matt.mod.kernelcraft.commands;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;

import com.matt.mod.generic.helpers.ChatHelper;

/**
 * 
 * @author Megacrafter127
 * TODO
 */
public class KernelToolCommand implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		return "accessTool";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "accessTool <key> <value>\naccessTool <key>\naccessTool";
	}

	@Override
	public List<String> getCommandAliases() {
		LinkedList<String> ret=new LinkedList<String>();
		ret.add("accesstool");
		ret.add("accesskerneltool");
		ret.add("accessKernelTool");
		ret.add("manipulateTool");
		ret.add("manipulatetool");
		ret.add("manipulateKernelTool");
		ret.add("manipulatekerneltool");
		ret.add("at");
		ret.add("akt");
		ret.add("mt");
		ret.add("mkt");
		return ret;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player=icommandsender.getEntityWorld().getPlayerEntityByName(icommandsender.getCommandSenderName());
		if(player==null) {
			ChatMessageComponent p=new ChatMessageComponent();
			p.addText("only players have access to this command");
			icommandsender.sendChatToPlayer(p);
		}
		ItemStack stack=player.inventory.getCurrentItem();
		switch(astring.length) {
		case 0:
			break;
		case 1:
			if(stack.hasTagCompound()) {
				if(stack.stackTagCompound.hasKey(astring[0])) {
					player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(stack.stackTagCompound.getString(astring[0]), ChatHelper.ENUMARRAY_NUMBER));
				}
				else {
					player.addChatMessage(ChatHelper.acf("The specified tag couldn't be found.", ChatHelper.ENUMARRAY_WARNING));
				}
			}
			else {
				player.addChatMessage(ChatHelper.acf("the tool has no tags", ChatHelper.ENUMARRAY_WARNING));
			}
			break;
		case 2:
		default:		
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return !icommandsender.getCommandSenderName().equals("Rcon");
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
