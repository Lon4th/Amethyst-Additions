package net.eps.amethystadds;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.entity.ModBlockEntities;
import net.eps.amethystadds.entity.ModEntities;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmethystAdditions implements ModInitializer {

	public static final String MOD_ID = "amethystadds";
	public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	public static final String GLINT_COLOR_NBT_TAG = "amethystadds:hasGlint";
	public static final String AMETHYST_COUNTER_NBT_TAG = "amethystadds:amethysts";

	public static final String AMETHYST_COLOR_ON_SLOT_0 = "amethystadds:amethyst_color_0";
	public static final String AMETHYST_COLOR_ON_SLOT_1 = "amethystadds:amethyst_color_1";
	public static final String AMETHYST_COLOR_ON_SLOT_2 = "amethystadds:amethyst_color_2";
	public static final String AMETHYST_COLOR_ON_SLOT_3 = "amethystadds:amethyst_color_3";
	public static final String AMETHYST_COLOR_ON_SLOT_5 = "amethystadds:amethyst_color_5";
	public static final String AMETHYST_COLOR_ON_SLOT_6 = "amethystadds:amethyst_color_6";
	public static final String AMETHYST_COLOR_ON_SLOT_7 = "amethystadds:amethyst_color_7";
	public static final String AMETHYST_COLOR_ON_SLOT_8 = "amethystadds:amethyst_color_8";

	public static final String ALLAY_COLOR = "amethystadds:allay_color";

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();

		ModParticles.registerParticles();

		FabricDefaultAttributeRegistry.register(ModEntities.COLORED_ALLAY, ColoredAllayEntity.createAllayAttributes());
	}
}
