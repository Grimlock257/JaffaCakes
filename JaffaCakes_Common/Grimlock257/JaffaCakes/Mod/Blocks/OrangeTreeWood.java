package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeWood
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeWood extends Block {
    int texture;

    public OrangeTreeWood(int id, int texture2, Material material) {
        super(id, texture2, material);
        this.setHardness(2.0F);
        this.setBlockName("block_Orange_Tree_Wood");
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        texture = texture2;
    }

    /** From the specified side and block metadata retrieves the blocks texture. Args: side, metadata */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return texture;
    }

    /** Determines the damage on the item the block drops. Used in cloth and wood. */
    public int damageDropped(int par1) {
        return par1;
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
