package supercoder79.supertech112.block.blocks;

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
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import supercoder79.supertech112.api.blocks.BasicBlock;
import supercoder79.supertech112.api.loottable.ore.OreLootTableEntry;
import supercoder79.supertech112.block.SuperTechBlocks;

import java.util.Random;

public class Ore extends BasicBlock {
    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 4);
    public OreLootTableEntry lootTable;

    String name;
    public Ore(String name, OreLootTableEntry entry) {
        super(Material.ROCK, name);
        setHardness(3.0F);
        setResistance(5.0F);
        this.name = name;
        setHarvestLevel("pickaxe", 2);
        setSoundType(SoundType.STONE);
        lootTable = entry;
        SuperTechBlocks.ores.add(this);

    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation("supertech112:" + name, "inventory"));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, (meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        state.withProperty(TYPE, 4);
    }

    @Deprecated
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState();
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        int type = state.getValue(TYPE);
        int offset = 0;

        if (this.lootTable.gentype == OreLootTableEntry.GENERATE_SECONDARY) {
            switch (type) {
                case 1:
                    offset = -1;
                    break;
                case 2:
                case 3:
                    offset = 1;
                    break;
                case 4:
                    offset = 2;
                    break;
            }
            drops.add(new ItemStack(Item.getItemFromBlock(this),1));
            int amt = rand.nextInt(this.lootTable.maximum+offset) + this.lootTable.minimum+offset;
            if (!(type == 0)) drops.add(this.lootTable.secondaryDrop.getTinyDust(amt));
        } else {
            switch (type) {
                case 1:
                    break;
                case 2:
                case 3:
                    offset = 1;
                    break;
                case 4:
                    offset = 2;
                    break;
            }

            int amt = rand.nextInt(this.lootTable.maximum+offset) + this.lootTable.minimum+offset;
            drops.add(this.lootTable.secondaryDrop.getGem(amt));
        }
    }

    //TODO: add state based exp drops
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return 0;
    }
}
