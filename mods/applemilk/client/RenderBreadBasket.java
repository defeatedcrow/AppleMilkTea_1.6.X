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
public class RenderBreadBasket implements ISimpleBlockRenderingHandler{
	
	private Icon[] boxIcon = new Icon[3];
	private Icon breadIconS;
	private Icon breadIconT;
	
	public static int modelBasket = -1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 5)meta = 5;
		this.boxIcon[0] = DCsAppleMilk.Basket.getBlockTextureFromSide(0);
		this.boxIcon[1] = DCsAppleMilk.Basket.getBlockTextureFromSide(1);
		this.boxIcon[2] = DCsAppleMilk.Basket.getBlockTextureFromSide(2);
		this.breadIconS = DCsAppleMilk.Basket.getBlockTextureFromSide(3);
		this.breadIconT = DCsAppleMilk.Basket.getBlockTextureFromSide(4);
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F,  this.boxIcon[2]);
			renderInvCuboid(renderer, block,  0.0F/16.0F, 7.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[1]);
			
			renderInvCuboid(renderer, block,  0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
			renderInvCuboid(renderer, block,  15.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
			renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 1.0F/16.0F,  this.boxIcon[0]);
			renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 16.0F/16.0F,  this.boxIcon[0]);
			
			
			if (DCsAppleMilk.noUseCupDirection)
			{
				//contents
				if (meta > 0)
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 1.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F,  this.breadIconS);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 3.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 6.0F/16.0F,  this.breadIconT);
				}
				if (meta > 1)
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F,  this.breadIconS);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 10.0F/16.0F,  this.breadIconT);
				}
				if (meta > 2)
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F,  this.breadIconS);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 14.0F/16.0F,  this.breadIconT);
				}
				if (meta > 3)
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F,  this.breadIconS);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 7.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 9.0F/16.0F, 8.0F/16.0F,  this.breadIconT);
				}
				if (meta > 4)
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 12.0F/16.0F,  this.breadIconS);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 13.0F/16.0F, 9.0F/16.0F, 12.0F/16.0F,  this.breadIconT);
				}
			}

		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 5)meta = 5;
		this.boxIcon[0] = DCsAppleMilk.Basket.getBlockTextureFromSide(0);
		this.boxIcon[1] = DCsAppleMilk.Basket.getBlockTextureFromSide(1);
		this.boxIcon[2] = DCsAppleMilk.Basket.getBlockTextureFromSide(2);
		this.breadIconS = DCsAppleMilk.Basket.getBlockTextureFromSide(3);
		this.breadIconT = DCsAppleMilk.Basket.getBlockTextureFromSide(4);
		
		if (modelId == this.getRenderId())
		{
			//box
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
			
			
			if (DCsAppleMilk.noUseCupDirection)
			{
				//contents
				if (meta > 0)
				{
					renderer.setOverrideBlockTexture(this.breadIconS);
					block.setBlockBounds(3.0F/16.0F, 1.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setOverrideBlockTexture(this.breadIconT);
					block.setBlockBounds(3.0F/16.0F, 3.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 6.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				if (meta > 1)
				{
					renderer.setOverrideBlockTexture(this.breadIconS);
					block.setBlockBounds(3.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setOverrideBlockTexture(this.breadIconT);
					block.setBlockBounds(3.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 10.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				if (meta > 2)
				{
					renderer.setOverrideBlockTexture(this.breadIconS);
					block.setBlockBounds(3.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setOverrideBlockTexture(this.breadIconT);
					block.setBlockBounds(3.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 14.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				if (meta > 3)
				{
					renderer.setOverrideBlockTexture(this.breadIconS);
					block.setBlockBounds(3.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setOverrideBlockTexture(this.breadIconT);
					block.setBlockBounds(3.0F/16.0F, 7.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 9.0F/16.0F, 8.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				if (meta > 4)
				{
					renderer.setOverrideBlockTexture(this.breadIconS);
					block.setBlockBounds(3.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setOverrideBlockTexture(this.breadIconT);
					block.setBlockBounds(3.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 13.0F/16.0F, 9.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
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
		
		return DCsAppleMilk.modelBasket;
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
