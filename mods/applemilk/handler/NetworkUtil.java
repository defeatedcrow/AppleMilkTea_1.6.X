package mods.applemilk.handler;

import net.minecraft.server.MinecraftServer;
import mods.applemilk.common.DCsAppleMilk;

public class NetworkUtil {
	
	//設定にかかわらず「オヤスミ、ケダモノ」宣告が出るため凍結中
	//クライアント側から、ログイン中のサーバーのプロパティ内容を取得する方法が判らん
	//何とかして、ネザー禁止時に救済レシピが追加されるような機能を付けたいのだが。
	public void NetworkUtility()
	{
		boolean a = DCsAppleMilk.proxy.func_44513dcs();
		boolean b = DCsAppleMilk.proxy.func_44892dcs();
		boolean c = false;
		
		if (!a && !b){
			DCsAppleMilk.inClient = true;
			System.out.println("[AppleMilk]Recognized to client mode.");
		}
		else if (a && b){
			DCsAppleMilk.inServer = true;
			c = true;
			System.out.println("[AppleMilk]Recognized to server mode.");
		}
		else{
			DCsAppleMilk.thirdParty = true;
			System.out.println("[AppleMilk]Good night, beasts.");
		}
		
		if (c)
		{
			//DCsAppleMilk.getServerPlop1 = MinecraftServer.getServer().getAllowNether();
			//System.out.println("[AppleMilk]Registered EX recipe.");
		}
	}
	
	public void clientUtility()
	{
		boolean a = false;
		boolean b = false;
		b = DCsAppleMilk.proxy.func_44892dcs();
		if (b){
			a = DCsAppleMilk.proxy.func_44513dcs();
		}
		
		boolean c = false;
		
		if (!a && !b){
			DCsAppleMilk.inClient = true;
			System.out.println("[AppleMilk]Recognized to client mode.");
		}
		else if (a && b){
			DCsAppleMilk.inServer = true;
			c = true;
			System.out.println("[AppleMilk]Recognized to server mode.");
		}
		else{
			DCsAppleMilk.thirdParty = true;
			System.out.println("[AppleMilk]Good night, beasts.");
		}
		
		if (c)
		{
			//DCsAppleMilk.getServerPlop1 = MinecraftServer.getServer().getAllowNether();
		}
	}

}
