package supercoder79.supertech.api.machine.conainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class MachineContainer extends Container {
    protected TileEntityMachine tileEntityMachine;
    public MachineContainer(InventoryPlayer playerInv, final TileEntityMachine tileentity) {
        tileEntityMachine = tileentity;
        addInventorySlots(playerInv);
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : listeners) {
            //TODO: Value caching
            listener.sendWindowProperty(this, 0, tileEntityMachine.getField(0));
        }
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileEntityMachine.setField(id, data);
    }

    public void addInventorySlots(InventoryPlayer playerInv) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }
}
