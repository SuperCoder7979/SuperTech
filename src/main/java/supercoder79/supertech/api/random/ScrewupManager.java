package supercoder79.supertech.api.random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScrewupManager {
    //for dealing with all the mistakes that people make

    public static void blowUpMachine(World world, BlockPos pos, int strength) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), strength, true);
    }
}
