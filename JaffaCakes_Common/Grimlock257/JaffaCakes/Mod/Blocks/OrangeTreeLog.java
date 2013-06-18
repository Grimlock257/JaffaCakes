package Grimlock257.JaffaCakes.Mod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeLog
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeLog extends Block {
    public OrangeTreeLog(int id, Material material, String blockName) {
        super(id, material);
        this.setHardness(2.0F);
        this.setUnlocalizedName(blockName);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    @SideOnly(Side.CLIENT)
    private Icon orangeTreeLogVertical;

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        Icon textureIcon;
        if (par1 == 0 || par1 == 1) {
            textureIcon = orangeTreeLogVertical;
        } else {
            textureIcon = blockIcon;
        }
        return textureIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + Strings.ORANGE_TREE_LOG_NAME);
        this.orangeTreeLogVertical = iconRegister.registerIcon(Reference.MODID + ":" + Strings.ORANGE_TREE_LOG_NAME + "_vert");
    }
}
