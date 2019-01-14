package supercoder79.supertech.api.machine.tileentity;

import net.minecraft.tileentity.TileEntity;
import supercoder79.supertech.api.enet.EnergyNetworkNode;

public class TileEntityWire extends TileEntity {
    public EnergyNetworkNode node;
    public TileEntityWire() {
        node = new EnergyNetworkNode(this.pos, this.world);
    }

    public void updateNeighbors() {
        node.updateConnections();
    }
}
