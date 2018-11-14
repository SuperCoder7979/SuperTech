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
        for(Material material : Materials.materialRegistry) {
            switch (material.getFlags()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    RecipeList.addMaceratorRecipe(material.ingot, material.getIngot(1),  material.getDust(1), ItemStack.EMPTY);
                    System.out.println(material);
                    break;
                case 5:
                    RecipeList.addMaceratorRecipe(material.gem, material.getGem(1),  material.getDust(1), ItemStack.EMPTY);
                    break;
            }
        }
    }
}
