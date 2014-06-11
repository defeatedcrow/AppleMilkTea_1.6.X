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
public class RenderCassisTree implements ISimpleBlockRenderingHandler{
	
	private Icon LeavesIcon;
	private Icon newLeavesIcon;
	private Icon woodIcon;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata & 7;
		this.LeavesIcon = DCsAppleMilk.cassisTree.getBlockTextureFromSide(1);
		this.newLeavesIcon = DCsAppleMilk.cassisTree.getIcon(2, meta);
		this.woodIcon = DCsAppleMilk.cassisTree.getBlockTextureFromSide(0);
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  1.0F/16.0F, 2.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F,  this.LeavesIcon);
			renderInvCuboid(renderer, block,  6.0F/16.0F, 0.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F,  this.woodIcon);
			if((meta & 3) > 0)
			{
				renderInvCuboid(renderer, block,  0.0F/16.0F, 1.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F,  this.newLeavesIcon);
			}
			
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		meta = meta & 7;
		this.LeavesIcon = DCsAppleMilk.cassisTree.getBlockTextureFromSide(1);
		this.newLeavesIcon = DCsAppleMilk.cassisTree.getIcon(2, meta);
		this.woodIcon = DCsAppleMilk.cassisTree.getBlockTextureFromSide(0);
		
		if (modelId == this.getRenderId())
		{
			int underID = world.getBlockId(x, y - 1, z);
			int upperID = world.getBlockId(x, y + 1, z);
			
			if (underID == block.blockID)
			{
				renderer.setOverrideBlockTexture(this.LeavesIcon);
				block.setBlockBounds(1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else
			{
				renderer.setOverrideBlockTexture(this.woodIcon);
				block.setBlockBounds(6.0F/16.0F, 0.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				if (upperID == block.blockID)
				{
					renderer.setOverrideBlockTexture(this.LeavesIcon);
					block.setBlockBounds(1.0F/16.0F, 2.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 15.5F/16.0F, 15.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.setOverrideBlockTexture(this.LeavesIcon);
					block.setBlockBounds(1.0F/16.0F, 2.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			
			
			if ((meta & 3) > 0)
			{
				renderer.setOverrideBlockTexture(this.newLeavesIcon);
				block.setBlockBounds(0.0F/16.0F, 1.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F);
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
		
		return DCsAppleMilk.modelCassisTree;
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
