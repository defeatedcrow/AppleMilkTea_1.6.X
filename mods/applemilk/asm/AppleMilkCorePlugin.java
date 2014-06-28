package mods.applemilk.asm;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import mods.applemilk.asm.config.*;

/**
* Original code was created by A.K.
*/
//@IFMLLoadingPlugin.MCVersion("1.6.2")
public class AppleMilkCorePlugin implements IFMLLoadingPlugin {
	
	public static boolean allowLoad = true;
	public static int range = Byte.MAX_VALUE;
	private final String BR = System.getProperty("line.separator");
	
    public static Logger logger = Logger.getLogger("AppleMilkCore");
    
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                "mods.applemilk.asm.PotionArrayEXTransformer2"
        };
    }

    @Override
    public String getModContainerClass() {
        return "mods.applemilk.asm.AppleMilkCoreModContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        if (data.containsKey("mcLocation"))
        {
            File mcLocation = (File) data.get("mcLocation");
            File configLocation = new File(mcLocation, "config");
            File configFile = new File(configLocation, "AppleMilkCore.cfg");
            
            loadConfig(configFile);
        }
    }
    
    private void loadConfig(File configFile)
    {
    	DCsConfig config = new DCsConfig(configFile);
        config.load();
        PropertyDC a = config.get("general", "EnableLoadCore", true,
        		"Enable to load AppleMilkCore. If you want to disable AppleMilkCore, please set false."
    					+ BR +"(For example, for avoiding crash cause of conflict with MCPC+.)");
        PropertyDC b = config.get("general", "SetNewPotionIDRange", Byte.MAX_VALUE,
        		"Set new potion ID maximum. It must be bigger than 32, and smaller than 256.");
        
        allowLoad = a.getBoolean(true);
        range = b.getInt();
        if (range < 32) range = 32;
        if (range > 255) range = 255;
        
        config.save();
    }

	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}
}
