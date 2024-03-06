package net.eps.amethystadds.block.custom.entity;

import net.eps.amethystadds.block.ModBlocks;
import net.eps.amethystadds.block.custom.AmethystBlock;
import net.eps.amethystadds.block.custom.CauldronBlockWithEntity;
import net.eps.amethystadds.block.custom.ColorBehavior;
import net.eps.amethystadds.block.custom.ColoredWaterCauldron;
import net.eps.amethystadds.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.BuddingAmethystBlock;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.eps.amethystadds.block.custom.ColoredWaterCauldron.BOILED;
import static net.eps.amethystadds.block.custom.ColoredWaterCauldron.POWERED;

public class ColoredCauldronBlockEntity extends BlockEntity implements ColorBehavior {

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 2000;
    private int transformProgress = 0;
    private int maxTransformProgress = 1000;

    public ColoredCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COLORED_CAULDRON_BLOCK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return ColoredCauldronBlockEntity.this.progress;
                    case 1: return ColoredCauldronBlockEntity.this.maxProgress;
                    case 2: return ColoredCauldronBlockEntity.this.transformProgress;
                    case 3: return ColoredCauldronBlockEntity.this.maxTransformProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: ColoredCauldronBlockEntity.this.progress = value; break;
                    case 1: ColoredCauldronBlockEntity.this.maxProgress = value; break;
                    case 2: ColoredCauldronBlockEntity.this.transformProgress = value; break;
                    case 3: ColoredCauldronBlockEntity.this.maxTransformProgress = value; break;
                }

            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("colored_cauldron_block.progress", progress);
        nbt.putInt("colored_cauldron_block.transformProgress", transformProgress);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        progress = nbt.getInt("colored_cauldron_block.progress");
        transformProgress = nbt.getInt("colored_cauldron_block.transformProgress");
    }

    public void resetTransformProgress() {
        transformProgress = 0;
    }

    private void resetProgress() {
        progress = 0;
    }

    public static void tick(World world, BlockPos pos, BlockState state, ColoredCauldronBlockEntity entity) {
        ColoredWaterCauldron.WarmUp(state, world, pos);


        if (state.get(POWERED) && !state.get(BOILED)) {
            entity.progress++;
            if (entity.progress >= entity.maxProgress) {
                world.setBlockState(pos, state.with(BOILED, true));
            }
        } else if (!state.get(POWERED) && state.get(BOILED)) {
            world.setBlockState(pos, state.with(BOILED, false));
            entity.resetProgress();
        } else {
            entity.resetProgress();
        }
        ColoredWaterCauldron.spawnBoilParticles(state, world, pos);


        transformBlock(state, world, pos, entity);
    }

    public static void transformBlock(BlockState state, World world, BlockPos pos, ColoredCauldronBlockEntity entity) {
        if (!state.get(BOILED)) { return; }

        boolean amethystblock = world.getBlockState(pos.up()).getBlock() instanceof AmethystBlock;
        boolean amethystcluster = world.getBlockState(pos.up()).getBlock() instanceof net.minecraft.block.AmethystBlock;
        boolean buddingamethyst = world.getBlockState(pos.up()).getBlock() instanceof BuddingAmethystBlock;
        boolean tintedglass = world.getBlockState(pos.up()).getBlock() instanceof TintedGlassBlock;


        if (buddingamethyst || amethystcluster || amethystblock || tintedglass) {
            if (!(world.getBlockState(pos.up()).getBlock() == ColorBehavior.GetAmethystColor(state, world.getBlockState(pos.up()).getBlock()))) {
                entity.transformProgress++;
                ColoredWaterCauldron.spawnParticlesWhileTransforming(world, pos.up(), ColorBehavior.GetBubbleColor(state));
                if (entity.transformProgress >= entity.maxTransformProgress) {
                    world.setBlockState(pos.up(), ColorBehavior.GetAmethystColor(state, world.getBlockState(pos.up()).getBlock()).getDefaultState());
                    ColoredWaterCauldron.decrementFluidLevel(state, world, pos);
                    ColoredWaterCauldron.spawnTransformParticles(world, pos.up(), ColorBehavior.GetBloomColor(state));
                }
            } else {
                entity.resetTransformProgress();
            }
        }
    }
}
