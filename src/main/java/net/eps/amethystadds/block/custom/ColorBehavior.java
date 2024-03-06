package net.eps.amethystadds.block.custom;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ColorBehavior {

    public static DyeColor GetDyeColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return DyeColor.RED;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return DyeColor.YELLOW;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return DyeColor.GREEN;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return DyeColor.LIME;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return DyeColor.ORANGE;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return DyeColor.WHITE;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return DyeColor.BROWN;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return DyeColor.LIGHT_BLUE;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return DyeColor.BLUE;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return DyeColor.CYAN;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return DyeColor.PINK;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return DyeColor.MAGENTA;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return DyeColor.PURPLE;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return DyeColor.LIGHT_GRAY;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return DyeColor.GRAY;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return DyeColor.BLACK;
        } else {
            return null;
        }
    }

    public static Block GetShulkerColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return Blocks.RED_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return Blocks.YELLOW_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return Blocks.GREEN_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return Blocks.LIME_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return Blocks.ORANGE_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return Blocks.WHITE_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return Blocks.BROWN_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return Blocks.LIGHT_BLUE_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return Blocks.BLUE_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return Blocks.CYAN_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return Blocks.PINK_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return Blocks.MAGENTA_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return Blocks.PURPLE_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return Blocks.LIGHT_GRAY_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return Blocks.GRAY_SHULKER_BOX;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return Blocks.BLACK_SHULKER_BOX;
        } else {
            return null;
        }
    }

    public static List<Block> GetAmethystBudColor(BlockState state) {
        List<Block> amethystsList = new ArrayList<>();

        if (state.getBlock() == ModBlocks.RED_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_RED_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_RED_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_RED_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_RED_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.YELLOW_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_YELLOW_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_YELLOW_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_YELLOW_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_YELLOW_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.GREEN_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_GREEN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_GREEN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_GREEN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_GREEN_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.LIME_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_LIME_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_LIME_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_LIME_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_LIME_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.ORANGE_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_ORANGE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_ORANGE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_ORANGE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_ORANGE_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.WHITE_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_WHITE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_WHITE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_WHITE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_WHITE_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.BROWN_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_BROWN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_BROWN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_BROWN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_BROWN_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_LIGHT_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_LIGHT_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_LIGHT_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_LIGHT_BLUE_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.BLUE_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_BLUE_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_BLUE_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.CYAN_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_CYAN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_CYAN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_CYAN_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_CYAN_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.PINK_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_PINK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_PINK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_PINK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_PINK_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.MAGENTA_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_MAGENTA_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_MAGENTA_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_MAGENTA_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_MAGENTA_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_LIGHT_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_LIGHT_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_LIGHT_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_LIGHT_GRAY_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.GRAY_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_GRAY_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_GRAY_AMETHYST_BUD);
        } else if (state.getBlock() == ModBlocks.BLACK_BUDDING_AMETHYST) {
            amethystsList.add(ModBlocks.SMALL_BLACK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.MEDIUM_BLACK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.LARGE_BLACK_AMETHYST_BUD);
            amethystsList.add(ModBlocks.GROWN_BLACK_AMETHYST_BUD);
        } else {
            amethystsList.add(Blocks.SMALL_AMETHYST_BUD);
            amethystsList.add(Blocks.MEDIUM_AMETHYST_BUD);
            amethystsList.add(Blocks.LARGE_AMETHYST_BUD);
            amethystsList.add(Blocks.AMETHYST_CLUSTER);
        }

        return amethystsList;
    }


    public static Block GetAmethystColor(BlockState state, Block block) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.RED_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.RED_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.RED_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.RED_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.YELLOW_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.YELLOW_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.YELLOW_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.YELLOW_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.GREEN_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.GREEN_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.GREEN_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.GREEN_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.LIME_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.LIME_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.LIME_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.LIME_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.ORANGE_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.ORANGE_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.ORANGE_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.ORANGE_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.WHITE_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.WHITE_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.WHITE_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.WHITE_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.BROWN_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.BROWN_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.BROWN_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.BROWN_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.LIGHT_BLUE_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.LIGHT_BLUE_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.LIGHT_BLUE_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.LIGHT_BLUE_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.BLUE_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.BLUE_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.BLUE_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.BLUE_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.CYAN_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.CYAN_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.CYAN_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.CYAN_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.PINK_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.PINK_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.PINK_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.PINK_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.MAGENTA_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.MAGENTA_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.MAGENTA_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.MAGENTA_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.PURPLE_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return Blocks.BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return Blocks.AMETHYST_BLOCK;
            } else if (block instanceof TintedGlassBlock) {
                return Blocks.TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.LIGHT_GRAY_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.LIGHT_GRAY_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.LIGHT_GRAY_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.LIGHT_GRAY_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.GRAY_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.GRAY_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.GRAY_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.GRAY_TINTED_GLASS;
            }
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            if (block instanceof AmethystBlock) {
                return ModBlocks.BLACK_AMETHYST_BLOCK;
            } else if (block instanceof BuddingAmethystBlock) {
                return ModBlocks.BLACK_BUDDING_AMETHYST;
            } else if (block instanceof net.minecraft.block.AmethystBlock) {
                return ModBlocks.BLACK_AMETHYST_CLUSTER;
            } else if (block instanceof TintedGlassBlock) {
                return ModBlocks.BLACK_TINTED_GLASS;
            }
        }
        return block;
    }


    public static Integer GetIntColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return 11546150;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return 16701501;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return 6192150;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return 8439583;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return 16351261;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return 0xF9FFFE;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return 8606770;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return 3847130;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return 3949738;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return 1481884;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return 15961002;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return 13061821;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return 8991416;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return 0x9D9D97;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return 4673362;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return 0x1D1D21;
        } else {
            return null;
        }
    }

    public static DefaultParticleType GetBubbleColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return ModParticles.RED_BUBBLE;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return ModParticles.YELLOW_BUBBLE;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return ModParticles.GREEN_BUBBLE;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return ModParticles.LIME_BUBBLE;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return ModParticles.ORANGE_BUBBLE;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return ModParticles.WHITE_BUBBLE;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return ModParticles.BROWN_BUBBLE;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return ModParticles.LIGHT_BLUE_BUBBLE;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return ModParticles.BLUE_BUBBLE;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return ModParticles.CYAN_BUBBLE;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return ModParticles.PINK_BUBBLE;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return ModParticles.MAGENTA_BUBBLE;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return ModParticles.PURPLE_BUBBLE;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return ModParticles.LIGHT_GRAY_BUBBLE;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return ModParticles.GRAY_BUBBLE;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return ModParticles.BLACK_BUBBLE;
        } else {
            return null;
        }
    }

    public static DefaultParticleType GetBloomColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return ModParticles.RED_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return ModParticles.YELLOW_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return ModParticles.GREEN_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return ModParticles.LIME_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return ModParticles.ORANGE_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return ModParticles.WHITE_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return ModParticles.BROWN_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return ModParticles.LIGHT_BLUE_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return ModParticles.BLUE_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return ModParticles.CYAN_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return ModParticles.PINK_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return ModParticles.MAGENTA_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return ModParticles.AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return ModParticles.BLACK_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return ModParticles.LIGHT_GRAY_AMETHYST_BLOOM;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return ModParticles.GRAY_AMETHYST_BLOOM;
        } else {
            return null;
        }
    }

    public static DefaultParticleType getDustColor(ItemStack stack) {
        if (stack.getItem() == Items.RED_DYE) {
            return ModParticles.RED_DUST;
        } else if (stack.getItem() == Items.YELLOW_DYE) {
            return ModParticles.YELLOW_DUST;
        } else if (stack.getItem() == Items.GREEN_DYE) {
            return ModParticles.GREEN_DUST;
        } else if (stack.getItem() == Items.LIME_DYE) {
            return ModParticles.LIME_DUST;
        } else if (stack.getItem() == Items.ORANGE_DYE) {
            return ModParticles.ORANGE_DUST;
        } else if (stack.getItem() == Items.WHITE_DYE) {
            return ModParticles.WHITE_DUST;
        } else if (stack.getItem() == Items.BROWN_DYE) {
            return ModParticles.BROWN_DUST;
        } else if (stack.getItem() == Items.LIGHT_BLUE_DYE) {
            return ModParticles.LIGHT_BLUE_DUST;
        } else if (stack.getItem() == Items.BLUE_DYE) {
            return ModParticles.BLUE_DUST;
        } else if (stack.getItem() == Items.CYAN_DYE) {
            return ModParticles.CYAN_DUST;
        } else if (stack.getItem() == Items.PINK_DYE) {
            return ModParticles.PINK_DUST;
        } else if (stack.getItem() == Items.MAGENTA_DYE) {
            return ModParticles.MAGENTA_DUST;
        } else if (stack.getItem() == Items.PURPLE_DYE) {
            return ModParticles.PURPLE_DUST;
        } else if (stack.getItem() == Items.BLACK_DYE) {
            return ModParticles.BLACK_DUST;
        } else if (stack.getItem() == Items.LIGHT_GRAY_DYE) {
            return ModParticles.LIGHT_GRAY_DUST;
        } else if (stack.getItem() == Items.GRAY_DYE) {
            return ModParticles.GRAY_DUST;
        } else {
            return null;
        }
    }

    public static Block getCauldronFromDye(ItemStack stack) {
        if (stack.getItem() == Items.RED_DYE) {
            return ModBlocks.RED_WATER_CAULDRON;
        } else if (stack.getItem() == Items.YELLOW_DYE) {
            return ModBlocks.YELLOW_WATER_CAULDRON;
        } else if (stack.getItem() == Items.GREEN_DYE) {
            return ModBlocks.GREEN_WATER_CAULDRON;
        } else if (stack.getItem() == Items.LIME_DYE) {
            return ModBlocks.LIME_WATER_CAULDRON;
        } else if (stack.getItem() == Items.ORANGE_DYE) {
            return ModBlocks.ORANGE_WATER_CAULDRON;
        } else if (stack.getItem() == Items.WHITE_DYE) {
            return ModBlocks.WHITE_WATER_CAULDRON;
        } else if (stack.getItem() == Items.BROWN_DYE) {
            return ModBlocks.BROWN_WATER_CAULDRON;
        } else if (stack.getItem() == Items.LIGHT_BLUE_DYE) {
            return ModBlocks.LIGHT_BLUE_WATER_CAULDRON;
        } else if (stack.getItem() == Items.BLUE_DYE) {
            return ModBlocks.BLUE_WATER_CAULDRON;
        } else if (stack.getItem() == Items.CYAN_DYE) {
            return ModBlocks.CYAN_WATER_CAULDRON;
        } else if (stack.getItem() == Items.PINK_DYE) {
            return ModBlocks.PINK_WATER_CAULDRON;
        } else if (stack.getItem() == Items.MAGENTA_DYE) {
            return ModBlocks.MAGENTA_WATER_CAULDRON;
        } else if (stack.getItem() == Items.PURPLE_DYE) {
            return ModBlocks.PURPLE_WATER_CAULDRON;
        } else if (stack.getItem() == Items.BLACK_DYE) {
            return ModBlocks.BLACK_WATER_CAULDRON;
        } else if (stack.getItem() == Items.LIGHT_GRAY_DYE) {
            return ModBlocks.LIGHT_GRAY_WATER_CAULDRON;
        } else if (stack.getItem() == Items.GRAY_DYE) {
            return ModBlocks.GRAY_WATER_CAULDRON;
        } else {
            return null;
        }
    }

    public static boolean compareColors(ItemStack stack, BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON &&
                stack.getItem() == Items.RED_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON &&
                stack.getItem() == Items.YELLOW_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON &&
                stack.getItem() == Items.ORANGE_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON &&
                stack.getItem() == Items.BROWN_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON &&
                stack.getItem() == Items.GREEN_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON &&
                stack.getItem() == Items.LIME_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON &&
                stack.getItem() == Items.PURPLE_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON &&
                stack.getItem() == Items.PINK_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON &&
                stack.getItem() == Items.MAGENTA_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON &&
                stack.getItem() == Items.BLUE_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON &&
                stack.getItem() == Items.LIGHT_BLUE_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON &&
                stack.getItem() == Items.CYAN_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON &&
                stack.getItem() == Items.WHITE_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON &&
                stack.getItem() == Items.LIGHT_GRAY_DYE) {
            return true;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON &&
                stack.getItem() == Items.GRAY_DYE) {
            return true;
        } else return state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON &&
                stack.getItem() == Items.BLACK_DYE;
    }

}
