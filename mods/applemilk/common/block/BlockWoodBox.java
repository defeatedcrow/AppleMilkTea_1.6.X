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
import mods.applemilk.common.*;
import mods.applemilk.handler.Util;

public class BlockWoodBox extends Block{
	
	private static final String[] boxType = new String[] {"_oak", "_spruse", "_birch", "_jungle", "_rubber", "_great", "_silver",
		"_force", "_sakura", "_momizi", "_JPcedar"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] boxSideTex;
	
	
	public BlockWoodBox (int blockid)
	{
		super(blockid, Material.wood);
		this.setUnlocalizedName("woodBox");
		this.setStepSound(Block.soundWoodFootstep);
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 10) i = 10;
		if (par1 == 4 || par1 == 5)
        {
        	return this.boxSideTex[i];
        }
        else
        {
        	return this.boxTex[i];
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
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
		this.boxTex = new Icon[11];
		this.boxSideTex = new Icon[11];
		
        for (int i = 0; i < 11; ++i)
        {
            this.boxTex[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "WoodBox" + boxType[i]);
            this.boxSideTex[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "WoodBoxside" + boxType[i]);
        }
	}

}
