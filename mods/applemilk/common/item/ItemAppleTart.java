package mods.applemilk.common.item;

import net.minecraft.src.*;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import mods.applemilk.common.*;
import mods.applemilk.handler.LoadSSectorHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class ItemAppleTart extends ItemFood {
	
	public ItemAppleTart (int itemId,int reco, boolean flag){
		super (itemId, reco, flag);
		maxStackSize = 64;

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon("applemilk:appletart");
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
			this.reduceMoisture(-1, 0.0F, par3EntityPlayer);
		}
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}
	
	private void reduceMoisture(int par1, float par2, EntityPlayer par3EntityPlayer)
	{
		if (DCsAppleMilk.SuccessLoadSSector)
		{
			LoadSSectorHandler.addStatus(par1, par2, 0, 0.0F, par3EntityPlayer);
		}
	}

}
