package net.eps.amethystadds.block;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.custom.AmethystBlock;
import net.eps.amethystadds.block.custom.ColoredCauldronBehavior;
import net.eps.amethystadds.block.custom.ColoredWaterCauldron;
import net.eps.amethystadds.block.custom.ModFluidBlock;
import net.eps.amethystadds.fluids.ModFluids;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.Material;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.CAULDRON;

public class ModBlocks {

    public static final Block PURPLE_AMETHYST_BLOCK = registerBlockWithItem("purple_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block GREEN_AMETHYST_BLOCK = registerBlockWithItem("green_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLACK_AMETHYST_BLOCK = registerBlockWithItem("black_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BLUE_AMETHYST_BLOCK = registerBlockWithItem("blue_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block BROWN_AMETHYST_BLOCK = registerBlockWithItem("brown_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block CYAN_AMETHYST_BLOCK = registerBlockWithItem("cyan_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block GRAY_AMETHYST_BLOCK = registerBlockWithItem("gray_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block LIGHT_BLUE_AMETHYST_BLOCK = registerBlockWithItem("light_blue_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block LIGHT_GRAY_AMETHYST_BLOCK = registerBlockWithItem("light_gray_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block LIME_AMETHYST_BLOCK = registerBlockWithItem("lime_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block MAGENTA_AMETHYST_BLOCK = registerBlockWithItem("magenta_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block ORANGE_AMETHYST_BLOCK = registerBlockWithItem("orange_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block PINK_AMETHYST_BLOCK = registerBlockWithItem("pink_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block RED_AMETHYST_BLOCK = registerBlockWithItem("red_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block WHITE_AMETHYST_BLOCK = registerBlockWithItem("white_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block YELLOW_AMETHYST_BLOCK = registerBlockWithItem("yellow_amethyst_block", new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()
                    .luminance(state -> state.get(AmethystBlock.LIT) ? 0 : 0).nonOpaque()), ItemGroup.BUILDING_BLOCKS);

    public static final Block RED_WATER_FLUID_BLOCK = registerBlock("red_water_fluid_block", new ModFluidBlock(ModFluids.RED_WATER_STILL, FabricBlockSettings.of(Material.WATER)
                    .noCollision().nonOpaque().dropsNothing()));

    public static final Block RED_WATER_CAULDRON = registerBlock( "red_water_cauldron", new ColoredWaterCauldron(AbstractBlock.Settings.copy(CAULDRON), LeveledCauldronBlock.RAIN_PREDICATE, CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR, ColoredCauldronBehavior.COLORED_CAULDRON_BEHAVIOR));



    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(AmethystAdditions.MOD_ID, name), block);
    }

    private static Block registerBlockWithItem(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group); return Registry.register(Registry.BLOCK, new Identifier(AmethystAdditions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(AmethystAdditions.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
//        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3495eb, PURPLE_AMETHYST_BLOCK);
        AmethystAdditions.LOGGER.info("Registering ModBlocks for " + AmethystAdditions.MOD_ID);
    }
    
}
