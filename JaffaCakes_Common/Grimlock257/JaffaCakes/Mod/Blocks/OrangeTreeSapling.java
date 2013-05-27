package Grimlock257.JaffaCakes.Mod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;

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
        this.setHardness(0.0F);
        this.setStepSound(Block.soundGrassFootstep);
        this.setBlockName("block_Orange_Tree_Sapling");
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
        this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.4F * 2.0F, 0.9F);
    }

    /** Determines the damage on the item the block drops. Used in cloth and wood. */
    public int damageDropped(int par1) {
        return par1 & 3;
    }

    public String getTextureFile() {
        return CommonProxy.items;
    }
}
