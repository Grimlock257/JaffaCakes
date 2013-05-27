package Grimlock257.JaffaCakes.Mod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;

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
    public OrangeTreeLog(int par1, int par2, Material par3Material) {
        super(par1, par2, par3Material);
        this.setHardness(2.0F);
        this.setBlockName("block_Orange_Tree_Log");
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    public String getTextureFile() {
        return CommonProxy.items;
    }

    public int getBlockTextureFromSide(int side) {
        if (side == 0 || side == 1) {
            return this.blockIndexInTexture + 1;
        } else {
            return this.blockIndexInTexture;
        }
    }
}
