package net.eps.amethystadds.mixin;


import com.google.common.collect.Maps;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.ColoredCauldronBehavior;
//import net.eps.amethystadds.block.custom.entity.WaterCauldronBlockEntity;
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
            if (state.get(LeveledCauldronBlock.LEVEL) == 3) {
                CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.RED_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
            }
            if (state.get(LeveledCauldronBlock.LEVEL) == 2) {
                CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.RED_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 2), SoundEvents.ITEM_BUCKET_EMPTY);
            }
            if (state.get(LeveledCauldronBlock.LEVEL) == 1) {
                CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.RED_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 1), SoundEvents.ITEM_BUCKET_EMPTY);
            }
            return ActionResult.success(world.isClient);

    });
    }
}
