package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;
import Grimlock257.JaffaCakes.Mod.Generation.Worldgen.WorldGenOrangeTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeSapling
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeSapling extends BlockFlower {
    public OrangeTreeSapling(int par1, int par2) {
        super(par1, par2);
        this.setTickRandomly(false);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundGrassFootstep);
        this.setBlockName("block_Orange_Tree_Sapling");
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.4F * 2.0F, 0.9F);
    }

    /** Determines the damage on the item the block drops. Used in cloth and wood. */
    public int damageDropped(int i) {
        return i;
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
        super.updateTick(world, i, j, k, random);

        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(30) == 0) {
            int l = world.getBlockMetadata(i, j, k);

            if (random.nextInt(3) == 0) {
                generateTree(world, i, j, k, random, l);
            }
        }
    }

    public void generateTree(World world, int i, int j, int k, Random random, int l) {
        world.setBlock(i, j, k, 0);

        WorldGenOrangeTree worldgenorangetree = new WorldGenOrangeTree(l);

        if (!((WorldGenerator) worldgenorangetree).generate(world, random, i, j, k)) {
            world.setBlock(i, j, k, blockID);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    /** Returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks) */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    public String getTextureFile() {
        return CommonProxy.items;
    }
}
