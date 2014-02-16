package com.matt.mod.swag.multiblock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.matt.lib.Ref;
import com.matt.mod.swag.SwagHelper;
import com.matt.mod.swag.model.ModelAltar;


public class TileEntityAltarRender extends TileEntitySpecialRenderer {
	ModelAltar model = new ModelAltar();
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
        GL11.glPushMatrix();
         //This will move our renderer so that it will be on proper place in the world
         GL11.glTranslatef((float)d, (float)d1, (float)d2);
         TileEntityAltar tileEntityYour = (TileEntityAltar)tileEntity;
         /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
         renderBlockYour(tileEntityYour, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, SwagHelper.blockAltarCore);
        GL11.glPopMatrix();
    }
    //And this method actually renders your tile entity
    public void renderBlockYour(TileEntityAltar tl, World world, int i, int j, int k, Block block) {
        Tessellator tessellator = Tessellator.instance;
        //This will make your block brightness dependent from surroundings lighting.
        float f = block.getBlockBrightness(world, i, j, k);
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2); 
        
        /*This will rotate your model corresponding to player direction that was when you placed the block. If you want this to work, 
        add these lines to onBlockPlacedBy method in your block class.
        int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);*/

        int dir = world.getBlockMetadata(i, j, k);
        
        GL11.glPushMatrix();
         GL11.glTranslatef(0.5F, 0, 0.5F);
         //This line actually rotates the renderer.
         //GL11.glRotatef(dir * (-90F), 0F, 1F, 0F);
         GL11.glTranslatef(-0.5F, 0, -0.5F);
         bindTexture(new ResourceLocation(Ref.NAME.toLowerCase() + "/textures/default"));
        this.model.render(null, 0.0F, 0.0F,0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }
}

