package supercoder79.supertech.gui.generator;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.api.machine.conainer.MachineContainer;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class ContainerGenerator extends MachineContainer {
    public TileEntityGenerator te;
    public ContainerGenerator(InventoryPlayer playerInv, TileEntityGenerator tileentity) {
        super(playerInv, tileentity);
        te = tileentity;
        addSlotToContainer(new Slot(tileentity, 0, 56, 53) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
//                tileentity.energy++;
                System.out.println(tileentity.energy);
                System.out.println(tileentity.maxEnergy);
                System.out.println("amt: " + (int)(((double)tileentity.energy/(double)tileentity.maxEnergy)*25));
            }
        });
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : listeners) {
            //TODO: Value caching
            listener.sendWindowProperty(this, 0, te.getField(0));
            listener.sendWindowProperty(this, 1, te.getField(1));
            listener.sendWindowProperty(this, 2, te.getField(2));
        }
    }
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.te.setField(id, data);
    }
}
