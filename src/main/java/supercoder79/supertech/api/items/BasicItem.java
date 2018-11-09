package supercoder79.supertech.api.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech.SuperTech;

public class BasicItem extends Item {
    public BasicItem(String name) {
        super();
        setRegistryName(name);
        setUnlocalizedName(SuperTech.MODID + "." + name);
        setCreativeTab(SuperTech.tabMain);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
