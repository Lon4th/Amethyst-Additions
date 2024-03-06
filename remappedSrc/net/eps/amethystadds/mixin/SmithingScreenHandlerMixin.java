package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SmithingScreenHandler.class)
public abstract class SmithingScreenHandlerMixin extends ForgingScreenHandler {

    @Shadow private @Nullable SmithingRecipe currentRecipe;

    @Shadow @Final private World world;

    public SmithingScreenHandlerMixin(
            @Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Override
    public boolean canTakeOutput(PlayerEntity player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.matches(this.input, this.world) || this.input.getStack(1).getItem() == Items.AMETHYST_SHARD || this.output.getStack(0).getNbt().contains(AmethystAdditions.GLINT_COLOR_NBT_TAG);
    }

    @Inject(method = "updateResult", at = @At(value = "RETURN"))
    private void updateGlintResult(CallbackInfo ci) {
        ItemStack leftStack = this.input.getStack(0).copy();
        ItemStack rightStack = this.input.getStack(1).copy();

        int glintColor = -1;
        if (leftStack.hasGlint() && rightStack.getOrCreateNbt().contains(AmethystAdditions.GLINT_COLOR_NBT_TAG)) {
            glintColor = rightStack.getNbt().getInt(AmethystAdditions.GLINT_COLOR_NBT_TAG);
        }
        if (glintColor != -1) {
            NbtCompound nbt = leftStack.getOrCreateNbt();

            nbt.putInt(AmethystAdditions.GLINT_COLOR_NBT_TAG, glintColor);
            leftStack.setCount(1);

            this.output.setStack(0, leftStack);
        }
    }
}
