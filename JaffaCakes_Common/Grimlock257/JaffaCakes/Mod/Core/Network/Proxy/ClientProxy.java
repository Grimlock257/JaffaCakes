package Grimlock257.JaffaCakes.Mod.Core.Network.Proxy;

import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Jaffa Cakes Mod
 * 
 * ClientProxy
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {
    /** Registers the Pre-Loads for JaffaCakes mod, Used to prevent glitches, Used in the preInit Method */
    public void registerRenderers() {
        // Blocks & Items
        MinecraftForgeClient.preloadTexture(items);
        MinecraftForgeClient.preloadTexture(blocks);
    }
}
