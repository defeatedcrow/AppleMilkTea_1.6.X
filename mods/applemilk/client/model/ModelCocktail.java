package mods.applemilk.client.model;

import net.minecraft.src.*;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCocktail extends ModelBase
{
  //fields
	ModelRenderer plate1;
    ModelRenderer plate2;
    ModelRenderer plate3;
    ModelRenderer plate4;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer lemon;
    ModelRenderer lime;
  
  public ModelCocktail()
  {
    
	  plate1 = new ModelRenderer(this, 0, 0);
      plate1.addBox(-4F, 0F, -6F, 8, 6, 0);
      plate1.setRotationPoint(0F, 10F, 0F);
      plate1.setTextureSize(64, 32);
      plate1.mirror = true;
      setRotation(plate1, 0.7853982F, 0F, 0F);
      plate2 = new ModelRenderer(this, 0, 0);
      plate2.addBox(-4F, 0F, 6F, 8, 6, 0);
      plate2.setRotationPoint(0F, 10F, 0F);
      plate2.setTextureSize(64, 32);
      plate2.mirror = true;
      setRotation(plate2, -0.7853982F, 0F, 0F);
      plate3 = new ModelRenderer(this, 0, 0);
      plate3.addBox(6F, 0F, -4F, 0, 6, 8);
      plate3.setRotationPoint(0F, 10F, 0F);
      plate3.setTextureSize(64, 32);
      plate3.mirror = true;
      setRotation(plate3, 0F, 0F, 0.7853982F);
      plate4 = new ModelRenderer(this, 0, 0);
      plate4.addBox(-6F, 0F, -4F, 0, 6, 8);
      plate4.setRotationPoint(0F, 10F, 0F);
      plate4.setTextureSize(64, 32);
      plate4.mirror = true;
      setRotation(plate4, 0F, 0F, -0.7853982F);
      leg1 = new ModelRenderer(this, 0, 15);
      leg1.addBox(-0.5F, 0F, -0.5F, 1, 6, 1);
      leg1.setRotationPoint(0F, 18F, 0F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 18);
      leg2.addBox(-2F, 0F, -2F, 4, 1, 4);
      leg2.setRotationPoint(0F, 23F, 0F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      lemon = new ModelRenderer(this, 16, 0);
      lemon.addBox(2F, -1F, 0F, 5, 4, 0);
      lemon.setRotationPoint(0F, 14F, 0F);
      lemon.setTextureSize(64, 32);
      lemon.mirror = true;
      setRotation(lemon, 0F, 0F, -0.2094395F);
      lime = new ModelRenderer(this, 16, 4);
      lime.addBox(2F, 0F, 0F, 5, 4, 0);
      lime.setRotationPoint(0F, 13F, 0F);
      lime.setTextureSize(64, 32);
      lime.mirror = true;
      setRotation(lime, 0F, 0F, -0.2094395F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, byte b0)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    plate1.render(f5);
    plate2.render(f5);
    plate3.render(f5);
    plate4.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    
    if (b0 == 0) lime.render(f5);
    else if (b0 == 1 || b0 == 8) lemon.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
