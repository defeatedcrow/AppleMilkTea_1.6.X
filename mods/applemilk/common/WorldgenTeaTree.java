package mods.applemilk.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldgenTeaTree implements IWorldGenerator {
	
	private int genDim1 = 0;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		genDim1 = world.provider.dimensionId;
		
		int chunk2X = chunkX << 4;
        int chunk2Z = chunkZ << 4;         
        int count = DCsConfig.teaTreeGenValue;
        
    	if ((genDim1 == 0))
    	{
    		for(int i = 0; i < count; i++)
			{
				int PosX = chunk2X + random.nextInt(16);
				int PosY = 70 + random.nextInt(30);
				int PosZ = chunk2Z + random.nextInt(16);
				
				if (world.getBlockLightValue(PosX, PosY, PosZ) > 11 && world.isAirBlock(PosX, PosY, PosZ) && world.getBlockId(PosX, PosY - 1, PosZ) == Block.grass.blockID)
				{
					world.setBlock(PosX, PosY, PosZ, DCsAppleMilk.teaTree.blockID, 0, 2);
				}
			}
    	}

	}

}