package mods.applemilk.common.block;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.client.particle.EntityBlinkFX;
import mods.applemilk.client.particle.EntityDCCloudFX;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.tile.TileIceMaker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockIceMaker extends BlockContainer {
	
	protected Random rand = new Random();
	
	public BlockIceMaker(int blockid)
	{
		super(blockid, Material.ground);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		this.setTickRandomly(true);
	}
	
	//外見の設定
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
		float f = 0.125F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 1.0F, 1.0F - f);
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
		return DCsAppleMilk.modelIceMaker;
	}
	
	//中身の設定
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			par5EntityPlayer.openGui(DCsAppleMilk.instance, DCsAppleMilk.instance.guiIceMaker, par1World, par2, par3, par4);
			return true;
		}
	}
	

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		TileIceMaker tileentity = (TileIceMaker) par1World.getBlockTileEntity(par2, par3, par4);
	 
		if (tileentity != null)
		{
			for (int j1 = 0; j1 < tileentity.inventory.getSizeInventory(); ++j1)
			{
				ItemStack itemstack = tileentity.inventory.getStackInSlot(j1);
	 
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
	 
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileIceMaker();
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
		this.blockIcon = par1IconRegister.registerIcon("applemilk:icemaker_body");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        boolean b = false;
        TileIceMaker tile = (TileIceMaker) par1World.getBlockTileEntity(par2, par3, par4);
        if (tile != null){
        	b = tile.isBurning();
        }
        
        double d0 = (double)((float)par2 + par5Random.nextFloat());
        double d1 = (double)((float)par3 - 0.2F + par5Random.nextFloat());
        double d2 = (double)((float)par4 + par5Random.nextFloat());
        double d3 = 0.0099999988079071D;
        double d4 = 0.0099999988079071D;
        double d5 = 0.0099999988079071D;

        if (!DCsAppleMilk.noRenderFoodsSteam && b) {
        	EntityBlinkFX cloud = new EntityBlinkFX(par1World, d0, d1, d2, 0.0D, d4, 0.0D);
        	cloud.setParticleIcon(ParticleTex.getInstance().getIcon("applemilk:particle_blink"));
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
        }
    }

}
