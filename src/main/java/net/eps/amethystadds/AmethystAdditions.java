package net.eps.amethystadds;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.entity.ModBlockEntities;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.eps.amethystadds.block.ModBlocks.*;

public class AmethystAdditions implements ModInitializer {
	public static final String MOD_ID = "amethystadds";
	public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), PURPLE_AMETHYST_BLOCK, GREEN_AMETHYST_BLOCK, BLACK_AMETHYST_BLOCK, BLUE_AMETHYST_BLOCK, BROWN_AMETHYST_BLOCK, CYAN_AMETHYST_BLOCK, GRAY_AMETHYST_BLOCK, LIGHT_BLUE_AMETHYST_BLOCK, LIGHT_GRAY_AMETHYST_BLOCK, LIME_AMETHYST_BLOCK, MAGENTA_AMETHYST_BLOCK, ORANGE_AMETHYST_BLOCK, PINK_AMETHYST_BLOCK, RED_AMETHYST_BLOCK, WHITE_AMETHYST_BLOCK, YELLOW_AMETHYST_BLOCK);

		ModParticles.registerParticles();
	}
}
