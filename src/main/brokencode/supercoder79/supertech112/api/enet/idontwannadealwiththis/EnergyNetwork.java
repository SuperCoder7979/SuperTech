package supercoder79.supertech112.api.enet.idontwannadealwiththis;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import supercoder79.supertech112.api.enet.IEnergyProvider;
import supercoder79.supertech112.api.machine.tileentity.TileEntityWire;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores all the EnergyNetworkNodes and manages energy insertion and extraction
 * @author SuperCoder79
 */
public class EnergyNetwork implements IEnergyProvider {
    public HashMap<BlockPos, EnergyNetworkNode> nodes = new HashMap<>();
    private ArrayList<BlockPos> recursionPos = new ArrayList<>();
    private EnergyNetworkNode initialNode;
    public World world;

    public EnergyNetwork(EnergyNetworkNode initial) {
        nodes.put(initial.pos, initial);
        initialNode = initial;
        world = initial.world;
    }

    @Override
    public int extractEnergy(int amt) {
        return 0;
    }

    /**
     * @return the amount of connected nodes
     */
    public int getNodeAmount() {
        return nodes.size();
    }

    public void calculateConnectedNodes() {
        nodes.clear();
        recursionPos.clear();
        findNodes(initialNode.pos);
    }

    private void findNodes(BlockPos pos) {
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add(pos.up());
        positions.add(pos.down());
        positions.add(pos.east());
        positions.add(pos.south());
        positions.add(pos.west());
        positions.add(pos.north());
        for (BlockPos position : positions) {
            if (world.getTileEntity(position) instanceof TileEntityWire) {
                nodes.put(position, ((TileEntityWire) world.getTileEntity(position)).node);
                if (recursionPos.contains(position)) {

                } else {
                    recursionPos.add(position);
                    findNodes(position);
                }
            }
        }
    }
}