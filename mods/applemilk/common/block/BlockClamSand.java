package mods.applemilk.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.client.particle.EntityOrbFX;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockClamSand extends Block
{
    private final int[] sideX = new int[] {1, -1, 0, 0};
    private final int[] sideZ = new int[] {0, 0, 1, -1};
	
	public BlockClamSand(int par1)
    {
        super(par1, Material.ground);
        this.setStepSound(Block.soundSandFootstep);
        this.setHardness(0.5F);
		this.setResistance(1.0F);
        this.setTickRandomly(true);
    }
    
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }
    
    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

        ret.add(new ItemStack(DCsAppleMilk.clam, 1, 0));

        return ret;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.sand.blockID;
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        Material ueBlockMaterial = par1World.getBlockMaterial(par2, par3 + 1, par4);
        
        if (itemstack == null)
        {
        	if (currentMeta == 2)
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.princessClam,1,0)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.princessClam,1,0), 1);
            	}
        	}
        	else
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.clam,1,0)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.clam,1,0), 1);
            	}
        	}
    		
    		par1World.setBlock(par2, par3, par4, Block.sand.blockID);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.clam.itemID || itemstack.itemID == DCsAppleMilk.princessClam.itemID)
        {
        	if (currentMeta == 2)
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.princessClam,1,0)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.princessClam,1,0), 1);
            	}
        	}
        	else
        	{
        		if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.clam,1,0)))
            	{
            		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.clam,1,0), 1);
            	}
        	}
    		
    		par1World.setBlock(par2, par3, par4, Block.sand.blockID);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else
        {
        	return false;
        }
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	//まずは確率1/20
        if(!par1World.isRemote && par1World.rand.nextInt(20) == 0)
        {
        	super.updateTick(par1World, par2, par3, par4, par5Random);
        	
        	//周囲のハマグリ数のカウント
        	int count = this.hamaguriCalculater(par1World, par2, par3, par4);
        	//メタデータ
        	int meta = par1World.getBlockMetadata(par2, par3, par4);
        	int chance = DCsAppleMilk.clamChanceValue;
        	
        	//増殖予定の座標選定
        	int i = par1World.rand.nextInt(4);
        	int Y1 = par3;
            int X1 = par2 + this.sideX[i];
        	int Z1 = par4 + this.sideZ[i];
        	
        	//座標が増殖可能な状態か？
        	boolean flag = par1World.getBlockId(X1, Y1, Z1) == Block.sand.blockID && par1World.getBlockMaterial(X1, Y1 + 1, Z1) == Material.water;
        	boolean flag2 = par1World.rand.nextInt(1 + chance) > par1World.rand.nextInt(1 + count);//どちらも乱数判断
        	
        	if (meta == 0)//ハマグリ
        	{
        		if (count < 6)//ふつうに増える。
        		{
        			if (flag2 && flag)
                	{
        				par1World.setBlock(X1, Y1, Z1, DCsAppleMilk.clamSand.blockID);
                	}
        		}
        		else if (count < 9)
        		{
        			if (flag2 && flag)
    				{
    					par1World.setBlock(X1, Y1, Z1, DCsAppleMilk.clamSand.blockID);
    				}
    				else
    				{
    					//自身が衰退ハマグリ砂になる
    					par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
    				}
        		}
        		else
        		{
        			if (flag2 && flag && par1World.rand.nextInt(50) == 0)//超低確率
    				{
        				//プリンセス誕生
    					par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 3);
    				}
    				else
    				{
    					//自身が衰退ハマグリ砂になる
    					par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
    				}
        		}
        	}
        	else if (meta == 1)
        	{
        		if (count < 4 && flag)//減ってきた
        		{
        			//復活する
					par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
        		}
        		else
        		{
        			//消えてしまう
        			if (!flag2) par1World.setBlock(par2, par3, par4, Block.sand.blockID);
        		}
        	}
        	else if (meta == 2 && flag)
        	{
        		//姫は無条件でハマグリを増やせる
        		par1World.setBlock(X1, Y1, Z1, DCsAppleMilk.clamSand.blockID);
        	}
        	
        }
    	
    }
    
    public void canPlaceClamSand()
    {
    	
    }
    
    public int tickRate(World par1World)
    {
        return 20;
    }
    
    @SideOnly(Side.CLIENT)
	@Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 + 1, par2);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 1.1F);
        double d2 = (double)((float)par4 + 0.5F);
        double d3 = 0.015D;
        double d4 = 0.27000001072883606D;
        
        boolean flag = par1World.getBlockMaterial(par2, par3 + 1, par4) == Material.water;
        int k = 0;
        
        if (l == 2)
        {
        	for (int j = 1 ; j < 5 ; j++)
        	{
        		if (par1World.getBlockMaterial(par2, par3 + j, par4) == Material.water) k++;
        	}
        		
        }

        if (!DCsAppleMilk.noRenderFoodsSteam)
        {
        	if (l == 2)
        	{
        		EntityOrbFX cloud = new EntityOrbFX(par1World, d0, d1 + (double)k, d2, 0.0D, d3, 0.0D);
            	cloud.setParticleIcon(ParticleTex.getInstance().getIcon("applemilk:particle_orb"));
    			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
        	}
        	if (l == 0)
        	{
        		par1World.spawnParticle("bubble", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        	}
        }
    }
    
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0x979797;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderColor(int par1)
    {
        return 0x979797;
    }
	
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return 0x979797;
    }
	
	public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
		int l = world.getBlockMetadata(x, y, z);
		return l == 2 ? 15 : 0;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = Block.sand.getBlockTextureFromSide(1);
		
	}
    
    public int hamaguriCalculater(World world, int X, int Z, int Y)
    {
    	int difficulty = 0;
    	int count = 0;
    	boolean aroundPrincess = false;
    	
    	//各方角ごとに、隣接1~3マス先までのハマグリ砂を探す。最大12カウント。
    	for (int i = 0; i < 3; i++)
    	{
    		if (world.getBlockId(X + 1 + i, Y, Z) == this.blockID) {
    			count += 1;
    			if (world.getBlockMetadata(X + 1 + i, Y, Z) == 2) aroundPrincess = true;
    		}
    		if (world.getBlockId(X - 1 - i, Y, Z) == this.blockID) {
    			count += 1;
    			if (world.getBlockMetadata(X - 1 - i, Y, Z) == 2) aroundPrincess = true;
    		}
    		if (world.getBlockId(X, Y, Z + 1 + i) == this.blockID) {
    			count += 1;
    			if (world.getBlockMetadata(X, Y, Z + 1 + i) == 2) aroundPrincess = true;
    		}
    		if (world.getBlockId(X, Y, Z - 1 - i) == this.blockID) {
    			count += 1;
    			if (world.getBlockMetadata(X, Y, Z - 1 - i) == 2) aroundPrincess = true;
    		}
    	}
    	
    	if (aroundPrincess)//姫ハマグリがいた
    	{
    		count /= 4;//カウントを減
    	}
    	
    	return difficulty;
    }
}
