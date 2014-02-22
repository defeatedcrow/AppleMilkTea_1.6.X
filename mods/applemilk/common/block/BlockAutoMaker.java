package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileAutoMaker;
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.handler.recipe.TeaRecipe;

public class BlockAutoMaker extends BlockContainer{
	
	private final Random rand = new Random();
	private static final String[] modeString = new String[] {"Disabled Automated TeaMaker.", "Enabled Auto mode.", "Enabled Manual mode.", "Enabled RS mode."};
	
	public static boolean RSactive = false;
	
	
	public BlockAutoMaker (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setTickRandomly(true);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return 0;
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.LampBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void LampBoundingBox (int par1)
	{
		float f = 0.25F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.5F, 1.0F - f);
		
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        TileAutoMaker tile = this.getAutoMaker(par1World, par2, par3, par4);
        if (tile != null)
        {
        	tile.setMode((byte)0);
        }
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		this.updateMetadata(par1World, par2, par3, par4);
    }
	
	private void updateMetadata(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
		this.RSactive = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
		
		if (l > 0 || this.RSactive)
		{
			TileAutoMaker tile = this.getAutoMaker(par1World, par2, par3, par4);
			TileMakerNext target = (TileMakerNext) par1World.getBlockTileEntity(par2, par3 - 1, par4);
			
			if (tile != null && target != null)
			{
				ItemStack items = tile.getItemstack();
				int mode = tile.getMode();
				int makerID = target.getID();
				int underMeta = par1World.getBlockMetadata(par2, par3 - 1, par4);
				int nextMeta = 0;
				if (underMeta == 0) nextMeta = 2;
				
				if (items != null)
				{
					int itemID = TeaRecipe.getID(items);
					if (itemID > 0)
					{
						if (mode == 1)
						{
							target.setID((byte)(itemID));
							target.setRemainByte((byte)(3 + par1World.rand.nextInt(3)));
							par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
							par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, nextMeta, 3);
							par1World.playSoundEffect(par2, par3, par4, "random.pop", 0.4F, 1.8F);
						}
						else if (mode == 3 && this.RSactive)
						{
							target.setID((byte)(itemID));
							target.setRemainByte((byte)(3 + par1World.rand.nextInt(3)));
							par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
							par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, nextMeta, 3);
							par1World.playSoundEffect(par2, par3, par4, "random.pop", 0.4F, 1.8F);
						}
						else
						{
							
						}
						
						par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
						par1World.notifyBlocksOfNeighborChange(par2, par3 -1, par4, target.getBlockType().blockID);
					}
					
				}
			}
		}
		
    }
	
	public TileEntity createNewTileEntity(World par1World)
    {
        return new TileAutoMaker();
    }
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileAutoMaker tile = getAutoMaker(par1World, par2, par3, par4);
            ItemStack item = par5EntityPlayer.inventory.getCurrentItem();

            if (tile != null)
            {
            	if (item == null)
            	{
            		if (par5EntityPlayer.isSneaking())
            		{
            			byte i = tile.getMode();
            			
            			
            			if (i < 2)
            			{
            				++i;
            				tile.setMode(i);
            				String s = "[AppleMilk] " + this.modeString[i];
            				par5EntityPlayer.addChatMessage(s);
            			}
            			else
            			{
            				tile.setMode((byte)0);
            				String s = "[AppleMilk] " + this.modeString[0];
            				par5EntityPlayer.addChatMessage(s);
            			}
            		}
            		else
            		{
            			par5EntityPlayer.openGui(DCsAppleMilk.instance, DCsAppleMilk.instance.guiIdAutoMaker, par1World, par2, par3, par4);
            		}
            		
            	}
            	else
            	{
            		if (tile.getMode() == 2)
            		{
            			TileMakerNext target = (TileMakerNext) par1World.getBlockTileEntity(par2, par3 - 1, par4);
            			
            			if (target != null)
            			{
            				ItemStack items = tile.getItemstack();
            				int makerID = target.getID();
            				int underMeta = par1World.getBlockMetadata(par2, par3 - 1, par4);
            				int nextMeta = 0;
            				if (underMeta == 0) nextMeta = 2;
            				
            				if (items != null)
            				{
            					int itemID = TeaRecipe.getID(items);
            					tile.reduceItemStack();
            					tile.onInventoryChanged();
            					
            					if (itemID > 0)
            					{
            						target.setID((byte)(itemID));
        							target.setRemainByte((byte)(3 + par1World.rand.nextInt(3)));
        							par1World.setBlockMetadataWithNotify(par2, par3, par4, nextMeta, 3);
        							par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, 0, 3);
        							
        							par1World.playSoundEffect(par2, par3, par4, "random.pop", 0.4F, 1.8F);
        							par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
        							par1World.notifyBlocksOfNeighborChange(par2, par3 -1, par4, target.getBlockType().blockID);
            					}
            					
            				}
            			}
            		}
            		
            	}
            }

            return true;
        }
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);

        if (par6ItemStack.hasDisplayName())
        {
        	TileAutoMaker tile = getAutoMaker(par1World, par2, par3, par4);
        }
    }
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileAutoMaker tile = (TileAutoMaker)par1World.getBlockTileEntity(par2, par3, par4);

        if (tile != null)
        {
            for (int j1 = 0; j1 < tile.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tile.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0)
                    {
                        int k1 = this.rand.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
                        par1World.spawnEntityInWorld(entityitem);
                    }
                }
            }

            par1World.func_96440_m(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.updateMetadata(par1World, par2, par3, par4);
        }
    }
	
	public boolean hasComparatorInputOverride()
    {
        return true;
    }
	
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory(getAutoMaker(par1World, par2, par3, par4));
    }
	
	public static TileAutoMaker getAutoMaker(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		return (TileAutoMaker)par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
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
		return DCsAppleMilk.modelAutoMaker;
	}
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 0.5F);
        double d2 = (double)((float)par4 + 0.5F);
        double d3 = 0.0199999988079071D;
        double d4 = 0.07000001072883606D;

        if (l > 0) par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("applemilk:porcelain");
		
	}
}
