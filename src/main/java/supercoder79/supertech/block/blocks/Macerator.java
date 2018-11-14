package supercoder79.supertech.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.blocks.BlockRotatable;
import supercoder79.supertech.gui.GUIHandler;
import supercoder79.supertech.gui.macerator.TileEntityMacerator;

import javax.annotation.Nullable;
import java.util.List;

public class Macerator extends BlockRotatable {
    public Macerator() {
        super(Material.IRON, "macerator");
        setHardness(5);
        setResistance(3f);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Turns ores into dusts for further processing.");
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityMacerator();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(world, pos, neighbor);
        if (world.getTileEntity(pos) instanceof TileEntityMacerator) {
            TileEntityMacerator macerator = (TileEntityMacerator)world.getTileEntity(pos);
            macerator.updateGenerators();
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                player.openGui(SuperTech.INSTANCE, GUIHandler.MACERATOR, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;

    }
}
