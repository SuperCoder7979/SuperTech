package supercoder79.supertech.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import supercoder79.supertech.api.blocks.BasicBlock;
import supercoder79.supertech.api.machine.tileentity.TileEntityWire;
import supercoder79.supertech.machines.macerator.TileEntityMacerator;

public class Wire extends BasicBlock {
    public Wire() {
        super(Material.IRON, "wire");
    }
    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(world, pos, neighbor);
        if (world.getTileEntity(pos) instanceof TileEntityWire) {
            TileEntityWire te = (TileEntityWire)world.getTileEntity(pos);
            te.updateNeighbors();
        }
    }
}
