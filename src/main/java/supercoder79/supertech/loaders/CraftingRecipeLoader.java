package supercoder79.supertech.loaders;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;

public class CraftingRecipeLoader {
    public static void run() {
        GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":generator_recipe"), null, new ItemStack(SuperTechBlocks.generator, 1), "IRI", "IFI", "IRI",
                'I', new ItemStack(Items.IRON_INGOT),
                'R', new ItemStack(Items.REDSTONE),
                'F', new ItemStack(Blocks.FURNACE));
        GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":macerator_recipe"), null, new ItemStack(SuperTechBlocks.macerator, 1), "DID", "IGI", "RDR",
                'I', new ItemStack(Items.IRON_INGOT),
                'R', new ItemStack(Items.REDSTONE),
                'D', new ItemStack(Items.DIAMOND),
                'G', new ItemStack(SuperTechBlocks.generator));


        for(Material material : Materials.materialRegistry) {
            switch (material.getFlags()) {
                case 1:
                    GameRegistry.addShapelessRecipe(new ResourceLocation(SuperTech.MODID + ":dust_to_tiny_"+ material.getName()), null, material.getTinyDust(4), Ingredient.fromStacks(material.getDust(1)));
                    GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":tiny_to_dust_"+ material.getName()), null, material.getDust(1), "XX", "XX",
                            'X', material.getTinyDust(1));
                    break;
                case 2:
                    break;
                case 3:
                    GameRegistry.addShapelessRecipe(new ResourceLocation(SuperTech.MODID + ":dust_to_tiny_"+ material.getName()), null, material.getTinyDust(4), Ingredient.fromStacks(material.getDust(1)));
                    GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":tiny_to_dust_"+ material.getName()), null, material.getDust(1), "XX", "XX",
                            'X', material.getTinyDust(1));
                    break;
                case 5:
                    GameRegistry.addShapelessRecipe(new ResourceLocation(SuperTech.MODID + ":dust_to_tiny_"+ material.getName()), null, material.getTinyDust(4), Ingredient.fromStacks(material.getDust(1)));
                    GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":tiny_to_dust_"+ material.getName()), null, material.getDust(1), "XX", "XX",
                            'X', material.getTinyDust(1));
                    break;
            }
        }
    }

}
