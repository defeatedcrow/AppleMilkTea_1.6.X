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
public class RenderSoupPan implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;
	private Icon contentsIcon;
	private Icon contentsIcon2;
	
	public static int modelPan = -1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 12)meta = 12;
		this.boxIcon = Block.hardenedClay.getBlockTextureFromSide(1);
		this.contentsIcon = DCsAppleMilk.filledPan.getIcon(0, meta);
		this.contentsIcon2 = DCsAppleMilk.filledPan2.getIcon(0, meta);
		int ID = block.blockID;
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  0.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 8.0F/16.0F, 9.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  14.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 9.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  2.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  13.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 4.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			
			//contents
			if (ID == DCsAppleMilk.filledPan.blockID)
			{
				renderInvCuboid(renderer, block,  3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 6.0F/16.0F, 13.0F/16.0F,  this.contentsIcon);
			}
			if (ID == DCsAppleMilk.filledPan2.blockID)
			{
				renderInvCuboid(renderer, block,  3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 6.0F/16.0F, 13.0F/16.0F,  this.contentsIcon2);
			}
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int ID = block.blockID;
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 12)meta = 12;
		this.boxIcon = Block.hardenedClay.getBlockTextureFromSide(1);
		this.contentsIcon = DCsAppleMilk.filledPan.getIcon(0, meta);
		this.contentsIcon2 = DCsAppleMilk.filledPan2.getIcon(0, meta);
		
		if (modelId == this.getRenderId())
		{
			//box
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			if (DCsAppleMilk.noUseCupDirection){
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(0.0F/16.0F, 7.0F/16.0F, 6.0F/16.0F, 2.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(14.0F/16.0F, 7.0F/16.0F, 6.0F/16.0F, 16.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			}
			
			//contents
			if (ID == DCsAppleMilk.filledPan.blockID)
			{
				if (meta < 4)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if (meta < 8)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			if (ID == DCsAppleMilk.filledPan2.blockID)
			{
				if (meta < 4)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon2);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if (meta < 8)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon2);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.setOverrideBlockTexture(this.contentsIcon2);
					block.setBlockBounds(3.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(2.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(13.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 3.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
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
		
		return DCsAppleMilk.modelPan;
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


