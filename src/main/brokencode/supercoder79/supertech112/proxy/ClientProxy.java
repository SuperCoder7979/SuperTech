package supercoder79.supertech112.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import supercoder79.supertech112.SuperTech;
import supercoder79.supertech112.api.material.Material;
import supercoder79.supertech112.api.material.Materials;
import supercoder79.supertech112.block.SuperTechBlocks;
import supercoder79.supertech112.item.SuperTechItems;

@Mod.EventBusSubscriber(modid = SuperTech.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLCommonSetupEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        SuperTechBlocks.initModels();
        SuperTechItems.initModels();

        for (Material material : Materials.materialRegistry) {
            if (material.dust != null) {
                material.dust.initModel();
            }
            if (material.dustTiny != null) {
                material.dustTiny.initModel();
            }
            if (material.ingot != null) {
                material.ingot.initModel();
            }
            if (material.gem != null) {
                material.gem.initModel();
            }
        }
    }
}
