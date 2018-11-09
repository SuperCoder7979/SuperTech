package supercoder79.supertech.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.api.worldgen.OreGenerator;
import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.block.blocks.ComputerCube;
import supercoder79.supertech.block.blocks.EFurnace;
import supercoder79.supertech.block.blocks.Generator;
import supercoder79.supertech.block.blocks.Ore;
import supercoder79.supertech.item.items.STCoin;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new ComputerCube());
        event.getRegistry().register(new Generator());
        event.getRegistry().register(new EFurnace());
        for (Ore o: SuperTechBlocks.ores) {
            event.getRegistry().register(o);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.computerCube).setRegistryName(SuperTechBlocks.computerCube.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.generator).setRegistryName(SuperTechBlocks.generator.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.eFurnace).setRegistryName(SuperTechBlocks.eFurnace.getRegistryName()));
        for (Ore o: SuperTechBlocks.ores) {
            event.getRegistry().register(new ItemBlock(o).setRegistryName(o.getRegistryName()));
        }

        event.getRegistry().register(new STCoin());

        for (Material material : Materials.materialRegistry) {
            if (material.dust != null) {
                event.getRegistry().register(material.dust);
                material.dust.setCreativeTab(SuperTech.tabMaterials);
            }
            if (material.dustTiny != null) {
                event.getRegistry().register(material.dustTiny);
                material.dustTiny.setCreativeTab(SuperTech.tabMaterials);
            }
            if (material.ingot != null) {
                event.getRegistry().register(material.ingot);
                material.ingot.setCreativeTab(SuperTech.tabMaterials);
            }
            if (material.gem != null) {
                event.getRegistry().register(material.gem);
                material.gem.setCreativeTab(SuperTech.tabMaterials);
            }
        }
        SuperTech.logger.info("Registered " + Materials.materialRegistry.size() + " Materials");
    }
}
