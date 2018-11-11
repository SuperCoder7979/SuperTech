package supercoder79.supertech.gui.generator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class TileEntityGenerator extends TileEntityMachine implements ITickable {

    public int burnTime;
    public int burnTimeTotal;
    public boolean isBurning;

    public TileEntityGenerator() {
        super(1, "Generator");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setInteger("burnTime", burnTime);
        compound.setInteger("burnTimeTotal", burnTimeTotal);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        burnTime = compound.getInteger("burnTime");
        burnTimeTotal = compound.getInteger("burnTimeTotal");
    }

    @Override
    public void update() {
        //TODO: optimize this somehow
        if (!this.world.isRemote) {
            if (this.isBurning) {
                this.burnTime--;
                this.energy++;
                this.isBurning = true;
                if (this.burnTime <= 0) {
                    this.isBurning = false;
                    this.burnTime = 0;
                }
            } else if (!this.isEmpty()) {
                if (!(this.energy >= this.maxEnergy)) {
                    if (TileEntityFurnace.isItemFuel(this.machineItemStacks.get(0))) {
                        this.burnTimeTotal = TileEntityFurnace.getItemBurnTime(this.machineItemStacks.get(0));
                        this.burnTime = TileEntityFurnace.getItemBurnTime(this.machineItemStacks.get(0));
                        this.isBurning = true;
//                        if (!this.world.isRemote) {
                            decrStackSize(0, 1);
                            System.out.println("started burning 1: " + this.burnTime + " 2: " + this.burnTimeTotal);
//                        }
                    }
                }
            }
            if (this.energy > this.maxEnergy) {
                this.energy = this.maxEnergy;
            }
        }
    }

    @Override
    public void setField(int id, int value) {
//        super.setField(id, value);
        switch (id) {
            case 0:
                this.energy = value;
                break;
            case 1:
                this.burnTime = value;
                break;
            case 2:
                this.burnTimeTotal = value;
                break;
        }
    }

    public int getField(int id) {
        switch (id)
        {
            case 0:
                return this.energy;
            case 1:
                return this.burnTime;
            case 2:
                return this.burnTimeTotal;
        }
        return 0;
    }

    @Override
    public int getFieldCount() {
        return 3;
    }
}
