package supercoder79.supertech.gui.macerator;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.gui.generator.TileEntityGenerator;

import java.util.ArrayList;

public class TileEntityMacerator extends TileEntityMachine implements ITickable {
    public int progress = 0;
    public int maxProgress = 0;
    public TileEntityGenerator generator = null;

    public TileEntityMacerator() {
        super(3, "macerator", 4000);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setInteger("progress", progress);
        compound.setInteger("maxProgress", maxProgress);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        progress = compound.getInteger("progress");
        maxProgress = compound.getInteger("maxProgress");
    }

    @Override
    public void update() {
        if (!this.world.isRemote) {
            if (this.generator != null) {
                this.energy += extractEnergy(generator, 32)-1;
            }
            //TODO: recipe maps
            if (progress <= 0) {
                if (getStackInSlot(0).getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) {
                    if ((getStackInSlot(1).getItem() == Materials.Iron.dust && getStackInSlot(2).getItem() == Materials.Gold.dustTiny) || (getStackInSlot(1).isEmpty() && getStackInSlot(2).isEmpty())) {
                        if (getStackInSlot(1).getCount() <= getStackInSlot(1).getMaxStackSize() && getStackInSlot(2).getCount() <= getStackInSlot(2).getMaxStackSize()) {
                            progress = 200;
                            maxProgress = 200;
                            decrStackSize(0, 1);
                            markDirty();
                        }

                    }
                }
            } else {
                if (this.energy > 2) {
                    progress--;
                    this.energy-=2;
                }

                if (progress <= 0) {
                    progress = 0;
                    if (maxProgress > 0) {
                        maxProgress = 0;
                        setInventorySlotContents(1, Materials.Iron.getDust(2 + getStackInSlot(1).getCount()));
                        setInventorySlotContents(2, Materials.Gold.getTinyDust(1 + getStackInSlot(2).getCount()));
                    }
                }
            }

        }

    }

    public void updateGenerators() { //find generators for power extraction
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add(this.pos.up());
        positions.add(this.pos.down());
        positions.add(this.pos.east());
        positions.add(this.pos.south());
        positions.add(this.pos.west());
        positions.add(this.pos.north());

        for (BlockPos pos: positions) {
            TileEntity te = this.world.getTileEntity(pos);
            if (te != null) {
                if (te instanceof TileEntityGenerator) {
                    this.generator = (TileEntityGenerator)te;
                    break;
                }
            }
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        updateGenerators();
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.energy = value;
                break;
            case 1:
                this.progress = value;
                break;
            case 2:
                this.maxProgress = value;
                break;
        }
    }

    public int getField(int id) {
        switch (id)
        {
            case 0:
                return this.energy;
            case 1:
                return this.progress;
            case 2:
                return this.maxProgress;
        }
        return 0;
    }

    @Override
    public int getFieldCount() {
        return 3;
    }
}
