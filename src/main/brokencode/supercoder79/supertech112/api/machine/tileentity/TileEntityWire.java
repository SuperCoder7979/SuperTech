package supercoder79.supertech112.api.machine.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import supercoder79.supertech112.api.enet.IEnergyMachine;
import supercoder79.supertech112.api.enet.IEnergyProvider;
import supercoder79.supertech112.api.enet.idontwannadealwiththis.EnergyNetworkNode;

import java.util.ArrayList;

public class TileEntityWire extends TileEntity implements ITickable, IEnergyProvider, IEnergyMachine {
    public int energy = 0;
    public int maxEnergy = 32;
    public EnergyNetworkNode node;
    public TileEntityWire() {
        super();
    }

    public void updateNeighbors() {
    }

    @Override
    public void onLoad() {
        super.onLoad();
        //System.out.println(SuperCoder79.willToLive)
        //0
    }

    @Override
    public void update() {
        //E-nets broken: 1
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add(pos.up());
        positions.add(pos.down());
        positions.add(pos.east());
        positions.add(pos.south());
        positions.add(pos.west());
        positions.add(pos.north());
        for (BlockPos position : positions) {
            if (world.getTileEntity(position) instanceof IEnergyProvider) {
                IEnergyProvider provider = (IEnergyProvider)world.getTileEntity(position);
                int total = maxEnergy - energy;
                if (total == 0) {
                    break;
                } else {
                    this.energy += provider.extractEnergy(total);
                }
            }
        }
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public int extractEnergy(int amt) {
//        if (this.energy >= amt) {
//            if (this.energy + amt <= this.maxEnergy) {
//                this.energy -= amt;
//                return amt;
//            }
//        }
        if (this.energy >= amt) {
            this.energy-=amt;
            return amt;
        } else {
            energy = 0;
            return energy;
        }
    }
    
}