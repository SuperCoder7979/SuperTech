package supercoder79.supertech112.api.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.HashMap;
import java.util.Map;

public class RecipeList {

    public static Map<Item, MachineRecipe> maceratorRecipes = new HashMap<>();
    public static Map<Item, MachineRecipe> electrolyzerRecipes = new HashMap<>();
    public static void addMaceratorRecipe(int energy, int ticks, Item item, ItemStack input, ItemStack output, ItemStack byproduct) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        stacks.add(input);
        stacks.add(output);
        stacks.add(byproduct);
        maceratorRecipes.put(item, new MachineRecipe(energy, ticks, stacks));
    }
    public static void addElectrolyzerRecipe(int energy, int ticks, Item item, ItemStack input, ItemStack output1, ItemStack output2, ItemStack output3, ItemStack output4) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        stacks.add(input);
        stacks.add(output1);
        stacks.add(output2);
        stacks.add(output3);
        stacks.add(output4);
        electrolyzerRecipes.put(item, new MachineRecipe(energy, ticks, stacks));
    }
}
