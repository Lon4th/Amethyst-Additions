package net.eps.amethystadds.mixin;

import net.eps.amethystadds.core.ColoredGlintCore;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// This class was taken from
// Mod "Enchant the Rainbow" (https://github.com/Pepperoni-Jabroni/EnchantTheRainbow/blob/main/src/main/java/pepjebs/enchant_the_rainbow/mixin/TridentEntityRendererMixin.java)
@Mixin(TridentEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class TridentEntityRendererMixin extends EntityRenderer<TridentEntity>  {

    protected TridentEntityRendererMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void setEnchantTheRainbowItemStack(
            TridentEntity tridentEntity,
            float f,
            float g,
            MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider,
            int i,
            CallbackInfo ci) {
        ItemStack itemStack = ((TridentEntityAccessor) tridentEntity).getTridentStack();
        ColoredGlintCore.setTargetStack(itemStack);
    }
}
