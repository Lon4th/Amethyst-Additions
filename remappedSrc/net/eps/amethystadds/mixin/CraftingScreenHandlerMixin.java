package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.custom.AmethystShieldColorBehavior;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Map;

@Mixin(CraftingScreenHandler.class)
public abstract class CraftingScreenHandlerMixin implements AmethystShieldColorBehavior {

    @Inject(method = "updateResult", at = @At(value = "TAIL"))
    private static void updateResultMixin(ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftingResultInventory resultInventory, CallbackInfo ci) {
        if (!world.isClient) {
            if (resultInventory.getStack(0).toString().equals(ModItems.AMETHYST_SHIELD.getDefaultStack().toString())) {
                NbtCompound shieldNbt = resultInventory.getStack(0).getOrCreateNbt();

                if (!shieldNbt.contains(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG)) {
                    shieldNbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, 8);
                }

                for (int i = 0; i < 9; i++) {
                    ItemStack stack = craftingInventory.getStack(i);

                    if (stack.getItem() instanceof ColoredAmethyst || stack.isOf(Items.AMETHYST_SHARD)) {
                        int colorOnSlot = stack != Items.AMETHYST_SHARD.getDefaultStack() ? AmethystShieldColorBehavior.getColorOnSlot(stack) : 10;
                        String writeToSlot = "amethystadds:amethyst_color_" + i;

                        shieldNbt.putInt(writeToSlot, colorOnSlot);
                        System.out.println("amethyst color when it registered, but before - " + colorOnSlot);
                        System.out.println("amethyst color when it registered - " + shieldNbt.getInt(writeToSlot));
                    }
                    if (stack.getItem() instanceof ShieldItem && stack.getSubNbt("BlockEntityTag") != null) {
                        NbtCompound nbt = stack.getSubNbt("BlockEntityTag");

                        resultInventory.getStack(0).getOrCreateSubNbt("BlockEntityTag").copyFrom(nbt);
                    }
                    if (stack.getItem() instanceof ShieldItem && stack.hasEnchantments()) {
                        Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.get(stack);

                        EnchantmentHelper.set(enchantmentMap, resultInventory.getStack(0));
                    }
                }
            }
        }
    }

}
