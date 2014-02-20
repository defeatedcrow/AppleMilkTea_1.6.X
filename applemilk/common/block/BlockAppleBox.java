package mods.applemilk.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import mods.applemilk.common.*;

public class BlockAppleBox extends Block{
	
	@SideOnly(Side.CLIENT)
    private Icon appleBoxTop;
	@SideOnly(Side.CLIENT)
	private Icon appleBoxSide;
	
	public BlockAppleBox (int blockid)
	{
		super(blockid, Material.wood);
		this.setStepSound(Block.soundWoodFootstep);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.appleBoxTop : (par1 == 0 ? this.appleBoxSide : (par1 != 2 && par1 != 4 ? this.blockIcon : this.appleBoxSide));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("applemilk:WoodBox");
		this.appleBoxTop = par1IconRegister.registerIcon("applemilk:AppleBox");
		this.appleBoxSide = par1IconRegister.registerIcon("applemilk:WoodBox");
		
	}
}
