package supercoder79.supertech.block.blocks.basicmachines;

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

public class EFurnace extends BlockRotatable {

    public EFurnace() {
        super(Material.ROCK, "e_furnace");
        setHardness(5);
        setResistance(5f);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Normal furnaces are for peasants!");
    }
}
