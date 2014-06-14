package mods.applemilk.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.PacketHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/* 熟成時間の処理と、完了したかどうかの判定を持つ。
 * 直射日光は厳禁。日光に当てると軸性時間がリセットされてしまう。*/
public class TileCordial extends TileEntity{
	
	private int aging = 0;
	private boolean isAged = false;

    //NBT
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.aging = par1NBTTagCompound.getInteger("Remaining");
        this.isAged = par1NBTTagCompound.getBoolean("IsAged");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Remaining", this.aging);
        par1NBTTagCompound.setBoolean("IsAged", this.isAged);
    }
    
    @Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
 
	@Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        this.readFromNBT(pkt.data);
    }

    public int getAgingTime()
    {
        return this.aging;
    }
    
    public void setAgingTime(int par1)
    {
    	this.aging = par1;
    }
    
    public boolean getAged()
    {
        return this.isAged;
    }
    
    public void setAged(boolean par1)
    {
    	this.isAged = par1;
    }
    
    //レンダー用の熟成段階取得メソッド。一日ごとに色が濃くなっていく。
    public int getAgingStage()
    {
    	int i = this.aging / 6000;
    	return i;
    }
    
    public void setAgingStage(int par1)
    {
    	int i = par1 * 6000;
    	this.aging = i;
    }
    
    public void updateEntity()
    {
    	if (this.worldObj != null)
        {
            if (!this.isAged)//まだ熟成未完了
            {
            	//直射日光が当たっていない・常温でのみ熟成する。
                if (!this.worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord)
                		&& !this.isColdBiome() && !this.isDryBiome())
                {
                	this.aging++;
                	
                	if (this.aging > 24000)//4日間で熟成完了する
                	{
                		this.aging = 24000;
                		this.setAged(true);
                	}
                }
            }
        }
    	
    	super.updateEntity();
    }
    
    public int getMetadata()
    {
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
    
    public boolean isColdBiome()
	{
		boolean flag = false;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord);
		
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FROZEN)
				|| biome.getEnableSnow())
		{
			flag = true;
		}
		
		return flag;
	}
    
    public boolean isDryBiome()
	{
		boolean flag = false;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord);
		
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DESERT)
				|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.NETHER)
				|| biome.getFloatRainfall() > 0.0F)
		{
			flag = true;
		}
		
		return flag;
	}

}
