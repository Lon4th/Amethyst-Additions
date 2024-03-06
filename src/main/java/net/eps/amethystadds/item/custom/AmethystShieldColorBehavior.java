package net.eps.amethystadds.item.custom;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.client.entity.AmethystShieldEntityModel;
import net.eps.amethystadds.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;

import java.util.HashMap;

public interface AmethystShieldColorBehavior {
    public static HashMap<Integer, VertexConsumer> SHARD_COLOR_TO_VERTEX = new HashMap<>();
    public static HashMap<Integer, VertexConsumer> BASE_COLOR_TO_VERTEX = new HashMap<>();

    public static void registerShardColorBehavior(SpriteIdentifier purple, SpriteIdentifier red, SpriteIdentifier orange, SpriteIdentifier yellow, SpriteIdentifier brown, SpriteIdentifier magenta, SpriteIdentifier pink, SpriteIdentifier white, SpriteIdentifier light_gray, SpriteIdentifier gray, SpriteIdentifier black, SpriteIdentifier green, SpriteIdentifier lime, SpriteIdentifier blue, SpriteIdentifier light_blue, SpriteIdentifier cyan, VertexConsumerProvider consumers, AmethystShieldEntityModel model, ItemStack stack) {
        SHARD_COLOR_TO_VERTEX.put(0, white.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(white.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(1, orange.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(orange.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(2, magenta.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(magenta.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(3, light_blue.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(light_blue.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(4, yellow.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(yellow.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(5, lime.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(lime.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(6, pink.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(pink.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(7, gray.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(gray.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(8, light_gray.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(light_gray.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(9, cyan.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(cyan.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(10, purple.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(purple.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(11, blue.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(blue.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(12, brown.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(brown.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(13, green.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(green.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(14, red.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(red.getAtlasId()), false, stack.hasGlint())));
        SHARD_COLOR_TO_VERTEX.put(15, black.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(black.getAtlasId()), false, stack.hasGlint())));
    }
    public static void registerBaseColorBehavior(SpriteIdentifier purple, SpriteIdentifier red, SpriteIdentifier orange, SpriteIdentifier yellow, SpriteIdentifier brown, SpriteIdentifier magenta, SpriteIdentifier pink, SpriteIdentifier white, SpriteIdentifier light_gray, SpriteIdentifier gray, SpriteIdentifier black, SpriteIdentifier green, SpriteIdentifier lime, SpriteIdentifier blue, SpriteIdentifier light_blue, SpriteIdentifier cyan, VertexConsumerProvider consumers, AmethystShieldEntityModel model, ItemStack stack) {
        BASE_COLOR_TO_VERTEX.put(0, white.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(white.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(1, orange.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(orange.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(2, magenta.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(magenta.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(3, light_blue.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(light_blue.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(4, yellow.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(yellow.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(5, lime.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(lime.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(6, pink.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(pink.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(7, gray.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(gray.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(8, light_gray.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(light_gray.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(9, cyan.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(cyan.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(10, purple.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(purple.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(11, blue.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(blue.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(12, brown.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(brown.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(13, green.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(green.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(14, red.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(red.getAtlasId()), false, stack.hasGlint())));
        BASE_COLOR_TO_VERTEX.put(15, black.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(consumers, model.getLayer(black.getAtlasId()), false, stack.hasGlint())));
    }

    public static int getColorOnSlot(ItemStack stack) {
        if (stack.getItem() == ModItems.BLACK_AMETHYST) {
            return 15;
        } else if (stack.getItem() == ModItems.BLUE_AMETHYST) {
            return 11;
        } else if (stack.getItem() == ModItems.BROWN_AMETHYST) {
            return 12;
        } else if (stack.getItem() == ModItems.GRAY_AMETHYST) {
            return 7;
        } else if (stack.getItem() == ModItems.LIGHT_GRAY_AMETHYST) {
            return 8;
        } else if (stack.getItem() == ModItems.LIGHT_BLUE_AMETHYST) {
            return 3;
        } else if (stack.getItem() == ModItems.WHITE_AMETHYST) {
            return 0;
        } else if (stack.getItem() == ModItems.GREEN_AMETHYST) {
            return 13;
        } else if (stack.getItem() == ModItems.LIME_AMETHYST) {
            return 5;
        } else if (stack.getItem() == ModItems.CYAN_AMETHYST) {
            return 9;
        } else if (stack.getItem() == ModItems.MAGENTA_AMETHYST) {
            return 2;
        } else if (stack.getItem() == ModItems.ORANGE_AMETHYST) {
            return 1;
        } else if (stack.getItem() == ModItems.PINK_AMETHYST) {
            return 6;
        } else if (stack.getItem() == ModItems.RED_AMETHYST) {
            return 14;
        } else if (stack.getItem() == ModItems.YELLOW_AMETHYST) {
            return 4;
        } else {
            return 10;
        }
    }

    public static int getIdFromAmethystCount(int count) {
        if (count == 0) {
            return 8;
        } else if (count == 1) {
            return 7;
        } else if (count == 2) {
            return 6;
        } else if (count == 3) {
            return 5;
        } else if (count == 4) {
            return 3;
        } else if (count == 5) {
            return 2;
        } else if (count == 6) {
            return 1;
        } else if (count == 7) {
            return 0;
        } else { return 8; }
    }

    public static int getIdForParticlesFromAmethystCount(int count) {
        if (count == 8) {
            return 0;
        } else if (count == 7) {
            return 1;
        } else if (count == 6) {
            return 2;
        } else if (count == 5) {
            return 3;
        } else if (count == 4) {
            return 5;
        } else if (count == 3) {
            return 6;
        } else if (count == 2) {
            return 7;
        } else if (count == 1) {
            return 8;
        } else { return 0; }
    }

    public static BlockStateParticleEffect getParticleFromColor(int color) {
        Block particlePattern = Blocks.AMETHYST_BLOCK;
        if (color == 0) {
            particlePattern = ModBlocks.WHITE_AMETHYST_CLUSTER;
        } else if (color == 1) {
            particlePattern = ModBlocks.ORANGE_AMETHYST_CLUSTER;
        } else if (color == 2) {
            particlePattern = ModBlocks.MAGENTA_AMETHYST_CLUSTER;
        } else if (color == 3) {
            particlePattern = ModBlocks.LIGHT_BLUE_AMETHYST_CLUSTER;
        } else if (color == 4) {
            particlePattern = ModBlocks.YELLOW_AMETHYST_CLUSTER;
        } else if (color == 5) {
            particlePattern = ModBlocks.LIME_AMETHYST_CLUSTER;
        } else if (color == 6) {
            particlePattern = ModBlocks.PINK_AMETHYST_CLUSTER;
        } else if (color == 7) {
            particlePattern = ModBlocks.GRAY_AMETHYST_CLUSTER;
        } else if (color == 8) {
            particlePattern = ModBlocks.LIGHT_GRAY_AMETHYST_CLUSTER;
        } else if (color == 9) {
            particlePattern = ModBlocks.CYAN_AMETHYST_CLUSTER;
        } else if (color == 11) {
            particlePattern = ModBlocks.BLUE_AMETHYST_CLUSTER;
        } else if (color == 12) {
            particlePattern = ModBlocks.BROWN_AMETHYST_CLUSTER;
        } else if (color == 13) {
            particlePattern = ModBlocks.GREEN_AMETHYST_CLUSTER;
        } else if (color == 14) {
            particlePattern = ModBlocks.RED_AMETHYST_CLUSTER;
        } else if (color == 15) {
            particlePattern = ModBlocks.BLACK_AMETHYST_CLUSTER;
        }
        return new BlockStateParticleEffect(ParticleTypes.BLOCK, particlePattern.getDefaultState());
    }

}
