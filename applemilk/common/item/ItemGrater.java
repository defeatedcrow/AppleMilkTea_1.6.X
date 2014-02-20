package mods.applemilk.common.item;

import java.util.ArrayList;
import net.minecraft.src.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class ItemGrater extends Item implements ICraftingHandler {
	
	private boolean repair;

	public ItemGrater (int itemId){
		super (itemId);
		this.setMaxStackSize(1);
		this.setMaxDamage(64);
        this.setNoRepair();

	}
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack){
		return false;
	}
	
	public boolean hasContainerItem(){
		return !repair;
	}
	
	public ItemStack getContainerItemStack(ItemStack itemStack)
	{
		if(itemStack != null && itemStack.itemID == this.itemID)
		{
			itemStack.setItemDamage(itemStack.getItemDamage()+1);
		}
		return itemStack;
	}
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		repair = this.itemID == item.itemID;
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon("applemilk:grater");
	}

}
