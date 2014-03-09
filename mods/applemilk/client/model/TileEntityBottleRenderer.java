package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileLargeBottle;
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
public class TileEntityBottleRenderer extends TileEntitySpecialRenderer
{
    private static ResourceLocation bottleTex = new ResourceLocation("applemilk:textures/entity/largebottle.png");
    private static final String[] type = new String[] {"", "_sake", "_beer", "_wine", "_gin", "_rum"};
    public static TileEntityBottleRenderer bottleRenderer;
    private ModelLargeBottle bottleModel = new ModelLargeBottle();

    public void renderTileEntityBottleAt(TileLargeBottle par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation(par1Tile, (float)par2, (float)par4, (float)par6);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        bottleRenderer = this;
    }

    public void setRotation(TileLargeBottle par0Tile, float par1, float par2, float par3)
    {
        ModelLargeBottle model = this.bottleModel;
        byte l = (byte)(par0Tile.getBlockMetadata()& 15);
        if (l > 5) l = 5;
        String texPass = new String ("applemilk:textures/entity/largebottle" + type[l] + ".png");
        bottleTex = new ResourceLocation(texPass);
        this.bindTexture(bottleTex);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();  
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityBottleAt((TileLargeBottle)par1TileEntity, par2, par4, par6, par8);
    }
}
