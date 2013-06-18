package Grimlock257.JaffaCakes.Mod.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    public JCItem(int id, String itemName) {
        super(id);
        this.setUnlocalizedName(itemName);
        this.setMaxStackSize(64);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
