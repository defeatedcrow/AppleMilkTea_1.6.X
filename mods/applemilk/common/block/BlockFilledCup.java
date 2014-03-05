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
import net.minecraft.entity.EntityLiving;
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

public class BlockFilledCup extends BlockContainer{
	
	@SideOnly(Side.CLIENT)
    private Icon itemIcon;
	@SideOnly(Side.CLIENT)
    private Icon boxIcon;
	@SideOnly(Side.CLIENT)
    private Icon[] contentsIcon;
	
	private static final String[] contents = new String[] {"_milk", "_milk", "_tea", "_tea_milk", "_greentea", "_greentea_milk", "_cocoa", "_cocoa_milk", "_juice", "_juice_milk", "_lemon", "_lemon", "_cocoa", "_cocoa_milk"};
	
	public BlockFilledCup (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        
        if (itemstack == null)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.teacupBlock,1,meta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.teacupBlock,1,meta), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else
        {
        	return false;
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
		return DCsAppleMilk.useSummerRender ? DCsAppleMilk.modelCupSummer : DCsAppleMilk.modelFilledCup;
	}
	
	public int damageDropped(int par1)
    {
        return par1;
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
        this.CupBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void CupBoundingBox (int par1)
	{
		float f = 0.25F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.5F, 0.5F + f);
	}
	
	//set direction as tileentity
	@Override
	public TileEntity createNewTileEntity(World world) {
		return DCsAppleMilk.noUseCupDirection ? null : new TileCupHandle();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!DCsAppleMilk.noUseCupDirection)
		{
			TileCupHandle tileCupHandle = (TileCupHandle)world.getBlockTileEntity(x, y, z);
			
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
	 
				tileCupHandle.setDirectionByte(var9);
			}
		}
	}
 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int playerFacing = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
 
		if (!DCsAppleMilk.noUseCupDirection)
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
			if (tileEntity != null && tileEntity instanceof TileCupHandle)
			{
				((TileCupHandle)tileEntity).setDirectionByte(facing);
				//System.out.println("[AppleMilk]Now fasing " + facing);
				par1World.markBlockForRenderUpdate(par2, par3, par4);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 14; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 13) i = 13;
		if (par1 == 2)
        {
        	return this.boxIcon;
        }
        else if (par1 == 1)
        {
        	return this.itemIcon;
        }
        else
        {
        	return i == 0 ? Block.waterStill.getIcon(0, 0) : this.contentsIcon[i];
        }
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
		this.boxIcon = par1IconRegister.registerIcon("applemilk:porcelain");
		
		
		this.contentsIcon = new Icon[14];
		for (int i = 0; i < 14; ++i)
        {
			this.blockIcon = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
			this.itemIcon = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
			this.contentsIcon[i] = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
        }
	}

}
