package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.entity.ModEntities;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;

@Mixin(AllayEntity.class)
public abstract class AllayEntityMixin extends PathAwareEntity {

    @Shadow public abstract boolean isDancing();

    @Shadow protected abstract boolean canDuplicate();

    @Shadow protected abstract void duplicate();

    @Shadow protected abstract void decrementStackUnlessInCreative(PlayerEntity player, ItemStack stack);

    @Shadow public abstract void writeCustomDataToNbt(NbtCompound nbt);

    @Shadow public abstract void startDuplicationCooldown();

    protected AllayEntityMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    private void createColoredAllay(int allayColor) {
        ColoredAllayEntity allayEntity = ModEntities.RED_ALLAY.create(this.world);
        if (allayEntity != null) {
            allayEntity.refreshPositionAfterTeleport(this.getPos());
            allayEntity.setPersistent();
            allayEntity.startDuplicationCooldown();
            allayEntity.setAllayColor(allayColor);
            allayEntity.spawnParticles(this.world);
            this.startDuplicationCooldown();
            this.world.spawnEntity(allayEntity);
        }

    }



    @Inject(method = "interactMob", at = @At(value = "HEAD"), cancellable = true)
    protected void interactMobMixin(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (this.isDancing() && (itemStack.getItem() instanceof ColoredAmethyst || itemStack.isOf(Items.AMETHYST_SHARD)) && this.canDuplicate()) {
            int amethystColor = itemStack.getItem() instanceof ColoredAmethyst amethyst ? amethyst.getColor() : 10;
            if (amethystColor == 3) {
                this.duplicate();
            } else {
                this.createColoredAllay(amethystColor);
            }
            this.world.sendEntityStatus(this, (byte)18);
            this.world.playSoundFromEntity(player, this, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.NEUTRAL, 2.0F, 1.0F);
            this.decrementStackUnlessInCreative(player, itemStack);
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}
