package supercoder79.supertech.loaders;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.api.recipe.RecipeList;

public class ModRecipeLoader {
    public static void run() {
        RecipeList.addMaceratorRecipe(Item.getItemFromBlock(Blocks.IRON_ORE), new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE), 1), new ItemStack(Materials.Iron.dust, 2), new ItemStack(Materials.Gold.dustTiny, 1));
        RecipeList.addMaceratorRecipe(Item.getItemFromBlock(Blocks.GOLD_ORE), new ItemStack(Item.getItemFromBlock(Blocks.GOLD_ORE), 1), new ItemStack(Materials.Gold.dust, 2), new ItemStack(Materials.Iron.dustTiny, 1));
    }
}
