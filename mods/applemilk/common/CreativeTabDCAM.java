package mods.applemilk.common;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.*;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabDCAM extends CreativeTabs {
	
	//クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativeTabDCAM(String type)
	{
		super(type);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return DCsAppleMilk.toffyApple.itemID;
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Apple&Milk&Tea";
	}
	

}
