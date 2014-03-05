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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
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
import mods.applemilk.common.tile.TileTeppann;

public class BlockTeppann extends BlockContainer{
	
	private final String[] teppanFoodTex = new String[] {"_rawbeef", "_cookedbeef", "_rawpork", "_cookedpork", "_rawchicken", "_cookedpork", "_clam", "_clam", "_cookedbeef"};
	
	@SideOnly(Side.CLIENT)
    private Icon teppannBase;
	@SideOnly(Side.CLIENT)
	private Icon teppannFoods[];
	@SideOnly(Side.CLIENT)
    private Icon teppannEX;
	
	public BlockTeppann (int blockid)
	{
		super(blockid, Material.iron);
		this.setStepSound(Block.soundMetalFootstep);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
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
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
	}
	
	//tileEntity
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack item = par5EntityPlayer.inventory.getCurrentItem();
        
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
        {
            if (item == null)
            {
            	return false;
            }
            else if (this.checkFoodstaff(item) && this.getUnderMaterial(par1World, par2, par3, par4))
            {
            	this.setFoodstaff(par1World, par2, par3, par4, par5EntityPlayer, item);
            	return true;
            }
            else
            {
            	return false;
            }
        }
        else if (item == null)
        {
            this.getFoodPlate(par1World, par2, par3, par4, par5EntityPlayer);
            return true;
        }
        else if (item.itemID == DCsAppleMilk.foodPlate.blockID)
        {
        	this.getFoodPlate(par1World, par2, par3, par4, par5EntityPlayer);
            return true;
        }
        else
        {
        	return false;
        }
    }
	
	private boolean checkFoodstaff(ItemStack itemstack)
	{
		if (itemstack.itemID == Item.beefRaw.itemID) return true;
		else if (itemstack.itemID == Item.porkRaw.itemID) return true;
		else if (itemstack.itemID == Item.chickenRaw.itemID) return true;
		else if (itemstack.itemID == DCsAppleMilk.clam.itemID && itemstack.getItemDamage() == 0) return true;
		else return false;
	}
	
	private void setFoodstaff(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, ItemStack itemstack)
	{
		if (!par1World.isRemote)
		{
			TileTeppann tile = (TileTeppann) par1World.getBlockTileEntity(par2, par3, par4);
			ItemStack setItem = new ItemStack(itemstack.itemID, 1, 0);
			if (tile != null)
			{
				tile.getItemstack(setItem);
				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
		        {
		            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
		        }
				par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
			}
		}
	}
	
	private void getFoodPlate(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		
		TileTeppann tile = (TileTeppann) par1World.getBlockTileEntity(par2, par3, par4);
		ItemStack getItem = new ItemStack(DCsAppleMilk.clam, 1, 2);
		if (tile != null)
		{
			getItem = this.getEjectFoods(meta);
			
			tile.getItemstack((ItemStack)null);
			if (!par5EntityPlayer.inventory.addItemStackToInventory(getItem))
			{
				par5EntityPlayer.entityDropItem(getItem, 1.0F);
			}
			
			//実績用処理
			if (getItem.itemID == DCsAppleMilk.foodPlate.blockID && getItem.getItemDamage() == 3) {
				par5EntityPlayer.triggerAchievement(AchievementRegister.getHamaguri);
			}
			
			tile.getItemstack((ItemStack)null);
			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
		}
	}
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        this.ejectFood(par1World, par2, par3, par4);
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
	public void ejectFood(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
        	TileTeppann tile = (TileTeppann)par1World.getBlockTileEntity(par2, par3, par4);

            if (tile != null)
            {
                ItemStack itemstack = this.getEjectFoods(tile.getBlockMetadata());

                if (itemstack != null)
                {
                    tile.getItemstack((ItemStack)null);
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
                    float f = 0.7F;
                    double d0 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.2D + 0.6D;
                    double d2 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    ItemStack itemstack1 = itemstack.copy();
                    EntityItem entityitem = new EntityItem(par1World, (double)par2 + d0, (double)par3 + d1, (double)par4 + d2, itemstack1);
                    entityitem.delayBeforeCanPickup = 10;
                    par1World.spawnEntityInWorld(entityitem);
                }
            }
        }
    }
	
	private ItemStack getEjectFoods (int meta)
	{
		if (meta == 1) return new ItemStack(Item.beefRaw, 1);
		else if (meta == 2) return new ItemStack(DCsAppleMilk.foodPlate, 1, 0);
		else if (meta == 3) return new ItemStack(Item.porkRaw, 1);
		else if (meta == 4) return new ItemStack(DCsAppleMilk.foodPlate, 1, 1);
		else if (meta == 5) return new ItemStack(Item.chickenRaw, 1);
		else if (meta == 6) return new ItemStack(DCsAppleMilk.foodPlate, 1, 2);
		else if (meta == 7) return new ItemStack(DCsAppleMilk.clam, 1, 0);
		else if (meta == 8) return new ItemStack(DCsAppleMilk.foodPlate, 1, 3);
		else if (meta == 9) return new ItemStack(DCsAppleMilk.clam, 1, 2);
		else return (ItemStack)null;
	}
	
	public TileEntity createNewTileEntity(World par1World)
    {
        return new TileTeppann();
    }
	
	//set entity burn if that waling on.
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
		if (this.getUnderMaterial(par1World, par2, par3, par4) && (par5Entity instanceof EntityLiving || par5Entity instanceof EntityPlayer))
        {
        	par5Entity.setFire(30);
        }
    }
	
	private boolean getUnderMaterial (World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlockMaterial(par2, par3 - 1, par4) == Material.fire) return true;
		else if (par1World.getBlockMaterial(par2, par3 - 1, par4) == Material.lava) return true;
		else return false;
	}
	
	//set metadata
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        return par9;
    }
	
//	@SideOnly(Side.CLIENT)
//	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
//    {
//		for(int i = 0; i < 9; ++i)
//		{
//			par3List.add(new ItemStack(this, 1, i));
//		}
//    }
	
	//rendeing
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelTeppann;
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
		if (par2 > 9) par2 = 9;
		int i = par2 - 1;
		if (i < 0) i = 0;
		return par1 == 1 ? this.teppannBase : (par1 == 0 ? (par2 == 0 ? this.teppannBase : this.teppannFoods[par2 - 1]) :  this.teppannEX);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("applemilk:teppann");
		this.teppannBase = par1IconRegister.registerIcon("applemilk:teppann");
		this.teppannEX = par1IconRegister.registerIcon("applemilk:whitepanel");
		
		this.teppannFoods = new Icon[9];
		for (int i = 0; i < 9; ++i)
        {
			this.teppannFoods[i] = par1IconRegister.registerIcon("applemilk:foodstaff" + teppanFoodTex[i]);
        }
		
	}

}
