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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileCordial;
import mods.applemilk.common.tile.TileLargeBottle;
import mods.applemilk.handler.Util;

/* Cordialの中身はメタデータに任せている。
 * 熟成の度合い等はTileEntityにて管理。
 * 破壊時にNBTに各種データを移し替える。
 * */
public class BlockCordial extends BlockContainer{
	
	@SideOnly(Side.CLIENT)
    private Icon contentsIcon[];//中身テクスチャ
	@SideOnly(Side.CLIENT)
    private Icon drinkIcon[];//中身テクスチャ
	
	private static String[] type = new String[] {"_apple", "_tea", "_cassis", "_plum"};
	
	public BlockCordial (int blockid)
	{
		super(blockid, Material.glass);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        TileCordial tile = (TileCordial) par1World.getBlockTileEntity(par2, par3, par4);
        
        if (tile == null || par1World.isRemote)
        {
        	return false;
        }
        else
        {
        	return false;
        }
    }
	
	//設置
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        short l = (short)par6ItemStack.getItemDamage();
        
        int newMeta = l >> 2;//Blockのメタデータは、Itemのダメージ値の3,4桁目に入っている
        int rem = l & 3; 
        boolean aged = (rem != 0);
        
        NBTTagCompound nbt = par6ItemStack.getTagCompound();
		int stage = 0;
        
		if (nbt != null && !aged)
		{
			stage = nbt.getByte("stage");
		}
        
        par1World.setBlockMetadataWithNotify(par2, par3, par4, newMeta, 3);
        //メタデータ自体はタイプに対応している。RenderBlockクラスでメタデータごとのテクスチャを振り分けるためだが、他にも方法はある気がする。
        
		TileCordial tile = (TileCordial) par1World.getBlockTileEntity(par2, par3, par4);
    	if (tile != null) tile.setAgingStage(stage);
    }
	
	//破壊
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileCordial tile = (TileCordial)par1World.getBlockTileEntity(par2, par3, par4);

        if (tile != null)
        {
        	//ブロックのメタデータとTileのShort値から新しいダメージ値を生成
        	int rem = (tile.getAged()) ? 3 : 0;
        	int l = tile.getAgingStage();
        	int type = par1World.getBlockMetadata(par2, par3, par4);
        	int damage = (type << 2) + rem;
        	
        	float f = par1World.rand.nextFloat() * 0.8F + 0.1F;
            float f1 = par1World.rand.nextFloat() * 0.8F + 0.1F;
            float f2 = par1World.rand.nextFloat() * 0.8F + 0.1F;
            
            //アイテム版の瓶をドロップ
            ItemStack itemstack = new ItemStack(DCsAppleMilk.itemCordial, 1, damage);
            
            if (rem == 0 && l > 0)//熟成未完了
            {
            	NBTTagCompound nbt = itemstack.getTagCompound();
        		
        		if (nbt == null)
        		{
        			nbt = new NBTTagCompound();
    				nbt.setByte("stage", (byte)l);
    				itemstack.setTagCompound(nbt);
        		}
            }
            
            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), itemstack);

            float f3 = 0.05F;
            entityitem.motionX = (double)((float)par1World.rand.nextGaussian() * f3);
            entityitem.motionY = (double)((float)par1World.rand.nextGaussian() * f3 + 0.2F);
            entityitem.motionZ = (double)((float)par1World.rand.nextGaussian() * f3);
            par1World.spawnEntityInWorld(entityitem);

            par1World.func_96440_m(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
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
		return DCsAppleMilk.modelCordial;
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
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 1.0F, 1.0F - f);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = Math.min(par2, 3);
		return par1 == 0 ? this.contentsIcon[i] : this.drinkIcon[i];
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return DCsAppleMilk.cordial.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return 0;
	}
	
	protected boolean canSilkHarvest()
    {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "cordial_drink");
		this.drinkIcon = new Icon[4];
		this.contentsIcon = new Icon[4];
		for (int i = 0; i < 4; ++i)
        {
			this.drinkIcon[i] = par1IconRegister.registerIcon("applemilk:cordial_drink" + this.type[i]);
            this.contentsIcon[i] = par1IconRegister.registerIcon("applemilk:cordial_inner" + this.type[i]);
        }	
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileCordial();
	}
}
