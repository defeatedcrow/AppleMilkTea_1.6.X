package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
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
import mods.applemilk.common.tile.TileChocoPan;
import mods.applemilk.common.tile.TilePanHandle;
import mods.applemilk.handler.LoadModHandler;
import mods.applemilk.handler.Util;

public class BlockEmptyPan extends BlockContainer{
	
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	@SideOnly(Side.CLIENT)
    private Icon chainTex;
	
	
	public BlockEmptyPan (int blockid)
	{
		super(blockid, Material.circuits);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        int bottomBlockID = par1World.getBlockId(par2, par3 - 1, par4);
        Block block = Block.blocksList[bottomBlockID];
        
        if (itemstack == null)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.emptyPan,1,0)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.emptyPan,1,0), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.emptyPan.blockID)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.emptyPan,1)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.emptyPan,1), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == Item.bowlEmpty.itemID)
        {
        	return true;
        }
        else
        {
        	int ID = itemstack.itemID;
        	int IDm = itemstack.getItemDamage();
        	int setMeta = this.getMakerMeta(ID, IDm);
        	
        	if ((setMeta > 0) && (this.onFurnace(par1World, par2, par3 - 1, par4)))
    		{
    			this.setPanMeta(par1World, par2, par3, par4, par5EntityPlayer, itemstack, setMeta);
    			par5EntityPlayer.triggerAchievement(AchievementRegister.makeRice);
        		return true;
    		}
    		else
    		{
    			return false;
    		}
        }
    }
	
	private boolean onFurnace(World world, int x , int y, int z)
	{
		int ID = world.getBlockId(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		ItemStack underBlock = new ItemStack(ID, 1, meta);
		
		if (ID == Block.furnaceBurning.blockID || ID == Block.furnaceIdle.blockID) {
			return true;
		}
		else if (LoadModHandler.matchItem("furnaceBlock", underBlock)) {
			return true;
		}
		else if (world.getBlockMaterial(x, y, z) == Material.fire) {
			return true;
		}
		
		return false;
	}
	
	private int getMakerMeta (int ID, int meta)
	{
		int m = -1;
		
		if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 3) m = 8;//rice
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 0) m = 9;//mushroom
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 1) m = 10;//stew
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 2) m = 11;//zousui
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 4) m = 8;//kayaku
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 5) m = 9;//tofu
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 6) m = 10;//pumpkin
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 7) m = 11;//BLT
		else if (ID == DCsAppleMilk.mincedFoods.itemID && meta == 8) m = 1;//choco
		
		return m;
	}
	
	private void setPanMeta(World world, int x, int y, int z,  EntityPlayer player, ItemStack itemstack, int setMeta)
	{
		TilePanHandle tile = (TilePanHandle) world.getBlockTileEntity(x, y, z);
		byte dir = tile.getDirectionByte();
		
		if (!player.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
        {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        }
		
		if (!world.isRemote && itemstack.getItemDamage() < 4){
			world.setBlock(x, y, z, DCsAppleMilk.filledPan.blockID, setMeta, 3);
			TilePanHandle tile2 = (TilePanHandle) world.getBlockTileEntity(x, y, z);
			tile2.setDirectionByte(dir);
		}
		else if (!world.isRemote && itemstack.getItemDamage() >= 4 && itemstack.getItemDamage() < 8){
			world.setBlock(x, y, z, DCsAppleMilk.filledPan2.blockID, setMeta, 3);
			TilePanHandle tile2 = (TilePanHandle) world.getBlockTileEntity(x, y, z);
			tile2.setDirectionByte(dir);
		}
		else if (!world.isRemote && itemstack.getItemDamage() == 8){
			world.setBlock(x, y, z, DCsAppleMilk.filledChocoPan.blockID);
			TileChocoPan tile2 = (TileChocoPan) world.getBlockTileEntity(x, y, z);
			tile2.setRemainByte((byte)11);
		}
		
		
		world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
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
		return DCsAppleMilk.modelPan;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return DCsAppleMilk.noUseCupDirection ? null : new TilePanHandle();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!DCsAppleMilk.noUseCupDirection)
		{
			TilePanHandle tileHandle = (TilePanHandle)world.getBlockTileEntity(x, y, z);
			
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
					var9 = 4;
				}
	 
				tileHandle.setDirectionByte(var9);
			}
		}
	}
 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int playerFacing = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
 
		if (!DCsAppleMilk.noUseCupDirection)
		{
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
				facing = 4;
			}
	 
			TileEntity tileEntity = par1World.getBlockTileEntity(par2, par3, par4);
			if (tileEntity != null && tileEntity instanceof TilePanHandle)
			{
				((TilePanHandle)tileEntity).setDirectionByte(facing);
				//System.out.println("[AppleMilk]Now fasing " + facing);
				par1World.markBlockForRenderUpdate(par2, par3, par4);
			}
		}
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
		float f = 0.125F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.5F, 1.0F - f);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (par1 == 1)
        {
        	return this.boxTex;
        }
		else if (par1 == 0)
		{
			return this.chainTex;
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
		this.chainTex = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "chain");
	}

}
