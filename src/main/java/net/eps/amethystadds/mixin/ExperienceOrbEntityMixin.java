package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.item.custom.AmethystShield;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;



@Mixin(ExperienceOrbEntity.class)
public abstract class ExperienceOrbEntityMixin {

    @Inject(method = "repairPlayerGears", at = @At(value = "HEAD"), cancellable = true)
    private void repairPlayerGearsMixin(PlayerEntity player, int amount, CallbackInfoReturnable<Integer> cir) {
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(Enchantments.MENDING, player, ItemStack::hasEnchantments);

        if (entry != null) {
            ItemStack itemStack = entry.getValue();
            NbtCompound nbt = itemStack.getNbt();

            if (itemStack.isOf(ModItems.AMETHYST_SHIELD)) {
                if (!nbt.contains(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG)) {
                    nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, 0);
                }

                int amethysts = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);

                if (amethysts < 8 && Math.random() > 0.75) {

                    nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, amethysts + 1);
                    cir.setReturnValue(0);
                }
            }
        }
    }

}
