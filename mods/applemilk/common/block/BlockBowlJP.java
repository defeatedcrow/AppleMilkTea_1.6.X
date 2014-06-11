package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.client.particle.EntityDCCloudFX;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileDummy;
import mods.applemilk.common.tile.TileJPBowl;
import mods.applemilk.handler.LoadBambooHandler;

public class BlockBowlJP extends BlockContainer{
	
	private static final String[] contents = new String[] {"_milk", "_tea_milk", "_soup", "_zousui", "_kayaku", "_soi", "_juice", "_BLTsoup"};
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] contentsTex;
	
	
	public BlockBowlJP (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
		this.setTickRandomly(true);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        int bottomBlockID = par1World.getBlockId(par2, par3 - 1, par4);
        
        if (itemstack == null)
        {
        	if (currentMeta == 15)
        	{
        		if (DCsAppleMilk.SuccessLoadBamboo)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(LoadBambooHandler.bambooBasket,1)))
                	{
                		par5EntityPlayer.entityDropItem(new ItemStack(LoadBambooHandler.bambooBasket,1), 1);
                	}
        		}
        		else
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bowlEmpty,1)))
        	    	{
        				par5EntityPlayer.entityDropItem(new ItemStack(Item.bowlEmpty,1), 1);
        	    	}
        		}
        	}
        	else
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
            	}
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == this.blockID || itemstack.itemID == Item.bowlEmpty.itemID)
        {
        	if (currentMeta == 15)
        	{
        		if (DCsAppleMilk.SuccessLoadBamboo)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(LoadBambooHandler.bambooBasket,1)))
                	{
                		par5EntityPlayer.entityDropItem(new ItemStack(LoadBambooHandler.bambooBasket,1), 1);
                	}
        		}
        		else
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bowlEmpty,1)))
        	    	{
        				par5EntityPlayer.entityDropItem(new ItemStack(Item.bowlEmpty,1), 1);
        	    	}
        		}
        	}
        	else
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
            	}
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.chopsticks.itemID)
        {
        	if (!par1World.isRemote)
    		{
    			par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 2, 2));
    		}
        	
        	par1World.setBlockMetadataWithNotify(par2, par3, par4, 15, 3);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else
        {
        	return false;
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
		return DCsAppleMilk.modelBowlJP;
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
		float f = 0.20F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.4F, 1.0F - f);
	}
	
	//tile
	@Override
	public TileEntity createNewTileEntity(World world) {
		return DCsConfig.noUseCupDirection ? null : new TileJPBowl();
	}
	
	//icon
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 7) i = 7;
		if (par1 == 1)
        {
        	return this.boxTex;
        }
        else
        {
        	return i < 8 ? this.contentsTex[i] : this.boxTex;
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 8; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
		par3List.add(new ItemStack(this, 1, 15));
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
		this.contentsTex = new Icon[8];
		this.boxTex = par1IconRegister.registerIcon("applemilk:porcelain");
		
        for (int i = 0; i < 8; ++i)
        {
        	this.contentsTex[i] = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
        }
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        double d0 = (double)((float)par2 + 0.375F + par5Random.nextFloat()/4);
        double d1 = (double)((float)par3 + par5Random.nextFloat());
        double d2 = (double)((float)par4 + 0.375F + par5Random.nextFloat()/4);
        double d3 = 0.0059999988079071D;
        double d4 = 0.27000001072883606D;

        if (!DCsConfig.noRenderFoodsSteam && l != 15) {
        	EntityDCCloudFX cloud = new EntityDCCloudFX(par1World, d0, d1, d2, 0.0D, d3, 0.0D);
        	cloud.setParticleIcon(ParticleTex.getInstance().getIcon("applemilk:particle_cloud"));
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
        }
    }
}
