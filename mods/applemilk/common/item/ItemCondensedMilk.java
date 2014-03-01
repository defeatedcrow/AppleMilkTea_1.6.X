package mods.applemilk.common.item;

import net.minecraft.src.*;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import mods.applemilk.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCondensedMilk extends ItemFood {
	
	public ItemCondensedMilk (int itemId,int reco, boolean flag){
		super (itemId, reco, flag);
		this.setMaxStackSize(64);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon("applemilk:condensedmilk");
	}

}
