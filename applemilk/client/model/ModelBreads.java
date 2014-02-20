package mods.applemilk.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBreads extends ModelBase
{
    //fields
    public ModelRenderer bread1 = (new ModelRenderer(this, 0, 0)).setTextureSize(32, 32);
    public ModelRenderer bread2 = (new ModelRenderer(this, 0, 0)).setTextureSize(32, 32);
    public ModelRenderer bread3 = (new ModelRenderer(this, 0, 0)).setTextureSize(32, 32);
    
    public ModelRenderer bread4 = (new ModelRenderer(this, 0, 8)).setTextureSize(32, 32);
    public ModelRenderer bread5 = (new ModelRenderer(this, 0, 8)).setTextureSize(32, 32);
  
  public ModelBreads()
  {
    
      bread1.addBox(0F, 0F, 0F, 10, 3, 4);
      bread1.setRotationPoint(-4F, 20F, 3F);
      bread1.mirror = true;
      this.setRotation(bread1, 0.3490659F, 0.418879F, 0F);
      bread2.addBox(0F, 0F, 0F, 10, 3, 4);
      bread2.setRotationPoint(4F, 20F, -7F);
      bread2.mirror = true;
      this.setRotation(bread2, 1.3174533F, -1.02173F, -1.3759587F);
      bread3.addBox(0F, 0F, 0F, 10, 3, 4);
      bread3.setRotationPoint(-3F, 20F, -4F);
      bread3.mirror = true;
      this.setRotation(bread3, 0.6174533F, -0.7726646F, -1.0457718F);
      bread5.addBox(0F, 0F, 0F, 5, 3, 5);
      bread5.setRotationPoint(0F, 17F, -6F);
      bread5.mirror = true;
      this.setRotation(bread5, 0.5061455F, 0.1745329F, -0.2268928F);
      bread4.addBox(0F, 0F, 0F, 5, 3, 5);
      bread4.setRotationPoint(-6F, 19F, -6F);
      bread4.mirror = true;
      this.setRotation(bread4, 0.5235988F, 0.2094395F, -0.5585054F);
  }
  
  public void render (Entity par1Entity, float par2, float par3, float par4, byte par5, float par6, float par7)
  {
	  super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	  this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	  if (par5 > 0)
	  {
		  this.bread1.render(par7);
		  if (par5 > 1)
		  {
			  this.bread2.render(par7);
			  if (par5 > 2)
			  {
				  this.bread3.render(par7);
				  if (par5 > 3)
				  {
					  this.bread5.render(par7);
					  if (par5 > 4)
					  {
						  this.bread4.render(par7);
					  }
				  }
			  }
		  }
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
  }
}
