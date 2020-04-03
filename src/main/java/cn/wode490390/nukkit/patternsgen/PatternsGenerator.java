package cn.wode490390.nukkit.patternsgen;

import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.biome.EnumBiome;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

import java.util.Collections;
import java.util.Map;

public class PatternsGenerator extends Generator {

    protected ChunkManager level;
    protected PatternsGeneratorSettings settings;

    public PatternsGenerator() {
        this(null);
    }

    public PatternsGenerator(Map<String, Object> options) {
        this.settings = PatternsGeneratorPlugin.getInstance().getSettings();
    }

    @Override
    public int getId() {
        return TYPE_INFINITE;
    }

    @Override
    public String getName() {
        return "normal";
    }

    @Override
    public ChunkManager getChunkManager() {
        return this.level;
    }

    @Override
    public Map<String, Object> getSettings() {
        return Collections.emptyMap();
    }

    @Override
    public void init(ChunkManager level, NukkitRandom random) {
        this.level = level;
    }

    @Override
    public void generateChunk(int chunkX, int chunkZ) {
        BaseFullChunk chunk = this.level.getChunk(chunkX, chunkZ);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunk.setBiome(x, z, EnumBiome.PLAINS.biome);
            }
        }

        this.fillPattern(chunk, 0, 0);
        this.fillPattern(chunk, 1, 0);
        this.fillPattern(chunk, 0, 1);
        this.fillPattern(chunk, 1, 1);
    }

    protected void fillPattern(BaseFullChunk chunk, int baseX, int baseZ) {
        long chunkHash = (chunk.getX() * 2L + baseX & 0x7fffff) << 31 | (chunk.getZ() * 2L + baseZ & 0x7fffff) << 8;
        for (int y = 0; y < 256; ++y) {
            long blockHash = chunkHash | y;
            for (int x = 0; x < 7; ++x) {
                for (int z = 0; z < 7; ++z) {
                    boolean flag = (blockHash & 1) != 0;
                    blockHash >>= 1;

                    if (flag) {
                        chunk.setBlock(x + baseX * 8, y, z + baseZ * 8, this.settings.getPattern1Id(), this.settings.getPattern1Meta());
                    } else {
                        chunk.setBlock(x + baseX * 8, y, z + baseZ * 8, this.settings.getPattern2Id(), this.settings.getPattern2Meta());
                    }
                }
            }
        }
    }

    @Override
    public void populateChunk(int chunkX, int chunkZ) {

    }

    @Override
    public Vector3 getSpawn() {
        return new Vector3(0.5, 256, 0.5);
    }
}
