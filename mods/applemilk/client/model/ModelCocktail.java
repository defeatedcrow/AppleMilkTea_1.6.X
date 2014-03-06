package mods.applemilk.client.model;

import net.minecraft.src.*;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCocktail extends ModelBase
{
    ModelRenderer lemon = new ModelRenderer(this, 16, 0).setTextureSize(32, 32);
    ModelRenderer lime = new ModelRenderer(this, 16, 5).setTextureSize(32, 32);
  
  public ModelCocktail()
  {
      lemon.addBox(2F, -1F, 0F, 5, 4, 1);
      lemon.setRotationPoint(0F, 15F, 0F);
      lemon.mirror = true;
      setRotation(lemon, 0F, 0F, -0.2094395F);
      lime.addBox(2F, 0F, 0F, 5, 4, 1);
      lime.setRotationPoint(0F, 15F, 0F);
      lime.mirror = true;
      setRotation(lime, 0F, 0F, -0.2094395F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, byte b0)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    if (b0 == 0 || b0 == 3) lime.render(f5);
    else if (b0 == 5) lemon.render(f5);
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
