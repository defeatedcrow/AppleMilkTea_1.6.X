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
public class RenderTeaMaker implements ISimpleBlockRenderingHandler{
	
	private Icon contentsIcon;
	private Icon boxIcon;
	private Icon glassIcon;
	
	public static int modelTeaMaker = -1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 13)meta = 13;
		this.glassIcon = Block.glass.getIcon(0, 0);
		this.boxIcon = DCsAppleMilk.teaMaker.getIcon(1, meta);
		this.contentsIcon = DCsAppleMilk.teaMaker.getIcon(0, meta);
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  4.0F/16.0F, 13.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 16.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  6.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 10.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  7.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F, 9.0F/16.0F, 12.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  4.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  4.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  11.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  11.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
			
			//glass
			renderInvCuboid(renderer, block,  4.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F,  this.glassIcon);
			//contents
			renderInvCuboid(renderer, block,  5.0F/16.0F, 4.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 11.0F/16.0F, 11.0F/16.0F,  this.contentsIcon);
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 13)meta = 13;
		this.glassIcon = Block.glass.getIcon(0, 0);
		this.boxIcon = DCsAppleMilk.teaMaker.getIcon(1, meta);
		this.contentsIcon = DCsAppleMilk.teaMaker.getIcon(0, meta);
		
		if (modelId == this.getRenderId())
		{
			//box
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(4.0F/16.0F, 13.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 16.0F/16.0F, 12.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			if (DCsAppleMilk.noUseCupDirection)
			{
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(6.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 10.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(7.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 9.0F/16.0F, 14.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(7.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 9.0F/16.0F, 6.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(7.0F/16.0F, 5.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 14.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			
			}
			
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(4.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(4.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(11.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(11.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			//glass
			renderer.setOverrideBlockTexture(this.glassIcon);
			block.setBlockBounds(4.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			//contents
			renderer.setOverrideBlockTexture(this.contentsIcon);
			block.setBlockBounds(5.0F/16.0F, 4.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 11.0F/16.0F, 11.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
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
		
		return DCsAppleMilk.modelTeaMaker;
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
