package Grimlock257.JaffaCakes.Mod.Items;

import net.minecraft.item.Item;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;

/**
 * Jaffa Cakes Mod
 * 
 * JCItem
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class JCItem extends Item {

    public JCItem(int id) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        // Set Item Details
        setMaxStackSize(64);
        setIconIndex(0);
        // Add to Creative tab
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    public JCItem(int id, int texture) {
        super(id);
        setIconIndex(texture);
    }

    @Override
    public String getTextureFile() {
        return CommonProxy.items;
    }

}
