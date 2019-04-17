package supercoder79.supertech112.machines.generator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import supercoder79.supertech112.api.enet.IEnergyProvider;
import supercoder79.supertech112.api.machine.tileentity.TileEntityMachine;

public class TileEntityGenerator extends TileEntityMachine implements IEnergyProvider {

    public int burnTime;
    public int burnTimeTotal;
    public boolean isBurning;

    public TileEntityGenerator() {
        super(1, "Generator", 4000);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setInteger("burnTime", burnTime);
        compound.setInteger("burnTimeTotal", burnTimeTotal);
        compound.setBoolean("isBurning", isBurning);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        burnTime = compound.getInteger("burnTime");
        burnTimeTotal = compound.getInteger("burnTimeTotal");
        isBurning = compound.getBoolean("isBurning");
    }

    @Override
    public void update() {
        super.update();
        //TODO: optimize this somehow
        if (!this.world.isRemote) {
            if (this.isBurning) {
                this.burnTime--;
                this.energy+=8;
                this.isBurning = true;
                if (this.burnTime <= 0) {
                    this.isBurning = false;
                    this.burnTime = 0;
                }
            } else if (!this.isEmpty()) {
                if (!(this.energy >= this.maxEnergy)) {
                    if (TileEntityFurnace.isItemFuel(this.machineItemStacks.get(0))) {
                        this.burnTimeTotal = TileEntityFurnace.getItemBurnTime(this.machineItemStacks.get(0))/2;
                        this.burnTime = TileEntityFurnace.getItemBurnTime(this.machineItemStacks.get(0))/2;
                        this.isBurning = true;
                            decrStackSize(0, 1);
                            markDirty();
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

    @Override
    public int extractEnergy(int amt) {
        if (this.energy >= amt) {
            if (this.energy + amt <= this.maxEnergy) {
                this.energy-=amt;
                return amt;
            }
        }
        return 0;
    }
}
