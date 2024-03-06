package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.item.custom.AmethystSmithingTemplate;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SmithingScreenHandler.class)
public abstract class SmithingScreenHandlerMixin extends ForgingScreenHandler {
    public SmithingScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    /*@Inject(method = "isValidIngredient", at = @At(value = "HEAD"), cancellable = true)
    private void isValidIngredientMixin(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("Validation Started");
        if (stack.getItem() instanceof AmethystSmithingTemplate) {
            System.out.println("Validation True");
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canInsertIntoSlot", at = @At(value = "HEAD"), cancellable = true)
    private void canInsertIntoSlotMixin(ItemStack stack, Slot slot, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("canInsert-ation Started");
        if (stack.getItem() instanceof AmethystSmithingTemplate && slot.getIndex() == 0) {
            System.out.println("canInsert-ation True");
            cir.setReturnValue(true);
        }
    }

     */
}
