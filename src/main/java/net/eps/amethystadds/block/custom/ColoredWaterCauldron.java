package net.eps.amethystadds.block.custom;

import java.util.Map;
import java.util.function.Predicate;

import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;


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
}


