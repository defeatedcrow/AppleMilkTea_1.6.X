package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileRotaryDial;
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
public class TileEntityDialRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation dialTex = new ResourceLocation("applemilk:textures/entity/rotarydial.png");
    public static TileEntityDialRenderer dialRenderer;
    private ModelRotaryDial dialModel = new ModelRotaryDial();

    public void renderTileEntitySteakAt(TileRotaryDial par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation(par1Tile, (float)par2, (float)par4, (float)par6, par1Tile.getDirectionByte());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        dialRenderer = this;
    }

    public void setRotation(TileRotaryDial par0Tile, float par1, float par2, float par3, byte par4)
    {
        ModelRotaryDial model = this.dialModel;
        byte l = (byte)par0Tile.getBlockMetadata();
        byte k = par4;
        float j = 0;
        if (k == 0) j = 180.0F;
        if (k == 1) j = -90.0F;
        if (k == 2) j = 0.0F;
        if (k == 4) j = 90.0F;

        this.bindTexture(dialTex);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, j, 0.0F, 0.0625F, l);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();  
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntitySteakAt((TileRotaryDial)par1TileEntity, par2, par4, par6, par8);
    }
}
