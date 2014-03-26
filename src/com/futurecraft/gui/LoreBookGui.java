package com.futurecraft.gui;


import java.util.List;

import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;

import java.util.StringTokenizer;

import org.lwjgl.opengl.GL11;

import com.futurecraft.lib.Ref;

public class LoreBookGui extends GuiScreen {
	private String lore;
	private GuiTextField text;
	public final int xSize = 176;
	public final int ySize = 88;
	public LoreBookGui(String lore) {
		this.lore=lore;
	}
	@Override
	public void drawScreen(int x, int y, float f)
	{
	drawDefaultBackground();

	ResourceLocation resourceLocation = new ResourceLocation(Ref.NAME.toLowerCase() +":textures/gui/loreBook.png");
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.renderEngine.bindTexture(resourceLocation);

	int posX = (this.width  - xSize) / 2;
	int posY = (this.height - ySize) / 2;

	drawTexturedModalRect(posX, posY, 0, 0, 176, 88);
	
	if(text==null) {
		text=new GuiTextField(fontRenderer,posX+5,posY+10,xSize-10,ySize-20);
		text.setMaxStringLength(lore.length());
		text.setText(lore);
	}
	
	text.drawTextBox();

	this.drawString(fontRenderer, "FutureCraft Companion", posX, posY,1);

	super.drawScreen(x, y, f);
	}
	
}
