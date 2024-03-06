package net.eps.amethystadds.entity.custom;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.entity.ModEntities;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.mixin.AllayEntityMixin;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.EntityPositionSource;
import net.minecraft.world.event.PositionSource;


public class ColoredAllayEntity extends AllayEntity {

    private static final TrackedData<Integer> ALLAY_COLOR;

    public ColoredAllayEntity(EntityType<? extends AllayEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ALLAY_COLOR, 3);
    }

    public void setAllayColor(int newAllayColor) {
        this.dataTracker.set(ALLAY_COLOR, newAllayColor);
    }

    public int getAllayColor() {
        return this.dataTracker.get(ALLAY_COLOR);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt(AmethystAdditions.ALLAY_COLOR, this.getAllayColor());
        super.writeCustomDataToNbt(nbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.dataTracker.set(ALLAY_COLOR, nbt.getInt(AmethystAdditions.ALLAY_COLOR));
        super.readCustomDataFromNbt(nbt);
    }

    public void spawnParticles(World world) {
        PositionSource positionSource = new EntityPositionSource(this, this.getStandingEyeHeight());
        Random random = world.getRandom();

        if ( world.isClient ) {
            ParticleEffect particle = ModParticles.AMETHYST_BLOOM;

            if (this.dataTracker.get(ALLAY_COLOR) == 0) {
                particle = ModParticles.WHITE_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 1) {
                particle = ModParticles.ORANGE_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 2) {
                particle = ModParticles.MAGENTA_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 3) {
                particle = ModParticles.LIGHT_BLUE_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 4) {
                particle = ModParticles.YELLOW_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 5) {
                particle = ModParticles.LIME_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 6) {
                particle = ModParticles.PINK_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 7) {
                particle = ModParticles.GRAY_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 8) {
                particle = ModParticles.LIGHT_GRAY_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 9) {
                particle = ModParticles.CYAN_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 11) {
                particle = ModParticles.BLUE_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 12) {
                particle = ModParticles.BROWN_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 13) {
                particle = ModParticles.GREEN_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 14) {
                particle = ModParticles.RED_AMETHYST_BLOOM;
            } else if (this.dataTracker.get(ALLAY_COLOR) == 15) {
                particle = ModParticles.BLACK_AMETHYST_BLOOM;
            }


            for (int r = 0; r < random.nextBetweenExclusive(9, 20); r++){

                world.addImportantParticle(particle, positionSource.getPos(world).get().x + random.nextBetween(-1, 1) * 0.8, positionSource.getPos(world).get().y + random.nextBetween(-1, 1) * 0.8, positionSource.getPos(world).get().z + random.nextBetween(-1, 1) * 0.8, 0, 0, 0);
            }
        }
    }

    static {
        ALLAY_COLOR = DataTracker.registerData(ColoredAllayEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
