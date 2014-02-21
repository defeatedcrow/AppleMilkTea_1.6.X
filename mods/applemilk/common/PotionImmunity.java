package mods.applemilk.common;

import net.minecraft.potion.Potion;

public class PotionImmunity extends Potion
{
    //ポーション効果はラベルやアイコンの登録しか行っていない。バニラの一部ポーションもこんな感じ。
	public PotionImmunity(int par1, boolean par2, int par3)
    {
        super(par1, par2, par3);
    }

}
