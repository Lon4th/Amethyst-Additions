package net.eps.amethystadds.block.custom;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.DyeColor;

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
            return Blocks.RED_SHULKER_BOX;
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

    public static Block GetAmethystColor(BlockState state) {
        if (state.getBlock() == ModBlocks.RED_WATER_CAULDRON) {
            return ModBlocks.RED_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.YELLOW_WATER_CAULDRON) {
            return ModBlocks.YELLOW_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.GREEN_WATER_CAULDRON) {
            return ModBlocks.GREEN_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.LIME_WATER_CAULDRON) {
            return ModBlocks.LIME_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.ORANGE_WATER_CAULDRON) {
            return ModBlocks.ORANGE_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.WHITE_WATER_CAULDRON) {
            return ModBlocks.WHITE_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.BROWN_WATER_CAULDRON) {
            return ModBlocks.BROWN_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.LIGHT_BLUE_WATER_CAULDRON) {
            return ModBlocks.LIGHT_BLUE_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.BLUE_WATER_CAULDRON) {
            return ModBlocks.BLUE_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.CYAN_WATER_CAULDRON) {
            return ModBlocks.CYAN_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.PINK_WATER_CAULDRON) {
            return ModBlocks.PINK_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.MAGENTA_WATER_CAULDRON) {
            return ModBlocks.MAGENTA_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.PURPLE_WATER_CAULDRON) {
            return ModBlocks.PURPLE_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.LIGHT_GRAY_WATER_CAULDRON) {
            return ModBlocks.LIGHT_GRAY_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.GRAY_WATER_CAULDRON) {
            return ModBlocks.GRAY_AMETHYST_BLOCK;
        } else if (state.getBlock() == ModBlocks.BLACK_WATER_CAULDRON) {
            return ModBlocks.BLACK_AMETHYST_BLOCK;
        } else {
            return null;
        }
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
        } else {
            return null;
        }
    }

}
