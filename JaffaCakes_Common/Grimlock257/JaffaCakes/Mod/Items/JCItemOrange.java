package Grimlock257.JaffaCakes.Mod.Items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;

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
    private final static String[] subNames = { "veryUnripeOrange", "unripeOrange", "ripeOrange" };

    public JCItemOrange(int id) {
        super(id);
        setHasSubtypes(true);
        setItemName("item_Orange_Tree_Orange");
        this.setIconIndex(16);
    }

    @Override
    public String getItemNameIS(ItemStack itemstack) {
        return getItemName() + "." + subNames[itemstack.getItemDamage()];
    }

    public String getTextureFile(ItemStack item) {
        return CommonProxy.items;
    }
}
