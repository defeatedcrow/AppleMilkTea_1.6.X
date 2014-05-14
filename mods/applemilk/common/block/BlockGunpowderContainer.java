package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.handler.Util;

public class BlockGunpowderContainer extends Block{
	
	private static final String[] boxType = new String[] {"Gunpowder", "Kayaku", "Clay", "Clam"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] boxTex;
	@SideOnly(Side.CLIENT)
    private Icon boxSideTex;
	
	
	public BlockGunpowderContainer (int blockid)
	{
		super(blockid, Material.ground);
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTickRandomly(true);
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 3) i = 3;
		if (par1 == 1)
        {
        	return this.boxTex[i];
        }
        else
        {
        	return this.boxSideTex;
        }
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			
			int meta = par1World.getBlockMetadata(par2, par3, par4);
			
			if (!DCsAppleMilk.noWetGContainer && meta < 2 && (par1World.isRaining()) && par1World.canBlockSeeTheSky(par2, par3 + 1, par4))
			{
				if (meta == 0) par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
				else if (meta == 1) par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			}
		}
	}
	
	public int tickRate(World par1World)
    {
        return 20;
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
		return this.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.boxSideTex = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "Container_S");
		this.boxTex = new Icon[4];
		
        for (int i = 0; i < 4; ++i)
        {
            this.boxTex[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + boxType[i] + "Container_T");
        }
	}

}