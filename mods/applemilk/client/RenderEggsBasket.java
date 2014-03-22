package mods.applemilk.client;

import org.lwjgl.opengl.GL11;

import mods.applemilk.common.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEggsBasket implements ISimpleBlockRenderingHandler{
	
	private Icon[] boxIcon = new Icon[3];
	private Icon eggIcon;
	private Icon eggBlackIcon;
	private Icon cageicon;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 3)meta = 3;
		this.boxIcon[2] = DCsAppleMilk.Basket.getBlockTextureFromSide(0);
		this.boxIcon[1] = DCsAppleMilk.Basket.getBlockTextureFromSide(1);
		this.boxIcon[0] = DCsAppleMilk.Basket.getBlockTextureFromSide(2);
		this.eggIcon = DCsAppleMilk.eggBasket.getBlockTextureFromSide(0);
		this.eggBlackIcon = DCsAppleMilk.eggBasket.getBlockTextureFromSide(1);
		this.cageicon = DCsAppleMilk.eggBasket.getBlockTextureFromSide(2);
		
		if (modelID == this.getRenderId())
		{
			//box
			if (meta < 2)
			{
				renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F,  this.boxIcon[2]);
				renderInvCuboid(renderer, block,  0.0F/16.0F, 7.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[1]);
				
				renderInvCuboid(renderer, block,  0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
				renderInvCuboid(renderer, block,  15.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 1.0F/16.0F,  this.boxIcon[0]);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
			}
			else
			{
				renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 6.0F/16.0F, 15.0F/16.0F,  this.cageicon);
			}
			
			if ((meta & 1) == 0)
			{
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 1.0F/16.0F, 6.0F/16.0F, 7.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  8.0F/16.0F, 1.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggIcon);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggIcon);
			}
			else
			{
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 1.0F/16.0F, 6.0F/16.0F, 7.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  8.0F/16.0F, 1.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggBlackIcon);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F,  this.eggBlackIcon);
			}

		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 3)meta = 3;
		this.boxIcon[2] = DCsAppleMilk.Basket.getBlockTextureFromSide(0);
		this.boxIcon[1] = DCsAppleMilk.Basket.getBlockTextureFromSide(1);
		this.boxIcon[0] = DCsAppleMilk.Basket.getBlockTextureFromSide(2);
		this.cageicon = DCsAppleMilk.eggBasket.getBlockTextureFromSide(2);
		
		if (modelId == this.getRenderId())
		{
			//box
			if (meta < 2)
			{
				renderer.setOverrideBlockTexture(this.boxIcon[2]);
				block.setBlockBounds(1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon[1]);
				block.setBlockBounds(0.0F/16.0F, 7.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon[0]);
				block.setBlockBounds(0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.boxIcon[0]);
				block.setBlockBounds(15.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.boxIcon[0]);
				block.setBlockBounds(1.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 1.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.boxIcon[0]);
				block.setBlockBounds(1.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else
			{
				renderer.setOverrideBlockTexture(this.cageicon);
				block.setBlockBounds(1.0F/16.0F, 0.5F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 2.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			renderer.clearOverrideBlockTexture();
			block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(block);
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		
		return true;
	}

	@Override
	public int getRenderId() {
		
		return DCsAppleMilk.modelEggBasket;
	}
	
	private void renderInvCuboid(RenderBlocks renderer, Block block, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, Icon icon)
	{
		Tessellator tessellator = Tessellator.instance;
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		block.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		renderer.setRenderBoundsFromBlock(block);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
	}
}
