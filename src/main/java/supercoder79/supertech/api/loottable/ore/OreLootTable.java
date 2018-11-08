package supercoder79.supertech.api.loottable.ore;

import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.block.SuperTechBlocks;

public class OreLootTable {
    public static LootTableEntry leadTable = new LootTableEntry(SuperTechBlocks.leadOre, Materials.Lead, 1, 2, LootTableEntry.GENERATE_SECONDARY);
}
