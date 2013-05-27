package Grimlock257.JaffaCakes.Mod.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModItems;

public class CreativeTabJaffaCakes extends CreativeTabs {
    public CreativeTabJaffaCakes(String name) {
        super(name);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.itemJaffaCake);
    }
}
