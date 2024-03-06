package net.eps.amethystadds;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.client.entity.AmethystShieldEntityModel;
import net.eps.amethystadds.client.entity.ColoredAllayModel;
import net.eps.amethystadds.client.entity.ColoredAllayRenderer;
import net.eps.amethystadds.entity.ModEntities;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.eps.amethystadds.particle.ModParticles;
import net.eps.amethystadds.particle.custom.CitrineParticle;
import net.eps.amethystadds.particle.custom.ColoredBubbleParticle;
import net.eps.amethystadds.particle.custom.DyeDustParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AmethystAddsClient implements ClientModInitializer {

    public static final EntityModelLayer AMETHYST_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier( AmethystAdditions.MOD_ID, "amethyst_shield"),"main");
    public static final EntityModelLayer AMETHYST_SHIELD_SHARDS_MODEL_LAYER = new EntityModelLayer(new Identifier( AmethystAdditions.MOD_ID, "amethyst_shield"),"shards");
    public static final EntityModelLayer COLORED_ALLAY = new EntityModelLayer(new Identifier(AmethystAdditions.MOD_ID, "allay"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(AMETHYST_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(AMETHYST_SHIELD_SHARDS_MODEL_LAYER, AmethystShieldEntityModel::getShardTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(COLORED_ALLAY, ColoredAllayModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.RED_ALLAY, ColoredAllayRenderer::new);



        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_RED_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_ORANGE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_YELLOW_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_BROWN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_WHITE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LIGHT_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_BLACK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LIGHT_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_CYAN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_MAGENTA_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_PINK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GREEN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LIME_AMETHYST_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_RED_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_ORANGE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_YELLOW_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BROWN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_WHITE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LIGHT_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BLACK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LIGHT_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_CYAN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_MAGENTA_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_PINK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GREEN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LIME_AMETHYST_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_RED_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_ORANGE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_YELLOW_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BROWN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WHITE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LIGHT_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BLACK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_MAGENTA_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_PINK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LIGHT_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CYAN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GREEN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LIME_AMETHYST_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_RED_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_ORANGE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_YELLOW_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_BROWN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_WHITE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_LIGHT_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_GRAY_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_BLACK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_MAGENTA_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_PINK_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_LIGHT_BLUE_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_CYAN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_GREEN_AMETHYST_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWN_LIME_AMETHYST_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPLE_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_GRAY_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAY_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_BLUE_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYAN_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGENTA_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_AMETHYST_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_AMETHYST_LAMP, RenderLayer.getCutout());

        /* REGISTERING TEXTURES */

        /*ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_base_nopattern"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_purple_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_red_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_orange_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_yellow_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_brown_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_magenta_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_pink_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_white_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_light_gray_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_gray_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_black_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_green_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_lime_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_blue_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_light_blue_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_cyan_v5"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_red"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_orange"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_yellow"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_brown"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_purple"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_magenta"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_pink"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_black"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_gray"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_light_gray"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_white"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_green"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_lime"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_blue"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_cyan"));
            registry.register(new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_light_blue"));
        });

         */

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
