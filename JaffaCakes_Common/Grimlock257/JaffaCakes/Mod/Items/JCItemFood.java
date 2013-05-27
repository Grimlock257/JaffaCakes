package Grimlock257.JaffaCakes.Mod.Items;

import net.minecraft.item.ItemFood;
import Grimlock257.JaffaCakes.Mod.JaffaCakes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;

public class JCItemFood extends ItemFood {

    public JCItemFood(int id, int hunger, float saturation, boolean wolf) {
        super(id, hunger, saturation, wolf);
        this.setCreativeTab(JaffaCakes.tabJaffaCakes);
    }

    @Override
    public String getTextureFile() {
        return CommonProxy.items;
    }
}
