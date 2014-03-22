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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.item.ItemWallMug;
import mods.applemilk.common.tile.TileLargeBottle;
import mods.applemilk.handler.LoadModHandler;
import mods.applemilk.handler.Util;

public class BlockLargeBottle extends BlockContainer{
	
	private static final String[] contents = new String[] {"_empty", "_sake", "_beer", "_wine", "_gin", "_rum", "_vodka", "_whiskey",
		"_milk", "_milk", "_sugar", "_maple", "_juice", "_nuts", "_berryjam"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] sideTex;
	
	
	public BlockLargeBottle (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundGlassFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	//回収動作
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        TileLargeBottle tile = (TileLargeBottle) par1World.getBlockTileEntity(par2, par3, par4);
        
        if (itemstack == null)//キャニスターの場合に限り、中身を一つづつ取り出すことが出来る。
        {
        	if (tile == null || currentMeta < 8) {
        		return false;
        	}
        	else {
        		short i = tile.getRemainShort();
        		int rem = checkRemain(i);
        		int type = currentMeta & 7;
        		
        		//中身の取得
        		String[] get = new String[] {"bucketMilk", "bucketSoy", "sugar", "maple", "honey", "nuts", "berry"};
        		ItemStack ret;
        		if (type == 2) {
        			ret = new ItemStack(Item.sugar, 1, 0);
        		}
        		else {
        			ret = LoadModHandler.getRandomItem(get[type]);
        		}
        		
        		if (type > 1 && ret != null)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(ret))
    	        	{
    	        		par5EntityPlayer.entityDropItem(ret, 1);
    	        	}
        			
        			if (rem == 0) {
        				tile.setRemainShort((short)0);
        				par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
        			}
        			else {
        				rem--;
        				int newRem = (rem << 4) + type + 8;
        				tile.setRemainShort((short)newRem);
        			}
        			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        			return true;
        		}
        	}
        	return false;
        }
        else if (itemstack.itemID == Item.bucketEmpty.itemID)//キャニスターの場合に限り、中身を一つづつ取り出すことが出来る。
        {
        	if (tile == null || currentMeta < 8) {
        		return false;
        	}
        	else {
        		short i = tile.getRemainShort();
        		int rem = checkRemain(i);
        		int type = currentMeta & 7;
        		
        		//中身の取得
        		ItemStack ret;
        		if (type == 0) {
        			ret = new ItemStack(Item.bucketMilk, 1, 0);
        		}
        		else {
        			ret = LoadModHandler.getItem("bucketSoy");
        		}
        		
        		if (type < 2 && ret != null)
        		{
        			if (!par5EntityPlayer.inventory.addItemStackToInventory(ret))
    	        	{
    	        		par5EntityPlayer.entityDropItem(ret, 1);
    	        	}
        			if (!par5EntityPlayer.capabilities.isCreativeMode)
                    {
                        --itemstack.stackSize;
                    }
        			
        			if (rem == 0) {
        				tile.setRemainShort((short)0);
        				par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
        			}
        			else {
        				rem--;
        				int newRem = (rem << 4) + type + 8;
        				tile.setRemainShort((short)newRem);
        			}
        			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        			return true;
        		}
        	}
        	return false;
        }
        else if (itemstack.itemID == DCsAppleMilk.wallMug.itemID)//wallmug
        {
        	short i = tile.getRemainShort();
        	int type = checkBottleType(i);
        	int rem = checkRemain(i);
        	
        	int damage = itemstack.getItemDamage();
        	int targetMilk = (damage >> 2) & 3;
        	int targetSugar = (damage >> 4) & 3;
        	int targetFruit = (damage >> 6) & 3;
        	
        	boolean flag = false;
        	int[] customize = {4, 12, 16, 32, 48, 128, 192};
        	
        	if (rem >= 0 && type > 7)//canisterのとき
        	{
        		if (targetMilk == 0 && (type == 8 || type == 9)) {
        			flag = true;
        		}
        		else if (targetSugar == 0 && (type == 10 || type == 11 || type == 12)) {
        			flag = true;
        		}
        		else if (targetFruit == 0 && (type == 13 || type == 14)) {
        			flag = true;
        		}
        	}
        	
        	if (flag)
        	{
        		if (!par5EntityPlayer.capabilities.isCreativeMode)
                {
                    --itemstack.stackSize;
                }
        		
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.wallMug,1,(damage + customize[type & 7]))))
	        	{
	        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.wallMug,1,(damage + customize[type & 7])), 1);
	        	}
        		
        		int newRem = 0;
        		if (rem - 1 < 0) {
        			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
        		}
        		else {
        			newRem = ((rem - 1) << 4) + type;
        		}
        		tile.setRemainShort((short)newRem);
        		
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        	}
    		
    		
    		return true;
        }
        else
        {
        	return false;
        }
    }
	
	//ドロップ
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        short l = (short)par6ItemStack.getItemDamage();
        
        super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, (l & 15), 3);
        //メタデータ自体はタイプに対応している。RenderBlockクラスでメタデータごとのテクスチャを振り分けるためだが、他にも方法はある気がする。
        
		TileLargeBottle tile = (TileLargeBottle) par1World.getBlockTileEntity(par2, par3, par4);
    	if (tile != null) tile.setRemainShort(l);
    	//ダメージ値をそのままTileEntityに渡す。
    }
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileLargeBottle tile = (TileLargeBottle)par1World.getBlockTileEntity(par2, par3, par4);

        if (tile != null)
        {
        	short l = (short)(tile.getRemainShort());
        	
        	if (l >= 0 && l <= 5000)//上限については余り考えていない
            {
                float f = par1World.rand.nextFloat() * 0.8F + 0.1F;
                float f1 = par1World.rand.nextFloat() * 0.8F + 0.1F;
                float f2 = par1World.rand.nextFloat() * 0.8F + 0.1F;
                
                //アイテム版の酒瓶をドロップ
                ItemStack itemstack = new ItemStack(DCsAppleMilk.itemLargeBottle, 1, l);
                //TileEntityのShort値をそのままダメージ値にして渡す
                EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), itemstack);

                float f3 = 0.05F;
                entityitem.motionX = (double)((float)par1World.rand.nextGaussian() * f3);
                entityitem.motionY = (double)((float)par1World.rand.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double)((float)par1World.rand.nextGaussian() * f3);
                par1World.spawnEntityInWorld(entityitem);
            }

            par1World.func_96440_m(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
	public int damageDropped(int par1)
    {
        return 0;
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return DCsAppleMilk.itemLargeBottle.itemID;
	}
	
	public int quantityDropped(Random random)
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
	
	//外見
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelLargeBottle;
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
		int i = par2;
		if (i > 14) i = 14;
		if (par2 < 8) {
			if (par1 == 1)
	        {
	        	return this.boxTex[i];
	        }
	        else
	        {
	        	return this.sideTex[i];
	        }
		}
		else {
			return this.boxTex[i];
		}
		
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 15; ++i)//登録はするが、クリエイティブで出すと残量は1になる
		{
			par3List.add(new ItemStack(this, 1, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.sideTex = new Icon[8];
		this.boxTex = new Icon[15];

        for (int i = 0; i < 8; ++i)
        {
        	this.sideTex[i] = par1IconRegister.registerIcon("applemilk:bottleside" + contents[i]);
        	this.boxTex[i] = par1IconRegister.registerIcon("applemilk:bottle" + contents[i]);
        }
        for (int j = 8; j < 15; ++j)
        {
        	this.boxTex[j] = par1IconRegister.registerIcon("applemilk:contents" + contents[j]);
        }
	}
	
	//Tile
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileLargeBottle();
	}
	
	//shortから情報を得るメソッド
	public static int checkBottleType(short par1)//内容物の種類は最大16種、remain値16以降は別のブロックとしての動作
	{
		int m = par1 & 15;
		return m;
	}
	
	public static int checkRemain(short par1)//Remain値の16、32、64の位が残量の管理用バイト
	{
		int m = par1 >> 4;//右にシフト。16から1へ。
        m = (m & 7);//16、32、64の桁をチェック
		return m;
	}

}
