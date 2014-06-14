package mods.applemilk.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileLargeBottle extends TileHasRemain2{
	

	@SideOnly(Side.CLIENT)
	public short getRemainClient()
	{
		int r = this.getRemainShort();
		r = (r & 7);
		return (short) r;
	}

}
