package supercoder79.supertech.api.loottable.ore;

import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.block.blocks.Ore;

public class LootTableEntry {
    public static final int GENERATE_SECONDARY = 1;
    public static final int GENERATE_PRIMARY = 2;


    public Ore mainDrop;
    public Material secondaryDrop;
    public int minimum;
    public int maximum;
    public int gentype;

    public LootTableEntry(Ore drop, Material secondary, int minimum, int maximum, int gentype) {
        this.mainDrop = drop;
        this.secondaryDrop = secondary;
        this.minimum = minimum;
        this.maximum = maximum;
        this.gentype = gentype;
    }
}
