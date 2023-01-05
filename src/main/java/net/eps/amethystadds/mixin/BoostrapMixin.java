package net.eps.amethystadds.mixin;

import net.eps.amethystadds.block.custom.ColoredCauldronBehavior;
import net.minecraft.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class BoostrapMixin {

    @Inject(method = "initialize", at = @At("TAIL"))
    private static void initialize0(CallbackInfo ci) {
        ColoredCauldronBehavior.registerBehavior();
    }

}
