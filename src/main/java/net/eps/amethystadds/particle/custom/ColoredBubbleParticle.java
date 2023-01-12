package net.eps.amethystadds.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;

public class ColoredBubbleParticle extends SpriteBillboardParticle {
    ColoredBubbleParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f);
        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.scale *= this.random.nextFloat() + 0.2f;
        this.velocityX = g * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.velocityY = h * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.velocityZ = i * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.maxAge = (int)(2.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(value=EnvType.CLIENT)
    public static class Factory
            implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            ColoredBubbleParticle coloredBubbleParticle = new ColoredBubbleParticle(clientWorld, d, e, f, g, h, i);
            coloredBubbleParticle.setSprite(this.spriteProvider);
            return coloredBubbleParticle;
        }
    }
}
