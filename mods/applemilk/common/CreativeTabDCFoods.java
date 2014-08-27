package mods.applemilk.common;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabDCFoods extends CreativeTabs {
	
	//クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativeTabDCFoods(String type)
	{
		super(type);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Apple&Milk&Tea:Foods";
	}

	@Override
	public Item getTabIconItem() {
		return DCsAppleMilk.toffyApple;
	}
}
