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
import mods.applemilk.common.tile.TileWipeBox;

public class BlockWipeBox extends BlockContainer{
	
	private static final String[] boxType = new String[] {"_B", "_T", "_S1", "_S2", "_C" ,"_C"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] KimTex;
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	
	
	public BlockWipeBox (int blockid)
	{
		super(blockid, Material.cloth);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
		this.setStepSound(Block.soundClothFootstep);
		this.setTickRandomly(true);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        TileWipeBox tile = (TileWipeBox) par1World.getBlockTileEntity(par2, par3, par4);
        
        if (itemstack == null)
        {
        	if (tile != null)
        	{
        		if (currentMeta == 0)
        		{
        			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 3);
        			tile.setRemainByte((byte)8);
        			par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
        		}
        		else if (currentMeta == 1)
        		{
        			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 3);
        			tile.setRemainByte((byte)80);
        			par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
        		}
        		else
        		{
        			byte remain = tile.getRemainByte();
        			
        			if (remain == -1)
        			{
        				if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.paper,1)))
        	        	{
        	        		par5EntityPlayer.entityDropItem(new ItemStack(Item.paper,1), 1);
        	        	}
        				par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
        			}
        			else if (remain == 0)
        			{
        				if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.paper,1)))
        	        	{
        	        		par5EntityPlayer.entityDropItem(new ItemStack(Item.paper,1), 1);
        	        	}
        				par1World.setBlockToAir(par2, par3, par4);
        	    		par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
        			}
        			else if (remain > 0)
        			{
        				if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.paper,1)))
        	        	{
        	        		par5EntityPlayer.entityDropItem(new ItemStack(Item.paper,1), 1);
        	        	}
        				par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
        				tile.setRemainByte((byte)(remain - 1));
        			}
        		}
        		
        	}
        	else
        	{
        		
        	}
        	return true;
        }
        else if (itemstack.itemID == Item.paper.itemID)
		{
			if (tile != null && (currentMeta == 1 || currentMeta == 3))
			{
				byte r = tile.getRemainByte();
				r++;
				tile.setRemainByte((byte)r);
				
				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
		        {
					par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
		        }
    			par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
    			
			}
			return true;
		}
        else if (itemstack.itemID == DCsAppleMilk.wipeBox.blockID && itemstack.getItemDamage() == 0)
		{
			if (tile != null && (currentMeta == 1 || currentMeta == 3))
			{
				int r = tile.getRemainByte();
				r += 8;
				if (r > 127)
				{
					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
			        {
						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
			        }
	    			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 1.0F, 1.8F);
	    			par1World.setBlock(par2, par3, par4, this.blockID, 4, 3);
	    			TileWipeBox tile2 = (TileWipeBox) par1World.getBlockTileEntity(par2, par3, par4);
	    			if (DCsAppleMilk.allowInfinityWipes) {
	    				tile2.setRemainByte((byte)-1);
	    			}
	    			else {
	    				tile2.setRemainByte((byte)127);
	    			}
				}
				else
				{
					tile.setRemainByte((byte)r);
					
					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
			        {
						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
			        }
	    			par1World.playSoundAtEntity(par5EntityPlayer, "dig.cloth", 1.0F, 1.3F);
				}
			}
			return true;
		}
        else
        {
        	return false;
        }
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
        this.thisBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void thisBoundingBox (int par1)
	{
		float f = 0.1875F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.5F, 1.0F - f);
	}
	
	public int damageDropped(int par1)
    {
        return (par1 & 1);
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par1;
		if ((par2 & 1) == 1)
        {
        	return this.KimTex[i];
        }
        else
        {
        	return this.boxTex;
        }
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
		return DCsAppleMilk.modelWipe;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return metadata > 1 ? Item.paper.itemID : this.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.boxTex = par1IconRegister.registerIcon("applemilk:basket_B");
		this.KimTex = new Icon[6];
		
        for (int i = 0; i < 6; ++i)
        {
            this.KimTex[i] = par1IconRegister.registerIcon("applemilk:wipes" + boxType[i]);
        }
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileWipeBox();
	}
	
	public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        return l == 4 ? 15 : 0;
    }
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        float r = par5Random.nextFloat();
        double d0 = (double)((float)par2 + r);
        double d1 = (double)((float)par3 + 0.5F + r);
        double d2 = (double)((float)par4 + r);

        if (!DCsAppleMilk.noRenderFoodsSteam && l == 4) par1World.spawnParticle("happyVillager", d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

}
