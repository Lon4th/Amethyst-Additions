package net.eps.amethystadds.block.custom;

import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import static net.eps.amethystadds.block.ModBlocks.*;

public class AmethystLampBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    protected final ParticleEffect particle;
    protected final VoxelShape northShape;
    protected final VoxelShape southShape;
    protected final VoxelShape eastShape;
    protected final VoxelShape westShape;
    protected final VoxelShape upShape;
    protected final VoxelShape downShape;

    public AmethystLampBlock(Settings settings, ParticleEffect particle) {
        super(settings);
        this.setDefaultState((this.getDefaultState().with(WATERLOGGED, false)).with(FACING, Direction.UP));
        this.particle = particle;
        this.upShape = Block.createCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
        this.downShape = Block.createCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
        this.northShape = Block.createCuboidShape(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D);
        this.southShape = Block.createCuboidShape(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D);
        this.eastShape = Block.createCuboidShape(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D);
        this.westShape = Block.createCuboidShape(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH -> this.northShape;
            case SOUTH -> this.southShape;
            case EAST -> this.eastShape;
            case WEST -> this.westShape;
            case DOWN -> this.downShape;
            case UP -> this.upShape;
        };
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction == (state.get(FACING)).getOpposite() && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        if (world.isClient && random.nextBetween(0, 2) == 2) {
            if (direction == Direction.UP) {
                world.addParticle(this.particle, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
            } else if (direction == Direction.DOWN) {
                world.addParticle(this.particle, pos.getX() + 0.5, pos.getY() + 0, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
            } else if (direction == Direction.NORTH) {
                world.addParticle(this.particle, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0, 0.0, 0.1, 0.0);
            } else if (direction == Direction.SOUTH) {
                world.addParticle(this.particle, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 1, 0.0, 0.1, 0.0);
            } else if (direction == Direction.EAST) {
                world.addParticle(this.particle, pos.getX() + 1, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
            } else if (direction == Direction.WEST) {
                world.addParticle(this.particle, pos.getX() + 0, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
            }
        }
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldAccess worldAccess = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        return (this.getDefaultState().with(WATERLOGGED, worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER)).with(FACING, ctx.getSide());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }


    static {
        WATERLOGGED = Properties.WATERLOGGED;
        FACING = Properties.FACING;
    }
}
