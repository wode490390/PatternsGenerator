# Patterns Generator for Nukkit
[![Build](https://img.shields.io/circleci/build/github/wode490390/PatternsGenerator/master)](https://circleci.com/gh/wode490390/PatternsGenerator/tree/master)
[![Release](https://img.shields.io/github/v/release/wode490390/PatternsGenerator)](https://github.com/wode490390/PatternsGenerator/releases)
[![Release date](https://img.shields.io/github/release-date/wode490390/PatternsGenerator)](https://github.com/wode490390/PatternsGenerator/releases)
<!--[![Servers](https://img.shields.io/bstats/servers/6989)](https://bstats.org/plugin/bukkit/PatternsGenerator/6989)
[![Players](https://img.shields.io/bstats/players/6989)](https://bstats.org/plugin/bukkit/PatternsGenerator/6989)-->

This is an easter egg generator ported from [20w14infinite](https://minecraft.gamepedia.com/Java_Edition_20w14infinite).

![](https://i.loli.net/2020/04/03/ZioLKwbUtRvpj6e.png)

If you found any bugs or have any suggestions, please open an issue on [GitHub Issues](https://github.com/wode490390/PatternsGenerator/issues).

If you love this plugin, please star it on [GitHub](https://github.com/wode490390/PatternsGenerator).

## Download
- [Releases](https://github.com/wode490390/PatternsGenerator/releases)
- [Snapshots](https://circleci.com/gh/wode490390/PatternsGenerator)

## Configurations

### config.yml
```yaml
pattern1:
  # Block ID used to generate the pattern A
  material: 236
  meta: 0
pattern2:
  # Block ID used to generate the pattern B
  material: 236
  meta: 15
```

## Compiling
1. Install [Maven](https://maven.apache.org/).
2. Run `mvn clean package`. The compiled JAR can be found in the `target/` directory.

## Metrics Collection

This plugin uses [bStats](https://github.com/wode490390/bStats-Nukkit) - you can opt out using the global bStats config, see the [official website](https://bstats.org/getting-started) for more details.

<!--[![Metrics](https://bstats.org/signatures/bukkit/PatternsGenerator.svg)](https://bstats.org/plugin/bukkit/PatternsGenerator/6989)-->

###### If I have any grammar and terms error, please correct my wrong :)
