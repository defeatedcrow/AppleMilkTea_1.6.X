package mods.applemilk.common.block;

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

public class BlockAutoMaker extends BlockContainer{
	
	private final Random rand = new Random();
	
	public BlockAutoMaker (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return 0;
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.updateMetadata(par1World, par2, par3, par4);
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        this.updateMetadata(par1World, par2, par3, par4);
    }
	
	private void updateMetadata(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        boolean flag = !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
        boolean flag1 = getIsBlockNotPoweredFromMetadata(l);

        if (flag != flag1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, (flag ? 0 : 1), 3);
        }
    }
	
	public static boolean getIsBlockNotPoweredFromMetadata(int par0)
    {
        return (par0 & 1) != 0;
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

            if (tile != null)
            {
                if (par5EntityPlayer.isSneaking())
                {
                	par5EntityPlayer.openGui(DCsAppleMilk.instance, DCsAppleMilk.instance.guiIdAutoMaker, par1World, par2, par3, par4);
                }
                else
                {
                	
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
	
	//RS
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("applemilk:porcelain");
		
	}
}
