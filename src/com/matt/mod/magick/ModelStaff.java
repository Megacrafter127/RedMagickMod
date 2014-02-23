// Date: 23/02/2014 10:52:15
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.matt.mod.magick;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStaff extends ModelBase
{
  //fields
    ModelRenderer UpCore;
    ModelRenderer StaffRod;
    ModelRenderer DownCore;
    ModelRenderer Detail1;
    ModelRenderer Detail2;
    ModelRenderer Detail3;
    ModelRenderer Detail4;
  
  public ModelStaff()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      UpCore = new ModelRenderer(this, 0, 0);
      UpCore.addBox(0F, 0F, 0F, 3, 3, 3);
      UpCore.setRotationPoint(0F, -9F, 0F);
      UpCore.setTextureSize(32, 32);
      UpCore.mirror = true;
      setRotation(DownCore, 0F, 0F, 0F);
      StaffRod = new ModelRenderer(this, 0, 0);
      StaffRod.addBox(0F, 0F, 0F, 1, 7, 1);
      StaffRod.setRotationPoint(1F, -6F, 1F);
      StaffRod.setTextureSize(32, 32);
      StaffRod.mirror = true;
      setRotation(StaffRod, 0F, 0F, 0F);
      DownCore = new ModelRenderer(this, 0, 0);
      DownCore.addBox(0F, 0F, 0F, 3, 3, 3);
      DownCore.setRotationPoint(0F, 0F, 0F);
      DownCore.setTextureSize(32, 32);
      DownCore.mirror = true;
      setRotation(DownCore, 0F, 0F, 0F);
      Detail1 = new ModelRenderer(this, 0, 0);
      Detail1.addBox(0F, 0F, 0F, 1, 2, 1);
      Detail1.setRotationPoint(1F, -10F, -1F);
      Detail1.setTextureSize(32, 32);
      Detail1.mirror = true;
      setRotation(Detail1, 0F, 0F, 0F);
      Detail2 = new ModelRenderer(this, 0, 0);
      Detail2.addBox(0F, 0F, 0F, 1, 2, 1);
      Detail2.setRotationPoint(-1F, -10F, 1F);
      Detail2.setTextureSize(32, 32);
      Detail2.mirror = true;
      setRotation(Detail2, 0F, 0F, 0F);
      Detail3 = new ModelRenderer(this, 0, 0);
      Detail3.addBox(0F, 0F, 0F, 1, 2, 1);
      Detail3.setRotationPoint(3F, -10F, 1F);
      Detail3.setTextureSize(32, 32);
      Detail3.mirror = true;
      setRotation(Detail3, 0F, 0F, 0F);
      Detail4 = new ModelRenderer(this, 0, 0);
      Detail4.addBox(0F, 0F, 0F, 1, 2, 1);
      Detail4.setRotationPoint(1F, -10F, 3F);
      Detail4.setTextureSize(32, 32);
      Detail4.mirror = true;
      setRotation(Detail4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    UpCore.render(f5);
    StaffRod.render(f5);
    DownCore.render(f5);
    Detail1.render(f5);
    Detail2.render(f5);
    Detail3.render(f5);
    Detail4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}