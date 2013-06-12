package Grimlock257.JaffaCakes.Mod.Generation.Worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import Grimlock257.JaffaCakes.Mod.Core.Init.ModBlocks;

/**
 * Jaffa Cakes Mod
 * 
 * WorldGenOrangeTree
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class WorldGenOrangeTree extends WorldGenerator {
    private int metaWood = 3;
    private int metaLeaves = 3;

    public WorldGenOrangeTree(int i) {
        treeType = i;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        int treeHeight = random.nextInt(3) + 5;
        boolean flag = true;

        // A big long check to see if the tree can spawn in this location
        if (y < 1 || y + treeHeight + 1 > 256) {
            return false;
        }

        for (int i1 = y; i1 <= y + 1 + treeHeight; i1++) {
            byte byte0 = 1;

            if (i1 == y) {
                byte0 = 0;
            }

            if (i1 >= (y + 1 + treeHeight) - 2) {
                byte0 = 2;
            }

            for (int i2 = x - byte0; i2 <= x + byte0 && flag; i2++) {
                for (int l2 = z - byte0; l2 <= z + byte0 && flag; l2++) {
                    if (i1 >= 0 && i1 < 128) {
                        int j3 = world.getBlockId(i2, i1, l2);

                        if (j3 != 0 && j3 != 18) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }
            }
        }

        if (!flag) {
            return false;
        }

        int j1 = world.getBlockId(x, y - 1, z);

        if (j1 != Block.grass.blockID && j1 != Block.dirt.blockID || y >= 256 - treeHeight - 1) {
            return false;
        }

        // This is where the tree starts generating
        world.setBlock(x, y - 1, z, Block.dirt.blockID); // If the block below the tree is a grass block, change it to a dirt block

        // For loop that generates leaves
        for (int currentYPos = (y - 3) + treeHeight; currentYPos <= y + treeHeight; currentYPos++) {
            // Assigns currentYPos to bottom most y position that leaves will gen, loops the following code for as many times as the treeHeight (gen starts above bottom log and ends above top log)
            int j2 = currentYPos - (y + treeHeight);
            int i3 = 1 - j2 / 2;

            for (int currentXPos = x - i3; currentXPos <= x + i3; currentXPos++) {
                for (int currentZPos = z - i3; currentZPos <= z + i3; currentZPos++) {
                    if (Math.abs(currentXPos - x) == i3 && Math.abs(currentZPos - z) == i3 && (random.nextInt(2) == 0 || j2 == 0) || Block.opaqueCubeLookup[world.getBlockId(currentXPos, currentYPos, currentZPos)]) {
                        continue;
                    }

                    this.setBlockAndMetadata(world, currentXPos, currentYPos, currentZPos, ModBlocks.blockOrangeTreeLeaves.blockID, this.metaLeaves); // Places leaves

                    if (world.getBlockId(currentXPos, currentYPos - 1, currentZPos) == 0) // if the block below the leaves that were just placed is air
                    {
                        int fruitType = treeType;

                        // if(fruitType == 0 && random.nextInt(25) == 0)
                        // {
                        // fruitType = /*Whatever fruit type golden oranges are*/;
                        // }
                        if (world.getBlockId(currentXPos, currentYPos - 2, currentZPos) == 0 && currentYPos > (y - 3) + treeHeight) {
                            // If the leaves placed are not the lowest possible leaves in the tree, 100% chance to spawn fruit (makes fruit positions look varied)
                            world.setBlockAndMetadata(currentXPos, currentYPos - 1, currentZPos, ModBlocks.blockOrangeTreeOrange.blockID, fruitType);
                        } else {
                            // else, 33% chance of spawning fruit
                            if (random.nextInt(4) == 0) {
                                world.setBlockAndMetadata(currentXPos, currentYPos - 1, currentZPos, ModBlocks.blockOrangeTreeOrange.blockID, fruitType);
                            }
                        }
                    }
                }
            }
        }

        // This part generates the vertical line of logs that make up the tree.
        for (int l1 = 0; l1 < treeHeight; l1++) {
            int k2 = world.getBlockId(x, y + l1 + 10, z);

            if (k2 == 0 || k2 == 18 || k2 == ModBlocks.blockOrangeTreeOrange.blockID) {
                this.setBlockAndMetadata(world, x, y + l1, z, ModBlocks.blockOrangeTreeLog.blockID, this.metaWood);
            }
        }

        return true;
    }

    public int treeType;
}
