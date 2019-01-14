package supercoder79.supertech.machines.electrolyzer;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import supercoder79.supertech.api.machine.conainer.MachineContainer;

public class ContainerElectrolyzer extends MachineContainer {
    TileEntityElectrolyzer te;
    public ContainerElectrolyzer(InventoryPlayer playerInv, TileEntityElectrolyzer tileentity) {
        super(playerInv, tileentity);
        te = tileentity;
        addSlotToContainer(new Slot(tileentity, 0, 80, 46) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }
        });
        addSlotToContainer(new Slot(tileentity, 1, 50, 16) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        addSlotToContainer(new Slot(tileentity, 2, 70, 16) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        addSlotToContainer(new Slot(tileentity, 3, 90, 16) {
            @Override
            public void onSlotChanged() {
                tileentity.markDirty();
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        addSlotToContainer(new Slot(tileentity, 4, 110, 16) {
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
