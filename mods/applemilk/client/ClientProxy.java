package mods.applemilk.client;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.client.model.*;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.CommonProxy;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import mods.applemilk.common.entity.EntityMelonBomb;
import mods.applemilk.common.tile.*;
import mods.applemilk.handler.NetworkUtil;
import mods.applemilk.handler.Util;
import mods.applemilk.handler.nei.LoadNEIHandler;


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
		ClientRegistry.registerTileEntity(TileRotaryDial.class, "TileRotaryDial", new TileEntityDialRenderer());
		ClientRegistry.registerTileEntity(TileCocktail.class, "TileCocktail", new TileEntityCocktailRenderer());
		ClientRegistry.registerTileEntity(TileLargeBottle.class, "TileLargeBottle", new TileEntityBottleRenderer());
		ClientRegistry.registerTileEntity(TileCLamp.class, "TileChalcedonyLamp", new TileEntityCLampRenderer());
		ClientRegistry.registerTileEntity(TileCordial.class, "TileCordial", new TileEntityCordialRenderer());
		ClientRegistry.registerTileEntity(TileAlcoholCup.class, "TileAlcoholCup", new TileEntityAlcoholCupRenderer());
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
		RenderingRegistry.registerBlockHandler(new RenderDial());
		RenderingRegistry.registerBlockHandler(new RenderCocktail());
		RenderingRegistry.registerBlockHandler(new RenderLargeBottle());
		RenderingRegistry.registerBlockHandler(new RenderCassisTree());
		RenderingRegistry.registerBlockHandler(new RenderCordial());
		RenderingRegistry.registerBlockHandler(new RenderAlcoholCup());
		RenderingRegistry.registerEntityRenderingHandler(EntityMelonBomb.class, new RenderMelonBomb());
		VillagerRegistry.instance().registerVillagerSkin(DCsConfig.villagerRecipeID, new ResourceLocation(Util.getEntityTexturePassNoAlt() + "villager_cafe.png"));
	}
	
	@Override
	public boolean func_44513dcs()
	{
		boolean func_23994dcs = false;
			
		return func_23994dcs;
	}
	
	@Override
	public boolean func_44892dcs ()
	{
		boolean func_25471dcs = !Minecraft.getMinecraft().isSingleplayer();
		return func_25471dcs;
	}
	
	@Override
	public void networkUtil()
	{
		//(new NetworkUtil()).clientUtility();
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void registerTex() {
		MinecraftForge.EVENT_BUS.register(new ParticleTex());
	}
	
	@Override
	public void loadNEI() {
		if (Loader.isModLoaded("NotEnoughItems")) {
			AMTLogger.loadingModInfo("NotEnoughItems");
	    	try
	        {
	    		LoadNEIHandler.load();
	        }
	        catch (Exception e) {
	        	AMTLogger.failLoadingModInfo("NotEnoughItems");
	          e.printStackTrace(System.err);
	        }
		}
	}

}
