package supercoder79.supertech.api.enet;

import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public interface IEnergyProvider {
    int extractEnergy(TileEntityMachine machine, int amt);
    int extractEnergy(int amt);
}
