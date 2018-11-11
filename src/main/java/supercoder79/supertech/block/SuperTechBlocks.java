package supercoder79.supertech.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.api.loottable.ore.OreLootTable;
import supercoder79.supertech.block.blocks.*;

import java.util.ArrayList;

public class SuperTechBlocks {

    public static ArrayList<Ore> ores = new ArrayList<>();

    @GameRegistry.ObjectHolder("supertech:computercube")
    public static ComputerCube computerCube = new ComputerCube();

    @GameRegistry.ObjectHolder("supertech:generator")
    public static Generator generator = new Generator();

    @GameRegistry.ObjectHolder("supertech:e_furnace")
    public static EFurnace eFurnace = new EFurnace();

    @GameRegistry.ObjectHolder("supertech:macerator")
    public static Macerator macerator = new Macerator();

    @GameRegistry.ObjectHolder("supertech:ore_lead")
    public static Ore leadOre = new Ore("ore_lead", OreLootTable.leadTable);

    @GameRegistry.ObjectHolder("supertech:ore_ruby")
    public static Ore rubyOre = new Ore("ore_ruby", OreLootTable.rubyTable);

    @GameRegistry.ObjectHolder("supertech:ore_sapphire")
    public static Ore sapphireOre = new Ore("ore_sapphire", OreLootTable.sapphireTable);

    @GameRegistry.ObjectHolder("supertech:ore_bauxite")
    public static Ore bauxiteOre = new Ore("ore_bauxite", OreLootTable.bauxiteTable);

    @GameRegistry.ObjectHolder("supertech:ore_copper")
    public static Ore copperOre = new Ore("ore_copper", OreLootTable.copperTable);


    public static void initModels() {
        computerCube.initModel();
        generator.initModel();
        eFurnace.initModel();
        macerator.initModel();
//        ore.initModel();
        for (Ore o: ores) {
            o.initModel();
        }
    }
}
