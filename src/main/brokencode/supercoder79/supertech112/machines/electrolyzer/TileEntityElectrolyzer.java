package supercoder79.supertech112.machines.electrolyzer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import supercoder79.supertech112.api.enet.IEnergyProvider;
import supercoder79.supertech112.api.machine.tileentity.TileEntityMachine;
import supercoder79.supertech112.api.recipe.MachineRecipe;
import supercoder79.supertech112.api.recipe.RecipeList;

import java.util.ArrayList;

public class TileEntityElectrolyzer extends TileEntityMachine {
    public int progress = 0;
    public int maxProgress = 0;
    public int energyUsed = 0;
    public IEnergyProvider provider = null;
    public NonNullList<ItemStack> recipeStacks = NonNullList.withSize(5, ItemStack.EMPTY);

    public TileEntityElectrolyzer() {
        super(5, "electrolyzer", 4000);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setInteger("progress", progress);
        compound.setInteger("energyUsed", energyUsed);
        compound.setInteger("maxProgress", maxProgress);
        saveAllItems(compound, recipeStacks, true);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        progress = compound.getInteger("progress");
        maxProgress = compound.getInteger("maxProgress");
        energyUsed = compound.getInteger("energyUsed");
        loadAllItems(compound, recipeStacks);

    }

    @Override
    public void update() {
        super.update();
        if (!this.world.isRemote) {
            if (this.provider != null) {
                if (this.maxEnergy >= this.energy+32) {
                    this.energy += provider.extractEnergy(32);
                }
            }
            if (progress <= 0) {
                Item item = getStackInSlot(0).getItem();
                if (RecipeList.electrolyzerRecipes.containsKey(item)) {
                    MachineRecipe recipe = RecipeList.electrolyzerRecipes.get(item);
                    NonNullList<ItemStack> stacks = recipe.stacks;
                    energyUsed = recipe.energy;
                    recipeStacks = stacks;
                    if (getStackInSlot(0).getCount() >= recipeStacks.get(0).getCount()) {
                        //oof
                        if ((getStackInSlot(1).getItem() == recipeStacks.get(1).getItem() && getStackInSlot(2).getItem() == recipeStacks.get(2).getItem() && getStackInSlot(3).getItem() == recipeStacks.get(3).getItem() && getStackInSlot(4).getItem() == recipeStacks.get(4).getItem()) || (getStackInSlot(1).isEmpty() && getStackInSlot(2).isEmpty() && getStackInSlot(3).isEmpty() && getStackInSlot(4).isEmpty())) {
                            if (getStackInSlot(1).getCount() + recipeStacks.get(1).getCount() <= getStackInSlot(1).getMaxStackSize() && getStackInSlot(2).getCount() + recipeStacks.get(2).getCount() <= getStackInSlot(2).getMaxStackSize() && getStackInSlot(3).getCount() + recipeStacks.get(3).getCount() <= getStackInSlot(3).getMaxStackSize()&& getStackInSlot(4).getCount() + recipeStacks.get(4).getCount() <= getStackInSlot(4).getMaxStackSize()) {
                                progress = recipe.ticks;
                                maxProgress = recipe.ticks;
                                decrStackSize(0, recipeStacks.get(0).getCount());
                                markDirty();
                            }
                        }
                    }
                }
            } else {
                if (this.energy >= energyUsed) {
                    progress--;
                    this.energy-=energyUsed;
                }

                if (progress <= 0) {
                    progress = 0;
                    if (maxProgress > 0) {
                        maxProgress = 0;
                        energyUsed = 0;
                        if (!(recipeStacks == null)) {
                            setInventorySlotContents(1, new ItemStack(recipeStacks.get(1).getItem(), recipeStacks.get(1).getCount() + getStackInSlot(1).getCount()));
                            setInventorySlotContents(2, new ItemStack(recipeStacks.get(2).getItem(), recipeStacks.get(2).getCount() + getStackInSlot(2).getCount()));
                            setInventorySlotContents(3, new ItemStack(recipeStacks.get(3).getItem(), recipeStacks.get(3).getCount() + getStackInSlot(3).getCount()));
                            setInventorySlotContents(4, new ItemStack(recipeStacks.get(4).getItem(), recipeStacks.get(4).getCount() + getStackInSlot(4).getCount()));
                            recipeStacks = NonNullList.withSize(5, ItemStack.EMPTY);
                        }
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
                if (te instanceof IEnergyProvider) {
                    this.provider = (IEnergyProvider)te;
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


    public NBTTagCompound saveAllItems(NBTTagCompound tag, NonNullList<ItemStack> list, boolean saveEmpty)
    {
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < list.size(); ++i)
        {
            ItemStack itemstack = list.get(i);

            if (!itemstack.isEmpty())
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("SlotRecipe", (byte)i);
                itemstack.writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        if (!nbttaglist.hasNoTags() || saveEmpty)
        {
            tag.setTag("ItemsRecipe", nbttaglist);
        }

        return tag;
    }

    public void loadAllItems(NBTTagCompound tag, NonNullList<ItemStack> list)
    {
        NBTTagList nbttaglist = tag.getTagList("ItemsRecipe", 10);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("SlotRecipe") & 255;

            if (j >= 0 && j < list.size())
            {
                list.set(j, new ItemStack(nbttagcompound));
            }
        }
    }
}
