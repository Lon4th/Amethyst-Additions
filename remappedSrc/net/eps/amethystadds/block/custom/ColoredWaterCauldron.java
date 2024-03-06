package net.eps.amethystadds.block.custom;

import java.util.Map;
import java.util.function.Predicate;

import net.eps.amethystadds.block.custom.entity.ColoredCauldronBlockEntity;
import net.eps.amethystadds.block.custom.entity.ModBlockEntities;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import static net.eps.amethystadds.block.ModBlocks.RED_WATER_CAULDRON;
import static net.eps.amethystadds.block.custom.CauldronBlockWithEntity.checkType;


public class ColoredWaterCauldron extends LeveledCauldronBlock implements BlockEntityProvider, ColorBehavior {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty BOILED = BooleanProperty.of("boiled");
    private final Map<Item, ColoredCauldronBehavior> behaviorMapExtended;

    public ColoredWaterCauldron(Settings settings, Predicate<Biome.Precipitation> precipitationPredicate, Map<Item, CauldronBehavior> behaviorMap, Map<Item, ColoredCauldronBehavior> behaviorMapExtended) {
        super(settings, precipitationPredicate, behaviorMap);
        this.setDefaultState(this.getDefaultState()
                .with(POWERED, false).with(BOILED, false));
        this.behaviorMapExtended = behaviorMapExtended;
    }

    /* REGULAR CAULDRON BEHAVIOR */

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

    /* COLORED CAULDRON BEHAVIOR */

    public static void WarmUp(BlockState state, World world, BlockPos pos) {
        boolean bl = state.get(POWERED);
        boolean bl2 = world.getBlockState(pos.down()).getBlock() instanceof FireBlock;
        if (bl && !bl2) {
            world.setBlockState(pos, state.with(POWERED, false));
        } else if (!bl && bl2) {
            world.setBlockState(pos, state.with(POWERED, true));
        }
    }

    public static void spawnBoilParticles(BlockState state, World world, BlockPos pos) {
        Random random = world.getRandom();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.set(pos.getX() + MathHelper.nextInt(random, 2/16, 14/16), pos.getY() + MathHelper.nextInt(random, 0, 10), pos.getZ() + MathHelper.nextInt(random, 2/16, 14/16));
        if (state.get(BOILED)) {
                world.addImportantParticle(ColorBehavior.GetBubbleColor(state), true, (double) pos.getX() + MathHelper.nextDouble(random, 2.0/16.0, 14.0/16.0), (double)pos.getY() + (6.0 + (double)state.get(LEVEL).intValue() * 3.0) / 16.0, (double) pos.getZ() + MathHelper.nextDouble(random, 2.0/16.0, 14.0/16.0), 0.0, 0.1, 0.0);
        }
    }

    public static void spawnParticlesWhileTransforming(World world, BlockPos pos, DefaultParticleType particle) {
        Random random = world.getRandom();
        world.addImportantParticle(particle, false,
                (double) pos.getX() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getY() + 1.0 + 0.1/16.0,
                (double) pos.getZ() + MathHelper.nextDouble(random, 1.0/16.0, 1.0), 0.0, 0.1, 0.0);

        world.addImportantParticle(particle, false,
                (double) pos.getX() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getY() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getZ() - 0.1/16.0, 0.0, 0.1, 0.0);

        world.addImportantParticle(particle, false,
                (double) pos.getX() - 0.1/16.0,
                (double) pos.getY() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getZ() + MathHelper.nextDouble(random, 1.0/16.0, 1.0), 0.0, 0.1, 0.0);

        world.addImportantParticle(particle, false,
                (double) pos.getX() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getY() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getZ() + 1 + 0.1/16.0, 0.0, 0.1, 0.0);

        world.addImportantParticle(particle, false,
                (double) pos.getX() + 1 + 0.1/16.0,
                (double) pos.getY() + MathHelper.nextDouble(random, 1.0/16.0, 1.0),
                (double) pos.getZ() + MathHelper.nextDouble(random, 1.0/16.0, 1.0), 0.0, 0.1, 0.0);
    }

    public static void spawnTransformParticles(World world, BlockPos pos, DefaultParticleType particle) {
        ParticleUtil.spawnParticle(world, pos, particle, UniformIntProvider.create(3, 5));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED, BOILED, LEVEL);
    }

    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ColoredCauldronBlockEntity(pos, state);
    }

        @Nullable
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
            return checkType(type, ModBlockEntities.COLORED_CAULDRON_BLOCK, ColoredCauldronBlockEntity::tick);
        }


}


