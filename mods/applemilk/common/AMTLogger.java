package mods.applemilk.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class AMTLogger {
	
	public static final Logger logger = Logger.getLogger("DCsAppleMilk");
	
	public static void loadingModInfo(String modid) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINER, "Now checking other mod :" + modid);
	}
	
	public static void loadedModInfo(String modid) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINER, "Succeeded to check other mod :" + modid);
	}
	
	public static void failLoadingModInfo(String modid) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINER, "Failed to check other mod :" + modid);
	}
	
	public static void trace(String msg) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.FINEST, msg);
	}
	
	public static void info(String msg) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.INFO, msg);
	}
	
	public static void warn(String msg) {
		logger.setParent(FMLLog.getLogger());
		logger.log(Level.WARNING, msg);
	}
	
	public static void debugInfo(String msg) {
		if (DCsAppleMilk.debugMode) {
			logger.setParent(FMLLog.getLogger());
			logger.log(Level.INFO, "Debug: " + msg);
		}
	}

}
