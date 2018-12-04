package supercoder79.supertech.loaders;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;

public class SmeltingRecipeLoader {
    public static void run() {
        GameRegistry.addSmelting(Materials.Iron.dust, new ItemStack(Items.IRON_INGOT), 0.01f);
        GameRegistry.addSmelting(Materials.Gold.dust, new ItemStack(Items.GOLD_INGOT), 0.01f);
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.copperOre), Materials.Copper.getIngot(1), 0.7f);
        GameRegistry.addSmelting(new ItemStack(SuperTechBlocks.leadOre), Materials.Lead.getIngot(1), 0.7f);
        for (Material m : Materials.materialRegistry) {
            if (m.smelting != null) {
                GameRegistry.addSmelting(m.smelting.getKey(), m.smelting.getValue(), 0.01f);
            }
        }
    }
}
