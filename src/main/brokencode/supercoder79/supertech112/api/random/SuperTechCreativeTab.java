package supercoder79.supertech112.api.random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SuperTechCreativeTab extends ItemGroup {
    public Item item;
    public SuperTechCreativeTab(String label, Item item) {
        super(label);
        this.item = item;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(item);
    }
}