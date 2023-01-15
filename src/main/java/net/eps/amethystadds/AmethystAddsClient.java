package net.eps.amethystadds;

import net.eps.amethystadds.fluids.ModFluids;
import net.eps.amethystadds.particle.ModParticles;
import net.eps.amethystadds.particle.custom.CitrineParticle;
import net.eps.amethystadds.particle.custom.ColoredBubbleParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;

public class AmethystAddsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
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

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.RED_WATER_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 11546150));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.RED_WATER_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 11546150));



    }
}
