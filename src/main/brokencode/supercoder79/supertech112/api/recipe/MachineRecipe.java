package supercoder79.supertech112.api.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class MachineRecipe {
    public NonNullList<ItemStack> stacks;
    public int energy;
    public int ticks;
    public MachineRecipe(int energy, int ticks, NonNullList<ItemStack> stacks) {
        this.energy = energy;
        this.ticks = ticks;
        this.stacks = stacks;
    }
}
