package mods.applemilk.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import mods.applemilk.common.tile.ContainerAutoMaker;
import mods.applemilk.common.tile.TileAutoMaker;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonMerchant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiAutoMaker extends GuiContainer
{
    private static final ResourceLocation guiTextures = new ResourceLocation("applemilk", "textures/gui/automakergui.png");
    private IInventory playerInv;
    private IInventory entityInv;
    private TileAutoMaker tileMaker;
    private GuiButtonAutoMaker modeButtonIndex;
    private ContainerAutoMaker containerAutoMaker;
    private static final String[] modeString = new String[] {"Disabled Automated TeaMaker.", "Enabled Auto mode.", "Enabled RS mode.", "Enabled Manual mode."};

    public GuiAutoMaker(InventoryPlayer par1InventoryPlayer, TileAutoMaker tile)
    {
        super(new ContainerAutoMaker(par1InventoryPlayer, tile));
        this.playerInv = par1InventoryPlayer;
        this.entityInv = tile;
        this.containerAutoMaker = (ContainerAutoMaker)this.inventorySlots;
        this.tileMaker = tile;
        this.allowUserInput = true;
        this.ySize = 168;
    }
    
    public void initGui()
    {
        super.initGui();
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.buttonList.add(this.modeButtonIndex = new GuiButtonAutoMaker(1, i + 80, j + 24, 0));
        this.modeButtonIndex.enabled = true;
        this.modeButtonIndex.buttonType = this.containerAutoMaker.getMode();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	String s = this.entityInv.isInvNameLocalized() ? this.entityInv.getInvName() : I18n.getString(this.entityInv.getInvName());
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
    
    public void updateScreen()
    {
        super.updateScreen();
        byte mode = this.containerAutoMaker.getMode();

        this.modeButtonIndex.enabled = true;
    	this.modeButtonIndex.buttonType = mode;
    }
    
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        boolean flag = false;
        int mode = this.modeButtonIndex.buttonType;

        if (par1GuiButton == this.modeButtonIndex)
        {
            ++mode;
            if (mode > 2) mode = 0;
            flag = true;
        }

        if (flag)
        {
            this.tileMaker.setMode((byte)mode);
            this.mc.thePlayer.addChatMessage(this.modeMessage());
            this.containerAutoMaker.onButtonPushed(mode);
        }
    }

    private String modeMessage() {
		
		String s = "[AppleMilk] " + this.modeString[this.modeButtonIndex.buttonType];
    	return s;
	}

	/**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        if (this.tileMaker.getMode() == 0)
        {
        	this.drawTexturedModalRect(k + 80, l + 24, 176, 0, 16, 16);
        }
        else
        {
        	this.drawTexturedModalRect(k + 80, l + 24, 176, 16, 16, 16);
        }
    }
    
    public TileAutoMaker getAutoMaker()
    {
    	return this.tileMaker;
    }
    
    static ResourceLocation textureForButton()
    {
        return guiTextures;
    }
}
