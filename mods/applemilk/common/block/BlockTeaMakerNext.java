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
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.handler.LoadIC2Handler;
import mods.applemilk.api.recipe.*;

public class BlockTeaMakerNext extends BlockContainer{
	
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	
	
	public BlockTeaMakerNext (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        TileMakerNext tile = (TileMakerNext)par1World.getBlockTileEntity(par2, par3, par4);
        if (tile == null)return false;
        
        ItemStack tileItem = tile.getItemStack();//tileが保持しているアイテム
        int remain = tile.getRemainByte();//残量
        
        ITeaRecipe recipe = null;//itemのほうのレシピ
        if (itemstack != null) recipe = RecipeRegisterManager.teaRecipe.getRecipe(itemstack);
        
        if (itemstack == null)
        {
        	AMTLogger.debugInfo("Checking tile... ");
        	if (tileItem != null )AMTLogger.debugInfo("tile hold item: " + tileItem.getDisplayName());
        	if (tile.getOutput() != null )AMTLogger.debugInfo("tile hold recipe: " + tile.getOutput().getDisplayName());
        	AMTLogger.debugInfo("tile remaining: " + tile.getRemainByte());
        	AMTLogger.debugInfo("tile texture: " + tile.getCurrentTexture());
        	
        	return DCsAppleMilk.debugMode;
        }
        else if (tileItem != null && remain > 0) //空ではない
        {
        	Item item = itemstack.getItem();
        	int meta = itemstack.getItemDamage();
        	
        	if (item.itemID == DCsAppleMilk.emptyCup.blockID) //空マグで右クリックする処理を最優先に
        	{
        		if (tile.getOutput() != null)
        		{
        			ItemStack output = tile.getOutput();//アウトプットの取得。レシピ無しの場合nullを返すのでそのチェックも兼ねている
        			if (output != null)
        			{
        				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
            			
            			if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(output.getItem(), 1, output.getItemDamage())))
                		{
                			par5EntityPlayer.entityDropItem((new ItemStack(output.getItem(), 1, output.getItemDamage())), 1.0F);
                		}
            			
            			//実績用処理
            			if (output.getItem().itemID == DCsAppleMilk.teacupBlock.blockID && output.getItemDamage() == 4) {
            				par5EntityPlayer.triggerAchievement(AchievementRegister.getTea);
            			}
            			else if (output.getItem().itemID == DCsAppleMilk.teaCup2.blockID && output.getItemDamage() == 3) {
            				par5EntityPlayer.triggerAchievement(AchievementRegister.getAppleMilkTea);
            			}
            			
            			tile.setRemainByte((byte)(remain - 1));
            			if ((remain - 1) == 0){
            				tile.clearTile();
            			}
            			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            			return true;
        			}
        		}
        		return false;
        	}
        	else if (item == DCsAppleMilk.EXItems && meta == 10) //ウォールマグは4種しか汲めない
        	{
        		if (tile.getOutput() != null)
        		{
        			ItemStack output = tile.getOutput();
        			if (tileItem.getItem() == DCsAppleMilk.EXItems && tileItem.getItemDamage() == 2) {
        				output = new ItemStack(DCsAppleMilk.wallMug, 1, 1);
        			}
        			else if (tileItem.getItem() == DCsAppleMilk.EXItems && tileItem.getItemDamage() == 3) {
        				output = new ItemStack(DCsAppleMilk.wallMug, 1, 0);
        			}
        			else if (tileItem.getItem() == DCsAppleMilk.gratedApple && tileItem.getItemDamage() == 2) {
        				output = new ItemStack(DCsAppleMilk.wallMug, 1, 3);
        			}
        			else if (tileItem.getItem() == Item.dyePowder && tileItem.getItemDamage() == 2) {
        				output = new ItemStack(DCsAppleMilk.wallMug, 1, 2);
        			}
        			
        			if (output.getItem() == DCsAppleMilk.wallMug)
        			{
        				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
            			
            			if (!par5EntityPlayer.inventory.addItemStackToInventory(output))
                		{
                			par5EntityPlayer.entityDropItem(output, 1.0F);
                		}
            			
            			tile.setRemainByte((byte)(remain - 1));
            			if ((remain - 1) == 0){
            				tile.clearTile();
            			}
            			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
            			return true;
        			}
        		}
        		return false;
        	}
        	else if (tileItem.getItem() == DCsAppleMilk.gratedApple && tileItem.getItemDamage() == 3 && DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Mug != null
					&& LoadIC2Handler.IC2MugCoffee != null && itemstack.getItem() == LoadIC2Handler.IC2Mug.getItem()) //IC2コーヒー
			{
				if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
	            {
	                par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
	            }
				
				if (tile.getMilked())
				{
					if (!par5EntityPlayer.inventory.addItemStackToInventory(LoadIC2Handler.IC2MugCoffeeMilk.copy()))
    	    		{
    	    			par5EntityPlayer.entityDropItem(LoadIC2Handler.IC2MugCoffeeMilk.copy(), 1);
    	    		}
				}
				else
				{
					if (!par5EntityPlayer.inventory.addItemStackToInventory(LoadIC2Handler.IC2MugCoffee.copy()))
    	    		{
    	    			par5EntityPlayer.entityDropItem(LoadIC2Handler.IC2MugCoffee.copy(), 1);
    	    		}
				}
				
				tile.setRemainByte((byte)(remain - 1));
				if ((remain - 1) == 0){
    				tile.clearTile();
    			}
    			
    			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
				return true;
			}
        	else if (recipe != null) //手持ちアイテムが登録済みの茶の材料のとき
        	{
        		AMTLogger.debugInfo("Checking currentItem... ");
            	boolean flag = false;
            	String s = "null";
            	if (recipe != null)
            	{
            		flag = true;
            		s = recipe.getOutput().getDisplayName();
            	}		
            	AMTLogger.debugInfo("This Item has recipe: " + flag + ", output: " + s);
        		
        		if (tile.getItemStack().getItem() == Item.bucketMilk) //ティーメーカーが牛乳のみのとき
        		{
        			AMTLogger.debugInfo("milk -> milk_drink");
        			tile.setMilk(true);
					tile.setItemStack(new ItemStack(itemstack.getItem(), 1, itemstack.getItemDamage()));
					tile.setRemainByte((byte)(3 + par1World.rand.nextInt(3)));
					tile.onInventoryChanged();;
					
					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                    {
                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }
					
					par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
					return true;
        		}
        		else //牛乳以外
        		{
        			if (!tile.getMilked() && itemstack.getItem() == Item.bucketMilk) //牛乳バケツを持っている
        			{
        				AMTLogger.debugInfo("drink -> milk_drink");
        				
        				if (recipe.getOutputMilk() != null) //ミルク追加可能として事前に登録済み
        				{
        					tile.setMilk(true);//ミルクフラグだけONに
        					tile.setRemainByte((byte)(3 + par1World.rand.nextInt(3)));
        					tile.onInventoryChanged();;
        					
        					if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty, 1, 0)))
                    		{
                    			par5EntityPlayer.entityDropItem((new ItemStack(Item.bucketEmpty, 1, 0)), 1.0F);
                    		}
        					if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                            {
                                par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                            }
        					par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        					return true;
        				}
        				else
        				{
        					return false;
        				}
        			}
        		}
        	}
        	else
        	{
        		return false;
        	}
        }
        else //ティーメーカーが空の時
        {
        	if (this.isEmptyCell(itemstack)) //水を汲むための処理
        	{
        		this.getWater(itemstack, par5EntityPlayer);
        		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
        		return true;
        	}
        	else if (recipe != null) //投入できる材料を持っている
    		{
        		AMTLogger.debugInfo("Checking currentItem... ");
            	boolean flag = false;
            	String s = "null";
            	if (recipe != null)
            	{
            		flag = true;
            		s = recipe.getOutput().getDisplayName();
            	}		
            	AMTLogger.debugInfo("This Item has recipe: " + flag + ", output: " + s);
        		
    			tile.setItemStack(new ItemStack(itemstack.getItem(), 1, itemstack.getItemDamage()));
    			tile.setRemainByte((byte)(3 + par1World.rand.nextInt(3))); //3～5杯
    			tile.onInventoryChanged();;
    			
    			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                {
                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
    			return true;
    		}
        	else if(DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Coffeepowder != null && itemstack.getItem() == LoadIC2Handler.IC2Coffeepowder.getItem())
        	{
        		tile.setItemStack(new ItemStack(DCsAppleMilk.gratedApple, 1, 3));//かわりに当MODのコーヒー粉が突っ込まれる
    			tile.setRemainByte((byte)(3 + par1World.rand.nextInt(3))); //3～5杯
    			par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    			if (!par5EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                {
                    par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
    			return true;
        	}
        	else
        	{
        		return false;
        	}
        	
        }
        
        return false;
    }
	
	
	private void getWater(ItemStack itemstack, EntityPlayer par2EntityPlayer)
	{
		int ID = itemstack.itemID;
    	int IDm = itemstack.getItemDamage();
    	
	    if (ID == Item.bucketEmpty.itemID)
		{
			if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketWater,1)))
    		{
    			par2EntityPlayer.entityDropItem(new ItemStack(Item.bucketWater, 1), 1);
    		}
			
			if (!par2EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
            {
                par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
		}
		else if (ID == Item.glassBottle.itemID)
		{
			if (!par2EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
            {
                par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
			
			if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.potion, 1, 0)))
    		{
    			par2EntityPlayer.entityDropItem(new ItemStack(Item.potion, 1, 0), 1);
    		}
		}
		else if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Cell != null && itemstack.getItem() == LoadIC2Handler.IC2Cell.getItem())
		{
			if (!par2EntityPlayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
            {
                par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
			
			if (!par2EntityPlayer.inventory.addItemStackToInventory(LoadIC2Handler.IC2WaterCell.copy()))
    		{
    			par2EntityPlayer.entityDropItem(LoadIC2Handler.IC2WaterCell.copy(), 1);
    		}
		}
	}
	
	private boolean isEmptyCell(ItemStack itemstack)
	{
		boolean flag;
		if (itemstack.itemID == Item.bucketEmpty.itemID) flag = true;
		else if (itemstack.itemID == Item.glassBottle.itemID) flag = true;
		else if (DCsAppleMilk.SuccessLoadIC2 && LoadIC2Handler.IC2Cell != null && itemstack.itemID == LoadIC2Handler.IC2Cell.itemID) flag = true;
		else flag = false;
		
		return flag;
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
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelMakerNext;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileMakerNext();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		
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
				var9 = 3;
			}
 
			world.setBlockMetadataWithNotify(x, y, z, var9, 3);
		}
	}
 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int playerFacing = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
 
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
			facing = 3;
		}
 
		par1World.setBlockMetadataWithNotify(par2, par3, par4, facing, 3);
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
		float f = 0.3125F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
	}
	
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par1 == 1)
        {
        	return this.boxTex;
        }
        else
        {
        	return Block.waterStill.getBlockTextureFromSide(0);
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
		this.boxTex = par1IconRegister.registerIcon("applemilk:porcelain");
	}
}
