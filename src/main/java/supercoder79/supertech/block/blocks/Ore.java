package supercoder79.supertech.block.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import supercoder79.supertech.api.blocks.BasicBlock;
import supercoder79.supertech.block.SuperTechBlocks;

public class Ore extends BasicBlock {
    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 4);

    String name;
    public Ore(String name) {
        super(Material.ROCK, name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(10);
        setResistance(5f);
        this.name = name;
        setSoundType(SoundType.STONE);
        SuperTechBlocks.ores.add(this);
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation("supertech:" + name, "inventory"));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
//        System.out.println(meta);
        return this.getDefaultState().withProperty(TYPE, (int)(Math.floor(Math.random()*4)+1));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE);
    }
    @Override
    protected BlockStateContainer createBlockState() {
//        TYPE.
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        state.withProperty(TYPE, 4);
    }
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState();
    }
}
