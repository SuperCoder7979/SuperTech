package supercoder79.supertech.loaders;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.api.recipe.RecipeList;

public class ModRecipeLoader {
    public static void run() {
        RecipeList.addMaceratorRecipe(16, 200, Item.getItemFromBlock(Blocks.IRON_ORE), new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE), 1), new ItemStack(Materials.Iron.dust, 2), new ItemStack(Materials.Gold.dustTiny, 1));
        RecipeList.addMaceratorRecipe(16, 200, Item.getItemFromBlock(Blocks.GOLD_ORE), new ItemStack(Item.getItemFromBlock(Blocks.GOLD_ORE), 1), new ItemStack(Materials.Gold.dust, 2), new ItemStack(Materials.Iron.dustTiny, 1));
        RecipeList.addElectrolyzerRecipe(30, 80, Materials.Tetrahedrite.dust, Materials.Tetrahedrite.getDust(4), Materials.Copper.getDust(1), Materials.Iron.getDust(1), ItemStack.EMPTY, ItemStack.EMPTY);
        for(Material material : Materials.materialRegistry) {
            switch (material.getFlags()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    RecipeList.addMaceratorRecipe(8, 80, material.ingot, material.getIngot(1),  material.getDust(1), ItemStack.EMPTY);
                    break;
                case 5:
                    RecipeList.addMaceratorRecipe(8, 80, material.gem, material.getGem(1),  material.getDust(1), ItemStack.EMPTY);
                    break;
            }
        }
    }
}
