package supercoder79.supertech.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.item.SuperTechItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
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
