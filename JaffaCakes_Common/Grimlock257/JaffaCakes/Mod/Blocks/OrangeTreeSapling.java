package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Generation.Worldgen.WorldGenOrangeTree;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
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
    public OrangeTreeSapling(int id, String blockName) {
        super(id);
        // this.setTickRandomly(false);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundGrassFootstep);
        this.setUnlocalizedName(blockName);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.4F * 2.0F, 0.9F);
    }

    /** Determines the damage on the item the block drops. Used in cloth and wood. */
    public int damageDropped(int i) {
        return i;
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
        super.updateTick(world, i, j, k, random);

        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0) {
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

    @Override
    @SideOnly(Side.CLIENT)
    /** From the specified side and block metadata retrieves the blocks texture. Args: side, metadata */
    public Icon getIcon(int side, int metadata) {
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + Strings.ORANGE_TREE_SAPLING_NAME);
    }
}
