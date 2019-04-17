package supercoder79.supertech112.api.enet.idontwannadealwiththis;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import supercoder79.supertech112.api.enet.IEnergyMachine;
import supercoder79.supertech112.api.machine.tileentity.TileEntityWire;

import java.util.ArrayList;

/**
 * A block connected to the EnergyNetwork (usually a wire) that can connect to EnergyNetworkConnections
 * @author SuperCoder79
 */
public class EnergyNetworkNode {
    public final BlockPos pos;
    public World world;
    public EnergyNetwork parent;
    public ArrayList<EnergyNetworkConnection> connections = new ArrayList<>();

    public EnergyNetworkNode(BlockPos pos, World world) {
        this.pos = pos;
        this.world = world;
        updateConnections();
        updateParentOnConstruction();
    }

    public void updateParentOnConstruction() {
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add(this.pos.up());
        positions.add(this.pos.down());
        positions.add(this.pos.east());
        positions.add(this.pos.south());
        positions.add(this.pos.west());
        positions.add(this.pos.north());
        boolean existingEnet = false;
        TileEntityWire wire = null;
        for (BlockPos pos : positions) {
            if (!(this.world == null)) {
                TileEntity te = this.world.getTileEntity(pos);
                if (te != null) {
                    if (te instanceof TileEntityWire) {
                        existingEnet = true;
                        wire = (TileEntityWire) te;
                    }
                }
            } else {
                System.out.println("Bad :(");
            }
        }
        if (existingEnet) {
            //shouldn't cause an npe afaik //nvm i was wrong
//            if (wire.loaded) {
//                this.parent = wire.node.parent;
//            } else {
//                this.parent = new EnergyNetwork(this);
//                this.parent.calculateConnectedNodes();
//            }
        } else {
            this.parent = new EnergyNetwork(this);
            this.parent.calculateConnectedNodes();
        }
    }

    public void updateConnections() {
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add(this.pos.up());
        positions.add(this.pos.down());
        positions.add(this.pos.east());
        positions.add(this.pos.south());
        positions.add(this.pos.west());
        positions.add(this.pos.north());

        connections.clear();
        for (BlockPos pos : positions) {
            if (!(this.world == null)) {
                TileEntity te = this.world.getTileEntity(pos);
                if (te != null) {
                    if (te instanceof IEnergyMachine) {
                        connections.add(new EnergyNetworkConnection(world, pos));
                    }
                }
            } else {
                System.out.println("Bad :(");
            }
        }
    }
}
