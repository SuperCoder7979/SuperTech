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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.blocks.BlockRotatable;
import supercoder79.supertech.gui.GUIHandler;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;
import supercoder79.supertech.gui.generator.TileEntityGenerator;
import supercoder79.supertech.item.SuperTechItems;

import javax.annotation.Nullable;
import java.util.List;

public class Generator extends BlockRotatable {

    public Generator() {
        super(Material.ROCK, "generator");
        setHardness(5);
        setResistance(3f);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Stick some coal in and get some power out! Somehow....");
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityGenerator();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (!player.isSneaking() && !(player.getHeldItemMainhand().getItem() == SuperTechItems.debugScissors)) {
                player.openGui(SuperTech.INSTANCE, GUIHandler.GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
            }
            if (player.getHeldItemMainhand().getItem() == SuperTechItems.debugScissors) {
                if (world.getTileEntity(pos) instanceof  TileEntityGenerator) {
                    player.sendStatusMessage(new TextComponentString("Energy: " + ((TileEntityGenerator)world.getTileEntity(pos)).energy), false);
                }
            }
        }
        return true;

    }

}
