package mods.applemilk.common.block;

import static net.minecraftforge.common.EnumPlantType.Plains;

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
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import mods.applemilk.common.*;
import mods.applemilk.handler.Util;

public class BlockCassisTree extends Block implements IPlantable{
	
	@SideOnly(Side.CLIENT)
    private Icon leafIcon;//内側
	@SideOnly(Side.CLIENT)
    private Icon[] newleafIcon;//外側
	@SideOnly(Side.CLIENT)
    private Icon logIcon;
	
	public BlockCassisTree (int blockid)
	{
		super(blockid, Material.wood);
		this.setStepSound(Block.soundGrassFootstep);
		this.setTickRandomly(true);
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote && par1World.rand.nextInt(8) == 0)
		{
			int meta = par1World.getBlockMetadata(par2, par3, par4);
			int growth = meta & 3;
			
			/*4段階成長する。カシスのみ、成長し切ると実を採取できる。*/
			if (growth < 3 && (par1World.getBlockLightValue(par2, par3, par4) > 11))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, (meta + 1), 3);
			}
		}
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        
        if (itemstack == null)
        {
        	/*採取可能なのはカシスのみ。山茶花は成長したあとは眺めるだけのもの。*/
        	if (meta == 3)
        	{
        		ItemStack get = new ItemStack(DCsAppleMilk.leafTea.itemID, 1, 2);
        		
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(get))
        		{
        			par5EntityPlayer.entityDropItem(get, 1);
        		}
        		
        		//2段階戻る
        		par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
        		
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        else if (!par1World.isRemote && meta == 3 && itemstack.itemID == DCsAppleMilk.leafTea.itemID)
        {
        	ItemStack get = new ItemStack(DCsAppleMilk.leafTea.itemID, 1, 2);
    		
    		if (!par5EntityPlayer.inventory.addItemStackToInventory(get))
    		{
    			par5EntityPlayer.entityDropItem(get, 1);
    		}
    		
    		//2段階戻る
    		par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else //骨粉の成長イベント
        {
        	if ((itemstack.itemID == Item.dyePowder.itemID) && (itemstack.getItemDamage() == 15))
        	{
        		int newMeta = meta > 3 ? 7 : 3;
        		
        		if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                {
                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
        		par1World.setBlockMetadataWithNotify(par2, par3, par4, newMeta, 3);
        		
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        		return true;
        	}
        	else
        	{
        		return false;
        	}
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
		return DCsAppleMilk.modelCassisTree;
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = Math.min(par2, 7);
		if (par1 == 0)
        {
        	return this.logIcon;
        }
        else if(par1 == 1)
        {
        	return this.leafIcon;
        }
        else
        {
        	return this.newleafIcon[i];
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 7));
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return DCsAppleMilk.saplingTea.blockID;
	}
	
	public int damageDropped(int par1)
    {
        return par1 < 4 ? 1 : 2;
    }
	
	public int quantityDropped(Random random)
	{
		return random.nextInt(3) == 0 ? 2 : 1;
	}
	
	protected boolean canSilkHarvest()
    {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.leafIcon = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "tealeaf");
		this.logIcon = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "tealog");
		
		this.newleafIcon = new Icon[8];
		for (int i = 0; i < 8; ++i)
        {
			if (i < 4)
			{
				int j = Math.max(i, 1);
				this.newleafIcon[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "cassisleaf_" + j);
			}
			else if (i < 8)
			{
				int j = Math.max(i, 1) - 4;
				this.newleafIcon[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "camellialeaf_" + j);
			}
            
        }
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		
		return Plains;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		
		return blockID;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		
		return world.getBlockMetadata(x, y, z);
	}
	

}
