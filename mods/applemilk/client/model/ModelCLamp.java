package mods.applemilk.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCLamp extends ModelBase
{
    //fields
	ModelRenderer body;
    ModelRenderer head;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer wing1;
    ModelRenderer wing2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer core1;
    ModelRenderer core2;
    
    ModelRenderer sphere;
    ModelRenderer sphere2;
    ModelRenderer arm1;
    ModelRenderer arm2;
    ModelRenderer arm3;
    ModelRenderer blade1;
    ModelRenderer blade2;
    ModelRenderer blade3;
    ModelRenderer blade21;
    ModelRenderer blade22;
    ModelRenderer blade23;
  
  public ModelCLamp()
  {
    
	  body = new ModelRenderer(this, 0, 0);
      body.addBox(-2.5F, -3F, -2F, 5, 6, 5);
      body.setRotationPoint(0F, 14F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-2F, -2F, -1.5F, 4, 3, 4);
      head.setRotationPoint(0F, 10F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      ear1 = new ModelRenderer(this, 0, 0);
      ear1.addBox(-1F, 0F, 0.5F, 1, 1, 1);
      ear1.setRotationPoint(0F, 8.3F, 0F);
      ear1.setTextureSize(64, 32);
      ear1.mirror = true;
      setRotation(ear1, 0.7853982F, -1.570796F, 0F);
      ear2 = new ModelRenderer(this, 0, 0);
      ear2.addBox(0F, 0F, 0.5F, 1, 1, 1);
      ear2.setRotationPoint(0F, 8.3F, 0F);
      ear2.setTextureSize(64, 32);
      ear2.mirror = true;
      setRotation(ear2, 0.7853982F, 1.570796F, 0F);
      tail1 = new ModelRenderer(this, 0, 0);
      tail1.addBox(-2F, 0F, -1.5F, 4, 2, 4);
      tail1.setRotationPoint(0F, 17F, 0F);
      tail1.setTextureSize(64, 32);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0F);
      tail2 = new ModelRenderer(this, 0, 0);
      tail2.addBox(-1.5F, 0F, -1F, 3, 2, 2);
      tail2.setRotationPoint(0F, 19F, 0F);
      tail2.setTextureSize(64, 32);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, 0F);
      core1 = new ModelRenderer(this, 0, 17);
      core1.addBox(-1F, -1F, -1F, 2, 2, 2);
      core1.setRotationPoint(0F, 14F, 0F);
      core1.setTextureSize(64, 32);
      core1.mirror = true;
      setRotation(core1, 0F, 0F, -0.7853982F);
      core2 = new ModelRenderer(this, 0, 12);
      core2.addBox(-1.5F, -0.5F, -1F, 3, 2, 2);
      core2.setRotationPoint(0F, 9F, 0F);
      core2.setTextureSize(64, 32);
      core2.mirror = true;
      setRotation(core2, 0F, 0F, 0F);
      wing1 = new ModelRenderer(this, 0, 0);
      wing1.addBox(0F, -1.5F, 2.5F, 1, 3, 6);
      wing1.setRotationPoint(0F, 15F, 0F);
      wing1.setTextureSize(64, 32);
      wing1.mirror = true;
      setRotation(wing1, 0.4363323F, 1.570796F, 0F);
      wing2 = new ModelRenderer(this, 0, 0);
      wing2.addBox(0F, -1.5F, 2.5F, 1, 3, 6);
      wing2.setRotationPoint(0F, 15F, 0F);
      wing2.setTextureSize(64, 32);
      wing2.mirror = true;
      setRotation(wing2, 0.4363323F, -1.570796F, 0F);
      
      sphere = new ModelRenderer(this, 0, 0);
      sphere.addBox(-3F, -3F, -3F, 6, 6, 6);
      sphere.setRotationPoint(0F, 14F, 0F);
      sphere.setTextureSize(64, 32);
      sphere.mirror = true;
      setRotation(sphere, 0F, 0F, 0F);
      sphere2 = new ModelRenderer(this, 24, 0);
      sphere2.addBox(-2F, -2F, -2F, 4, 4, 4);
      sphere2.setRotationPoint(0F, 14F, 0F);
      sphere2.setTextureSize(64, 32);
      sphere2.mirror = true;
      setRotation(sphere2, 0F, 0F, 0F);
      arm1 = new ModelRenderer(this, 0, 13);
      arm1.addBox(-5F, -1F, -1F, 2, 2, 2);
      arm1.setRotationPoint(0F, 13F, -0.5F);
      arm1.setTextureSize(64, 32);
      arm1.mirror = true;
      setRotation(arm1, 0F, 0.6981317F, 0.2617994F);
      arm2 = new ModelRenderer(this, 0, 13);
      arm2.addBox(3F, -1F, -1F, 2, 2, 2);
      arm2.setRotationPoint(0F, 13F, -0.5F);
      arm2.setTextureSize(64, 32);
      arm2.mirror = true;
      setRotation(arm2, 0F, -0.6981317F, -0.2617994F);
      arm3 = new ModelRenderer(this, 0, 13);
      arm3.addBox(-1F, -1F, -4F, 2, 2, 2);
      arm3.setRotationPoint(0F, 12.5F, 0F);
      arm3.setTextureSize(64, 32);
      arm3.mirror = true;
      setRotation(arm3, -0.2617994F, 0F, 0F);
      blade1 = new ModelRenderer(this, 0, 17);
      blade1.addBox(-0.5F, 0F, -4.5F, 1, 10, 2);
      blade1.setRotationPoint(0F, 11F, 0F);
      blade1.setTextureSize(64, 32);
      blade1.mirror = true;
      setRotation(blade1, -0.3490659F, 0F, 0F);
      blade2 = new ModelRenderer(this, 0, 17);
      blade2.addBox(-0.5F, 0F, -5.5F, 1, 10, 2);
      blade2.setRotationPoint(0F, 11.5F, -0.2F);
      blade2.setTextureSize(64, 32);
      blade2.mirror = true;
      setRotation(blade2, -0.3490659F, 2.234021F, 0F);
      blade3 = new ModelRenderer(this, 0, 17);
      blade3.addBox(-0.5F, 0F, -5.5F, 1, 10, 2);
      blade3.setRotationPoint(0F, 11.5F, -0.2F);
      blade3.setTextureSize(64, 32);
      blade3.mirror = true;
      setRotation(blade3, -0.3490659F, -2.234021F, 0F);
      blade21 = new ModelRenderer(this, 14, 13);
      blade21.addBox(-0.5F, 0F, -8.7F, 1, 1, 3);
      blade21.setRotationPoint(0F, 23F, 0F);
      blade21.setTextureSize(64, 32);
      blade21.mirror = true;
      setRotation(blade21, -0.5410521F, 0F, 0F);
      blade22 = new ModelRenderer(this, 14, 13);
      blade22.addBox(-0.5F, 0F, -9.5F, 1, 1, 3);
      blade22.setRotationPoint(0F, 23.5F, -0.2F);
      blade22.setTextureSize(64, 32);
      blade22.mirror = true;
      setRotation(blade22, -0.5410521F, 2.234021F, 0F);
      blade23 = new ModelRenderer(this, 14, 13);
      blade23.addBox(-0.5F, 0F, -9.5F, 1, 1, 3);
      blade23.setRotationPoint(0F, 23.5F, -0.2F);
      blade23.setTextureSize(64, 32);
      blade23.mirror = true;
      setRotation(blade23, -0.5410521F, -2.234021F, 0F);
  }
  
  public void render (Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7, byte b0)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity, b0);
	  
	  if (b0 == 5)
	  {
		  this.arm1.render(par7);
		  this.arm2.render(par7);
		  this.arm3.render(par7);
		  this.blade1.render(par7);
		  this.blade2.render(par7);
		  this.blade3.render(par7);
		  this.blade21.render(par7);
		  this.blade22.render(par7);
		  this.blade23.render(par7);
	  }
  }
  
  public void renderLucent(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7, byte b0)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity, b0);
	  
	  if (b0 == 4)
	  {
		  this.body.render(par7);
		  this.head.render(par7);
		  this.ear1.render(par7);
		  this.ear2.render(par7);
		  this.wing1.render(par7);
		  this.wing2.render(par7);
		  this.tail1.render(par7);
		  this.tail2.render(par7);
	  }
	  else if (b0 == 5)
	  {
		  this.sphere.render(par7);
	  }
  }
  
  public void renderGlow(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7, byte b0)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity, b0);
	  
	  if (b0 == 4)
	  {
		  this.core1.render(par7);
		  this.core2.render(par7);
	  }
	  else if (b0 == 5)
	  {
		  this.sphere2.render(par7);
	  }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
	  model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity, byte b0)
  {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      float fi = f3;
      
      this.body.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.ear1.rotateAngleY = -1.570796F + (f3 / (180F / (float)Math.PI));
      this.ear2.rotateAngleY = 1.570796F + (f3 / (180F / (float)Math.PI));
      this.tail1.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.tail2.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.wing1.rotateAngleY = 1.570796F + f3 / (180F / (float)Math.PI);
      this.wing2.rotateAngleY = -1.570796F + f3 / (180F / (float)Math.PI);
      this.core2.rotateAngleY = f3 / (180F / (float)Math.PI);
      
      this.core1.rotateAngleY += 0.5F / (180F / (float)Math.PI);
      this.core1.rotateAngleX += 0.5F / (180F / (float)Math.PI);
  }
}
