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
public class RenderChalcedonyLamp implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;//side_1 chalcedony
	private Icon glassIcon;//glass
	private Icon Icon0;//side_0 white inner , force rods and burst plate
	private Icon Icon2;//side_2 force rods2 and burst glow
	private Icon Icon3;//side_3 burst panel
	
	public static int modelCLamp = -1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		if (meta > 5)meta = 5;
		this.boxIcon = DCsAppleMilk.cLamp.getIcon(1, meta);
		this.glassIcon = Block.glass.getBlockTextureFromSide(0);
		this.Icon0 = DCsAppleMilk.cLamp.getIcon(0, meta);
		this.Icon2 = DCsAppleMilk.cLamp.getIcon(2, meta);
		this.Icon3 = DCsAppleMilk.cLamp.getIcon(3, meta);
		
		if (modelID == this.getRenderId())
		{
			if (meta == 0 || meta == 1) //for normal glass lamp
			{
				renderInvCuboid(renderer, block,  0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F,  this.Icon0);
			}
			else if (meta == 2 || meta == 3) //for inner glass lamp
			{
				renderInvCuboid(renderer, block,  0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F,  this.glassIcon);
				renderInvCuboid(renderer, block,  3.0F/16.0F, 3.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F,  this.boxIcon);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F,  this.Icon0);
			}
			else if (meta == 4)
			{
				
				//wing1
				renderInvCuboid(renderer, block,  7.0F/16.0F, 9.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F, 2.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 9.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 9.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 9.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F,  this.Icon2);
				
				renderInvCuboid(renderer, block,  6.0F/16.0F, 6.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 2.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  6.0F/16.0F, 6.0F/16.0F, 14.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 2.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F,  this.Icon2);
				
				renderInvCuboid(renderer, block,  7.0F/16.0F, 1.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 3.0F/16.0F, 2.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 1.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 3.0F/16.0F, 15.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F,  this.Icon2);
				//blade
				renderInvCuboid(renderer, block,  7.0F/16.0F, 5.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 2.0F/16.0F,  this.Icon3);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 5.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F,  this.Icon3);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 5.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F,  this.Icon3);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 5.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F,  this.Icon3);
				//plate
				renderInvCuboid(renderer, block,  5.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  5.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 3.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 3.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F,  this.Icon0);
				
				renderInvCuboid(renderer, block,  7.0F/16.0F, 3.0F/16.0F, 0.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  7.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 16.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  0.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 16.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F,  this.Icon0);
				//plate2
				renderInvCuboid(renderer, block,  4.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F,  this.Icon2);
				//plate3
				renderInvCuboid(renderer, block,  11.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  11.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  1.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  14.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F,  this.Icon2);
				
			}
			else if (meta == 5)
			{
				//force
				renderInvCuboid(renderer, block,  4.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 15.0F/16.0F, 12.0F/16.0F,  this.boxIcon);
				
				//rod
				renderInvCuboid(renderer, block,  2.0F/16.0F, 2.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  2.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 14.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  13.0F/16.0F, 2.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F,  this.Icon2);
				renderInvCuboid(renderer, block,  13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 14.0F/16.0F,  this.Icon2);
				
				//rod 2
				renderInvCuboid(renderer, block,  3.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  3.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  12.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  12.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  10.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  3.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  3.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F, 14.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  12.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  12.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 13.0F/16.0F,  this.Icon0);
				//base
				renderInvCuboid(renderer, block,  7.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F,  this.Icon0);
				renderInvCuboid(renderer, block,  4.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F,  this.Icon0);
			}		
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 5)meta = 5;
		this.boxIcon = DCsAppleMilk.cLamp.getIcon(1, meta);
		this.glassIcon = Block.glass.getBlockTextureFromSide(0);
		this.Icon0 = DCsAppleMilk.cLamp.getIcon(0, meta);
		this.Icon2 = DCsAppleMilk.cLamp.getIcon(2, meta);
		this.Icon3 = DCsAppleMilk.cLamp.getIcon(3, meta);
		
		if (modelId == this.getRenderId())
		{
			if (meta == 0 || meta == 1)
			{
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (meta == 2 || meta == 3)
			{
				renderer.setOverrideBlockTexture(this.glassIcon);
				block.setBlockBounds(0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(3.0F/16.0F, 3.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else if (meta == 4)
			{
				//wing1
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(7.0F/16.0F, 10.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(7.0F/16.0F, 10.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(1.0F/16.0F, 10.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(14.0F/16.0F, 10.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//wing2
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(6.0F/16.0F, 6.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(6.0F/16.0F, 6.0F/16.0F, 14.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(1.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 2.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(14.0F/16.0F, 6.0F/16.0F, 6.0F/16.0F, 15.0F/16.0F, 10.0F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//wing3
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(7.0F/16.0F, 1.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 3.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(7.0F/16.0F, 1.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 3.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(1.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(14.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 3.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				//blade
				renderer.setOverrideBlockTexture(this.Icon3);
				block.setBlockBounds(7.0F/16.0F, 5.0F/16.0F, 1.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon3);
				block.setBlockBounds(7.0F/16.0F, 5.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon3);
				block.setBlockBounds(1.0F/16.0F, 5.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon3);
				block.setBlockBounds(14.0F/16.0F, 5.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 9.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				//plate
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(5.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(5.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 11.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(1.0F/16.0F, 3.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(14.0F/16.0F, 3.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 11.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 3.0F/16.0F, 0.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 9.0F/16.0F, 5.0F/16.0F, 16.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(0.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(14.0F/16.0F, 3.0F/16.0F, 7.0F/16.0F, 16.0F/16.0F, 5.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				//plate2
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(4.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(4.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(1.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(14.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 5.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//plate3
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(11.0F/16.0F, 3.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(11.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 5.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(1.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 2.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(14.0F/16.0F, 3.0F/16.0F, 11.0F/16.0F, 15.0F/16.0F, 5.0F/16.0F, 12.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//base
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 6.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(4.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
			}
			else if (meta == 5)
			{
				//force
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(4.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 15.0F/16.0F, 12.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//rod
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(2.0F/16.0F, 2.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(2.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(13.0F/16.0F, 2.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon2);
				block.setBlockBounds(13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 12.0F/16.0F, 14.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//rod2
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(3.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(3.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(12.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(12.0F/16.0F, 11.0F/16.0F, 10.0F/16.0F, 13.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//rod3
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(4.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(4.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 6.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(10.0F/16.0F, 11.0F/16.0F, 3.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(10.0F/16.0F, 11.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//rod4
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(3.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(3.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 4.0F/16.0F, 14.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(12.0F/16.0F, 12.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 4.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(12.0F/16.0F, 12.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 14.0F/16.0F, 13.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				//base
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(7.0F/16.0F, 1.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F, 7.0F/16.0F, 9.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setOverrideBlockTexture(this.Icon0);
				block.setBlockBounds(4.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F);
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
		
		return DCsAppleMilk.modelCLamp;
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
