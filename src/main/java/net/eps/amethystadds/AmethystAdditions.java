package net.eps.amethystadds;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.entity.AmethystBlockEntity;
import net.eps.amethystadds.block.custom.entity.ModBlockEntities;
//import net.eps.amethystadds.block.custom.entity.WaterCauldronBlockEntity;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.particle.ModParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.eps.amethystadds.block.ModBlocks.*;

public class AmethystAdditions implements ModInitializer {
	public static final String MOD_ID = "amethystadds";
	public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Environment(EnvType.CLIENT)
	public static void rebuildBlock(BlockPos pos) {
		MinecraftClient.getInstance().worldRenderer.scheduleBlockRenders(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), PURPLE_AMETHYST_BLOCK, GREEN_AMETHYST_BLOCK, BLACK_AMETHYST_BLOCK, BLUE_AMETHYST_BLOCK, BROWN_AMETHYST_BLOCK, CYAN_AMETHYST_BLOCK, GRAY_AMETHYST_BLOCK, LIGHT_BLUE_AMETHYST_BLOCK, LIGHT_GRAY_AMETHYST_BLOCK, LIME_AMETHYST_BLOCK, MAGENTA_AMETHYST_BLOCK, ORANGE_AMETHYST_BLOCK, PINK_AMETHYST_BLOCK, RED_AMETHYST_BLOCK, WHITE_AMETHYST_BLOCK, YELLOW_AMETHYST_BLOCK);

		ModParticles.registerParticles();
	}
}
