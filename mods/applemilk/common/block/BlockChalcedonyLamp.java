package mods.applemilk.common.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.UP;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockChalcedonyLamp extends Block{
	
	@SideOnly(Side.CLIENT)
    private Icon[] color;
	@SideOnly(Side.CLIENT)
    private Icon[] burst;
	@SideOnly(Side.CLIENT)
    private Icon[] force;
	@SideOnly(Side.CLIENT)
    private Icon inner;
	
	public BlockChalcedonyLamp  (int blockid, Material material, boolean flag)
	{
		super(blockid, Material.glass);
		this.setHardness(0.5F);
		this.setResistance(1.0F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setLightValue(1.0F);
		this.setTickRandomly(true);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
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
	
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.LampBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void LampBoundingBox (int par1)
	{
		float f = 0.125F;
		if (par1 < 4)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 1.0F, 1.0F - f);
		}
		
	}
	
	public int getMobilityFlag()
    {
        return 0;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par2 == 0 || par2 == 2)
		{
			return par1 == 1 ? this.color[0] : this.inner;
		}
		else if (par2 == 1 || par2 == 3)
		{
			return par1 == 1 ? this.color[1] : this.inner;
		}
		else if (par2 == 4)
		{
			return par1 == 1? this.color[0] : (par1 == 0 ? this.burst[0] : (par1 == 2 ? this.burst[1] : this.burst[2]));
		}
		else
		{
			return par1 == 1? this.color[1] : (par1 == 0 ? this.force[0] : this.force[1]);
		}
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 6; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
    }
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelCLamp;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 0.5F);
        double d2 = (double)((float)par4 + 0.5F);
        double d3 = 0.0199999988079071D;
        double d4 = 0.07000001072883606D;

        if (l == 4) par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.color = new Icon[2];
        for (int i = 0; i < 2; ++i)
        {
            if (i == 0) this.color[i] = par1IconRegister.registerIcon("applemilk:chalcedony");
            else this.color[i] = par1IconRegister.registerIcon("applemilk:chalcedony_orange");
        	
        }
        this.force = new Icon[2];
        for (int i = 0; i < 2; ++i)
        {
            this.force[i] = par1IconRegister.registerIcon("applemilk:lampside_force_" + i);
        	
        }
        this.burst = new Icon[3];
        for (int i = 0; i < 3; ++i)
        {
            this.burst[i] = par1IconRegister.registerIcon("applemilk:lampside_burst_" + i);
        	
        }
        this.inner = par1IconRegister.registerIcon("applemilk:whitepanel");
	}

}
