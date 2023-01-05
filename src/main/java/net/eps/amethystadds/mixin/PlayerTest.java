package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerTest {

//    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"))
    public void dropItem0(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        AmethystAdditions.LOGGER.info(player.getDisplayName().toString());
    }

//    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    public void dropItem1(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        AmethystAdditions.LOGGER.info(String.valueOf(cir.getReturnValue() != null));

        double d = player.getEyeY() - 0.30000001192092896D;
        ItemEntity itemEntity = new ItemEntity(player.getWorld(), player.getX(), d, player.getZ(), stack);
        cir.setReturnValue(itemEntity);
    }
}
