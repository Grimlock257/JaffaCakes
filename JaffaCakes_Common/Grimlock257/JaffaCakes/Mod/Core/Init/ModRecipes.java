package Grimlock257.JaffaCakes.Mod.Core.Init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Jaffa Cakes Mod
 * 
 * ModRecipes
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModRecipes {
    public static void init() {
        // Add Structured Recipes
        GameRegistry.addRecipe(new ItemStack(ModItems.itemStoneBowl), "S S", " S ", 'S', Block.stone);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemJaffaDough), "WMW", 'M', Item.bucketMilk, 'W', Item.wheat);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemRawJamMixture), "WOS", " B ", 'W', Item.bucketWater, 'O', ModItems.itemOrange, 'S', Item.sugar, 'B', ModItems.itemStoneBowl);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemChocolateBar), " S ", "CCC", " M ", 'S', Item.sugar, 'C', new ItemStack(Item.dyePowder, 1, 3), 'M', Item.bucketMilk);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemJaffaCake), "D", "J", "B", 'D', ModItems.itemChocolateDrop, 'J', ModItems.itemJamDisk, 'B', ModItems.itemJaffaBase);

        // Add Shapeless
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemJamDisk), ModItems.itemJamMixture);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChocolateDrop, 9), ModItems.itemChocolateBar);

        // Add Smelting
        GameRegistry.addSmelting(ModItems.itemJaffaDough.itemID, new ItemStack(ModItems.itemJaffaBase), 0.1f);
        GameRegistry.addSmelting(ModItems.itemRawJamMixture.itemID, new ItemStack(ModItems.itemJamMixture), 0.1f);
    }
}
