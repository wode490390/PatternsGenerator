package cn.wode490390.nukkit.patternsgen;

import cn.nukkit.block.Block;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DyeColor;
import cn.wode490390.nukkit.patternsgen.util.MetricsLite;

import java.util.NoSuchElementException;

public class PatternsGeneratorPlugin extends PluginBase {

    private static PatternsGeneratorPlugin INSTANCE;

    private PatternsGeneratorSettings settings;

    @Override
    public void onLoad() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        try {
            new MetricsLite(this, 6989);
        } catch (Throwable ignore) {

        }

        this.saveDefaultConfig();
        Config config = this.getConfig();

        String node = "pattern1.material";
        int pattern1Material = Block.CONCRETE;
        try {
            pattern1Material = config.getInt(node, pattern1Material);
        } catch (Exception e) {
            this.logConfigException(node, e);
        }
        int pattern1Meta = DyeColor.WHITE.getWoolData();
        node = "pattern1.meta";
        try {
            pattern1Meta = config.getInt(node, pattern1Meta);
        } catch (Exception e) {
            this.logConfigException(node, e);
        }
        node = "pattern2.material";
        int pattern2Material = Block.CONCRETE;
        try {
            pattern2Material = config.getInt(node, pattern2Material);
        } catch (Exception e) {
            this.logConfigException(node, e);
        }
        int pattern2Meta = DyeColor.BLACK.getWoolData();
        node = "pattern2.meta";
        try {
            pattern2Meta = config.getInt(node, pattern2Meta);
        } catch (Exception e) {
            this.logConfigException(node, e);
        }

        try {
            GlobalBlockPalette.getOrCreateRuntimeId(pattern1Material, 0);
            try {
                GlobalBlockPalette.getOrCreateRuntimeId(pattern1Material, pattern1Meta);
            } catch (NoSuchElementException e) {
                pattern1Meta = 0;
                this.getLogger().warning("Invalid block meta. Use the default value.");
            }
        } catch (NoSuchElementException e) {
            pattern1Material = Block.CONCRETE;
            pattern1Meta = DyeColor.WHITE.getWoolData();
            this.getLogger().warning("Invalid block ID. Use the default value.");
        }
        try {
            GlobalBlockPalette.getOrCreateRuntimeId(pattern2Material, 0);
            try {
                GlobalBlockPalette.getOrCreateRuntimeId(pattern2Material, pattern2Meta);
            } catch (NoSuchElementException e) {
                pattern2Meta = 0;
                this.getLogger().warning("Invalid block meta. Use the default value.");
            }
        } catch (NoSuchElementException e) {
            pattern2Material = Block.CONCRETE;
            pattern2Meta = DyeColor.BLACK.getWoolData();
            this.getLogger().warning("Invalid block ID. Use the default value.");
        }

        this.settings = new PatternsGeneratorSettings(pattern1Material, pattern1Meta, pattern2Material, pattern2Meta);

        Generator.addGenerator(PatternsGenerator.class, "default", Generator.TYPE_INFINITE);
        Generator.addGenerator(PatternsGenerator.class, "normal", Generator.TYPE_INFINITE);
    }

    public PatternsGeneratorSettings getSettings() {
        return this.settings;
    }

    private void logConfigException(String node, Throwable t) {
        this.getLogger().alert("An error occurred while reading the configuration '" + node + "'. Use the default value.", t);
    }

    public static PatternsGeneratorPlugin getInstance() {
        return INSTANCE;
    }
}
