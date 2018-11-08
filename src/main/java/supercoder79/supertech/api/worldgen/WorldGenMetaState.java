package supercoder79.supertech.api.worldgen;

import com.google.common.base.Predicate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.block.blocks.Ore;

public class WorldGenMetaState extends WorldGenerator
{
    private final Ore oreBlock;
    /** The number of blocks to generate. */
    private final int numberOfBlocks;
    private final Predicate<IBlockState> predicate;

    public WorldGenMetaState(Ore ore, int blockCount)
    {
        this(ore, blockCount, new WorldGenMetaState.StonePredicate());
    }

    public WorldGenMetaState(Ore ore, int blockCount, Predicate<IBlockState> p_i45631_3_) {
        this.oreBlock = ore;
        this.numberOfBlocks = blockCount;
        this.predicate = p_i45631_3_;
    }

    public boolean generate(World worldIn, Random rngsus, BlockPos position) {
        float f = rngsus.nextFloat() * (float)Math.PI;
        double d0 = (double)((float)(position.getX() + 8) + MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d1 = (double)((float)(position.getX() + 8) - MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d2 = (double)((float)(position.getZ() + 8) + MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d3 = (double)((float)(position.getZ() + 8) - MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d4 = (double)(position.getY() + rngsus.nextInt(3) - 2);
        double d5 = (double)(position.getY() + rngsus.nextInt(3) - 2);

        for (int i = 0; i < this.numberOfBlocks; ++i) {
            float f1 = (float)i / (float)this.numberOfBlocks;
            double d6 = d0 + (d1 - d0) * (double)f1;
            double d7 = d4 + (d5 - d4) * (double)f1;
            double d8 = d2 + (d3 - d2) * (double)f1;
            double d9 = rngsus.nextDouble() * (double)this.numberOfBlocks / 16.0D;
            double d10 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.floor(d6 - d10 / 2.0D);
            int k = MathHelper.floor(d7 - d11 / 2.0D);
            int l = MathHelper.floor(d8 - d10 / 2.0D);
            int i1 = MathHelper.floor(d6 + d10 / 2.0D);
            int j1 = MathHelper.floor(d7 + d11 / 2.0D);
            int k1 = MathHelper.floor(d8 + d10 / 2.0D);

            for (int l1 = j; l1 <= i1; ++l1)
            {
                double d12 = ((double)l1 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D)
                {
                    for (int i2 = k; i2 <= j1; ++i2)
                    {
                        double d13 = ((double)i2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D)
                        {
                            for (int j2 = l; j2 <= k1; ++j2)
                            {
                                double d14 = ((double)j2 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
                                {
                                    BlockPos blockpos = new BlockPos(l1, i2, j2);

                                    IBlockState state = worldIn.getBlockState(blockpos);
                                    if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, this.predicate)) {
//                                        rngsus = new Random();
//                                        int rng = rngsus.nextInt((100 - 1) + 1) + 1;
                                        int rng = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                                        int type;
                                        if (rng <= 40) {
                                            type = 1;
                                        } else if (rng > 40 && rng <= 60) {
                                            type = 2;
                                        } else if (rng > 60 && rng <= 80) {
                                            type = 3;
                                        } else if (rng > 80) {
                                            type = 4;
                                        } else {
                                            type = 0;
                                            System.out.println("This shouldn't happen!!!");
                                        }

//                                        if (this.oreBlock == SuperTechBlocks.leadOre) {
//                                            System.out.println("Lead: " + type);
//                                        } else {
//                                            System.out.println("Ruby: " + type);
//                                        }
                                        worldIn.setBlockState(blockpos, this.oreBlock.getDefaultState().withProperty(Ore.TYPE, type), 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    static class StonePredicate implements Predicate<IBlockState>
    {
        private StonePredicate()
        {
        }

        public boolean apply(IBlockState p_apply_1_)
        {
            if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.STONE)
            {
                BlockStone.EnumType blockstone$enumtype = (BlockStone.EnumType)p_apply_1_.getValue(BlockStone.VARIANT);
                return blockstone$enumtype.isNatural();
            }
            else
            {
                return false;
            }
        }
    }
}
