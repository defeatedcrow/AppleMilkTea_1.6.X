package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileChopsticksBox;

public class BlockChopsticksBox extends BlockContainer{	
		
	public BlockChopsticksBox (int blockid)
	{
		super(blockid, Material.wood);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        int bottomBlockID = par1World.getBlockId(par2, par3 - 1, par4);
        
        if (itemstack == null)
        {
    		if (currentMeta == 0)
    		{
    			return false;
    		}
    		else
    		{
    			this.getBowl(par5EntityPlayer, currentMeta);
    			par1World.setBlockMetadataWithNotify(par2, par3, par4, (currentMeta - 1), 3);
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        		return true;
    		}
        }
        else if (itemstack.itemID == DCsAppleMilk.chopsticks.itemID)
        {
        	if (currentMeta >= 4)
        	{
        		return false;
        	}
        	else
        	{
        		if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                {
            		par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            	par1World.setBlockMetadataWithNotify(par2, par3, par4, (currentMeta + 1), 3);
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        		return true;
        	}
        }
        else
        {
        	return false;
        }
    }
	
	private void getBowl (EntityPlayer player, int meta)
	{
		if (player.isSneaking())
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.chopsticks,1, 1)))
	    	{
	    		player.entityDropItem(new ItemStack(DCsAppleMilk.chopsticks,1, 1), 1);
	    	}
		}
		else
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.chopsticks,1, 0)))
	    	{
	    		player.entityDropItem(new ItemStack(DCsAppleMilk.chopsticks,1, 0), 1);
	    	}
		}
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}
 
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelChopsticks;
	}
	
	//tile
	@Override
	public TileEntity createNewTileEntity(World world) {
		return DCsAppleMilk.noUseCupDirection ? null : new TileChopsticksBox();
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.TeaMakerBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void TeaMakerBoundingBox (int par1)
	{
		float f = 0.3F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.8F, 1.0F - f);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		return Block.planks.getIcon(1, 0);
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = Block.planks.getIcon(1, 0);
		
	}
}
