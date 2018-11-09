package supercoder79.supertech.api.material;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import supercoder79.supertech.api.random.ItsNotMyFaultException;

public class Material {
    String name;
    /**
     * Flags:
     * 0 - Do nothing
     * 1 - Generate dust and tiny dust
     * 2 - Generate tiny dust
     * 3 - Generate dust, tiny dust, and ingot (Metals)
     * 4 - Generate dust, tiny dust, ingot, and hot ingot (High tier Metals)
     *
     * 5 - Generate dust, gem (Gems obviously)
     * 6 - Generate Plasma
     *
     * */

    int flags = 0;

    public MaterialItem ingot = null;
    public MaterialItem dust = null;
    public MaterialItem dustTiny = null;
    public MaterialItem gem = null;

    public Material(String name, int flags) {
        this.name = name;
        this.flags = flags;
        Materials.materialRegistry.add(this);
        switch ( this.flags) {
            case 0:
                break;
            case 1:
                dust = new MaterialItem("dust_"+this.name);
                dustTiny = new MaterialItem("dust_tiny_"+this.name);
                break;
            case 2:
                dustTiny = new MaterialItem("dust_tiny_"+this.name);
                break;
            case 3:
                dust = new MaterialItem("dust_"+this.name);
                dustTiny = new MaterialItem("dust_tiny_"+this.name);
                ingot = new MaterialItem("ingot_"+this.name);
                break;
            case 5:
                dust = new MaterialItem("dust_"+this.name);
                dustTiny = new MaterialItem("dust_tiny_"+this.name);
                gem = new MaterialItem("gem_"+this.name);
        }
    }

    @Override
    public String toString() {
        return " NAME: " + this.name + " GENERATION FLAGS: " + this.flags;
    }


    //TODO: add null checks instead of this shit
    public ItemStack getDust(int amt) {
        if (flags != 1 && flags != 3) {
            throw new ItsNotMyFaultException("Attempted to get dust itemstack from Material " +this.name + " but it does not have flags to create a dust!");
        }
        return new ItemStack(dust, amt);
    }
    public ItemStack getTinyDust(int amt) {
        if (flags == 0) {
                throw new ItsNotMyFaultException("Attempted to get tiny dust itemstack from Material " +this.name + " but it does not have flags to create a tiny dust!");
        }
        return new ItemStack(dustTiny, amt);
    }
    public ItemStack getIngot(int amt) {
        if (flags >= 3 && flags <= 4) {
            throw new ItsNotMyFaultException("Attempted to get ingot itemstack from Material " +this.name + " but it does not have flags to create a ingot!");
        }
        return new ItemStack(ingot, amt);
    }
    public ItemStack getGem(int amt) {
        if (flags != 5) {
            throw new ItsNotMyFaultException("Attempted to get gem itemstack from Material " +this.name + " but it does not have flags to create a gem!");
        }
        return new ItemStack(gem, amt);
    }
    public String getName() {
        return name;
    }
    public int getFlags() {
        return flags;
    }
}
