package net.eps.amethystadds.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

public class CitrineParticle extends SpriteBillboardParticle {
    protected CitrineParticle(ClientWorld level, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.1f;
        this.scale *= 0.75F;
        this.maxAge = level.random.nextInt(50) + 10;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public int getBrightness(float tint) {
        float f = ((float)this.age + tint) / (float)this.maxAge;
        f = MathHelper.clamp(f, 0.0f, 1.0f);
        int i = super.getBrightness(tint);
        int j = i & 0xFF;
        int k = i >> 16 & 0xFF;
        if ((j += (int)(f * 15.0f * 16.0f)) > 240) {
            j = 240;
        }
        return j | k << 16;
    }

    @Override
   public void tick() {
        super.tick();
        fadeOut();
   }

    private void fadeOut() {
        if (age <= 20){
            this.alpha = (-(1 / (float) 20) * age + 1);
        } else {
            this.alpha = 0;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double dx, double dy, double dz) {
            CitrineParticle citrineparticle = new CitrineParticle(level, x, y, z, this.sprites, 0.0, 0.0, 0.0);
//            citrineparticle.setVelocity(dx * 0.01, dy * 0.01, dz * 0.01);
            return citrineparticle;
        }
    }
}
