package mods.applemilk.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import mods.applemilk.common.DCsAppleMilk;

public class Util {
	
	//コンフィグで規定範囲外の数値を入れた時に、安全に動かすためのメソッドその1
	public static int getCupRender()
	{
		int l = DCsAppleMilk.setCupTexture;
		if (l < 0) l = 1;
		else if (l > 3) l = 3;
		
		return l;
	}
	
	//その2
	public static int getTeppannReadyTime()
	{
		int l = DCsAppleMilk.teppannReadyTime;
		if (l < 0) l = 1;
		else if (l > 60) l = 60;
		
		return l;
	}
	
	//その3
	public static int getCupStacksize()
	{
		int l = DCsAppleMilk.cupStackSize;
		if (l <= 1) l = 1;
		else
		{
			if (l <= 3) l = 3;
			else
			{
				l = 8;
			}
		}
		return l;
	}
	
	//0,0=south, 1,90=west, 2,180=north, 3,-90=east
	//相変わらず方角を覚えられないため自分用に作ったメソッド
	public static final int[] metaX = new int[] {0, -1, 0, 1};
	
	public static final int[] metaZ = new int[] {-1, 0, 1, 0};
	
	public static final int[] rad = new int[] {0, -90, 180, 90};
	
	//FMLの機能を利用した他MOD様のアイテム取得メソッド。
	//protectedにする意味は正直あんまりない。
	protected static Item getModItem(String modId, String name)
	{
		Item ret = GameRegistry.findItem(modId, name);
		if (ret != null) {
			return ret;
		}
		else {
			return null;
		}
	}

	//現在地のバイオームを確認。
	//複数のクラスで利用するので、ここにまとめた。
	public static BiomeGenBase checkCurrentBiome(World world, EntityPlayer player)
	{
		BiomeGenBase biome = BiomeGenBase.plains;
		
		int x = MathHelper.floor_double(player.posX);
		int y = MathHelper.floor_double(player.posY);
		int z = MathHelper.floor_double(player.posZ);
		
		biome = world.getBiomeGenForCoords(x, z);
		
		return biome;
	}

}
