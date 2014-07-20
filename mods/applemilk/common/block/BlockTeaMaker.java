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
import mods.applemilk.common.tile.TileMakerHandle;
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.handler.LoadIC2Handler;

public class BlockTeaMaker extends BlockContainer{
	
	private static final String[] contents = new String[] {"_empty", "_milk", "_cocoa", "_cocoa_milk", "_tea", "_tea_milk", "_greentea", "_greentea_milk", "_cocoa", "_cocoa_milk", "_juice", "_juice_milk", "_lemon", "_lemon"};
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] contentsTex;
	
	
	public BlockTeaMaker (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        TileMakerHandle tile = (TileMakerHandle) par1World.getBlockTileEntity(par2, par3, par4);
		byte dir = tile.getDirectionByte();
        
        	if (itemstack == null)
            {
            	return false;
            }
            else
            {
            	int ID = itemstack.itemID;
            	int IDm = itemstack.getItemDamage();
            	int setMeta = this.getMakerMeta(ID, IDm);
            	
            	if (meta == 0)
            	{
            	    return true;
            	}
            	else if (meta == 1)
            	{
            		if (ID == Item.bucketEmpty.itemID)
            		{
            			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
            			
            			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketMilk,1)))
                		{
                			par5EntityPlayer.entityDropItem(new ItemStack(Item.bucketMilk.itemID, 1, 0), 1);
                		}
            			if (par1World.rand.nextInt(3) == 0 && !par1World.isRemote)
            			{
            				par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
            				TileMakerNext tile2 = (TileMakerNext) par1World.getBlockTileEntity(par2, par3, par4);
            				tile2.setID((byte)0);
            				tile2.setMilk(false);
            			}
                		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                		return true;
            		}
            		else if (setMeta > 0)
            		{
            			this.setMakerMeta(par1World, par2, par3, par4, par5EntityPlayer, itemstack, setMeta, meta);
                		return true;
            		}
            		else if (ID == DCsAppleMilk.emptyCup.blockID)
            		{
            			this.getTea(par1World, par2, par3, par4, par5EntityPlayer, itemstack, meta);
                		return true;
            		}
            		else
            		{
            			return false;
            		}
            	}
            	else
            	{
            		if ((meta & 1) == 1)
            		{
            			if (ID == DCsAppleMilk.emptyCup.blockID && meta != 3)
                		{
            				this.getTea(par1World, par2, par3, par4, par5EntityPlayer, itemstack, meta);
                    		return true;
                		}
            			else if (meta == 3)
            			{
            				if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Mug != null && itemstack.itemID == LoadIC2Handler.IC2Mug.itemID)
            				{
            					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                                {
                                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                                }
                    			
                    			if (!par5EntityPlayer.inventory.addItemStackToInventory(LoadIC2Handler.IC2MugCoffee.copy()))
                        		{
                        			par5EntityPlayer.entityDropItem((LoadIC2Handler.IC2MugCoffee.copy()), 1);
                        		}
                    			
                    			if (par1World.rand.nextInt(3) == 0 && !par1World.isRemote)
                    			{
                    				par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
                    				TileMakerNext tile2 = (TileMakerNext) par1World.getBlockTileEntity(par2, par3, par4);
                    				tile2.setID((byte)0);
                    				tile2.setMilk(false);
                    			}
                        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                        		return true;
            				}
            				else if (itemstack.itemID == DCsAppleMilk.emptyCup.blockID)
            				{
            					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                                {
                                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                                }
                    			
                    			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.teacupBlock, 1, 13)))
                        		{
                        			par5EntityPlayer.entityDropItem((new ItemStack(DCsAppleMilk.teacupBlock, 1, 13)), 1);
                        		}
                    			
                    			if (par1World.rand.nextInt(3) == 0 && !par1World.isRemote)
                    			{
                    				par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
                    				TileMakerNext tile2 = (TileMakerNext) par1World.getBlockTileEntity(par2, par3, par4);
                    				tile2.setID((byte)0);
                    				tile2.setMilk(false);
                    			}
                        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                        		return true;
            				}
            				else
            				{
            					return false;
            				}
            				
            			}
            			else
            			{
            				return false;
            			}
            		}
            		else
            		{
            			if (ID == Item.bucketMilk.itemID && meta < 13)
                		{
            				if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty,1)))
                    		{
                    			par5EntityPlayer.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);
                    		}
            				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                            {
                                par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                            }
                			
                			if (!par1World.isRemote) par1World.setBlockMetadataWithNotify(par2, par3, par4, (meta + 1), 3);
                    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                    		return true;
                		}
            			else if (ID == DCsAppleMilk.emptyCup.blockID && meta != 2)
                		{
                			this.getTea(par1World, par2, par3, par4, par5EntityPlayer, itemstack, meta);
                    		return true;
                		}
            			else if (meta == 2)
            			{
            				if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Mug != null && itemstack.getItem() == LoadIC2Handler.IC2Mug.getItem())
            				{
            					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                                {
                                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                                }
                    			
                    			if (!par5EntityPlayer.inventory.addItemStackToInventory(LoadIC2Handler.IC2MugCoffee.copy()))
                        		{
                        			par5EntityPlayer.entityDropItem((LoadIC2Handler.IC2MugCoffee.copy()), 1);
                        		}
                    			
                    			if (par1World.rand.nextInt(3) == 0 && !par1World.isRemote)
                    			{
                    				par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
                    				TileMakerNext tile2 = (TileMakerNext) par1World.getBlockTileEntity(par2, par3, par4);
                    				tile2.setID((byte)0);
                    				tile2.setMilk(false);
                    			}
                        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                        		return true;
            				}
            				else if (itemstack.itemID == DCsAppleMilk.emptyCup.blockID)
            				{
            					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                                {
                                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                                }
                    			
                    			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.teacupBlock, 1, 12)))
                        		{
                        			par5EntityPlayer.entityDropItem((new ItemStack(DCsAppleMilk.teacupBlock, 1, 12)), 1);
                        		}
                    			
                    			if (par1World.rand.nextInt(3) == 0 && !par1World.isRemote)
                    			{
                    				par1World.setBlock(par2, par3, par4, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
                    				TileMakerNext tile2 = (TileMakerNext) par1World.getBlockTileEntity(par2, par3, par4);
                    				tile2.setID((byte)0);
                    				tile2.setMilk(false);
                    			}
                        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
                        		return true;
            				}
            				else
            				{
            					return false;
            				}
            			}
            			else
            			{
            				return false;
            			}
            		}
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
		else if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Coffeepowder != null && ID == LoadIC2Handler.IC2Coffeepowder.itemID) m = 2; //IC2 coffee
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta < 2) m = 10;//apple
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta == 2) m = 12;//lemon
		else if (ID == DCsAppleMilk.gratedApple.itemID && meta == 3) m = 2;//coffee
		
		return m;
	}
	
	private void setMakerMeta(World world, int x, int y, int z,  EntityPlayer player, ItemStack itemstack, int getMeta, int setMeta)
	{
		int m = 0;
		if (setMeta == 1 && getMeta == 1) m = 1;
		else m = setMeta + getMeta;
		
		if (m > 13) m = 13;
		
		if (!world.isRemote)
		{
			if (!player.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
	        {
	            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
	            if (setMeta == 1 && !player.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty,1)))
	    		{
	    			player.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);;
	    		}
	        }
			
			if (!world.isRemote) world.setBlockMetadataWithNotify(x, y, z, m, 3);
			world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
		}
	}
	
	private void getTea (World world, int x, int y, int z,  EntityPlayer player, ItemStack itemstack, int teaMeta)
	{
		int m = teaMeta;
		if (teaMeta > 3) m = teaMeta - 2;
		if (teaMeta > 13) m = 11;
		TileMakerHandle tile = (TileMakerHandle) world.getBlockTileEntity(x, y, z);
		byte dir = tile.getDirectionByte();
		
		if (!player.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
        {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        }
		if (!player.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.teacupBlock,1,m)))
		{
			player.entityDropItem(new ItemStack(DCsAppleMilk.teacupBlock,1,m), 1);
		}
		if (world.rand.nextInt(3) == 0 && !world.isRemote)
		{
			world.setBlock(x, y, z, DCsAppleMilk.teaMakerNext.blockID, dir, 3);
			TileMakerNext tile2 = (TileMakerNext) world.getBlockTileEntity(x, y, z);
			tile2.setID((byte)0);
			tile2.setMilk(false);
		}
		world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
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
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 13) i = 13;
		if (par1 == 1)
        {
        	return this.boxTex;
        }
        else
        {
        	return i == 0 ? Block.waterStill.getBlockTextureFromSide(0) : this.contentsTex[i];
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
		this.contentsTex = new Icon[14];
		this.boxTex = par1IconRegister.registerIcon("applemilk:porcelain");
		
        for (int i = 0; i < 14; ++i)
        {
            this.contentsTex[i] = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
        }
	}

}
