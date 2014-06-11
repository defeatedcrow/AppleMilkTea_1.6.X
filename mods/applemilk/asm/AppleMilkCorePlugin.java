package mods.applemilk.asm;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

/**
* Original code was created by A.K.
*/
@IFMLLoadingPlugin.MCVersion("1.6.2")
public class AppleMilkCorePlugin implements IFMLLoadingPlugin {
    public static Logger logger = Logger.getLogger("AppleMilkCore");
    public static int maxDamageModifier;
    public static int maxAnvilLevelModifier;
    public static int setAnvilLevelModifier;
    public static int beaconBaseRange;
    public static int beaconLevelRange;
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                "mods.applemilk.asm.PotionArrayEXTransformer"
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
            File configFile = new File(configLocation, "DCsAppleMilk.cfg");
        }
    }

	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}
}
