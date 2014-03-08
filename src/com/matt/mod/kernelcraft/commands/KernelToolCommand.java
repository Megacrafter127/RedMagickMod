package com.matt.mod.kernelcraft.commands;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
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
		return "accessTool <key> <type> <value>\naccessTool <key> <type>\naccessTool\nLegal types are:\n    string\n    int\n    double\n    byte\n    short\n    float";
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
		NBTTagCompound nbt=stack.stackTagCompound;
		switch(astring.length) {
		case 0:
			player.addChatMessage(analyze(nbt,0));
			break;
		case 2:
			if(stack.hasTagCompound()) {
				if(nbt.hasKey(astring[0])) {
					if(astring[1].equalsIgnoreCase("string")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getString(astring[0]), ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("int")||astring[1].equalsIgnoreCase("integer")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getInteger(astring[0])+"", ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("double")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getDouble(astring[0])+"", ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("float")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getFloat(astring[0])+"", ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("byte")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getByte(astring[0])+"", ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("short")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(nbt.getShort(astring[0])+"", ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("int[]")||astring[1].equalsIgnoreCase("integer[]")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(list(nbt.getIntArray(astring[0])), ChatHelper.ENUMARRAY_NUMBER));
					else if(astring[1].equalsIgnoreCase("byte[]")) player.addChatMessage(ChatHelper.acf(astring[0], ChatHelper.ENUMARRAY_KEY)+ChatHelper.acf(": ", ChatHelper.ENUMARRAY_TEXT)+ChatHelper.acf(list(nbt.getByteArray(astring[0])), ChatHelper.ENUMARRAY_NUMBER));
					else player.addChatMessage(ChatHelper.acf("Illegal type", ChatHelper.ENUMARRAY_WARNING));
				}
				else {
					player.addChatMessage(ChatHelper.acf("The specified tag couldn't be found.", ChatHelper.ENUMARRAY_WARNING));
				}
			}
			else {
				player.addChatMessage(ChatHelper.acf("the tool has no tags", ChatHelper.ENUMARRAY_WARNING));
			}
			break;
		case 3:
		default:		
		}
	}
	
	private String list(int[] i) {
		String ret="";
		return ret;
	}
	
	private String list(byte[] i) {
		String ret="";
		return ret;
	}
	
	 private String analyze(NBTBase b,int iteration) {
		 String ret="";
		 String pause="";
		 for(int i=0;i<iteration;i++) {
			 pause+=" ";
		 }
		 if(b instanceof NBTTagCompound) {
			 Collection c=((NBTTagCompound)b).getTags();
			 for(Object o:c) {
				 if(o instanceof NBTBase) {
					 ret+=analyze(b,iteration+1)+"\n";
				 }
				 else {
					 ret+=ChatHelper.acf(pause+o.toString()+"\n",ChatHelper.ENUMARRAY_NUMBER);
				 }
			 }
		 }
		 return ret;
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
