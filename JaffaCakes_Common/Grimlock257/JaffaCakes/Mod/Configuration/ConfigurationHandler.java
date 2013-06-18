package Grimlock257.JaffaCakes.Mod.Configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import Grimlock257.JaffaCakes.Mod.Lib.BlockIDs;
import Grimlock257.JaffaCakes.Mod.Lib.Generator;
import Grimlock257.JaffaCakes.Mod.Lib.ItemIDs;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.common.FMLLog;

/**
 * Jaffa Cakes Mod
 * 
 * ConfigurationHandler
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static final String CATEGORY_GENERATION = "generation";

    public static void init(File configFile) {
        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* General Config Settings */
            ConfigurationSettings.ORANGE_TREE_RARITY_CONFIG = configuration.get(CATEGORY_GENERATION, ConfigurationSettings.ORANGE_TREE_RARITY_CONFIGNAME, Generator.ORANGE_TREE_RARITY_DEFAULT).getString();

            /* Block Config IDs Settings */
            BlockIDs.ORANGE_TREE_SAPLING = configuration.getBlock(Strings.ORANGE_TREE_SAPLING_NAME, BlockIDs.ORANGE_TREE_SAPLING_DEFAULT).getInt(BlockIDs.ORANGE_TREE_SAPLING_DEFAULT);
            BlockIDs.ORANGE_TREE_LOG = configuration.getBlock(Strings.ORANGE_TREE_LOG_NAME, BlockIDs.ORANGE_TREE_LOG_DEFAULT).getInt(BlockIDs.ORANGE_TREE_LOG_DEFAULT);
            BlockIDs.ORANGE_TREE_WOOD = configuration.getBlock(Strings.ORANGE_TREE_WOOD_NAME, BlockIDs.ORANGE_TREE_WOOD_DEFAULT).getInt(BlockIDs.ORANGE_TREE_WOOD_DEFAULT);
            BlockIDs.ORANGE_TREE_LEAVES = configuration.getBlock(Strings.ORANGE_TREE_LEAVES_NAME, BlockIDs.ORANGE_TREE_LEAVES_DEFAULT).getInt(BlockIDs.ORANGE_TREE_LEAVES_DEFAULT);
            BlockIDs.ORANGE_TREE_ORANGE = configuration.getBlock(Strings.ORANGE_TREE_ORANGE_NAME, BlockIDs.ORANGE_TREE_ORANGE_DEFAULT).getInt(BlockIDs.ORANGE_TREE_ORANGE_DEFAULT);

            /* Item Config IDs Settings */
            ItemIDs.STONE_BOWL = configuration.getItem(Strings.STONE_BOWL_NAME, ItemIDs.STONE_BOWL_DEFAULT).getInt(ItemIDs.STONE_BOWL_DEFAULT);
            ItemIDs.ORANGE = configuration.getItem(Strings.ORANGE_NAME, ItemIDs.ORANGE_DEFAULT).getInt(ItemIDs.ORANGE_DEFAULT);
            ItemIDs.JAFFA_DOUGH = configuration.getItem(Strings.JAFFA_DOUGH_NAME, ItemIDs.JAFFA_DOUGH_DEFAULT).getInt(ItemIDs.JAFFA_DOUGH_DEFAULT);
            ItemIDs.JAFFA_BASE = configuration.getItem(Strings.JAFFA_BASE_NAME, ItemIDs.JAFFA_BASE_DEFAULT).getInt(ItemIDs.JAFFA_BASE_DEFAULT);
            ItemIDs.RAW_JAM_MIXTURE = configuration.getItem(Strings.RAW_JAM_MIXTURE_NAME, ItemIDs.RAW_JAM_MIXTURE_DEFAULT).getInt(ItemIDs.RAW_JAM_MIXTURE_DEFAULT);
            ItemIDs.JAM_MIXTURE = configuration.getItem(Strings.JAM_MIXTURE_NAME, ItemIDs.JAM_MIXTURE_DEFAULT).getInt(ItemIDs.JAM_MIXTURE_DEFAULT);
            ItemIDs.JAM_DISK = configuration.getItem(Strings.JAM_DISK_NAME, ItemIDs.JAM_DISK_DEFAULT).getInt(ItemIDs.JAM_DISK_DEFAULT);
            ItemIDs.CHOCOLATE_BAR = configuration.getItem(Strings.CHOCOLATE_BAR_NAME, ItemIDs.CHOCOLATE_BAR_DEFAULT).getInt(ItemIDs.CHOCOLATE_BAR_DEFAULT);
            ItemIDs.CHOCOLATE_DROP = configuration.getItem(Strings.CHOCOLATE_DROP_NAME, ItemIDs.CHOCOLATE_DROP_DEFAULT).getInt(ItemIDs.CHOCOLATE_DROP_DEFAULT);
            ItemIDs.JAFFA_CAKE = configuration.getItem(Strings.JAFFACAKES_NAME, ItemIDs.JAFFA_CAKE_DEFAULT).getInt(ItemIDs.JAFFA_CAKE_DEFAULT);
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "[" + Reference.NAME + "] [CONFIG ERROR] Problem loading the configuration file! :(");
        } finally {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue) {
        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }

}
