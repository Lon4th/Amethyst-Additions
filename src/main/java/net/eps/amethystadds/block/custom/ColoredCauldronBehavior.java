package net.eps.amethystadds.block.custom;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public interface ColoredCauldronBehavior extends CauldronBehavior, ColorBehavior {
    public static final Map<Item, ColoredCauldronBehavior> COLORED_CAULDRON_BEHAVIOR = ColoredCauldronBehavior.createMap();

    public static final ColoredCauldronBehavior DYE_DYEABLE_ITEM = (state, world, pos, player, hand, stack) -> {
        Item item = stack.getItem();
        if (!(item instanceof DyeableItem)) {
            return ActionResult.PASS;
        }
        DyeableItem dyeableItem = (DyeableItem)((Object)item);
        if (dyeableItem.getColor(stack) == ColorBehavior.GetIntColor(state)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            dyeableItem.setColor(stack, ColorBehavior.GetIntColor(state));
            ColoredWaterCauldron.decrementFluidLevel(state, world, pos);
        }
        return ActionResult.success(world.isClient);
    };

    public static final ColoredCauldronBehavior DYE_SHULKER_BOX = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof ShulkerBoxBlock)) {
            return ActionResult.PASS;
        }
        DyeColor color = ShulkerBoxBlock.getColor(block);
        if (color == ColorBehavior.GetDyeColor(state)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            ItemStack itemStack = new ItemStack(ColorBehavior.GetShulkerColor(state));
            if (stack.hasNbt()) {
                itemStack.setNbt(stack.getNbt().copy());
            }
            player.setStackInHand(hand, itemStack);
            ColoredWaterCauldron.decrementFluidLevel(state, world, pos);
        }
        return ActionResult.success(world.isClient);
    };

    public static final ColoredCauldronBehavior DYE_CAULDRON = (state, world, pos, player, hand, stack) -> {
        if (ColorBehavior.compareColors(stack, state)) {
            return ActionResult.PASS;
        }
            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float roll = 0.0F;
            float f = (float) (-Math.sin(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            float g = (float) -Math.sin((pitch + roll) * 0.017453292F);
            float h = (float) (Math.cos(yaw * 0.017453292F) * Math.cos(pitch * 0.017453292F));
            Vec3d position = player.getEyePos();
            Item item = stack.getItem();

            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.AIR)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, ColorBehavior.getCauldronFromDye(stack).getDefaultState().with(ColoredWaterCauldron.LEVEL,
                    state.get(ColoredWaterCauldron.LEVEL)), SoundEvents.ITEM_BONE_MEAL_USE, true);
            for (int i = 0; i <= world.getRandom().nextBetween(3, 12); i++) {
                world.addImportantParticle(ColorBehavior.getDustColor(stack), position.x, position.y + 0.1, position.z,
                        f + world.getRandom().nextBetween(-1, 1) / 7.0,
                        g + world.getRandom().nextBetween(-1, 1) / 16.0,
                        h + world.getRandom().nextBetween(-1, 1) / 7.0);
        }

        return ActionResult.success(world.isClient);
    };

    public static Object2ObjectOpenHashMap<Item, ColoredCauldronBehavior> createMap() {
        return Util.make(new Object2ObjectOpenHashMap<>(), map -> map.defaultReturnValue((state, world, pos, player, hand, stack) -> ActionResult.PASS));
    }

    public ActionResult interact(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, ItemStack var6);

    public static void registerBehavior() {
        COLORED_CAULDRON_BEHAVIOR.put(Items.LEATHER_BOOTS, DYE_DYEABLE_ITEM);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LEATHER_LEGGINGS, DYE_DYEABLE_ITEM);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LEATHER_CHESTPLATE, DYE_DYEABLE_ITEM);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LEATHER_HELMET, DYE_DYEABLE_ITEM);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LEATHER_HORSE_ARMOR, DYE_DYEABLE_ITEM);

        COLORED_CAULDRON_BEHAVIOR.put(Items.SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.RED_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BLACK_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BLUE_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BROWN_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.CYAN_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.GRAY_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.GREEN_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIME_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.MAGENTA_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.ORANGE_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.PINK_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.PURPLE_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.WHITE_SHULKER_BOX, DYE_SHULKER_BOX);
        COLORED_CAULDRON_BEHAVIOR.put(Items.YELLOW_SHULKER_BOX, DYE_SHULKER_BOX);

        COLORED_CAULDRON_BEHAVIOR.put(Items.RED_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.ORANGE_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BROWN_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.YELLOW_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.GREEN_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIME_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.CYAN_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BLUE_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.PURPLE_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.PINK_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.MAGENTA_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.WHITE_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.GRAY_DYE, DYE_CAULDRON);
        COLORED_CAULDRON_BEHAVIOR.put(Items.BLACK_DYE, DYE_CAULDRON);

        COLORED_CAULDRON_BEHAVIOR.put(Items.WATER_BUCKET, (state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY));
        COLORED_CAULDRON_BEHAVIOR.put(Items.LAVA_BUCKET, (state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, Blocks.LAVA_CAULDRON.getDefaultState(), SoundEvents.ITEM_BUCKET_EMPTY_LAVA));
        COLORED_CAULDRON_BEHAVIOR.put(Items.POWDER_SNOW_BUCKET, (state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)Blocks.POWDER_SNOW_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW));
        COLORED_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state2, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state2, world, pos, player, hand, stack, new ItemStack(Items.WATER_BUCKET), state -> state.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL));
        COLORED_CAULDRON_BEHAVIOR.put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                ColoredWaterCauldron.decrementFluidLevel(state, world, pos);
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }
            return ActionResult.success(world.isClient);
        });
        COLORED_CAULDRON_BEHAVIOR.put(Items.POTION, (state, world, pos, player, hand, stack) -> {
            if (PotionUtil.getPotion(stack) != Potions.WATER) {
                return ActionResult.PASS;
            }
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                if (state.get(LeveledCauldronBlock.LEVEL) != 3) {
                    ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, state.get(ColoredWaterCauldron.LEVEL)).cycle(LeveledCauldronBlock.LEVEL), SoundEvents.ITEM_BUCKET_EMPTY, false);
                } else {
                    ColoredCauldronBehavior.ChangeCauldron(world, pos, player, hand, stack, Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, state.get(ColoredWaterCauldron.LEVEL)), SoundEvents.ITEM_BUCKET_EMPTY, false);
                }
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        });
    }

    public static ActionResult ChangeCauldron(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent, boolean colorChange) {
        if (!world.isClient) {
            Item item = stack.getItem();
            if (!player.isCreative()){
                if (colorChange) {
                    stack.decrement(1);
                } else {
                    player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                }
            }
            player.incrementStat(Stats.FILL_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            world.setBlockState(pos, state);
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
        }
        return ActionResult.success(world.isClient);
    }
}
