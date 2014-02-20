package mods.applemilk.common.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.UP;
import net.minecraft.block.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.*;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockFlint extends BlockBreakable{
	
	public BlockFlint  (int blockid, Material material, boolean flag)
	{
		super(blockid, "stoneSlab", material, flag);
		this.setHardness(1.5F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.0F);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
    {
        return 0;
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
	
	public boolean canPlaceTorchOnTop(World par1World, int par2, int par3, int par4)
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0x808080;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderColor(int par1)
    {
        return 0x808080;
    }
	
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return 0x808080;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = Block.stoneDoubleSlab.getBlockTextureFromSide(1);
		
	}

}
