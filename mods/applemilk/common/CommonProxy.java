package mods.applemilk.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.client.*;
import mods.applemilk.client.gui.*;
import mods.applemilk.common.tile.*;
import mods.applemilk.handler.NetworkUtil;
import mods.applemilk.handler.Util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class CommonProxy implements IGuiHandler{
	
	//TileEntityの登録
	//こちらはサーバー用クラスなので、レンダー関係は一切登録しない
    public void registerTileEntity()
    {
		GameRegistry.registerTileEntity(TileHasDirection.class, "TileHasDirection");
		GameRegistry.registerTileEntity(TileHasRemaining.class, "TileHasRemaining");
		GameRegistry.registerTileEntity(TileHasRemain2.class, "TileHasRemaining2");
		
		GameRegistry.registerTileEntity(TileTeppann.class, "TileTeppann");
		GameRegistry.registerTileEntity(TileCupHandle.class, "TileCupHandle");
		GameRegistry.registerTileEntity(TileBread.class, "TileBread");
		GameRegistry.registerTileEntity(TileDummy.class, "TileDummy");
		GameRegistry.registerTileEntity(TileJPBowl.class, "TileJPBowl");
		GameRegistry.registerTileEntity(TileChopsticksBox.class, "TileChopsticksBox");
		GameRegistry.registerTileEntity(TileEggs.class, "TileEggs");
		GameRegistry.registerTileEntity(TileSteak.class, "TileSteak");
		GameRegistry.registerTileEntity(TileMakerHandle.class, "TileMakerHandle");
		GameRegistry.registerTileEntity(TilePanHandle.class, "TilePanHandle");
		GameRegistry.registerTileEntity(TileChocoPan.class, "TileChocoPan");
		GameRegistry.registerTileEntity(TileMakerNext.class, "TileMakerNext");
		GameRegistry.registerTileEntity(TileAutoMaker.class, "TileAutoMaker");
		GameRegistry.registerTileEntity(TileWipeBox.class, "TileWipeBox");
		GameRegistry.registerTileEntity(TileIceMaker.class, "TileIceMaker");
		GameRegistry.registerTileEntity(TileIceCream.class, "TileIcecream");
		GameRegistry.registerTileEntity(TileWipeBox2.class, "TileWipeBox2");
	}
	
    //レンダーIDには-1を返す
	public int getRenderID()
	{
		return -1;
	}
	
	//レンダーの登録も何もしない
	public void registerRenderers()
	{
		
	}

	//クライアント側のワールドではないのでnullを返す。
	public World getClientWorld() {
		
		return null;
	}
	
	//GUIの登録
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;
 
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if (tileentity instanceof TileAutoMaker) {
			return new ContainerAutoMaker(player.inventory, (TileAutoMaker) tileentity);
		}
		else if (tileentity instanceof TileIceMaker) {
			return new ContainerIceMaker(player, (TileIceMaker)tileentity);
		}
		return null;
	}
 
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;
 
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if (tileentity instanceof TileAutoMaker) {
			return new GuiAutoMaker(player.inventory, (TileAutoMaker) tileentity);
		}
		else if (tileentity instanceof TileIceMaker) {
			return new GuiIceMaker(player, (TileIceMaker)tileentity);
		}
		return null;
	}
	
	//自分でもよくわからなくなった例その1
	public boolean func_44513dcs()
	{
		boolean func_23994dcs = MinecraftServer.getServer().isServerInOnlineMode();
		return func_23994dcs;
	}
	
	//自分でもよくわからないものその2
	public boolean func_44892dcs()
	{
		boolean func_25471dcs = MinecraftServer.getServer().isSinglePlayer();
		return !func_25471dcs;
	}
	
	//バグるので凍結中
	public void networkUtil()
	{
		//(new NetworkUtil()).NetworkUtility();
	}

	public void init() {
		
	}

}