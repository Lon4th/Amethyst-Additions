package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.custom.AmethystSmithingTemplate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SmithingTrimRecipe.class)
public abstract class SmithingTrimRecipeMixin implements SmithingRecipe {

    @Inject(method = "matches(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/world/World;)Z", at = @At(value = "HEAD"), cancellable = true)
    private void matchesMixin(Inventory inventory, World world, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack1 = inventory.getStack(0);
        ItemStack stack2 = inventory.getStack(1);
        ItemStack stack3 = inventory.getStack(2);

        if (stack1.getItem() instanceof AmethystSmithingTemplate) {
            cir.setReturnValue(stack2.hasGlint() && stack3.isOf(Items.LAPIS_LAZULI));
        }
    }

    @Inject(method = "craft(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/registry/DynamicRegistryManager;)Lnet/minecraft/item/ItemStack;", at = @At(value = "HEAD"), cancellable = true)
    private void craftMixin(Inventory inventory, DynamicRegistryManager registryManager, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack templateStack = inventory.getStack(0).copy();
        ItemStack mainStack = inventory.getStack(1).copy();
        ItemStack materialStack = inventory.getStack(2).copy();

        int glintColor = -1;
        if (mainStack.hasGlint() && materialStack.isOf(Items.LAPIS_LAZULI)) {

            if (templateStack.getItem() instanceof AmethystSmithingTemplate template) {
                NbtCompound nbt = template.getColorNbt(templateStack);

                glintColor = nbt.getInt(AmethystAdditions.GLINT_COLOR_NBT_TAG);
            }
        }
        if (glintColor != -1) {
            NbtCompound nbt = mainStack.getOrCreateNbt();

            nbt.putInt(AmethystAdditions.GLINT_COLOR_NBT_TAG, glintColor);
            mainStack.setCount(1);

            cir.setReturnValue(mainStack);
        }
    }

    @Inject(method = "testAddition", at = @At(value = "HEAD"), cancellable = true)
    private void testAdditionMixin(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isOf(Items.LAPIS_LAZULI)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "testBase", at = @At(value = "HEAD"), cancellable = true)
    private void testBaseMixin(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.hasGlint()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "testTemplate", at = @At(value = "HEAD"), cancellable = true)
    private void testTemplate(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() instanceof AmethystSmithingTemplate) {
            cir.setReturnValue(true);
        }
    }
}
