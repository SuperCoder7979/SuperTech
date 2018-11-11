package supercoder79.supertech.api.machine.conainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class MachineContainer extends Container {
    public MachineContainer(InventoryPlayer playerInv, final TileEntityMachine tileentity) {
        addInventorySlots(playerInv);
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
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
