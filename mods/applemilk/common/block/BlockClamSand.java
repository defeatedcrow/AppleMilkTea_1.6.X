package mods.applemilk.common.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.clam,1,0)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.clam,1,0), 1);
        	}
    		
    		par1World.setBlock(par2, par3, par4, Block.sand.blockID);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.clam.itemID)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.clam,1,0)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.clam,1,0), 1);
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
        if(!par1World.isRemote && par1World.rand.nextInt(10) == 0 && !DCsAppleMilk.disableClam)
        {
        	super.updateTick(par1World, par2, par3, par4, par5Random);
        	
        	int i = par1World.rand.nextInt(4);
        	int Y1 = par3;
            int X1 = par2 + this.sideX[i];
        	int Z1 = par4 + this.sideZ[i];
        	
        	if (par1World.getBlockId(X1, Y1, Z1) == Block.sand.blockID && par1World.getBlockMaterial(X1, Y1 + 1, Z1) == Material.water)
        	{
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
    
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 1.1F);
        double d2 = (double)((float)par4 + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (!DCsAppleMilk.noRenderFoodsSteam) par1World.spawnParticle("bubble", d0, d1, d2, 0.0D, 0.0D, 0.0D);
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
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = Block.sand.getBlockTextureFromSide(1);
		
	}
}
