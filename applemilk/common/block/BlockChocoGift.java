package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import mods.applemilk.common.*;

public class BlockChocoGift extends Block{
	
	private static final String[] boxType = new String[] {"", "_heartfelt"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] boxSideTex;
	
	
	public BlockChocoGift (int blockid)
	{
		super(blockid, Material.circuits);
		this.setHardness(0.2F);
		this.setResistance(0.0F);
		this.setStepSound(Block.soundClothFootstep);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.3F, 0.8F);
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
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 2) i = 2;
		if (par1 == 1)
        {
        	return this.boxTex[i];
        }
        else
        {
        	return this.boxSideTex[i];
        }
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
		return this.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.boxTex = new Icon[2];
		this.boxSideTex = new Icon[2];
		
        for (int i = 0; i < 2; ++i)
        {
            this.boxTex[i] = par1IconRegister.registerIcon("applemilk:chocogift" + boxType[i]);
            this.boxSideTex[i] = par1IconRegister.registerIcon("applemilk:chocogiftside" + boxType[i]);
        }
	}

}
