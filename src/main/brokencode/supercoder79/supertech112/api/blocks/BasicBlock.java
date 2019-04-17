package supercoder79.supertech112.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supercoder79.supertech112.SuperTech;

public class BasicBlock extends Block {

    public BasicBlock(Material materialIn, String name) {
        super(materialIn);
        setRegistryName(name);
        setUnlocalizedName(SuperTech.MODID + "." + name);
        setCreativeTab(SuperTech.tabMain);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
