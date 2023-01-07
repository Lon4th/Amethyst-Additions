package net.eps.amethystadds.block.custom;

import java.util.Map;
import java.util.function.Predicate;

import net.eps.amethystadds.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;


public class ColoredWaterCauldron extends LeveledCauldronBlock {
    private final Map<Item, ColoredCauldronBehavior> behaviorMapExtended;

    public ColoredWaterCauldron(Settings settings, Predicate<Biome.Precipitation> precipitationPredicate, Map<Item, CauldronBehavior> behaviorMap, Map<Item, ColoredCauldronBehavior> behaviorMapExtended) {
        super(settings, precipitationPredicate, behaviorMap);
        this.behaviorMapExtended = behaviorMapExtended;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        ColoredCauldronBehavior coloredcauldronBehavior = this.behaviorMapExtended.get(itemStack.getItem());
        return coloredcauldronBehavior.interact(state, world, pos, player, hand, itemStack);
    }

    protected static boolean canFillWithPrecipitation(World world, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return world.getRandom().nextFloat() < 0.05f;
        }
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (!ColoredWaterCauldron.canFillWithPrecipitation(world, precipitation)) {
            return;
        }
        BlockState blockState = state.cycle(LEVEL);
        if (state.get(LEVEL) != 3) {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(ColoredWaterCauldron.LEVEL)).cycle(ColoredWaterCauldron.LEVEL));
        } else {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(ColoredWaterCauldron.LEVEL)));
        }
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        BlockState blockState = state.cycle(LEVEL);
        if (state.get(LEVEL) != 3) {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(ColoredWaterCauldron.LEVEL)).cycle(ColoredWaterCauldron.LEVEL));
        } else {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState().with(ColoredWaterCauldron.LEVEL, state.get(ColoredWaterCauldron.LEVEL)));
        }
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
    }
}


