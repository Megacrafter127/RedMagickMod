package com.matt.gui;


import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.matt.lib.Ref;

public class LoreBookGui extends GuiScreen {
	public final int xSize = 176;
	public final int ySize = 88;
	public LoreBookGui() {
		// TODO Auto-generated constructor stub
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
	this.drawString(fontRenderer, "FutureCraft Companion", posX, posY,1);
	super.drawScreen(x, y, f);
	}
	
}
