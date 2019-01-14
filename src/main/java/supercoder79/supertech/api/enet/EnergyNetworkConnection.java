package supercoder79.supertech.api.enet;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

/**
 * Manages the connection between the EnergyNetwork and the IEnergyMachine
 * @author SuperCoder79
 */
public class EnergyNetworkConnection implements IEnergyProvider {
    public TileEntityMachine te;
    public World world;
    public IEnergyProvider provider = null;
    public BlockPos pos;
    public boolean canExtract = false;
    public EnergyNetworkConnection(World world, BlockPos pos) {
        this.world = world;
        this.pos = pos;
        if (world.getTileEntity(pos) instanceof  TileEntityMachine) {
            te = (TileEntityMachine)world.getTileEntity(pos);
            if (world.getTileEntity(pos) instanceof IEnergyProvider) {
                canExtract = true;
                provider = (IEnergyProvider)world.getTileEntity(pos);
            }
        }
    }

    @Override
    public int extractEnergy(int amt) {
        if (canExtract) {
            return provider.extractEnergy(amt);
        } else {
            return 0;
        }
    }
}
