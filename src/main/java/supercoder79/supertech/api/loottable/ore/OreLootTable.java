package supercoder79.supertech.api.loottable.ore;

import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;

public class OreLootTable {
    public static OreLootTableEntry leadTable = new OreLootTableEntry(SuperTechBlocks.leadOre, Materials.Lead, 1, 2, OreLootTableEntry.GENERATE_SECONDARY);
    public static OreLootTableEntry bauxiteTable = new OreLootTableEntry(SuperTechBlocks.bauxiteOre, Materials.Bauxite, 1, 3, OreLootTableEntry.GENERATE_SECONDARY);
    public static OreLootTableEntry copperTable = new OreLootTableEntry(SuperTechBlocks.copperOre, Materials.Tetrahedrite, 1, 2, OreLootTableEntry.GENERATE_SECONDARY);
    //TODO: make materials for these
    public static OreLootTableEntry rubyTable = new OreLootTableEntry(SuperTechBlocks.rubyOre, Materials.Ruby, 1, 2, OreLootTableEntry.GENERATE_PRIMARY);
    public static OreLootTableEntry sapphireTable = new OreLootTableEntry(SuperTechBlocks.sapphireOre, Materials.Sapphire, 1, 2, OreLootTableEntry.GENERATE_PRIMARY);



}
