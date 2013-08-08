package Grimlock257.JaffaCakes.Mod.Core.Init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Grimlock257.JaffaCakes.Mod.Lib.RecipeAmounts;
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
        GameRegistry.addRecipe(new ItemStack(ModItems.itemStoneBowl, RecipeAmounts.STONE_BOWL), "S S", " S ", 'S', Block.stone);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemJaffaDough, RecipeAmounts.JAFFA_DOUGH), "WMW", 'M', Item.bucketMilk, 'W', Item.wheat);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemRawJamMixture, RecipeAmounts.RAW_JAM_MIXTURE), "WOS", " B ", 'W', Item.bucketWater, 'O', ModItems.itemOrange, 'S', Item.sugar, 'B', ModItems.itemStoneBowl);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemChocolateBar, RecipeAmounts.CHOCOLATE_BAR), " S ", "CCC", " M ", 'S', Item.sugar, 'C', new ItemStack(Item.dyePowder, 1, 3), 'M', Item.bucketMilk);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemJaffaCake, RecipeAmounts.JAFFA_CAKE), "D", "J", "B", 'D', ModItems.itemChocolateDrop, 'J', ModItems.itemJamDisk, 'B', ModItems.itemJaffaBase);

        // Add Shapeless
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemJamDisk, RecipeAmounts.JAM_DISK), ModItems.itemJamMixture);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChocolateDrop, 9), ModItems.itemChocolateBar);

        // Add Smelting
        GameRegistry.addSmelting(ModItems.itemJaffaDough.itemID, new ItemStack(ModItems.itemJaffaBase), 0.1f);
        GameRegistry.addSmelting(ModItems.itemRawJamMixture.itemID, new ItemStack(ModItems.itemJamMixture), 0.1f);
    }
}
