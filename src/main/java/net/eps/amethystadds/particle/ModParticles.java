package net.eps.amethystadds.particle;

import net.eps.amethystadds.AmethystAdditions;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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

    public static final DefaultParticleType RED_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType LIME_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType WHITE_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BROWN_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_BLUE_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType CYAN_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType MAGENTA_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_GRAY_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GRAY_BUBBLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLACK_BUBBLE = FabricParticleTypes.simple();

    public static final DefaultParticleType RED_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType BROWN_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType LIME_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_BLUE_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType CYAN_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType MAGENTA_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType WHITE_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType LIGHT_GRAY_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType GRAY_DUST = FabricParticleTypes.simple();
    public static final DefaultParticleType BLACK_DUST = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "citrine_particle"), AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "green_citrine_particle"), GREEN_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "black_citrine_particle"), BLACK_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "blue_citrine_particle"), BLUE_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "brown_citrine_particle"), BROWN_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "cyan_citrine_particle"), CYAN_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "gray_citrine_particle"), GRAY_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_blue_citrine_particle"), LIGHT_BLUE_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_gray_citrine_particle"), LIGHT_GRAY_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "lime_citrine_particle"), LIME_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "magenta_citrine_particle"), MAGENTA_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "orange_citrine_particle"), ORANGE_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "pink_citrine_particle"), PINK_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_citrine_particle"), RED_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "white_citrine_particle"), WHITE_AMETHYST_BLOOM);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "yellow_citrine_particle"), YELLOW_AMETHYST_BLOOM);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_bubble_particle"), RED_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "yellow_bubble_particle"), YELLOW_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "green_bubble_particle"), GREEN_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "lime_bubble_particle"), LIME_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "orange_bubble_particle"), ORANGE_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "white_bubble_particle"), WHITE_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "brown_bubble_particle"), BROWN_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_blue_bubble_particle"), LIGHT_BLUE_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "blue_bubble_particle"), BLUE_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "cyan_bubble_particle"), CYAN_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "pink_bubble_particle"), PINK_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "magenta_bubble_particle"), MAGENTA_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "purple_bubble_particle"), PURPLE_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_gray_bubble_particle"), LIGHT_GRAY_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "gray_bubble_particle"), GRAY_BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "black_bubble_particle"), BLACK_BUBBLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_dust_particle"), RED_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "yellow_dust_particle"), YELLOW_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "orange_dust_particle"), ORANGE_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "brown_dust_particle"), BROWN_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "lime_dust_particle"), LIME_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "green_dust_particle"), GREEN_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_blue_dust_particle"), LIGHT_BLUE_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "cyan_dust_particle"), CYAN_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "blue_dust_particle"), BLUE_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "purple_dust_particle"), PURPLE_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "magenta_dust_particle"), MAGENTA_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "pink_dust_particle"), PINK_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "white_dust_particle"), WHITE_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "light_gray_dust_particle"), LIGHT_GRAY_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "gray_dust_particle"), GRAY_DUST);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(AmethystAdditions.MOD_ID, "black_dust_particle"), BLACK_DUST);
    }
}
