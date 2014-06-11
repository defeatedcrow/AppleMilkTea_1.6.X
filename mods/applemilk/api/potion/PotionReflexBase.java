package mods.applemilk.api.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

/**
 * ただ単に継承して使えるようにするだけのもの。
 * <br>継承しているポーション効果は、
 * プレイヤーを含むEntityLivingBaseのダメージ処理時に呼び出され、Amplifierが一段階減少する。
 * <br>呼び出されたあとの処理はこのクラス内で定義できます。*/
public abstract class PotionReflexBase extends Potion{
	
	public boolean endlessly = false;

	protected PotionReflexBase(int id, boolean flag, int color, boolean isInfinity) {
		super(id, flag, color);
		this.endlessly = isInfinity;
	}
	
	
	/**@param target : 攻撃を受けたEntityLivingBase
	 * @param source : 受けた攻撃のダメージソース
	 * @param id : このポーション効果のID
	 * @param amount : 受けたダメージの値
	 * <br>このメソッド内でダメージを受けた瞬間の処理を行い、成否判定をboolean型で返して下さい。
	 * <br>trueを返した場合のみ、Amplifierの減少処理とダメージの無効化が行われます。
	 * */
	public abstract boolean effectFormer(EntityLivingBase target, DamageSource source, int id, float amount);

}
