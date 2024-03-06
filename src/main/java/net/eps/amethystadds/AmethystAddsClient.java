package net.eps.amethystadds;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.client.entity.AmethystShieldEntityModel;
import net.eps.amethystadds.client.entity.ColoredAllayModel;
import net.eps.amethystadds.client.entity.ColoredAllayRenderer;
import net.eps.amethystadds.entity.ModEntities;
import net.eps.amethystadds.particle.ModParticles;
import net.eps.amethystadds.particle.custom.CitrineParticle;
import net.eps.amethystadds.particle.custom.ColoredBubbleParticle;
import net.eps.amethystadds.particle.custom.DyeDustParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.util.Identifier;

import static net.eps.amethystadds.block.ModBlocks.*;

public class AmethystAddsClient implements ClientModInitializer {

    public static final EntityModelLayer AMETHYST_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier( AmethystAdditions.MOD_ID, "amethyst_shield"),"main");
    public static final EntityModelLayer AMETHYST_SHIELD_SHARDS_MODEL_LAYER = new EntityModelLayer(new Identifier( AmethystAdditions.MOD_ID, "amethyst_shield"),"shards");
    public static final EntityModelLayer COLORED_ALLAY = new EntityModelLayer(new Identifier(AmethystAdditions.MOD_ID, "allay"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(AMETHYST_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(AMETHYST_SHIELD_SHARDS_MODEL_LAYER, AmethystShieldEntityModel::getShardTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(COLORED_ALLAY, ColoredAllayModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.COLORED_ALLAY, ColoredAllayRenderer::new);

        /* BLOCK RENDERS */

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), PURPLE_AMETHYST_BLOCK, GREEN_AMETHYST_BLOCK, BLACK_AMETHYST_BLOCK, BLUE_AMETHYST_BLOCK, BROWN_AMETHYST_BLOCK, CYAN_AMETHYST_BLOCK, GRAY_AMETHYST_BLOCK, LIGHT_BLUE_AMETHYST_BLOCK, LIGHT_GRAY_AMETHYST_BLOCK, LIME_AMETHYST_BLOCK, MAGENTA_AMETHYST_BLOCK, ORANGE_AMETHYST_BLOCK, PINK_AMETHYST_BLOCK, RED_AMETHYST_BLOCK, WHITE_AMETHYST_BLOCK, YELLOW_AMETHYST_BLOCK,
                RED_TINTED_GLASS, ORANGE_TINTED_GLASS, YELLOW_TINTED_GLASS, BROWN_TINTED_GLASS, GREEN_TINTED_GLASS, LIME_TINTED_GLASS, BLUE_TINTED_GLASS, LIGHT_BLUE_TINTED_GLASS, CYAN_TINTED_GLASS, LIGHT_GRAY_TINTED_GLASS, GRAY_TINTED_GLASS, WHITE_TINTED_GLASS, BLACK_TINTED_GLASS, MAGENTA_TINTED_GLASS, PINK_TINTED_GLASS);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                SMALL_RED_AMETHYST_BUD, SMALL_ORANGE_AMETHYST_BUD, SMALL_YELLOW_AMETHYST_BUD, SMALL_BROWN_AMETHYST_BUD, SMALL_WHITE_AMETHYST_BUD, SMALL_LIGHT_GRAY_AMETHYST_BUD, SMALL_GRAY_AMETHYST_BUD, SMALL_BLACK_AMETHYST_BUD, SMALL_BLUE_AMETHYST_BUD, SMALL_LIGHT_BLUE_AMETHYST_BUD, SMALL_CYAN_AMETHYST_BUD, SMALL_MAGENTA_AMETHYST_BUD, SMALL_PINK_AMETHYST_BUD, SMALL_GREEN_AMETHYST_BUD, SMALL_LIME_AMETHYST_BUD,
                MEDIUM_RED_AMETHYST_BUD, MEDIUM_ORANGE_AMETHYST_BUD, MEDIUM_YELLOW_AMETHYST_BUD, MEDIUM_BROWN_AMETHYST_BUD, MEDIUM_WHITE_AMETHYST_BUD, MEDIUM_LIGHT_GRAY_AMETHYST_BUD, MEDIUM_GRAY_AMETHYST_BUD, MEDIUM_BLACK_AMETHYST_BUD, MEDIUM_BLUE_AMETHYST_BUD, MEDIUM_LIGHT_BLUE_AMETHYST_BUD, MEDIUM_CYAN_AMETHYST_BUD, MEDIUM_MAGENTA_AMETHYST_BUD, MEDIUM_PINK_AMETHYST_BUD, MEDIUM_GREEN_AMETHYST_BUD, MEDIUM_LIME_AMETHYST_BUD,
                LARGE_RED_AMETHYST_BUD, LARGE_ORANGE_AMETHYST_BUD, LARGE_YELLOW_AMETHYST_BUD, LARGE_BROWN_AMETHYST_BUD, LARGE_WHITE_AMETHYST_BUD, LARGE_LIGHT_GRAY_AMETHYST_BUD, LARGE_GRAY_AMETHYST_BUD, LARGE_BLACK_AMETHYST_BUD, LARGE_MAGENTA_AMETHYST_BUD, LARGE_PINK_AMETHYST_BUD, LARGE_BLUE_AMETHYST_BUD, LARGE_LIGHT_BLUE_AMETHYST_BUD, LARGE_CYAN_AMETHYST_BUD, LARGE_GREEN_AMETHYST_BUD, LARGE_LIME_AMETHYST_BUD,
                GROWN_RED_AMETHYST_BUD, GROWN_ORANGE_AMETHYST_BUD, GROWN_YELLOW_AMETHYST_BUD, GROWN_BROWN_AMETHYST_BUD, GROWN_WHITE_AMETHYST_BUD, GROWN_LIGHT_GRAY_AMETHYST_BUD, GROWN_GRAY_AMETHYST_BUD, GROWN_BLACK_AMETHYST_BUD, GROWN_MAGENTA_AMETHYST_BUD, GROWN_PINK_AMETHYST_BUD, GROWN_BLUE_AMETHYST_BUD, GROWN_LIGHT_BLUE_AMETHYST_BUD, GROWN_CYAN_AMETHYST_BUD, GROWN_GREEN_AMETHYST_BUD, GROWN_LIME_AMETHYST_BUD,
                PURPLE_AMETHYST_LAMP, RED_AMETHYST_LAMP, ORANGE_AMETHYST_LAMP, YELLOW_AMETHYST_LAMP, BROWN_AMETHYST_LAMP, WHITE_AMETHYST_LAMP, LIGHT_GRAY_AMETHYST_LAMP, GRAY_AMETHYST_LAMP, BLACK_AMETHYST_LAMP, BLUE_AMETHYST_LAMP, LIGHT_BLUE_AMETHYST_LAMP, CYAN_AMETHYST_LAMP, MAGENTA_AMETHYST_LAMP, PINK_AMETHYST_LAMP, GREEN_AMETHYST_LAMP, LIME_AMETHYST_LAMP);

        /* REGISTERING PARTICLES */

        ParticleFactoryRegistry.getInstance().register(ModParticles.AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLACK_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BROWN_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CYAN_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GRAY_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_BLUE_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_GRAY_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIME_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGENTA_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WHITE_AMETHYST_BLOOM, CitrineParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_AMETHYST_BLOOM, CitrineParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIME_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WHITE_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BROWN_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_BLUE_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CYAN_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGENTA_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PURPLE_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_GRAY_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GRAY_BUBBLE, ColoredBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLACK_BUBBLE, ColoredBubbleParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BROWN_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIME_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_BLUE_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CYAN_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PURPLE_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGENTA_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WHITE_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_GRAY_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GRAY_DUST, DyeDustParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLACK_DUST, DyeDustParticle.Factory::new);
    }
}
