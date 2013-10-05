package Grimlock257.JaffaCakes.Mod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import Grimlock257.JaffaCakes.Mod.Configuration.ConfigurationHandler;
import Grimlock257.JaffaCakes.Mod.Core.OrangeTreeBonemealEvent;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModItems;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModRecipes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;
import Grimlock257.JaffaCakes.Mod.CreativeTab.CreativeTabJaffaCakes;
import Grimlock257.JaffaCakes.Mod.Generation.Generators.OrangeTreeGenerator;
import Grimlock257.JaffaCakes.Mod.Lib.BlockIDs;
import Grimlock257.JaffaCakes.Mod.Lib.Generator;
import Grimlock257.JaffaCakes.Mod.Lib.ItemIDs;
import Grimlock257.JaffaCakes.Mod.Lib.RecipeAmounts;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Jaffa Cakes Mod
 * 
 * JaffaCakes
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class JaffaCakes {
    /** If the JaffaCakes debugger is enabled then a message will be printed to the console */
    public static void debug(String message) {
        if (Reference.debug == true) {
            System.out.println("[" + Reference.NAME + "] DEBUG: " + message);
        }
    }

    /** Print a raw string ( Not used in debug mode, used to print messages to the console ) */
    public static void printMessage(String message) {
        System.out.println("[" + Reference.NAME + "] " + message);
    }

    @Instance(Reference.MODID)
    public static JaffaCakes instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    // Add Jaffa Cake Creative Tabs
    public static CreativeTabs tabJaffaCakes = new CreativeTabJaffaCakes("tabJaffaCakes");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        printMessage("Pre Initialization Event");

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CONFIGFOLDER + File.separator + Reference.MODID + ".cfg"));

        if (Reference.debug) {
            JaffaCakes.debug("Debugger mode has been enabled for " + Reference.AUTHOR + "'s " + Reference.NAME + " Mod! - " + Reference.AUTHOR + " - If this is a release version, You cannot disable the Debug option - Sorry!");
        }

        JaffaCakes.printMessage("");
        JaffaCakes.printMessage("Mod Details:");
        JaffaCakes.printMessage("ModID: " + Reference.MODID);
        JaffaCakes.printMessage("Name: " + Reference.NAME);
        JaffaCakes.printMessage("Version: " + Reference.VERSION);
        JaffaCakes.printMessage("Channels: " + Reference.CHANNELS);
        JaffaCakes.printMessage("Base Texture Directory: " + Reference.BASE_TEXTURE_LOCATION);

        // Register Bonemeal Event
        MinecraftForge.EVENT_BUS.register(new OrangeTreeBonemealEvent());

        // Register Renders
        JaffaCakes.proxy.registerRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        printMessage("Initialization Event");
        
        // Add name's to the Tabs
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabJaffaCakes", "en_US", Strings.TAB_MAIN_NAME);

        // Initialize Blocks
        ModBlocks.init();

        // Initialize Items
        ModItems.init();

        // Create Recipes
        ModRecipes.init();

        // Dungeon
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.itemJaffaCake), 1, 3, 115));

        // Generate Tree's
        GameRegistry.registerWorldGenerator(new OrangeTreeGenerator());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        printMessage("Post Initialization Event");

        JaffaCakes.printMessage("Basic Info:");

        JaffaCakes.printMessage("  Block ID's Used: " + BlockIDs.ORANGE_TREE_SAPLING + ", " + BlockIDs.ORANGE_TREE_LOG + ", " + BlockIDs.ORANGE_TREE_WOOD + ", " + BlockIDs.ORANGE_TREE_LEAVES + ", " + BlockIDs.ORANGE_TREE_ORANGE + ".");
        JaffaCakes.printMessage("  Item ID's Used: " + ItemIDs.STONE_BOWL + ", " + ItemIDs.ORANGE + ", " + ItemIDs.JAFFA_DOUGH + ", " + ItemIDs.JAFFA_BASE + ", " + ItemIDs.RAW_JAM_MIXTURE + ", " + ItemIDs.JAM_MIXTURE + ", " + ItemIDs.JAM_DISK + ", " + ItemIDs.CHOCOLATE_BAR + ", " + ItemIDs.CHOCOLATE_DROP + ", " + ItemIDs.JAFFA_CAKE + ".");

        JaffaCakes.printMessage("");

        JaffaCakes.printMessage("  Orange Tree Rarity: " + Generator.ORANGE_TREE_RARITY);
        JaffaCakes.printMessage("  Crafting Result Amounts: " + RecipeAmounts.CHOCOLATE_BAR + ", " + RecipeAmounts.JAFFA_CAKE + ", " + RecipeAmounts.JAFFA_DOUGH + ", " + RecipeAmounts.JAM_DISK + ", " + RecipeAmounts.RAW_JAM_MIXTURE + ", " + RecipeAmounts.STONE_BOWL + ".");

        JaffaCakes.printMessage(Reference.NAME + " by " + Reference.AUTHOR + " seems to have loaded correctly, using ModID " + Reference.MODID + ". Version " + Reference.VERSION + ". Using Channels " + Reference.CHANNELS + ".");
        JaffaCakes.printMessage("If you find any glitchs, errors or spelling mistakes, AI problems, Please notify " + Reference.AUTHOR + " at either Minecraft Forums or at the website; " + Reference.WEBSITE + ". You may also be able to find me on " + Reference.WEBCHAT + " on my channel " + Reference.IRC + ".");
    }
}
