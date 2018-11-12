package supercoder79.supertech.loaders;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;

public class SmeltingRecipeLoader {
    public static void run() {
        GameRegistry.addSmelting(Materials.Iron.dust, new ItemStack(Items.IRON_INGOT), 0.1f);
        GameRegistry.addSmelting(Materials.Gold.dust, new ItemStack(Items.GOLD_INGOT), 0.1f);
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.copperOre), Materials.Copper.getIngot(1), 1f);
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.leadOre), Materials.Lead.getIngot(1), 1f);
    }
}
