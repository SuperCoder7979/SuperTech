package supercoder79.supertech.block.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.blocks.BlockRotatable;
import supercoder79.supertech.gui.GUIHandler;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;
import supercoder79.supertech.gui.generator.TileEntityGenerator;

import javax.annotation.Nullable;
import java.util.List;

public class Generator extends BlockRotatable implements ITileEntityProvider {

    public Generator() {
        super(Material.ROCK, "generator");
        setHardness(30);
        setResistance(5f);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Stick some coal in and get some power out! Somehow....");
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGenerator();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                player.openGui(SuperTech.INSTANCE, GUIHandler.GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;

    }

}
