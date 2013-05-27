package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;

public class OrangeTreeLeaves extends BlockLeavesBase implements IShearable {

    public int baseIndexInPNG;

    public OrangeTreeLeaves(int par1, int par2) {
        super(par1, par2, Material.leaves, false);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setStepSound(Block.soundGrassFootstep);
        this.setBlockName("block_Orange_Tree_Leaves");
        this.setTickRandomly(true);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        this.baseIndexInPNG = par2;
    }

    public String getTextureFile() {
        return CommonProxy.items;
    }

    public int idDropped(int par1, Random rand, int par3) {
        return ModBlocks.blockOrangeTreeSapling.blockID;
    }

    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> retVal = new ArrayList<ItemStack>();
        retVal.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return retVal;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isLeaves(World world, int x, int y, int z) {
        return true;
    }
}
