package supercoder79.supertech.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import supercoder79.supertech.api.machine.conainer.MachineContainer;
import supercoder79.supertech.api.machine.gui.MachineGUI;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;
import supercoder79.supertech.gui.generator.ContainerGenerator;
import supercoder79.supertech.gui.generator.GUIGenerator;
import supercoder79.supertech.gui.generator.TileEntityGenerator;

import javax.annotation.Nullable;

public class GUIHandler implements IGuiHandler {
    public static final int GENERATOR = 0;

    @Nullable
    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case GENERATOR:
                return new ContainerGenerator(player.inventory, (TileEntityGenerator) world.getTileEntity(new BlockPos(x, y, z)));
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
            default:
                return null;
        }
    }
}
