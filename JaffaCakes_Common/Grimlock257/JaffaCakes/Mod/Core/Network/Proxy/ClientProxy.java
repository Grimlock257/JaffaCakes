package Grimlock257.JaffaCakes.Mod.Core.Network.Proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    /** Registers the Pre-Loads for JaffaCakes mod, Used to prevent glitches, Used in the preInit Method */
    public void registerRenderers() {
        // Blocks & Items
        MinecraftForgeClient.preloadTexture(items);
        MinecraftForgeClient.preloadTexture(blocks);
    }
}
