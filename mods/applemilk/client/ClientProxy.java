package mods.applemilk.client;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.client.model.*;
import mods.applemilk.common.CommonProxy;
import mods.applemilk.common.entity.EntityMelonBomb;
import mods.applemilk.common.tile.*;
import mods.applemilk.handler.NetworkUtil;


@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
	
	@Override
	public void registerTileEntity()
    {
		GameRegistry.registerTileEntity(TileTeppann.class, "TileTeppann");
		GameRegistry.registerTileEntity(TileHasDirection.class, "TileHasDirection");
		GameRegistry.registerTileEntity(TileHasRemaining.class, "TileHasRemaining");
		GameRegistry.registerTileEntity(TileHasRemain2.class, "TileHasRemaining2");
		
		GameRegistry.registerTileEntity(TileDummy.class, "TileDummy");
		ClientRegistry.registerTileEntity(TileCupHandle.class, "TileCupHandle", new TileEntityCupHandleRenderer());
		ClientRegistry.registerTileEntity(TileBread.class, "TileBread", new TileEntityBreadRenderer());
		ClientRegistry.registerTileEntity(TileJPBowl.class, "TileJPBowl", new TileEntityBowlJPRenderer());
		ClientRegistry.registerTileEntity(TileChopsticksBox.class, "TileChopsticks", new TileEntityChopsticksRenderer());
		ClientRegistry.registerTileEntity(TileEggs.class, "TileEggs", new TileEntityEggsRenderer());
		ClientRegistry.registerTileEntity(TileSteak.class, "TileSteak", new TileEntitySteakRenderer());
		ClientRegistry.registerTileEntity(TileMakerHandle.class, "TileMakerHandle", new TileEntityMakerRenderer());
		ClientRegistry.registerTileEntity(TilePanHandle.class, "TilePanHandle", new TileEntityPanHandleRenderer());
		ClientRegistry.registerTileEntity(TileChocoPan.class, "TileChocoPan", new TileEntityChocoPanRenderer());
		ClientRegistry.registerTileEntity(TileMakerNext.class, "TilemakerNext", new TileEntityMakerNextRenderer());
		ClientRegistry.registerTileEntity(TileAutoMaker.class, "TileAutoMaker", new TileEntityAutoMakerRenderer());
		ClientRegistry.registerTileEntity(TileWipeBox.class, "TileWipeBox", new TileEntityWipeBoxRenderer());
		ClientRegistry.registerTileEntity(TileIceMaker.class, "TileIceMaker", new TileEntityIceMakerRenderer());
		ClientRegistry.registerTileEntity(TileIceCream.class, "TileIceCream", new TileEntityIceCreamRenderer());
		ClientRegistry.registerTileEntity(TileWipeBox2.class, "TileWipeBox2", new TileEntityWipe2Renderer());
	}

	@Override
	public int getRenderID()
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerBlockHandler(new RenderTeaMaker());
		RenderingRegistry.registerBlockHandler(new RenderEmptyCup());
		RenderingRegistry.registerBlockHandler(new RenderSoupPan());
		RenderingRegistry.registerBlockHandler(new RenderTeaTree());
		RenderingRegistry.registerBlockHandler(new RenderFilledCup());
		RenderingRegistry.registerBlockHandler(new RenderFilledBowl());
		RenderingRegistry.registerBlockHandler(new RenderBowlRack());
		RenderingRegistry.registerBlockHandler(new RenderChalcedonyLamp());
		RenderingRegistry.registerBlockHandler(new RenderBreadBasket());
		RenderingRegistry.registerBlockHandler(new RenderFoodPlate());
		RenderingRegistry.registerBlockHandler(new RenderTeppann());
		RenderingRegistry.registerBlockHandler(new RenderFilledBowlJP());
		RenderingRegistry.registerBlockHandler(new RenderCupSummer());
		RenderingRegistry.registerBlockHandler(new RenderChopsticksBox());
		RenderingRegistry.registerBlockHandler(new RenderEggsBasket());
		RenderingRegistry.registerBlockHandler(new RenderKinoko());
		RenderingRegistry.registerBlockHandler(new RenderChocoPan());
		RenderingRegistry.registerBlockHandler(new RenderTeaMakerNext());
		RenderingRegistry.registerBlockHandler(new RenderAutoMaker());
		RenderingRegistry.registerBlockHandler(new RenderWipeBox());
		RenderingRegistry.registerBlockHandler(new RenderIceMaker());
		RenderingRegistry.registerBlockHandler(new RenderIceCream());
		RenderingRegistry.registerEntityRenderingHandler(EntityMelonBomb.class, new RenderMelonBomb());
	}
	
	public boolean func_44513dcs()
	{
		boolean func_23994dcs = false;
			
		return func_23994dcs;
	}
	
	public boolean func_44892dcs ()
	{
		boolean func_25471dcs = !Minecraft.getMinecraft().isSingleplayer();
		return func_25471dcs;
	}
	
	public void networkUtil()
	{
		//(new NetworkUtil()).clientUtility();
	}
	
	public void init() {
		
	}

}
