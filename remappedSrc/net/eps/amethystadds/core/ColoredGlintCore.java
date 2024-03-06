package net.eps.amethystadds.core;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.client.ColoredGlintRenderLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;


/**
 * @author WireSegal
 * Hacked by svenhjol
 * Ported to Fabric 1.18 by Pepperoni-Jabroni
 * Created at 1:52 PM on 8/17/19.
 */
// This class lovingly yoinked (& updated to 1.18) from
// https://github.com/VazkiiMods/Quark/blob/master/src/main/java/vazkii/quark/content/tools/module/ColorRunesModule.java
// Published under the "CC BY-NC-SA 3.0" Creative Commons License
public class ColoredGlintCore {

    private static final ThreadLocal<ItemStack> targetStack = new ThreadLocal<>();

    public static void setTargetStack(ItemStack stack) {
        targetStack.set(stack);
    }

    public static int changeColor() {
        ItemStack target = targetStack.get();

        if (target == null ||
                target.isEmpty() ||
                target.getNbt() == null ||
                !target.getNbt().contains(AmethystAdditions.GLINT_COLOR_NBT_TAG))
            return -1;

        return target.getNbt().getInt(AmethystAdditions.GLINT_COLOR_NBT_TAG);
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getGlint() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.glintColor.get(color)
                : RenderLayer.getGlint();
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getEntityGlint() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.entityGlintColor.get(color)
                : RenderLayer.getEntityGlint();
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getGlintDirect() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.glintDirectColor.get(color)
                : RenderLayer.getDirectGlint();
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getEntityGlintDirect() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.entityGlintDirectColor.get(color)
                : RenderLayer.getDirectEntityGlint();
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getArmorGlint() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.armorGlintColor.get(color)
                : RenderLayer.getArmorGlint();
    }

    @Environment(EnvType.CLIENT)
    public static RenderLayer getArmorEntityGlint() {
        int color = changeColor();
        return color >= 0 && color < DyeColor.values().length
                ? ColoredGlintRenderLayer.armorEntityGlintColor.get(color)
                : RenderLayer.getArmorEntityGlint();
    }
}