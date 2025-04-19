package net.eps.amethystadds.block.custom;


import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.custom.entity.AmethystBlockEntity;
import net.eps.amethystadds.block.custom.entity.ModBlockEntities;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;



import static net.eps.amethystadds.block.ModBlocks.*;
import static net.minecraft.block.Blocks.*;

public class AmethystBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");


    public AmethystBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    /*@Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
     */

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return world.getMaxLightLevel();
    }


    /* TICK */


    private static void tick(World world, BlockPos pos, BlockState state, AmethystBlockEntity blockEntity) {
        if (!world.isClient) {
            if (AmethystBlock.checkNeighbour(world, pos)) {

                world.setBlockState(pos, state.with(LIT, true));
            } else {

                world.setBlockState(pos, state.with(LIT, false));
            }
        }

        if (state.get(LIT) && world.isClient) {

            AmethystBlock.spawnLightParticle(state, world, pos, true);
        }
    }

    public static boolean checkNeighbour(World world, BlockPos pos) {
            boolean EastLight = doesBlockCauseLight(world.getBlockState(pos.east()));
            boolean WestLight = doesBlockCauseLight(world.getBlockState(pos.west()));

            boolean DownLight = doesBlockCauseLight(world.getBlockState(pos.down()));
            boolean UpLight = doesBlockCauseLight(world.getBlockState(pos.up()));

            boolean SouthLight = doesBlockCauseLight(world.getBlockState(pos.south()));
            boolean NorthLight = doesBlockCauseLight(world.getBlockState(pos.north()));

            boolean isNoBlockLight = (EastLight || world.getLightLevel(LightType.BLOCK, pos.east()) <= 7) &&
                    (WestLight || world.getLightLevel(LightType.BLOCK, pos.west()) <= 7) &&
                    (NorthLight || world.getLightLevel(LightType.BLOCK, pos.north()) <= 7) &&
                    (SouthLight || world.getLightLevel(LightType.BLOCK, pos.south()) <= 7) &&
                    (UpLight || world.getLightLevel(LightType.BLOCK, pos.up()) <= 7) &&
                    (DownLight || world.getLightLevel(LightType.BLOCK, pos.down()) <= 7);

            boolean isNoSkyLight = world.getLightLevel(LightType.SKY, pos.west()) < 1 &&
                    world.getLightLevel(LightType.SKY, pos.east()) < 1 &&
                    world.getLightLevel(LightType.SKY, pos.north()) < 1 &&
                    world.getLightLevel(LightType.SKY, pos.south()) < 1 &&
                    world.getLightLevel(LightType.SKY, pos.up()) < 1 &&
                    world.getLightLevel(LightType.SKY, pos.down()) < 1;

            boolean isNight = world.isNight();
            boolean isNoLight = (isNight || isNoSkyLight) && isNoBlockLight;


            return isNoLight && checkStateNeighbour(world, pos);
    }

    public static boolean checkStateNeighbour(World world, BlockPos pos) {
        return doesBlockCauseLight(world.getBlockState(pos.north())) ||
                doesBlockCauseLight(world.getBlockState(pos.west())) ||
                doesBlockCauseLight(world.getBlockState(pos.east())) ||
                doesBlockCauseLight(world.getBlockState(pos.south())) ||
                doesBlockCauseLight(world.getBlockState(pos.up())) ||
                doesBlockCauseLight(world.getBlockState(pos.down()));
    }

    public static boolean doesBlockCauseLight(BlockState state) {
        return state.getLuminance() > 7;
    }

    public static void spawnLightParticle(BlockState state, World world, BlockPos pos, boolean lightShred) {
        Block block = state.getBlock();
        Random random = world.getRandom();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.set(pos.getX() + MathHelper.nextInt(random, -10, 10), pos.getY() + MathHelper.nextInt(random, 0, 10), pos.getZ() + MathHelper.nextInt(random, -10, 10));
        if (lightShred) {
            if (block.equals(PURPLE_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(GREEN_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.GREEN_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(BLACK_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.BLACK_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(BLUE_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.BLUE_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(BROWN_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.BROWN_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(CYAN_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.CYAN_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(GRAY_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.GRAY_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(LIGHT_BLUE_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.LIGHT_BLUE_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(LIGHT_GRAY_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.LIGHT_GRAY_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(LIME_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.LIME_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(MAGENTA_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.MAGENTA_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(ORANGE_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.ORANGE_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(PINK_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.PINK_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(RED_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.RED_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(WHITE_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.WHITE_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            } else if (block.equals(YELLOW_AMETHYST_BLOCK)) {
                world.addImportantParticle(ModParticles.YELLOW_AMETHYST_BLOOM, true, (double) mutable.getX() + random.nextDouble(), (double) mutable.getY() + random.nextDouble(), (double) mutable.getZ() + random.nextDouble(), 0.0, 0.1, 0.0);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    /* BLOCK ENTITY */


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AmethystBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.AMETHYST_BLOCK, AmethystBlock::tick);
    }

}