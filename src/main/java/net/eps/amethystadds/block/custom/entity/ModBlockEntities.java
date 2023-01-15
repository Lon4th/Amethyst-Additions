package net.eps.amethystadds.block.custom.entity;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.ModBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.eps.amethystadds.AmethystAdditions.MOD_ID;
import static net.eps.amethystadds.block.ModBlocks.*;


public class ModBlockEntities {
    public static BlockEntityType<AmethystBlockEntity> AMETHYST_BLOCK;
    public static BlockEntityType<ColoredCauldronBlockEntity> COLORED_CAULDRON_BLOCK;

    public static void registerAllBlockEntities() {
        AMETHYST_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "amethyst_block"),
                FabricBlockEntityTypeBuilder.create(AmethystBlockEntity::new, PURPLE_AMETHYST_BLOCK, GREEN_AMETHYST_BLOCK, BLACK_AMETHYST_BLOCK, BLUE_AMETHYST_BLOCK, BROWN_AMETHYST_BLOCK, CYAN_AMETHYST_BLOCK, GRAY_AMETHYST_BLOCK, LIGHT_BLUE_AMETHYST_BLOCK, LIGHT_GRAY_AMETHYST_BLOCK, LIME_AMETHYST_BLOCK, MAGENTA_AMETHYST_BLOCK, ORANGE_AMETHYST_BLOCK, PINK_AMETHYST_BLOCK, RED_AMETHYST_BLOCK, WHITE_AMETHYST_BLOCK, YELLOW_AMETHYST_BLOCK).build(null));
        COLORED_CAULDRON_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "colored_cauldron_block"),
                FabricBlockEntityTypeBuilder.create(ColoredCauldronBlockEntity::new, RED_WATER_CAULDRON, YELLOW_WATER_CAULDRON, GREEN_WATER_CAULDRON, LIME_WATER_CAULDRON, ORANGE_WATER_CAULDRON, WHITE_WATER_CAULDRON, BROWN_WATER_CAULDRON, LIGHT_BLUE_WATER_CAULDRON, BLUE_WATER_CAULDRON, CYAN_WATER_CAULDRON, PINK_WATER_CAULDRON, MAGENTA_WATER_CAULDRON, PURPLE_WATER_CAULDRON, LIGHT_GRAY_WATER_CAULDRON, GRAY_WATER_CAULDRON, BLACK_WATER_CAULDRON).build(null));
    }
}
