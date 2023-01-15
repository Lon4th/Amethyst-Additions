package net.eps.amethystadds.mixin;


import com.google.common.collect.Maps;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.ColoredCauldronBehavior;
//import net.eps.amethystadds.block.custom.entity.WaterCauldronBlockEntity;
import net.eps.amethystadds.block.custom.ColoredWaterCauldron;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

import static net.minecraft.item.Items.SHULKER_BOX;
import static net.minecraft.item.Items.STICK;

@Mixin(CauldronBehavior.class)
public interface ColoredCauldronBehaviourMixin {

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerBehavior0(CallbackInfo ci) {
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.RED_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.YELLOW_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.GREEN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIME_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.ORANGE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.WHITE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BROWN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIGHT_BLUE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BLUE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.CYAN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.PINK_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.MAGENTA_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.PURPLE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIGHT_GRAY_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.GRAY_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_DYE, (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BLACK_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY);
            return ActionResult.success(world.isClient);
    });
    }
}
