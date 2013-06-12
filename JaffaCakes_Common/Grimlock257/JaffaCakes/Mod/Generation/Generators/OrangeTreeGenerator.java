package Grimlock257.JaffaCakes.Mod.Generation.Generators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import Grimlock257.JaffaCakes.Mod.Generation.Worldgen.WorldGenOrangeTree;
import Grimlock257.JaffaCakes.Mod.Lib.Generator;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Jaffa Cakes Mod
 * 
 * OrangeTreeGenerator
 * 
 * @author Grimlock257
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class OrangeTreeGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    /** Generates ores in the normal minecraft world */
    public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        // Code for 1.5.2 Version
        // BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
        // if (BiomeDictionary.isBiomeOfType(biome, Type.SWAMP) || BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) || BiomeDictionary.isBiomeOfType(biome, Type.WATER) || BiomeDictionary.isBiomeOfType(biome, Type.DESERT)) {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX + 16, chunkZ + 16);
        if (biome == BiomeGenBase.swampland || biome == BiomeGenBase.jungle || biome == BiomeGenBase.river || biome == BiomeGenBase.desert) {
            for (int k = 0; k < Generator.ORANGE_TREE_RARITY; k++) {
                for (int treeType = 0; treeType < 1; treeType++) {
                    int l = rand.nextInt(128);
                    int i1 = chunkX + rand.nextInt(16);
                    int j1 = chunkZ + rand.nextInt(16);
                    if ((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3)) {
                        (new WorldGenOrangeTree(treeType)).generate(world, rand, i1, l, j1);
                    }
                }
            }
        }
    }
}