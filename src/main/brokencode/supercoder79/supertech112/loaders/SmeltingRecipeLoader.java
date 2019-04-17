package supercoder79.supertech112.loaders;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech112.api.material.Material;
import supercoder79.supertech112.api.material.Materials;
import supercoder79.supertech112.block.SuperTechBlocks;

public class SmeltingRecipeLoader {
    public static void run() {
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.copperOre), Materials.Copper.getIngot(1), 0.7f);
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.leadOre), Materials.Lead.getIngot(1), 0.7f);
        for (Material m : Materials.materialRegistry) {
            if (m.smelting != null) {
                GameRegistry.addSmelting(m.smelting.getElement0(), m.smelting.getElement1(), 0.0f);
            }
        }
    }
}
