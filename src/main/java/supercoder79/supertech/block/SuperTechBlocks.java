package supercoder79.supertech.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.block.blocks.ComputerCube;
import supercoder79.supertech.block.blocks.EFurnace;
import supercoder79.supertech.block.blocks.Generator;
import supercoder79.supertech.block.blocks.Ore;

import java.util.ArrayList;

public class SuperTechBlocks {

    public static ArrayList<Ore> ores = new ArrayList<>();

    @GameRegistry.ObjectHolder("supertech:computercube")
    public static ComputerCube computerCube = new ComputerCube();

    @GameRegistry.ObjectHolder("supertech:generator")
    public static Generator generator = new Generator();

    @GameRegistry.ObjectHolder("supertech:e_furnace")
    public static EFurnace eFurnace = new EFurnace();

//    @GameRegistry.ObjectHolder("supertech:ore")
//    public static Ore ore = new Ore();

    @GameRegistry.ObjectHolder("supertech:ore_lead")
    public static Ore leadOre = new Ore("ore_lead");

    public static void initModels() {
        computerCube.initModel();
        generator.initModel();
        eFurnace.initModel();
//        ore.initModel();
        for (Ore o: ores) {
            o.initModel();
        }
    }
}
