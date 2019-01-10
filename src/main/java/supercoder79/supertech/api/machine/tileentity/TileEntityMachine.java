package supercoder79.supertech.api.machine.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import supercoder79.supertech.api.config.SuperTechConfig;
import supercoder79.supertech.api.enet.IEnergyMachine;
import supercoder79.supertech.api.random.ScrewupManager;

public class TileEntityMachine extends TileEntity implements IInventory, ITickable, IEnergyMachine {
    public int energy = 0;
    public int maxEnergy = 4000;
    public String name = "SuperTech Machine";
    public NonNullList<ItemStack> machineItemStacks;
    //TODO: Make this usable for all machines

    public TileEntityMachine(int size, String name, int maxEnergy) {
         machineItemStacks = NonNullList.withSize(size, ItemStack.EMPTY);
         this.name = name;
         this.maxEnergy = maxEnergy;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("energy", energy);
        ItemStackHelper.saveAllItems(compound, this.machineItemStacks);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energy = compound.getInteger("energy");
        ItemStackHelper.loadAllItems(compound, this.machineItemStacks);
    }

    @Override
    public void update() {
        if (this.world.getWorldTime() % 600 == 0) {
            boolean isOpenToSky = true;
            BlockPos pos = this.pos;
            for (int i = 1; i < 256 - pos.getY(); i++) {
                BlockPos up = pos.up(i);
                if (this.world.getBlockState(up).getBlock() != Blocks.AIR) {
                    isOpenToSky = false;
                }
            }
            if (isOpenToSky) {
                if (world.isRaining()) {
                    if (SuperTechConfig.Rain_Explodes_Machines) {
                        ScrewupManager.blowUpMachine(this.world, this.pos, 4);
                    }
                }
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return machineItemStacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.machineItemStacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.machineItemStacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        this.markDirty();
        return ItemStackHelper.getAndSplit(this.machineItemStacks, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        this.markDirty();
        return ItemStackHelper.getAndRemove(this.machineItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.machineItemStacks.set(index, stack);
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return energy;
    }

    @Override
    public void setField(int id, int value) {
        energy = value;
    }

    @Override
    public int getFieldCount() {
        return 1;
    }

    @Override
    public void clear() {
        this.machineItemStacks.clear();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int extractEnergy(TileEntityMachine machine, int amt) {
        if (machine.energy >= amt) {
            if (this.energy + amt <= this.maxEnergy) {
                machine.energy-=amt;
                return amt;
            }
        }
        return 0;
    }
}
