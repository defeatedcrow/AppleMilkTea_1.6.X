package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileAlcoholCup;
import mods.applemilk.handler.Util;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityAlcoholCupRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation cocktailTex = new ResourceLocation("applemilk:textures/entity/cocktail.png");
    public static TileEntityAlcoholCupRenderer cupRenderer;
    private ModelAlcoholCup cupModel = new ModelAlcoholCup();

    public void renderTileEntityCupAt(TileAlcoholCup par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation(par1Tile, (float)par2, (float)par4, (float)par6);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        cupRenderer = this;
    }

    public void setRotation(TileAlcoholCup par0Tile, float par1, float par2, float par3)
    {
        ModelAlcoholCup model = this.cupModel;
        byte l = (byte)par0Tile.getBlockMetadata();

        this.bindTexture(cocktailTex);
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
//        GL11.glPolygonOffset(-1, -1);
//        GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
//        
//        GL11.glEnable(GL11.GL_STENCIL_TEST);
//        GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);
//        GL11.glStencilFunc(GL11.GL_NOTEQUAL, 1, 1);
//        GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        model.renderGlass((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, l);
        
//        GL11.glDisable(GL11.GL_STENCIL_TEST);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
//        GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix(); 
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityCupAt((TileAlcoholCup)par1TileEntity, par2, par4, par6, par8);
    }
}
