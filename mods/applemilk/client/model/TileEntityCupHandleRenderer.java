package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileCupHandle;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityCupHandleRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation CupHandleTex = new ResourceLocation("applemilk:textures/blocks/porcelain.png");
    public static TileEntityCupHandleRenderer cupRenderer;
    private ModelCupHandle cupHandleModel = new ModelCupHandle();

    public void renderTileEntityCupAt(TileCupHandle par1TileCupHandle, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1TileCupHandle.getDirectionByte());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        cupRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, byte par4)
    {
        ModelCupHandle modelCupHandle = this.cupHandleModel;


        this.bindTexture(CupHandleTex);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par1, (float)par2 + 1.0F, (float)par3 + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short short1 = 0;

        GL11.glTranslatef(0.0F, -1.0F, 0.0F);
        GL11.glRotatef((float)short1, 0.0F, -1.0F, 0.0F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        this.cupHandleModel.render((Entity)null, 0.0F, 0.0F, 0.0F, par4, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityCupAt((TileCupHandle)par1TileEntity, par2, par4, par6, par8);
    }
}
