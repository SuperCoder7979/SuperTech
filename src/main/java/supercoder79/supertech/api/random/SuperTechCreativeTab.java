package supercoder79.supertech.api.random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SuperTechCreativeTab extends CreativeTabs {
    public Item item;
    public SuperTechCreativeTab(String label, Item item) {
        super(label);
        this.item = item;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        return new ItemStack(item);
    }
}