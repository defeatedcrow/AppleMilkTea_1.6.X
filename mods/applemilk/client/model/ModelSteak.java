package mods.applemilk.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSteak extends ModelBase
{
    //fields
	ModelRenderer pork = (new ModelRenderer(this, 0, 8)).setTextureSize(32, 32);
    ModelRenderer carrot1 = (new ModelRenderer(this, 0, 18)).setTextureSize(32, 32);
    ModelRenderer carrot2 = (new ModelRenderer(this, 0, 18)).setTextureSize(32, 32);
    ModelRenderer carrot3 = (new ModelRenderer(this, 0, 18)).setTextureSize(32, 32);
    ModelRenderer potato1 = (new ModelRenderer(this, 0, 23)).setTextureSize(32, 32);
    ModelRenderer potato2 = (new ModelRenderer(this, 0, 23)).setTextureSize(32, 32);
    ModelRenderer beef = (new ModelRenderer(this, 0, 0)).setTextureSize(32, 32);
    ModelRenderer butter = (new ModelRenderer(this, 9, 18)).setTextureSize(32, 32);
  
  public ModelSteak()
  {
    
      pork.addBox(-4F, 0F, -5F, 8, 3, 5);
      pork.setRotationPoint(0F, 18F, 0F);
      pork.mirror = true;
      setRotation(pork, 0F, 0F, 0F);
      carrot1.addBox(5F, 0F, 0F, 1, 1, 3);
      carrot1.setRotationPoint(0F, 20F, 0F);
      carrot1.mirror = true;
      setRotation(carrot1, 0F, -0.4363323F, 0F);
      carrot2.addBox(4F, 0F, 1F, 1, 1, 3);
      carrot2.setRotationPoint(0F, 20F, 0F);
      carrot2.mirror = true;
      setRotation(carrot2, 0F, -0.4363323F, 0F);
      carrot3.addBox(-1F, 0F, 3F, 1, 1, 3);
      carrot3.setRotationPoint(0F, 21F, 0F);
      carrot3.mirror = true;
      setRotation(carrot3, 0.4363323F, 0.7853982F, 0F);
      potato1.addBox(-5F, 0F, 2F, 2, 2, 2);
      potato1.setRotationPoint(0F, 19F, 0F);
      potato1.mirror = true;
      setRotation(potato1, 0F, 0F, 0F);
      potato2.addBox(-3F, 0F, 3F, 2, 2, 2);
      potato2.setRotationPoint(0F, 19F, 0F);
      potato2.mirror = true;
      setRotation(potato2, 0F, 0F, 0F);
      beef.addBox(-4F, 0F, -5F, 8, 3, 5);
      beef.setRotationPoint(0F, 18F, 0F);
      beef.mirror = true;
      setRotation(beef, 0F, 0F, 0F);
      butter.addBox(-0.5F, 0F, -3F, 1, 1, 1);
      butter.setRotationPoint(0F, 17F, 0F);
      butter.mirror = true;
      setRotation(butter, 0F, 0F, 0F);
  }
  
  public void render (Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7, byte par8)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	  
	  if (par8 == 0 || par8 == 1)
	  {
		  this.butter.render(par7);
		  this.carrot1.render(par7);
		  this.carrot2.render(par7);
		  this.carrot3.render(par7);
		  this.potato1.render(par7);
		  this.potato2.render(par7);
		  if (par8 == 0) this.beef.render(par7);
		  if (par8 == 1) this.pork.render(par7);
	  }
	  else if (par8 == 2)
	  {
		  
	  }
	  else
	  {
		  
	  }
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
      this.beef.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.pork.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.butter.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.carrot1.rotateAngleY = -0.4363323F + f3 / (180F / (float)Math.PI);
      this.carrot2.rotateAngleY = -0.4363323F + f3 / (180F / (float)Math.PI);
      this.carrot3.rotateAngleY = 0.7853982F + f3 / (180F / (float)Math.PI);
      this.potato1.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.potato2.rotateAngleY = f3 / (180F / (float)Math.PI);
      
  }
}
