package mods.applemilk.client.gui;

import mods.applemilk.common.tile.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
 
public class GuiIceMaker extends GuiContainer {
 
	private TileIceMaker tileentity;
	private TileIceMaker inventory;
 
	public GuiIceMaker(EntityPlayer player, TileIceMaker par2TileEntity) {
		super(new ContainerIceMaker(player, par2TileEntity));
		this.tileentity = par2TileEntity;
		this.inventory = par2TileEntity;
	}
 
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		//インベントリ名の描画
		String s = this.inventory.isInvNameLocalized() ? this.inventory.getInvName() : I18n.getString(this.inventory.getInvName());
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
 
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
 
		//テクスチャの指定
		//ResourceLocationの第一引数を付け足してドメインを指定することもできる
		//例:new ResourceLocation("sample", "textures/gui/container/furnace.png")
		this.mc.getTextureManager().bindTexture(new ResourceLocation("applemilk", "textures/gui/icemakergui.png"));
 
		//かまど描画処理
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		int i2;
 
		i1 = this.tileentity.getBurnTimeRemainingScaled(16);
		this.drawTexturedModalRect(k + 57, l + 36 + 16 - i1, 176, 16 - i1, 14, i1);
 
		i2 = this.tileentity.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i2 + 1, 16);
	}
 
}
