package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeLeaves
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeLeaves extends BlockLeavesBase implements IShearable {
    int[] adjacentTreeBlocks;

    public OrangeTreeLeaves(int id, String blockName) {
        super(id, Material.leaves, false);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setStepSound(Block.soundGrassFootstep);
        this.setUnlocalizedName(blockName);
        this.setTickRandomly(true);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.TEXTURE_FOLDER_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    public int idDropped(int par1, Random rand, int par3) {
        return ModBlocks.blockOrangeTreeSapling.blockID;
    }

    @SideOnly(Side.CLIENT)
    /** Returns the color this block should be rendered. Used by leaves. */
    public int getRenderColor(int par1) {
        return (par1 & 3) == 1 ? ColorizerFoliage.getFoliageColorPine() : ((par1 & 3) == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic());
    }

    @SideOnly(Side.CLIENT)
    /** Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. 
     * Note only called when first determining what to render. */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if ((var5 & 3) == 1) {
            return ColorizerFoliage.getFoliageColorPine();
        } else if ((var5 & 3) == 2) {
            return ColorizerFoliage.getFoliageColorBirch();
        } else {
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;

            for (int var9 = -1; var9 <= 1; ++var9) {
                for (int var10 = -1; var10 <= 1; ++var10) {
                    int var11 = par1IBlockAccess.getBiomeGenForCoords(par2 + var10, par4 + var9).getBiomeFoliageColor();
                    var6 += (var11 & 16711680) >> 16;
                    var7 += (var11 & 65280) >> 8;
                    var8 += var11 & 255;
                }
            }

            return (var6 / 9 & 255) << 16 | (var7 / 9 & 255) << 8 | var8 / 9 & 255;
        }
    }

    /** Ejects contained items into the world, and notifies neighbours of an update, as appropriate */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        byte var7 = 1;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    for (int var11 = -var7; var11 <= var7; ++var11) {
                        // if (ModBlocks.blockOrangeTreeLeaves != null) {
                        // ModBlocks.blockOrangeTreeLeaves.beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        // }
                    }
                }
            }
        }
    }

    // /** Ticks the block if it's been scheduled */
    // public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
    // if (!par1World.isRemote) {
    // int var6 = par1World.getBlockMetadata(par2, par3, par4);
    //
    // if ((var6 & 8) != 0 && (var6 & 4) == 0) {
    // byte var7 = 4;
    // int var8 = var7 + 1;
    // byte var9 = 32;
    // int var10 = var9 * var9;
    // int var11 = var9 / 2;
    //
    // if (this.adjacentTreeBlocks == null) {
    // this.adjacentTreeBlocks = new int[var9 * var9 * var9];
    // }
    //
    // int var12;
    //
    // if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
    // int var13;
    // int var14;
    // int var15;
    //
    // for (var12 = -var7; var12 <= var7; ++var12) {
    // for (var13 = -var7; var13 <= var7; ++var13) {
    // for (var14 = -var7; var14 <= var7; ++var14) {
    // var15 = par1World.getBlockId(par2 + var12, par3 + var13, par4 + var14);

    // Block block = Block.blocksList[var15];
    // Block block = ModBlocks.blockOrangeTreeLeaves;
    //
    // if (block != null && block.canSustainLeaves(par1World, par2 + var12, par3 + var13, par4 + var14)) {
    // this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
    // } else if (block != null && block.isLeaves(par1World, par2 + var12, par3 + var13, par4 + var14)) {
    // this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
    // } else {
    // this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
    // }
    // }
    // }
    // }
    //
    // for (var12 = 1; var12 <= 4; ++var12) {
    // for (var13 = -var7; var13 <= var7; ++var13) {
    // for (var14 = -var7; var14 <= var7; ++var14) {
    // // for (var15 = -var7; var15 <= var7; ++var15) {
    // if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
    // if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
    // this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
    // }
    //
    // if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
    // this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
    // }

    // if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
    // this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
    // }

    // if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
    // this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
    // }
    // //
    // if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
    // / this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
    // }
    //
    // if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
    // this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
    // }
    // }
    // }
    // }
    // }
    // }
    // }
    //
    // var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];
    //
    // if (var12 >= 0) {
    // par1World.setBlockMetadata(par2, par3, par4, var6 & -9);
    // } else {
    // this.removeLeaves(par1World, par2, par3, par4);
    // }
    // }
    // }
    // }

    @SideOnly(Side.CLIENT)
    /** A randomly called display update to be able to add particles or other items for display */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && par5Random.nextInt(15) == 1) {
            double var6 = (double) ((float) par2 + par5Random.nextFloat());
            double var8 = (double) par3 - 0.05D;
            double var10 = (double) ((float) par4 + par5Random.nextFloat());
            par1World.spawnParticle("dripWater", var6, var8, var10, 0.0D, 0.0D, 0.0D);
        }
    }

    // private void removeLeaves(World par1World, int par2, int par3, int par4) {
    // this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
    // par1World.setBlockWithNotify(par2, par3, par4, 0);
    // }

    /** Returns the quantity of items to drop on block destruction. */
    public int quantityDropped(Random par1Random) {
        return par1Random.nextInt(10) == 0 ? 1 : 0;
    }

    /** Drops the block items with a specified chance of dropping the specified items */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        if (!par1World.isRemote) {
            byte var8 = 20;

            if ((par5 & 3) == 3) {
                var8 = 40;
            }

            if (par1World.rand.nextInt(var8) == 0) {
                int var9 = this.idDropped(par5, par1World.rand, par7);
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(var9, 1, this.damageDropped(par5)));
            }
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return !this.graphicsLevel;
    }

    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }

    // @Override
    // public void beginLeavesDecay(World world, int x, int y, int z) {
    // world.setBlockMetadata(x, y, z, world.getBlockMetadata(x, y, z) | 8);
    // }

    @Override
    public boolean isLeaves(World world, int x, int y, int z) {
        return true;
    }
}
