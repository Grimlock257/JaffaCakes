package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModItems;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeOrange
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeOrange extends Block {
    private static int blockid;
    public Icon[] icons;

    @SuppressWarnings("static-access")
    public OrangeTreeOrange(int id, String blockName) {
        super(id, Material.circuits);
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        this.setStepSound(Block.soundGrassFootstep);
        this.setUnlocalizedName(blockName);
        this.blockid = id;

    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.icons = new Icon[3];

        for (int metadata = 0; metadata < this.icons.length; ++metadata) {
            this.icons[metadata] = iconRegister.registerIcon(Reference.TEXTURE_FOLDER_NAME + ":" + Strings.ORANGE_TREE_ORANGE_NAME + "_" + metadata);
        }
    }

    @SideOnly(Side.CLIENT)
    /** From the specified side and block metadata retrieves the blocks texture. Args: side, metadata */
    public Icon getIcon(int side, int metadata) {
        return this.icons[metadata % this.icons.length];
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        int var6 = par1World.getBlockMetadata(par2, par3, par4);

        if (var6 < 2) {
            if (par5Random.nextInt(30) == 0) {
                ++var6;
                par1World.setBlock(par2, par3, par4, blockid, var6, 2);
            }
        }
    }

    /** Apply bonemeal to the crops. */
    public void fertilize(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

        if (l > 2) {
            l = 2;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

    }

    public int idDropped(int i, Random random, int j) {

        if (j == 2) {
            return ModItems.itemOrange.itemID;
        }
        if (i == 2) {
            return ModItems.itemOrange.itemID;
        }

        return j;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k) {
        int l = world.getBlockId(i, j + 1, k);
        // 18 = Normal leaves 2503 = OrangeTreeLeaves ... May remove 18 later
        return l == 18 || l == 2503;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
        h(world, i, j, k);
    }

    protected final void h(World world, int i, int j, int k) {
        if (!canBlockStay(world, i, j, k)) {
            // dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 1);
            world.setBlock(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k) {
        return canPlaceBlockAt(world, i, j, k);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }

    public float getBlockHardness(World par1World, int par2, int par3, int par4) {
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        if (meta == 2) {
            return 0.0F;
        } else {
            return 2.0F;
        }
    }

    public void onBlockDestroyedByPlayer(World world, int par2, int par3, int par4, int par5) {
        if (par5 == 2) {
            world.setBlock(par2, par3, par4, blockid, 0, 2);
        }
    }

    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // @SideOnly(Side.CLIENT)
    // public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
    // for (int ix = 0; ix < 3; ix++) {
    // subItems.add(new ItemStack(this, 1, ix));
    // }
    // }

    // Minecraft Default
    // @SuppressWarnings({ "unchecked", "rawtypes" })
    // public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
    // par3List.add(new ItemStack(par1, 1, 0));
    // par3List.add(new ItemStack(par1, 1, 1));
    // par3List.add(new ItemStack(par1, 1, 2));
    //
    // }
}
