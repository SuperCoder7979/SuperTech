package supercoder79.supertech112.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech112.api.loottable.ore.OreLootTable;
import supercoder79.supertech112.block.blocks.*;
import supercoder79.supertech112.block.blocks.basicmachines.EFurnace;
import supercoder79.supertech112.block.blocks.basicmachines.Electrolyzer;
import supercoder79.supertech112.block.blocks.basicmachines.Generator;
import supercoder79.supertech112.block.blocks.basicmachines.Macerator;

import java.util.ArrayList;

public class SuperTechBlocks {

    public static ArrayList<Ore> ores = new ArrayList<>();

    @GameRegistry.ObjectHolder("supertech112:computercube")
    public static ComputerCube computerCube = new ComputerCube();

    @GameRegistry.ObjectHolder("supertech112:generator")
    public static Generator generator = new Generator();

    @GameRegistry.ObjectHolder("supertech112:e_furnace")
    public static EFurnace eFurnace = new EFurnace();

    @GameRegistry.ObjectHolder("supertech112:macerator")
    public static Macerator macerator = new Macerator();

    @GameRegistry.ObjectHolder("supertech112:electrolyzer")
    public static Electrolyzer electrolyzer = new Electrolyzer();

    @GameRegistry.ObjectHolder("supertech112:wire")
    public static Wire wire = new Wire();

    @GameRegistry.ObjectHolder("supertech112:ore_lead")
    public static Ore leadOre = new Ore("ore_lead", OreLootTable.leadTable);

    @GameRegistry.ObjectHolder("supertech112:ore_ruby")
    public static Ore rubyOre = new Ore("ore_ruby", OreLootTable.rubyTable);

    @GameRegistry.ObjectHolder("supertech112:ore_sapphire")
    public static Ore sapphireOre = new Ore("ore_sapphire", OreLootTable.sapphireTable);

    @GameRegistry.ObjectHolder("supertech112:ore_bauxite")
    public static Ore bauxiteOre = new Ore("ore_bauxite", OreLootTable.bauxiteTable);

    @GameRegistry.ObjectHolder("supertech112:ore_copper")
    public static Ore copperOre = new Ore("ore_copper", OreLootTable.copperTable);


    public static void initModels() {
        computerCube.initModel();
        generator.initModel();
        eFurnace.initModel();
        macerator.initModel();
        electrolyzer.initModel();
        wire.initModel();
        for (Ore o: ores) {
            o.initModel();
        }
    }
}
