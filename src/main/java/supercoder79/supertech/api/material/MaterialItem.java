package supercoder79.supertech.api.material;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.items.BasicItem;

import javax.annotation.Nullable;
import java.util.List;

public class MaterialItem extends Item {
    String name;
    String formula;
    public MaterialItem(String name, String tooltip) {
        super();
        setRegistryName(name);
        setUnlocalizedName(SuperTech.MODID + "." + name);
        this.name = name;
        this.formula = tooltip;
        setCreativeTab(SuperTech.tabMaterials);
        setMaxStackSize(64);
    }
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("supertech:materials/" + name, "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!formula.isEmpty()) {
            tooltip.add(formula);
        }
    }

}
