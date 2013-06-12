package Grimlock257.JaffaCakes.Mod.Core.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Grimlock257.JaffaCakes.Mod.Items.JCItem;
import Grimlock257.JaffaCakes.Mod.Items.JCItemFood;
import Grimlock257.JaffaCakes.Mod.Lib.ItemIDs;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Jaffa Cakes Mod
 * 
 * ModItems
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModItems {
    // Add Tools
    public static Item itemStoneBowl;
    // Add Foods
    public static Item itemOrange;
    public static Item itemJaffaDough;
    public static Item itemJaffaBase;
    public static Item itemRawJamMixture;
    public static Item itemJamMixture;
    public static Item itemJamDisk;
    public static Item itemChocolateBar;
    public static Item itemChocolateDrop;
    public static Item itemJaffaCake;

    public static ItemStack itemOrange_0;
    public static ItemStack itemOrange_1;
    public static ItemStack itemOrange_2;

    public static void init() {
        // Tools
        itemStoneBowl = new JCItem(ItemIDs.STONE_BOWL).setMaxStackSize(16).setIconIndex(0).setItemName("item_StoneBowl");

        // Foods
        itemOrange = new JCItemFood(ItemIDs.ORANGE, 4, 3F, false).setIconIndex(1).setItemName("item_Orange");
        itemJaffaDough = new JCItem(ItemIDs.JAFFA_DOUGH).setIconIndex(2).setItemName("item_Jaffa_Dough");
        itemJaffaBase = new JCItemFood(ItemIDs.JAFFA_BASE, 2, 1F, false).setIconIndex(3).setItemName("item_Jaffa_Base");
        itemRawJamMixture = new JCItem(ItemIDs.RAW_JAM_MIXTURE).setIconIndex(4).setItemName("item_Raw_Jam_Mixture");
        itemJamMixture = new JCItem(ItemIDs.JAM_MIXTURE).setIconIndex(5).setItemName("item_Jam_Mixture");
        itemJamDisk = new JCItemFood(ItemIDs.JAM_DISK, 2, 1F, false).setIconIndex(6).setItemName("item_Jam_Disk");
        itemChocolateBar = new JCItemFood(ItemIDs.CHOCOLATE_BAR, 4, 2F, false).setIconIndex(7).setItemName("item_Chocolate_Bar");
        itemChocolateDrop = new JCItem(ItemIDs.CHOCOLATE_DROP).setIconIndex(8).setItemName("item_Chocolate_Drop");
        itemJaffaCake = new JCItemFood(ItemIDs.JAFFA_CAKE, 6, 8F, false).setIconIndex(9).setItemName("item_Jaffa_Cake");

        // Orange Sub Items ( Meta Data )
        itemOrange_0 = new ItemStack(ModBlocks.blockOrangeTreeOrange, 16, 0);
        itemOrange_1 = new ItemStack(ModBlocks.blockOrangeTreeOrange, 16, 1);
        itemOrange_2 = new ItemStack(ModBlocks.blockOrangeTreeOrange, 16, 2);

        // Add Items Names
        LanguageRegistry.addName(itemStoneBowl, "Stone Bowl");

        // Add Food Names
        LanguageRegistry.addName(itemOrange, "Orange");
        LanguageRegistry.addName(itemJaffaDough, "Jaffa Dough");
        LanguageRegistry.addName(itemJaffaBase, "Jaffa Base");
        LanguageRegistry.addName(itemRawJamMixture, "Raw Jam Mixture");
        LanguageRegistry.addName(itemJamMixture, "Jam Mixture");
        LanguageRegistry.addName(itemJamDisk, "Jam Disk");
        LanguageRegistry.addName(itemChocolateBar, "Chocolate Bar");
        LanguageRegistry.addName(itemChocolateDrop, "Chocolate Drop");
        LanguageRegistry.addName(itemJaffaCake, "Jaffa Cake");

        // Orange Sub Items
        LanguageRegistry.addName(itemOrange_0, "Very Unripe Orange");
        // TODO: Remove these do... as I could't change the textures for inventory.. May add later!
        // LanguageRegistry.addName(itemOrange_1, "Unripe Orange");
        // LanguageRegistry.addName(itemOrange_2, "Ripe Orange");
    }
}
