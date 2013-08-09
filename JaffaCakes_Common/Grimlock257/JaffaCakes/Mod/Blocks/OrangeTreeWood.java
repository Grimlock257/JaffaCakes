package Grimlock257.JaffaCakes.Mod.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
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
    public OrangeTreeWood(int id, Material material, String blockName) {
        super(id, material);
        this.setHardness(2.0F);
        this.setUnlocalizedName(blockName);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.TEXTURE_FOLDER_NAME + ":" + Strings.ORANGE_TREE_WOOD_NAME);
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
}
