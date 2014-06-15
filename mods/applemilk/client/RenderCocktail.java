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
public class RenderCocktail implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;
	private Icon contentsIcon;
	private Icon topIcon;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		this.boxIcon = DCsAppleMilk.blockIcecream.getBlockTextureFromSide(0);
		this.contentsIcon = DCsAppleMilk.cocktail.getIcon(1, meta);
		this.topIcon = DCsAppleMilk.cocktail.getIcon(1, 5);
		
		if (modelID == this.getRenderId())
		{
			if (meta == 5 || meta == 7 || meta == 8 || meta == 9 || meta > 10) { //long type
				//bottom
				renderInvCuboid(renderer, block,  5.0F/16.0F, 0.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 1.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 9.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  11.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F, 9.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				
				//contents
				renderInvCuboid(renderer, block,  5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 7.0F/16.0F, 11.0F/16.0F,  this.contentsIcon);
			}
			else { //short type
				//bottom
				renderInvCuboid(renderer, block,  6.0F/16.0F, 0.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  7.5F/16.0F, 1.0F/16.0F, 7.5F/16.0F, 8.50F/16.0F, 3.0F/16.0F, 8.5F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  5.0F/16.0F, 4.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				
				renderInvCuboid(renderer, block,  4.0F/16.0F, 6.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 5.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 8.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  11.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 11.0F/16.0F,  this.boxIcon);
				
				//contents
				renderInvCuboid(renderer, block,  5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 7.0F/16.0F, 11.0F/16.0F,  this.contentsIcon);
				if (meta < 2) {//frozen
					renderInvCuboid(renderer, block,  5.5F/16.0F, 7.0F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 8.0F/16.0F, 10.5F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  6.0F/16.0F, 8.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 9.0F/16.0F, 10.0F/16.0F,  this.contentsIcon);
				}
			}
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		this.boxIcon = DCsAppleMilk.blockIcecream.getBlockTextureFromSide(0);
		this.contentsIcon = DCsAppleMilk.cocktail.getIcon(1, meta);
		this.topIcon = DCsAppleMilk.cocktail.getIcon(1, 5);
		
		if (modelId == this.getRenderId())
		{
			
			if (meta < 2) {//frozen
				//contents
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 7.5F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.5F/16.0F, 5.0F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 6.0F/16.0F, 10.5F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.5F/16.0F, 7.5F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 8.5F/16.0F, 10.5F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(6.0F/16.0F, 8.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 9.5F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (meta == 5 || meta == 8 || meta == 9 || meta > 10) {//long
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 8.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (meta == 6 || meta == 10) {//wine glass
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 9.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.5F/16.0F, 5.0F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 6.0F/16.0F, 10.5F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				if (meta == 6)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(5.5F/16.0F, 9.0F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 9.5F/16.0F, 10.5F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(6.0F/16.0F, 9.5F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				
			}
			else if (meta == 7) {
				renderer.setOverrideBlockTexture(this.topIcon);
				block.setBlockBounds(5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 8.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 6.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else {//short
				//contents
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 7.5F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.contentsIcon);
				block.setBlockBounds(5.5F/16.0F, 5.0F/16.0F, 5.5F/16.0F, 10.5F/16.0F, 6.0F/16.0F, 10.5F/16.0F);
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
		
		return DCsAppleMilk.modelCocktail;
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
