package net.eps.amethystadds.item.custom;

import net.eps.amethystadds.AmethystAdditions;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ColoredAmethyst extends Item {
    public final int color;

    public ColoredAmethyst(Settings settings, int color, NbtCompound nbt) {
        super(settings);
        nbt.putInt(AmethystAdditions.GLINT_COLOR_NBT_TAG, color);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public static String getTooltipColorForStack(ItemStack stack){
        if (stack.getNbt() == null || !stack.getNbt().contains(AmethystAdditions.GLINT_COLOR_NBT_TAG))
            return null;
        int color = stack.getNbt().getInt(AmethystAdditions.GLINT_COLOR_NBT_TAG);
        String dyeColor = DyeColor.byId(color).getName();
        return Arrays.stream(dyeColor
                        .split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
    }

}
