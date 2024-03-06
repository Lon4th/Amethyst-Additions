package net.eps.amethystadds.block.custom.entity;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.block.custom.AmethystBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.eps.amethystadds.block.ModBlocks.PURPLE_AMETHYST_BLOCK;
import static net.eps.amethystadds.block.custom.AmethystBlock.LIT;
import static net.eps.amethystadds.block.custom.AmethystBlock.checkNeighbour;
import static net.minecraft.block.Blocks.GLOWSTONE;

public class AmethystBlockEntity extends BlockEntity {

    public AmethystBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.AMETHYST_BLOCK, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AmethystBlockEntity entity) {
    }
}
