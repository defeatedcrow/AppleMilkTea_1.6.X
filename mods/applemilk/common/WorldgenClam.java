package mods.applemilk.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldgenClam implements IWorldGenerator {
	
	private int genDim1 = 0;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		genDim1 = world.provider.dimensionId;
		
		int chunk2X = chunkX << 4;
        int chunk2Z = chunkZ << 4;         
        int count = DCsAppleMilk.clamChanceValue;
        
    	if ((genDim1 == 0))
    	{
    		for(int i = 0; i < count; i++)
			{
				int PosX = chunk2X + random.nextInt(16);
				int PosY = 55 + random.nextInt(10);
				int PosZ = chunk2Z + random.nextInt(16);
				
				if (world.getBlockMaterial(PosX, PosY + 1, PosZ) == Material.water && (world.getBlockId(PosX, PosY, PosZ) == Block.sand.blockID || world.getBlockId(PosX, PosY, PosZ) == Block.dirt.blockID))
				{
					if (world.rand.nextInt(30) == 0)
					{
						world.setBlock(PosX, PosY, PosZ, DCsAppleMilk.clamSand.blockID, 2, 2);
					}
					else
					{
						world.setBlock(PosX, PosY, PosZ, DCsAppleMilk.clamSand.blockID, 0, 2);
					}
				}
			}
    	}

	}

}
