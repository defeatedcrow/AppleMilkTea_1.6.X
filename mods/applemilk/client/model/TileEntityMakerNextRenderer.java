package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.api.TeaRecipe;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityMakerNextRenderer extends TileEntitySpecialRenderer
{
    private static ResourceLocation makerTex = new ResourceLocation("applemilk:textures/blocks/contents_milk.png");
    private static final ResourceLocation emptyTex = new ResourceLocation("applemilk:textures/blocks/contents_water.png");
    public static TileEntityMakerNextRenderer makerRenderer;
    private ModelMakerNext nextModel = new ModelMakerNext();

    public void renderTileEntityMakerAt(TileMakerNext par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1Tile.getID(), par1Tile.getMilked());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        makerRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, byte par4, boolean milk)
    {
        ModelMakerNext model = this.nextModel;
        String tex = TeaRecipe.getTex(par4);
        makerTex = new ResourceLocation(tex);

        if (par4 == 0)
        {
        	this.bindTexture(emptyTex);
        }
        else
        {
        	this.bindTexture(makerTex);
        }
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(0.8F, 0.8F, 0.8F, 1.0F);
        if (milk)
        {
        	GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
        }
        else
        {
        	GL11.glColor4f(0.8F, 0.8F, 0.8F, 1.0F);
        }
        GL11.glTranslatef((float)par1, (float)par2 + 1.0F, (float)par3 + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short short1 = 0;

        GL11.glTranslatef(0.0F, -1.0F, 0.0F);
        GL11.glRotatef((float)short1, 0.0F, -1.0F, 0.0F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityMakerAt((TileMakerNext)par1TileEntity, par2, par4, par6, par8);
    }
}
