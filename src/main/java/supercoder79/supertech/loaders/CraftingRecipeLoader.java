package supercoder79.supertech.loaders;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.block.SuperTechBlocks;

public class CraftingRecipeLoader {
    public static void run() {
        GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":generator_recipe"), null, new ItemStack(SuperTechBlocks.generator, 1), new Object[]{
                "IRI", "IFI", "IRI",
                'I', new ItemStack(Items.IRON_INGOT),
                'R', new ItemStack(Items.REDSTONE),
                'F', new ItemStack(Blocks.FURNACE)});
        GameRegistry.addShapedRecipe(new ResourceLocation(SuperTech.MODID + ":macerator_recipe"), null, new ItemStack(SuperTechBlocks.macerator, 1), new Object[]{
                "DID", "IGI", "RDR",
                'I', new ItemStack(Items.IRON_INGOT),
                'R', new ItemStack(Items.REDSTONE),
                'D', new ItemStack(Items.DIAMOND),
                'G', new ItemStack(SuperTechBlocks.generator)});
    }
}
