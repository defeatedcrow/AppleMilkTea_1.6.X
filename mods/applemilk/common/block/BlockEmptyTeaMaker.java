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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileCupHandle;
import mods.applemilk.common.tile.TileMakerHandle;
import mods.applemilk.handler.LoadIC2Handler;

public class BlockEmptyTeaMaker extends BlockContainer{
	
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	
	
	public BlockEmptyTeaMaker (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        
        	if (itemstack == null)
            {
            	return false;
            }
            else
            {
            	int ID = itemstack.itemID;
            	int IDm = itemstack.getItemDamage();
            	int setMeta = this.getMakerMeta(ID, IDm);
            	
            	if (ID == DCsAppleMilk.emptyCup.blockID)
        	    {
        	    	return true;
        	    }
        	    else if (ID == Item.bucketEmpty.itemID)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketWater,1)))
            		{
            			par5EntityPlayer.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);
            		}
        			
        			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                    {
                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
        			
            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            		return true;
        		}
        		else if (ID == Item.glassBottle.itemID)
        		{
        			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                    {
                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
        			
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.potion, 1, 0)))
            		{
            			par5EntityPlayer.entityDropItem(new ItemStack(Item.potion, 1, 0), 1);
            		}
            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            		return true;
        		}
//        		else if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Cell != 0 && itemstack.itemID == LoadIC2Handler.IC2Cell)
//        		{
//        			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
//                    {
//                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
//                    }
//        			
//        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(LoadIC2Handler.IC2WaterCell, 1, 1)))
//            		{
//            			par5EntityPlayer.entityDropItem(new ItemStack(LoadIC2Handler.IC2WaterCell, 1, 1), 1);
//            		}
//            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
//            		return true;
//        		}
        		else if (ID == Item.bucketMilk.itemID)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty,1)))
            		{
            			par5EntityPlayer.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);
            		}
    				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                    {
                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
        			
        			if (!par1World.isRemote) par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMaker.blockID, 1, 3);
            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            		return true;
        		}
        		else if (setMeta > 0)
        		{
        			this.setMakerMeta(par1World, par2, par3, par4, par5EntityPlayer, itemstack, setMeta, 0);
            		return true;
        		}
        		else
        		{
        			return false;
        		}
            }
    }
	
	private int getMakerMeta (int ID, int meta)
	{
		int m = -1;
		
		if (ID == Item.bucketMilk.itemID) m = 1; //milk
		else if (ID == Item.dyePowder.itemID && meta == 3) m = 8; //cocoa
		else if (ID == DCsAppleMilk.EXItems.itemID && meta == 2) m = 6; //green tea
		else if (ID == DCsAppleMilk.EXItems.itemID && meta == 3) m = 4; //tea
//		else if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Coffeepowder != 0 && ID == LoadIC2Handler.IC2Coffeepowder) m = 2; //IC2 coffee
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta < 2) m = 10;//apple
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta == 2) m = 12;//lemon
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta == 3) m = 2;//coffee
		
		return m;
	}
	
	private void setMakerMeta(World world, int x, int y, int z,  EntityPlayer player, ItemStack itemstack, int getMeta, int setMeta)
	{
		int m = getMeta;
		if (m > 13) m = 13;
		TileMakerHandle tile = (TileMakerHandle) world.getBlockTileEntity(x, y, z);
		byte dir = tile.getDirectionByte();
		
		if (!world.isRemote)
		{
			if (setMeta == 1 && !player.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty,1)))
    		{
    			player.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);
    		}
			
			if (!player.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
	        {
	            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
	        }
			
			world.setBlock(x, y, z, DCsAppleMilk.teaMaker.blockID, m, 3);
			TileMakerHandle tile2 = (TileMakerHandle) world.getBlockTileEntity(x, y, z);
			tile2.setDirectionByte(dir);
			world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
		}
	}
	
	public int damageDropped(int par1)
    {
        return 0;
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
		return DCsAppleMilk.modelTeaMaker;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return DCsConfig.noUseCupDirection ? null : new TileMakerHandle();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!DCsConfig.noUseCupDirection)
		{
			TileMakerHandle tileHandle = (TileMakerHandle)world.getBlockTileEntity(x, y, z);
			
			if (!world.isRemote)
			{
				int var5 = world.getBlockId(x, y, z - 1);
				int var6 = world.getBlockId(x, y, z + 1);
				int var7 = world.getBlockId(x - 1, y, z);
				int var8 = world.getBlockId(x + 1, y, z);
				byte var9 = 0;
	 
				if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
				{
					var9 = 0;
				}
	 
				if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
				{
					var9 = 1;
				}
	 
				if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
				{
					var9 = 2;
				}
	 
				if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
				{
					var9 = 4;
				}
	 
				tileHandle.setDirectionByte(var9);
			}
		}
	}
 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int playerFacing = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
 
		if (!DCsConfig.noUseCupDirection)
		{
			byte facing = 0;
			if (playerFacing == 0)
			{
				facing = 0;
			}
			if (playerFacing == 1)
			{
				facing = 1;
			}
			if (playerFacing == 2)
			{
				facing = 2;
			}
			if (playerFacing == 3)
			{
				facing = 4;
			}
	 
			TileEntity tileEntity = par1World.getBlockTileEntity(par2, par3, par4);
			if (tileEntity != null && tileEntity instanceof TileMakerHandle)
			{
				((TileMakerHandle)tileEntity).setDirectionByte(facing);
				//System.out.println("[AppleMilk]Now fasing " + facing);
				par1World.markBlockForRenderUpdate(par2, par3, par4);
			}
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
        this.TeaMakerBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void TeaMakerBoundingBox (int par1)
	{
		float f = 0.3125F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
	}
	
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par1 == 1)
        {
        	return this.boxTex;
        }
        else
        {
        	return Block.waterStill.getBlockTextureFromSide(0);
        }
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return DCsAppleMilk.teaMakerNext.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.boxTex = par1IconRegister.registerIcon("applemilk:porcelain");
	}

}