package supercoder79.supertech.api.material;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoader;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.items.BasicItem;

public class MaterialItem extends BasicItem {
    String name;
    public MaterialItem(String name) {
        super(name);
        this.name = name;
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(64);
    }
    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("supertech:materials/" + name, "inventory"));
    }
//    @Override
//    public static void initModelStatic() {
//        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("materials/" + getRegistryName(), "inventory"));
//    }
}
