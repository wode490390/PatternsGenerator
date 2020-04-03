package cn.wode490390.nukkit.patternsgen;

public class PatternsGeneratorSettings {

    private final int pattern1Id;
    private final int pattern1Meta;
    private final int pattern2Id;
    private final int pattern2Meta;

    public PatternsGeneratorSettings(int pattern1Id, int pattern1Meta, int pattern2Id, int pattern2Meta) {
        this.pattern1Id = pattern1Id;
        this.pattern1Meta = pattern1Meta;
        this.pattern2Id = pattern2Id;
        this.pattern2Meta = pattern2Meta;
    }

    public int getPattern1Id() {
        return this.pattern1Id;
    }

    public int getPattern1Meta() {
        return this.pattern1Meta;
    }

    public int getPattern2Id() {
        return this.pattern2Id;
    }

    public int getPattern2Meta() {
        return this.pattern2Meta;
    }
}
