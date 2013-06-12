package Grimlock257.JaffaCakes.Mod.Core;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeOrange;
import Grimlock257.JaffaCakes.Mod.Blocks.OrangeTreeSapling;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeBonemealEvent
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeBonemealEvent {
    @ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event) {
        if (event.ID == ModBlocks.blockOrangeTreeSapling.blockID) {
            if (!event.world.isRemote) {
                ((OrangeTreeSapling) ModBlocks.blockOrangeTreeSapling).generateTree(event.world, event.X, event.Y, event.Z, event.world.rand, event.world.getBlockMetadata(event.X, event.Y, event.Z));
                event.setResult(Result.ALLOW);
            }
        }

        if (event.ID == ModBlocks.blockOrangeTreeOrange.blockID) {
            if (!event.world.isRemote) {
                ((OrangeTreeOrange) ModBlocks.blockOrangeTreeOrange).fertilize(event.world, event.X, event.Y, event.Z);
                event.setResult(Result.ALLOW);
            }
        }
    }
}
