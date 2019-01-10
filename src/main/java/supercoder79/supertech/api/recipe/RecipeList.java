package supercoder79.supertech.api.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeList {

    public static Map<Item, NonNullList<ItemStack>> maceratorRecipes = new HashMap<>();
    public static Map<Item, NonNullList<ItemStack>> electrolyzerRecipes = new HashMap<>();
    public static void addMaceratorRecipe(Item item, ItemStack input, ItemStack output, ItemStack byproduct) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        stacks.add(input);
        stacks.add(output);
        stacks.add(byproduct);
        maceratorRecipes.put(item, stacks);
    }
}
