package supercoder79.supertech.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.api.blocks.BlockRotatable;

import javax.annotation.Nullable;
import java.util.List;

public class Generator extends BlockRotatable {

    public Generator() {
        super(Material.ROCK, "generator");
        setHardness(30);
        setResistance(5f);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Stick some coal in and get some power out! Somehow....");
    }
}
