package net.eps.amethystadds.mixin;

import net.eps.amethystadds.item.custom.AmethystShield;
import net.eps.amethystadds.util.AmethystShieldMain;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damageShield(F)V", shift = At.Shift.AFTER))
    private void damageShield(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        AmethystShieldMain.damage(this, source);
    }


    @Shadow protected void initDataTracker() {

    }

    @Shadow public void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Shadow public void writeCustomDataToNbt(NbtCompound nbt) {

    }
}
