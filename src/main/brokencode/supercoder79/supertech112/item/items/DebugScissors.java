package supercoder79.supertech112.item.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech112.api.items.BasicItem;

import javax.annotation.Nullable;
import java.util.List;

public class DebugScissors extends BasicItem {
    public DebugScissors() {
        super("debug_scissors");
        setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Click any machine to get it's information. Not for use by children!");
    }
}
