package Grimlock257.JaffaCakes.Mod.Core.Network.Proxy;

import Grimlock257.JaffaCakes.Mod.Lib.Reference;

/**
 * Jaffa Cakes Mod
 * 
 * CommonProxy
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy {
    // Items & Blocks
    public static String items = Reference.ITEM_TEXTURE_LOCATION + "items.png";
    public static String blocks = Reference.BLOCK_TEXTURE_LOCATION + "blocks.png";

    // Client Renders
    public void registerRenderers() {
        // Nothing here as this is the server side proxy
    }
}
