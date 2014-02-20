package mods.applemilk.handler;

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


}
