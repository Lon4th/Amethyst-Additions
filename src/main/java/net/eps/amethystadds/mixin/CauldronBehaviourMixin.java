package net.eps.amethystadds.mixin;


import com.google.common.collect.Maps;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.ColoredCauldronBehavior;
//import net.eps.amethystadds.block.custom.entity.WaterCauldronBlockEntity;
import net.eps.amethystadds.block.custom.ColoredWaterCauldron;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Random;

import static net.minecraft.item.Items.SHULKER_BOX;
import static net.minecraft.item.Items.STICK;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviourMixin {

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerBehavior0(CallbackInfo ci) {
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, ModBlocks.RED_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                world.addImportantParticle(ModParticles.RED_DUST, true, position.x, position.y + 0.1, position.z,
                        f + world.getRandom().nextBetween(-1, 1) / 7.0,
                        g + world.getRandom().nextBetween(-1, 1) / 16.0,
                        h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, ModBlocks.YELLOW_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
            world.addImportantParticle(ModParticles.YELLOW_DUST, true, position.x, position.y + 0.1, position.z,
                    f + world.getRandom().nextBetween(-1, 1) / 7.0,
                    g + world.getRandom().nextBetween(-1, 1) / 16.0,
                    h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.GREEN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
            world.addImportantParticle(ModParticles.GREEN_DUST, true, position.x, position.y + 0.1, position.z,
                    f + world.getRandom().nextBetween(-1, 1) / 7.0,
                    g + world.getRandom().nextBetween(-1, 1) / 16.0,
                    h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIME_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
            world.addImportantParticle(ModParticles.LIME_DUST, true, position.x, position.y + 0.1, position.z,
                    f + world.getRandom().nextBetween(-1, 1) / 7.0,
                    g + world.getRandom().nextBetween(-1, 1) / 16.0,
                    h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.ORANGE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
            world.addImportantParticle(ModParticles.ORANGE_DUST, true, position.x, position.y + 0.1, position.z,
                    f + world.getRandom().nextBetween(-1, 1) / 7.0,
                    g + world.getRandom().nextBetween(-1, 1) / 16.0,
                    h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.WHITE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.WHITE_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BROWN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
            world.addImportantParticle(ModParticles.BROWN_DUST, true, position.x, position.y + 0.1, position.z,
                    f + world.getRandom().nextBetween(-1, 1) / 7.0,
                    g + world.getRandom().nextBetween(-1, 1) / 16.0,
                    h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIGHT_BLUE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.LIGHT_BLUE_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BLUE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.BLUE_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.CYAN_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.CYAN_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.PINK_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.PINK_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.MAGENTA_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.MAGENTA_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.PURPLE_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.PURPLE_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.LIGHT_GRAY_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.LIGHT_GRAY_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.GRAY_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.GRAY_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_DYE, (state, world, pos, player, hand, stack) -> {
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.BLACK_WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(LeveledCauldronBlock.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                    world.addImportantParticle(ModParticles.BLACK_DUST, true, position.x, position.y + 0.1, position.z,
                            f + world.getRandom().nextBetween(-1, 1) / 7.0,
                            g + world.getRandom().nextBetween(-1, 1) / 16.0,
                            h + world.getRandom().nextBetween(-1, 1) / 7.0);
            }
            return ActionResult.success(world.isClient);
    });
    }
}
