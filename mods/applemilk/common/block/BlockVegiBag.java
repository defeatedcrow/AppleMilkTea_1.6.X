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
import net.minecraft.util.MathHelper;
import mods.applemilk.common.*;
import mods.applemilk.handler.Util;

public class BlockVegiBag extends Block{
	
	private static final String[] bagVegi = new String[] {"_Leaves", "_Potato", "_Carrot", "_Pumpkin", "_Seed", "_Reed", "_Cactus", "_Cocoa", "_Wart", "Sugar"};
	private static final String[] bagTexType = new String[] {"LeavesBag_T", "PotatoBag_T", "CarrotBag_T", "PumpkinBag_T", "SeedBag_T", "ReedBag_T",
		"CactusBag_T", "CocoaBag_T", "WartBag_T", "SugarBag_T"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] wheatBagTop;
	@SideOnly(Side.CLIENT)
	private Icon wheatBagSide;
	
	public BlockVegiBag (int blockid)
	{
		super(blockid, Material.wood);
		this.setStepSound(Block.soundWoodFootstep);
	}
	
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        int i = par2;
        if (i > 9) i = 9;
        if (par1 == 0 || par1 == 1)
        {
        	return this.wheatBagTop[i];
        }
        else
        {
        	return this.wheatBagSide;
        }
		
    }
	
	public int damageDropped(int par1)
    {
        return par1;
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
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "WheatBag_S");
        this.wheatBagSide = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "WheatBag_S");
        this.wheatBagTop = new Icon[10];
        
        for (int i = 0; i < 10; ++i)
        {
            this.wheatBagTop[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + bagTexType[i]);
        }
        
	}

}
