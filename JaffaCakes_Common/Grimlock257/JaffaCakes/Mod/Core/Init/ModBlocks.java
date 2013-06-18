package Grimlock257.JaffaCakes.Mod.Core.Init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeLeaves;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeLog;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeOrange;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeSapling;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeWood;
import Grimlock257.JaffaCakes.Mod.Items.JCItemOrange;
import Grimlock257.JaffaCakes.Mod.Lib.BlockIDs;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Jaffa Cakes Mod
 * 
 * ModBlocks
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModBlocks {
    // Blocks
    public static Block blockOrangeTreeSapling;
    public static Block blockOrangeTreeLog;
    public static Block blockOrangeTreeWood;
    public static Block blockOrangeTreeLeaves;
    public static Block blockOrangeTreeOrange;

    public static void init() {
        // Add Blocks
        blockOrangeTreeSapling = new OrangeTreeSapling(BlockIDs.ORANGE_TREE_SAPLING, Strings.ORANGE_TREE_SAPLING_NAME);
        blockOrangeTreeLog = new OrangeTreeLog(BlockIDs.ORANGE_TREE_LOG, Material.wood, Strings.ORANGE_TREE_LOG_NAME);
        blockOrangeTreeWood = new OrangeTreeWood(BlockIDs.ORANGE_TREE_WOOD, Material.wood, Strings.ORANGE_TREE_WOOD_NAME);
        blockOrangeTreeLeaves = new OrangeTreeLeaves(BlockIDs.ORANGE_TREE_LEAVES, Strings.ORANGE_TREE_LEAVES_NAME);
        blockOrangeTreeOrange = new OrangeTreeOrange(BlockIDs.ORANGE_TREE_ORANGE, Strings.ORANGE_TREE_ORANGE_NAME);

        // Register Blocks
        GameRegistry.registerBlock(blockOrangeTreeSapling, Strings.ORANGE_TREE_SAPLING_NAME);
        GameRegistry.registerBlock(blockOrangeTreeLog, Strings.ORANGE_TREE_LOG_NAME);
        GameRegistry.registerBlock(blockOrangeTreeWood, Strings.ORANGE_TREE_WOOD_NAME);
        GameRegistry.registerBlock(blockOrangeTreeLeaves, Strings.ORANGE_TREE_LEAVES_NAME);
        GameRegistry.registerBlock(blockOrangeTreeOrange, JCItemOrange.class, Strings.ORANGE_TREE_ORANGE_NAME);

        // Add Block Names
        LanguageRegistry.addName(blockOrangeTreeSapling, "Orange Tree Sapling");
        LanguageRegistry.addName(blockOrangeTreeLog, "Orange Tree Log");
        LanguageRegistry.addName(blockOrangeTreeWood, "Orange Tree Planks");
        LanguageRegistry.addName(blockOrangeTreeLeaves, "Orange Tree Leaves");
    }
}
