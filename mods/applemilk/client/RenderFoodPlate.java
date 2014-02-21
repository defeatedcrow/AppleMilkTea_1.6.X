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
public class RenderFoodPlate implements ISimpleBlockRenderingHandler{
	
	private Icon woodIcon;
	private Icon contentsIcon;
	private Icon plateIcon;
	private Icon dishIcon;
	private Icon tsukeawase1;
	private Icon tsukeawase2;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 4)meta = 4;
		this.woodIcon = Block.planks.getIcon(0, 0);
		this.contentsIcon = DCsAppleMilk.foodPlate.getIcon(2, meta);
		this.plateIcon = DCsAppleMilk.teppann.getBlockTextureFromSide(1);
		this.dishIcon = DCsAppleMilk.foodPlate.getBlockTextureFromSide(1);
		this.tsukeawase1 = DCsAppleMilk.foodPlate.getBlockTextureFromSide(3);
		this.tsukeawase2 = DCsAppleMilk.foodPlate.getBlockTextureFromSide(4);
		int ID = block.blockID;
		
		if (modelID == this.getRenderId())
		{
			if (meta == 0 || meta == 1)//beef and pork
			{
				//base plate
				renderInvCuboid(renderer, block,  1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F,  this.woodIcon);
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F,  this.plateIcon);
				
				//meat
				renderInvCuboid(renderer, block,  4.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 14.0F/16.0F, 6.0F/16.0F, 9.0F/16.0F,  this.contentsIcon);
				//side
				renderInvCuboid(renderer, block,  4.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F,  this.tsukeawase1);
				renderInvCuboid(renderer, block,  5.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 6.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F,  this.tsukeawase1);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F,  this.tsukeawase1);
				
				renderInvCuboid(renderer, block,  10.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F,  this.tsukeawase2);
			}
			else
			{
				//dish
				renderInvCuboid(renderer, block,  2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F,  this.dishIcon);
				renderInvCuboid(renderer, block,  5.0F/16.0F, 0.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F,  this.dishIcon);
				if (meta == 2)
				{
					//meat
					renderInvCuboid(renderer, block,  4.0F/16.0F, 2.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  4.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F, 12.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  9.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 12.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  4.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  9.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F,  this.contentsIcon);
					
					renderInvCuboid(renderer, block,  4.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F,  this.dishIcon);
					renderInvCuboid(renderer, block,  11.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F,  this.dishIcon);
				}
				else
				{
					renderInvCuboid(renderer, block,  6.0F/16.0F, 2.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  5.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  5.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 5.0F/16.0F,  this.contentsIcon);
					renderInvCuboid(renderer, block,  6.0F/16.0F, 5.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 4.0F/16.0F,  this.contentsIcon);
					
					renderInvCuboid(renderer, block,  6.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F,  this.tsukeawase2);
				}
			}
			
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int ID = block.blockID;
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 4)meta = 4;
		this.woodIcon = Block.planks.getIcon(0, 0);
		this.contentsIcon = DCsAppleMilk.foodPlate.getIcon(2, meta);
		this.plateIcon = DCsAppleMilk.teppann.getBlockTextureFromSide(1);
		this.dishIcon = DCsAppleMilk.foodPlate.getBlockTextureFromSide(1);
		this.tsukeawase1 = DCsAppleMilk.foodPlate.getBlockTextureFromSide(3);
		this.tsukeawase2 = DCsAppleMilk.foodPlate.getBlockTextureFromSide(4);
		
		if (modelId == this.getRenderId())
		{
			
			if ((meta == 0 || meta == 1))
			{
				//box
				renderer.setOverrideBlockTexture(this.woodIcon);
				block.setBlockBounds(1.0F/16.0F, 0.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F, 1.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.plateIcon);
				block.setBlockBounds(2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				if (DCsAppleMilk.noUseCupDirection)
				{
					//meat
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(4.0F/16.0F, 2.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F, 9.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					//side
					renderer.setOverrideBlockTexture(this.tsukeawase1);
					block.setBlockBounds(4.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.tsukeawase1);
					block.setBlockBounds(5.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 6.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.tsukeawase1);
					block.setBlockBounds(6.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.tsukeawase2);
					block.setBlockBounds(10.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.tsukeawase2);
					block.setBlockBounds(7.0F/16.0F, 6.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			else
			{
				//dish
				renderer.setOverrideBlockTexture(this.dishIcon);
				block.setBlockBounds(2.0F/16.0F, 1.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.dishIcon);
				block.setBlockBounds(5.0F/16.0F, 0.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				//meat
				if (meta == 2)
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(4.0F/16.0F, 2.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(4.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(9.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 12.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(4.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 7.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(9.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.dishIcon);
					block.setBlockBounds(4.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 5.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.dishIcon);
					block.setBlockBounds(11.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(6.0F/16.0F, 2.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(5.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(5.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 5.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.contentsIcon);
					block.setBlockBounds(6.0F/16.0F, 5.0F/16.0F, 3.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 4.0F/16.0F);
					renderer.setRenderBoundsFromBlock(block);
					renderer.renderStandardBlock(block, x, y, z);
					
					renderer.setOverrideBlockTexture(this.tsukeawase2);
					block.setBlockBounds(6.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F, 6.0F/16.0F, 10.0F/16.0F);
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
		
		return DCsAppleMilk.modelFoodPlate;
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
