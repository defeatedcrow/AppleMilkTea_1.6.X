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
import mods.applemilk.common.tile.TileBread;
import mods.applemilk.common.tile.TileDummy;

public class BlockBasket extends BlockContainer{	
	
	@SideOnly(Side.CLIENT)
    private Icon[] basketTex;
	@SideOnly(Side.CLIENT)
    private Icon[] basketSideTex;
	@SideOnly(Side.CLIENT)
    private Icon[] basketTopTex;
	@SideOnly(Side.CLIENT)
    private Icon[] breadTex;
		
	public BlockBasket (int blockid)
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
    		if (currentMeta <= 0)
    		{
    			return false;
    		}
    		else
    		{
    			if (currentMeta < 6) {
    				this.getBowl(par5EntityPlayer, currentMeta);
        			par1World.setBlockMetadataWithNotify(par2, par3, par4, (currentMeta - 1), 3);
            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            		return true;
    			}
    			else {
    				this.getBottle(par5EntityPlayer, currentMeta);
        			if (currentMeta == 6) {
        				par1World.setBlockToAir(par2, par3, par4);
        			}
        			else {
        				par1World.setBlockMetadataWithNotify(par2, par3, par4, (currentMeta - 1), 3);
        			}
            		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            		return true;
    			}
    		}
        }
        else if (itemstack.itemID == Item.bread.itemID)
        {
        	if (currentMeta >= 5)
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
        else if (itemstack.itemID == DCsAppleMilk.itemLargeBottle.itemID && itemstack.getItemDamage() == 0)
        {
        	if (currentMeta < 6 || currentMeta > 13)
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
		if (!player.inventory.addItemStackToInventory(new ItemStack(Item.bread,1)))
    	{
    		player.entityDropItem(new ItemStack(Item.bread,1), 1.0F);
    	}
	}
	
	private void getBottle (EntityPlayer player, int meta)
	{
		if (!player.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0)))
    	{
    		player.entityDropItem(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0), 1.0F);
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
		return DCsAppleMilk.modelBasket;
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
		if (par1 < 6) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.6F, 1.0F);
		}
		else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		}
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return DCsAppleMilk.noUseCupDirection ? null : new TileBread();
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par2 < 6) {
			if (par1 == 0) return this.basketTex[0];
			if (par1 == 1) return this.basketTopTex[0];
			if (par1 == 2) return this.basketSideTex[0];
			if (par1 == 3) return this.breadTex[0];
			if (par1 == 4) return this.breadTex[1];
			else return Block.planks.getBlockTextureFromSide(0);
		}
		else {
			if (par1 == 0) return this.basketTex[1];
			if (par1 == 1) return this.basketTopTex[1];
			else return this.basketSideTex[1];
		}
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		par3List.add(new ItemStack(this, 1, 5));
		par3List.add(new ItemStack(this, 1, 14));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.basketTex = new Icon[2];
		this.basketSideTex = new Icon[2];
		this.basketTopTex = new Icon[2];
		this.breadTex = new Icon[2];
		this.breadTex[0] = par1IconRegister.registerIcon("applemilk:bread_S");
		this.breadTex[1] = par1IconRegister.registerIcon("applemilk:bread_T");
		
        for (int i = 0; i < 2; ++i)
        {
        	this.basketTex[i] = par1IconRegister.registerIcon("applemilk:basket_B" + i);
        	this.basketSideTex[i] = par1IconRegister.registerIcon("applemilk:basket_S" + i);
        	this.basketTopTex[i] = par1IconRegister.registerIcon("applemilk:basket_T" + i);
        }
	}
	
}
