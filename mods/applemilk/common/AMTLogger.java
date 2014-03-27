package mods.applemilk.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class AMTLogger {
	
	public static final Logger logger = Logger.getLogger("AppleMilkTea");
	
	public static void LoadingModInfo(String modid) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINER, "Now checking other mod :" + modid);
	}
	
	public static void LoadedModInfo(String modid) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINEST, "Succeeded to check other mod :" + modid);
	}
	
	public static void info(String msg) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.INFO, msg);
	}
	
	public static void debugInfo(String msg) {
		if (DCsAppleMilk.debugMode) {
			logger.setParent(FMLLog.getLogger());
			logger.log(Level.INFO, msg);
		}
	}

}
