package net.eps.amethystadds.mixin;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.custom.AmethystSmithingTemplate;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

// This class was taken from
// Mod "Enchant the Rainbow" (https://github.com/Pepperoni-Jabroni/EnchantTheRainbow/blob/main/src/main/java/pepjebs/enchant_the_rainbow/mixin/ItemMixin.java)
@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "appendTooltip", at = @At(value = "TAIL"))
    public void appendFragmentColorTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        String tooltipColor = AmethystSmithingTemplate.getTooltipColorForStack(stack);
        if (tooltipColor == null)
            return;
        tooltip.add(1, Text.translatable("item.amethystadds.colored_amethyst.color", tooltipColor).formatted(Formatting.GRAY)
        );
    }
}
