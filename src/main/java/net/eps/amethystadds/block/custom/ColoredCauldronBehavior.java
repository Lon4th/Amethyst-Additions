package net.eps.amethystadds.block.custom;

import it.unimi.dsi.fastutil.objects.Object2ObjectFunction;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.HashMap;
import java.util.Map;

public interface ColoredCauldronBehavior extends CauldronBehavior {
    public static final Map<Item, ColoredCauldronBehavior> COLORED_CAULDRON_BEHAVIOR = ColoredCauldronBehavior.createMap();

    public static final ColoredCauldronBehavior DYE_SHULKER_BOX = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof ShulkerBoxBlock)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            ItemStack itemStack = new ItemStack(Blocks.RED_SHULKER_BOX);
            if (stack.hasNbt()) {
                itemStack.setNbt(stack.getNbt().copy());
            }
            player.setStackInHand(hand, itemStack);
            ColoredWaterCauldron.decrementFluidLevel(state, world, pos);
        }
        return ActionResult.success(world.isClient);
    };

    public static Object2ObjectOpenHashMap<Item, ColoredCauldronBehavior> createMap() {
        return Util.make(new Object2ObjectOpenHashMap(), map -> map.defaultReturnValue((state, world, pos, player, hand, stack) -> ActionResult.PASS));
    }

    public ActionResult interact(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, ItemStack var6);

    public static void registerBehavior() {
        COLORED_CAULDRON_BEHAVIOR.put(Items.SHULKER_BOX, DYE_SHULKER_BOX);
    }
}
