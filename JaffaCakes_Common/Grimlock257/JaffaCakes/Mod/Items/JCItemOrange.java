package Grimlock257.JaffaCakes.Mod.Items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Jaffa Cakes Mod
 * 
 * JCItemOrange
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class JCItemOrange extends ItemBlock {
    // private final static String[] subNames = { "veryUnripeOrange", "unripeOrange", "ripeOrange" };

    public JCItemOrange(int id) {
        super(id);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.ORANGE_TREE_ORANGE_NAME);
    }

    @SideOnly(Side.CLIENT)
    /** Gets an icon index based on an item's damage value */
    public Icon getIconFromDamage(int damageValue) {
        return ModBlocks.blockOrangeTreeOrange.getIcon(2, damageValue);
    }

    public int getMetadata(int par1) {
        return par1;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int metadata = itemStack.getItemDamage();
        switch (metadata) {
            case 0:
                return "orangeTreeOrange_0";
            case 1:
                return "orangeTreeOrange_1";
            case 2:
                return "orangeTreeOrange_2";
            default:
                return null;
        }
    }
}
