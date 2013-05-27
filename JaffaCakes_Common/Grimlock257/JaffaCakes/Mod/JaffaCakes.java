package Grimlock257.JaffaCakes.Mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModItems;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModRecipes;
import Grimlock257.JaffaCakes.Mod.Core.Network.Proxy.CommonProxy;
import Grimlock257.JaffaCakes.Mod.CreativeTab.CreativeTabJaffaCakes;
import Grimlock257.JaffaCakes.Mod.Lib.Reference;
import Grimlock257.JaffaCakes.Mod.Lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
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
            System.out.println("[JaffaCakes] Debug: " + message);
        }
    }

    /** Print a raw string ( Not used in debug mode, used on start up for the disabled items message ) */
    public static void printMessage(String message) {
        System.out.println("[JaffaCakes] " + message);
    }

    @Instance(Reference.MODID)
    public static JaffaCakes instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    // Add Jaffa Cake Creative Tabs
    public static CreativeTabs tabJaffaCakes = new CreativeTabJaffaCakes("tabJaffaCakes");

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        printMessage("Pre Init Event");

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

        // Register Renders
        JaffaCakes.proxy.registerRenderers();

        // Add name's to the Tabs
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabJaffaCakes", "en_US", Strings.TAB_MAIN_NAME);

        // Initialize Blocks
        ModBlocks.init();

        // Initialize Items
        ModItems.init();

        // Create Recipes
        ModRecipes.init();
    }

    @Init
    public void init(FMLInitializationEvent event) {
        printMessage("Init Event");

        // Dungeon
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.itemJaffaCake), 1, 3, 115));

        // Not much to do here at this time!
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        printMessage("Post Init Event");
        JaffaCakes.printMessage(Reference.NAME + " by " + Reference.AUTHOR + " seems to have loaded correctly, using ModID " + Reference.MODID + ". Version " + Reference.VERSION + ". Using Channels " + Reference.CHANNELS + ".");
        JaffaCakes.printMessage("If you find any glitchs, errors or spelling mistakes, AI problems, Please notify " + Reference.AUTHOR + " at either Minecraft Forums or at the website; " + Reference.WEBSITE + ". You may also be able to find me on " + Reference.WEBCHAT + " on my channel " + Reference.IRC + ".");

    }
}
