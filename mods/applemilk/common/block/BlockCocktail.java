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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileCocktail;

public class BlockCocktail extends BlockContainer{
	
	private static final String[] contents = new String[] {"_milk", "_milk", "_milk", "_lime", "_cocoa", "_tomato", "_juice", "_lemon_gradient", "_lime", "_mintjulep"};
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] contentsTex;
	
	
	public BlockCocktail (int blockid)
	{
		super(blockid, Material.glass);
		this.setStepSound(Block.soundGlassFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
		this.setLightValue(0.4F);
		this.setTickRandomly(true);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        int bottomBlockID = par1World.getBlockId(par2, par3 - 1, par4);
        
        if (itemstack == null)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == this.blockID)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
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
		return DCsAppleMilk.modelCocktail;
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
		float f = 0.25F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.7F, 1.0F - f);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par1 == 1)
		{
			return this.contentsTex[par2];
		}
		else
		{
			return this.boxTex;
		}
		
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 10; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
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
		this.boxTex = par1IconRegister.registerIcon("applemilk:blueglass");
		this.contentsTex = new Icon[10];
        for (int i = 0; i < 10; ++i)
        {
        	this.contentsTex[i] = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
        }
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileCocktail();
	}
	
}
