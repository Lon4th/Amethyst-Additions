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
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}
