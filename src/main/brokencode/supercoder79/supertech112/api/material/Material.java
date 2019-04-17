package supercoder79.supertech112.api.material;

import net.minecraft.item.ItemStack;
import supercoder79.supertech112.api.random.ItsNotMyFaultException;
import supercoder79.supertech112.api.random.Pair;

public class Material {
    public String name;
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

    public int flags;
    public String formula;

    public Pair<ItemStack, ItemStack> smelting;

    public MaterialItem ingot = null;
    public MaterialItem dust = null;
    public MaterialItem dustTiny = null;
    public MaterialItem gem = null;

    public Material(String name, int flags, String tooltip) {
        this.name = name;
        this.flags = flags;
        this.formula = tooltip;
        Materials.materialRegistry.add(this);
        switch ( this.flags) {
            case 0:
                break;
            case 1:
                dust = new MaterialItem("dust_" + this.name, tooltip);
                dustTiny = new MaterialItem("dust_tiny_" + this.name, tooltip);
                break;
            case 2:
                dustTiny = new MaterialItem("dust_tiny_" + this.name, tooltip);
                break;
            case 3:
                dust = new MaterialItem("dust_" + this.name, tooltip);
                dustTiny = new MaterialItem("dust_tiny_" + this.name, tooltip);
                ingot = new MaterialItem("ingot_" + this.name, tooltip);
                break;
            case 5:
                dust = new MaterialItem("dust_" + this.name, tooltip);
                dustTiny = new MaterialItem("dust_tiny_" + this.name, tooltip);
                gem = new MaterialItem("gem_" + this.name, tooltip);
        }
    }

    public void setSmelting(ItemStack stackIn, ItemStack stackOut) {
        smelting = new Pair<>(stackIn, stackOut);
    }
    public Pair<ItemStack, ItemStack> getSmelting() {
        return smelting;
    }

    @Override
    public String toString() {
        return " NAME: " + this.name + " GENERATION FLAGS: " + this.flags;
    }

    public ItemStack getDust(int amt) {
        if (dust == null) {
            throw new ItsNotMyFaultException("Attempted to get dust itemstack from Material " + this.name + " but it does not have flags to create a dust!");
        }
        return new ItemStack(dust, amt);
    }
    public ItemStack getTinyDust(int amt) {
        if (dustTiny == null) {
                throw new ItsNotMyFaultException("Attempted to get tiny dust itemstack from Material " + this.name + " but it does not have flags to create a tiny dust!");
        }
        return new ItemStack(dustTiny, amt);
    }
    public ItemStack getIngot(int amt) {
        if (ingot == null) {
            throw new ItsNotMyFaultException("Attempted to get ingot itemstack from Material " + this.name + " but it does not have flags to create a ingot!");
        }
        return new ItemStack(ingot, amt);
    }
    public ItemStack getGem(int amt) {
        if (gem == null) {
            throw new ItsNotMyFaultException("Attempted to get gem itemstack from Material " + this.name + " but it does not have flags to create a gem!");
        }
        return new ItemStack(gem, amt);
    }
    public String getName() {
        return name;
    }
    public int getFlags() {
        return flags;
    }
    public String getFormula() {
        return formula;
    }

}
