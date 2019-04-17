package supercoder79.supertech112.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech112.api.blocks.BasicBlock;

import javax.annotation.Nullable;
import java.util.List;

public class ComputerCube extends BasicBlock {
    public ComputerCube() {
        super(Material.ROCK, "computercube");
        setHardness(30);
        setResistance(5f);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("A cube filled with lots of intricate machinery, especially computers.");
    }
}
