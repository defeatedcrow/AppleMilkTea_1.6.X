package mods.applemilk.common.item;

import net.minecraft.src.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.applemilk.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class ItemToffyApple extends ItemFood {
	
	public ItemToffyApple (int itemId,int reco, boolean flag){
		super (itemId, reco, flag);
		maxStackSize = 64;

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon("applemilk:toffyapple");
	}

}
