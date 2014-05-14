package mods.applemilk.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCsNewSound {
	
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void SoundLoad(SoundLoadEvent event)
	{
		
		String dir = new String("applemilk:suzu.ogg");
		
		try
		{
			event.manager.soundPoolSounds.addSound(dir);
		}
		catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds.");
		}
		
	}

}
