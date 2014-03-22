package mods.applemilk.common.block;

import java.util.Random;

import cpw.mods.fml.common.IFuelHandler;
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

public class BlockCharcoalBox extends Block implements IFuelHandler{
	
	@SideOnly(Side.CLIENT)
    private Icon charcoalBoxTop;
	@SideOnly(Side.CLIENT)
	private Icon charcoalBoxSide;
	
	public BlockCharcoalBox (int blockid)
	{
		super(blockid, Material.ground);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(1.0F);
		this.setResistance(2.0F);
	}
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		int i = fuel.itemID;
		return i == this.blockID ? 14400 : 0;
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.charcoalBoxTop : (par1 == 0 ? this.charcoalBoxSide : (par1 != 2 && par1 != 4 ? this.blockIcon : this.charcoalBoxSide));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "Container_S");
		this.charcoalBoxTop = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "CharcoalContainer_T");
		this.charcoalBoxSide = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "Container_S");
		
	}

}
