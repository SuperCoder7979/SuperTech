package supercoder79.supertech.api.worldgen;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import supercoder79.supertech.api.random.ItsNotMyFaultException;
import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.block.blocks.Ore;
import supercoder79.supertech.api.config.SuperTechConfig;

import java.lang.reflect.Field;
import java.util.Random;

public class OreGenerator implements IWorldGenerator {
    @Override
    public void generate(Random rngsus, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (SuperTechConfig.Generate_Ores) {
            switch(world.provider.getDimension()) {
                case -1: //nether
                    break;
                case 0: //overworld
                    runGenerator(SuperTechBlocks.leadOre, 8, 4, 12, 60, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    runGenerator(SuperTechBlocks.rubyOre, 4, 2, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    runGenerator(SuperTechBlocks.sapphireOre, 4, 2, 0, 30, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    runGenerator(SuperTechBlocks.bauxiteOre, 14, 2, 30, 75, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    runGenerator(SuperTechBlocks.copperOre, 10, 3, 40, 75, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    runGenerator(SuperTechBlocks.copperOre, 6, 2, 0, 20, BlockMatcher.forBlock(Blocks.STONE), world, rngsus, chunkX, chunkZ);
                    break;
                case 1: //end
                    break;
                default: //other dims
                    break;
            }
        }

    }

    private void runGenerator(Ore ore, int blockAmount, int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rngsus, int chunk_X, int chunk_Z){
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new ItsNotMyFaultException("Illegal Height Arguments for WorldGenMetaState");

        WorldGenMetaState generator = new WorldGenMetaState(ore, blockAmount, blockToReplace);
        int heightdiff = maxHeight - minHeight +1;
        for (int i=0; i<chancesToSpawn; i++){
            int x = chunk_X * 16 +rngsus.nextInt(16);
            int y = minHeight + rngsus.nextInt(heightdiff);
            int z = chunk_Z * 16 + rngsus.nextInt(16);

            generator.generate(world, rngsus, new BlockPos(x, y, z));
        }
    }
}
