package net.eps.amethystadds.particle;

import net.eps.amethystadds.AmethystAdditions;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType BLACK_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType BROWN_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType CYAN_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType GRAY_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_BLUE_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_GRAY_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType LIME_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType MAGENTA_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType RED_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType WHITE_AMETHYST_BLOOM = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_AMETHYST_BLOOM = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "citrine_particle"), AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "green_citrine_particle"), GREEN_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "black_citrine_particle"), BLACK_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "blue_citrine_particle"), BLUE_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "brown_citrine_particle"), BROWN_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "cyan_citrine_particle"), CYAN_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "gray_citrine_particle"), GRAY_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_blue_citrine_particle"), LIGHT_BLUE_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_gray_citrine_particle"), LIGHT_GRAY_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "lime_citrine_particle"), LIME_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "magenta_citrine_particle"), MAGENTA_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "orange_citrine_particle"), ORANGE_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "pink_citrine_particle"), PINK_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_citrine_particle"), RED_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "white_citrine_particle"), WHITE_AMETHYST_BLOOM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "yellow_citrine_particle"), YELLOW_AMETHYST_BLOOM);
    }
}
