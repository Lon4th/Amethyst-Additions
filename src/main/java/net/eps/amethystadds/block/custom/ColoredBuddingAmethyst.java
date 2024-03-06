package net.eps.amethystadds.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

import java.util.List;

public class ColoredBuddingAmethyst extends BuddingAmethystBlock implements ColorBehavior {
    private static final Direction[] DIRECTIONS = Direction.values();

    public ColoredBuddingAmethyst(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            List<Block> amethystBudColor = ColorBehavior.GetAmethystBudColor(state);

            if (BuddingAmethystBlock.canGrowIn(blockState)) {
                block = amethystBudColor.get(0);
            } else if (blockState.isOf(amethystBudColor.get(0)) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = amethystBudColor.get(1);
            } else if (blockState.isOf(amethystBudColor.get(1)) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = amethystBudColor.get(2);
            } else if (blockState.isOf(amethystBudColor.get(2)) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = amethystBudColor.get(3);
            }

            if (block != null) {
                BlockState blockState2 = (block.getDefaultState().with(AmethystClusterBlock.FACING, direction)).with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }

        }
    }
}
