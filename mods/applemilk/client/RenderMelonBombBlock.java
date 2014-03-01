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
public class RenderMelonBombBlock implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;
	private Icon coverIcon1;
	private Icon coverIcon2;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		this.boxIcon = Block.melon.getBlockTextureFromSide(2);
		this.coverIcon1 = Block.melon.getBlockTextureFromSide(1);
		this.coverIcon2 = Block.melon.getBlockTextureFromSide(0);
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  1.0F/16.0F, 1.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 14.0F/16.0F, 15.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  1.0F/16.0F, 14.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F,  this.coverIcon1);
			renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F,  this.coverIcon2);
			
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int ID = block.blockID;
		int meta = world.getBlockMetadata(x, y, z);
		this.boxIcon = Block.melon.getBlockTextureFromSide(2);
		this.coverIcon1 = Block.melon.getBlockTextureFromSide(1);
		this.coverIcon2 = Block.melon.getBlockTextureFromSide(0);
		
		if (modelId == this.getRenderId())
		{
			//box
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			renderer.setOverrideBlockTexture(this.coverIcon1);
			block.setBlockBounds(2.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 14.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			renderer.setOverrideBlockTexture(this.coverIcon2);
			block.setBlockBounds(2.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 1.0F/16.0F, 14.0F/16.0F);
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
		
		return DCsAppleMilk.modelMelonBomb;
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
