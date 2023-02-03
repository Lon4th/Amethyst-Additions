package net.eps.amethystadds.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class DyeDustParticle extends SpriteBillboardParticle {
    protected DyeDustParticle(ClientWorld level, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double velocityX, double velocityY, double velocityZ) {
        super(level, xCoord, yCoord, zCoord, velocityX, velocityY, velocityZ);
        this.velocityMultiplier = 0.4f;
        this.scale = 0.1f;

        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;

        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.maxAge = (int) ((Math.random() + 1) * 20);
        this.setSpriteForAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.maxAge-- <= 0) {
            this.markDead();
        }
        if (this.onGround) {
            this.velocityMultiplier = 0.1f;
        }
        if ((this.velocityX <= 0.1 && this.velocityX >= -0.1) && (this.velocityY <= 0.1 && this.velocityY >= -0.1) && (this.velocityZ <= 0.1 && this.velocityZ >= -0.1) && !this.onGround) {
            this.velocityMultiplier = 0.999f;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(value=EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            DyeDustParticle dustParticle = new DyeDustParticle(level, x, y, z, this.sprites, velocityX, velocityY, velocityZ);
            dustParticle.setSprite(sprites.getSprite(level.random));
            return dustParticle;
        }
    }
}
