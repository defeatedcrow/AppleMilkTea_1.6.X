package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileCupHandle;
import mods.applemilk.common.tile.TileWipeBox;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityWipeBoxRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation wipeTex = new ResourceLocation("applemilk:textures/entity/wipebox.png");
    public static TileEntityWipeBoxRenderer wipeRenderer;
    private ModelWipeBox wipeModel = new ModelWipeBox();

    public void renderTileEntityWipeAt(TileWipeBox par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1Tile.blockMetadata, par1Tile);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        wipeRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, int par4, TileWipeBox tile)
    {
        ModelWipeBox model = this.wipeModel;
        byte l = (byte)tile.getBlockMetadata();

        this.bindTexture(wipeTex);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, l, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityWipeAt((TileWipeBox)par1TileEntity, par2, par4, par6, par8);
    }
}