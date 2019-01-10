package supercoder79.supertech.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
import supercoder79.supertech.block.blocks.*;
import supercoder79.supertech.block.blocks.basicmachines.EFurnace;
import supercoder79.supertech.block.blocks.basicmachines.Electrolyzer;
import supercoder79.supertech.block.blocks.basicmachines.Generator;
import supercoder79.supertech.block.blocks.basicmachines.Macerator;
import supercoder79.supertech.gui.electrolyzer.TileEntityElectrolyzer;
import supercoder79.supertech.gui.generator.TileEntityGenerator;
import supercoder79.supertech.gui.macerator.TileEntityMacerator;
import supercoder79.supertech.item.items.DebugScissors;
import supercoder79.supertech.item.items.STCoin;
import supercoder79.supertech.loaders.CraftingRecipeLoader;
import supercoder79.supertech.loaders.ModRecipeLoader;
import supercoder79.supertech.loaders.OreDictLoader;
import supercoder79.supertech.loaders.SmeltingRecipeLoader;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
        GameRegistry.registerTileEntity(TileEntityGenerator.class, new ModelResourceLocation(SuperTech.MODID + ":tegenerator"));
        GameRegistry.registerTileEntity(TileEntityMacerator.class, new ModelResourceLocation(SuperTech.MODID + ":temacerator"));
        GameRegistry.registerTileEntity(TileEntityElectrolyzer.class, new ModelResourceLocation(SuperTech.MODID + ":teelectrolyzer"));
        OreDictLoader.run();
        CraftingRecipeLoader.run();
        SmeltingRecipeLoader.run();
        ModRecipeLoader.run();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new ComputerCube());
        event.getRegistry().register(new Generator());
        event.getRegistry().register(new EFurnace());
        event.getRegistry().register(new Macerator());
        event.getRegistry().register(new Electrolyzer());
        for (Ore o: SuperTechBlocks.ores) {
            event.getRegistry().register(o);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.computerCube).setRegistryName(SuperTechBlocks.computerCube.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.generator).setRegistryName(SuperTechBlocks.generator.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.eFurnace).setRegistryName(SuperTechBlocks.eFurnace.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.macerator).setRegistryName(SuperTechBlocks.macerator.getRegistryName()));
        event.getRegistry().register(new ItemBlock(SuperTechBlocks.electrolyzer).setRegistryName(SuperTechBlocks.electrolyzer.getRegistryName()));
        for (Ore o: SuperTechBlocks.ores) {
            event.getRegistry().register(new ItemBlock(o).setRegistryName(o.getRegistryName()));
        }

        event.getRegistry().register(new STCoin());
        event.getRegistry().register(new DebugScissors());

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
