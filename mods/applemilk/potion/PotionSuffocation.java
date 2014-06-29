package mods.applemilk.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class PotionSuffocation extends Potion{
	
	public PotionSuffocation(int par1, boolean par2, int par3)
    {
        super(par1, par2, par3);
        this.setEffectiveness(0.25D);
    }
	
	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2)
    {
		if (par2 > 0 && par1EntityLivingBase.getHealth() > 1.0F)
        {
			float damage = (float)par2;
            par1EntityLivingBase.attackEntityFrom(DamageSource.inWall, damage);
        }
    }
	
	@Override
	public boolean isReady(int par1, int par2)
    {
		int k = 40 >> par2;
        return k > 0 ? par1 % k == 0 : true;
    }

}
