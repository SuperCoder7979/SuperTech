package supercoder79.supertech.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import supercoder79.supertech.machines.electrolyzer.ContainerElectrolyzer;
import supercoder79.supertech.machines.electrolyzer.GUIElectrolyzer;
import supercoder79.supertech.machines.electrolyzer.TileEntityElectrolyzer;
import supercoder79.supertech.machines.generator.ContainerGenerator;
import supercoder79.supertech.machines.generator.GUIGenerator;
import supercoder79.supertech.machines.generator.TileEntityGenerator;
import supercoder79.supertech.machines.macerator.ContainerMacerator;
import supercoder79.supertech.machines.macerator.GUIMacerator;
import supercoder79.supertech.machines.macerator.TileEntityMacerator;

import javax.annotation.Nullable;

public class GUIHandler implements IGuiHandler {
    public static final int GENERATOR = 0;
    public static final int MACERATOR = 1;
    public static final int ELECTROLYZER = 2;

    @Nullable
    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case GENERATOR:
                return new ContainerGenerator(player.inventory, (TileEntityGenerator) world.getTileEntity(new BlockPos(x, y, z)));
            case MACERATOR:
                return new ContainerMacerator(player.inventory, (TileEntityMacerator) world.getTileEntity(new BlockPos(x, y, z)));
            case ELECTROLYZER:
                return new ContainerElectrolyzer(player.inventory, (TileEntityElectrolyzer) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GENERATOR:
                return new GUIGenerator(getServerGuiElement(ID, player, world, x, y, z), player.inventory, (TileEntityGenerator) world.getTileEntity(new BlockPos(x, y, z)));
            case MACERATOR:
                return new GUIMacerator(getServerGuiElement(ID, player, world, x, y, z), player.inventory, (TileEntityMacerator) world.getTileEntity(new BlockPos(x, y, z)));
            case ELECTROLYZER:
                return new GUIElectrolyzer(getServerGuiElement(ID, player, world, x, y, z), player.inventory, (TileEntityElectrolyzer) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }
}
