package net.eps.amethystadds.mixin;

import net.eps.amethystadds.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {

    @Shadow
    @Final
    private Property levelCost;

    @Shadow
    private int repairItemUsage;

    public AnvilScreenHandlerMixin( @Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject( method = "updateResult", at = @At( value = "RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void updateResultMixin(CallbackInfo ci) {
        ItemStack stack = this.input.getStack(0).copy();
        ItemStack stack2 = this.input.getStack(1).copy();

        if (stack.isOf(ModItems.AMETHYST_SHIELD) && stack2.isOf(Items.ENCHANTED_BOOK)) {
            ItemStack result = stack.copy();

            Map<Enchantment, Integer> mapBook = EnchantmentHelper.get(stack2);
            Map<Enchantment, Integer> mapShield = EnchantmentHelper.get(result);
            Enchantment sharpness = Enchantments.SHARPNESS;
            Enchantment unbreaking = Enchantments.UNBREAKING;
            Enchantment mending = Enchantments.MENDING;


            if (mapBook.containsKey(unbreaking) && (mapShield.containsKey(unbreaking) || mapShield.containsKey(sharpness))) {

                this.output.setStack(0, ItemStack.EMPTY);
                this.repairItemUsage = 1;
                ci.cancel();
            }

            if (mapBook.containsKey(mending) && (mapShield.containsKey(mending))) {

                this.output.setStack(0, ItemStack.EMPTY);
                this.repairItemUsage = 1;
                ci.cancel();
            }

            if (mapBook.containsKey(sharpness) && !mapShield.containsKey(sharpness) && !mapShield.containsKey(unbreaking)) {
                int level = mapBook.get(sharpness);

                result.addEnchantment(sharpness, level);
                this.output.setStack(0, result);
                this.levelCost.set(level);
                this.repairItemUsage = 1;
                ci.cancel();
            }
        }
    }
}
