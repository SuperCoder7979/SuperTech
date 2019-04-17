package supercoder79.supertech112.machines.macerator;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import supercoder79.supertech112.api.machine.conainer.MachineContainer;

public class ContainerMacerator extends MachineContainer {
    TileEntityMacerator te;
    public ContainerMacerator(InventoryPlayer playerInv, TileEntityMacerator tileentity) {
        super(playerInv, tileentity);
        te = tileentity;
        addSlotToContainer(new Slot(tileentity, 0, 44, 25) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }
        });
        addSlotToContainer(new Slot(tileentity, 1, 98, 25) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        addSlotToContainer(new Slot(tileentity, 2, 116, 25) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
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
}
