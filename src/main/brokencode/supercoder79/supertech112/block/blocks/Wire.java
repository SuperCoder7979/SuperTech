package supercoder79.supertech112.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import supercoder79.supertech112.api.blocks.BasicBlock;
import supercoder79.supertech112.api.machine.tileentity.TileEntityWire;

import javax.annotation.Nullable;

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

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        TileEntityWire wire = new TileEntityWire();
//        wire.setWorld(world);
        return wire;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
                if (world.getTileEntity(pos) instanceof TileEntityWire) {
                    player.sendStatusMessage(new TextComponentString("Energy: " + ((TileEntityWire) world.getTileEntity(pos)).energy), false);
                }
        }
        return true;
    }
}
