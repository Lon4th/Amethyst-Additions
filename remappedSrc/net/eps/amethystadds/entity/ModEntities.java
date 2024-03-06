package net.eps.amethystadds.entity;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEntities {
    public static final EntityType<ColoredAllayEntity> RED_ALLAY = Registry.register(Registries.ENTITY_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_allay"), EntityType.Builder.create(ColoredAllayEntity::new, SpawnGroup.CREATURE).setDimensions(0.35F, 0.6F).maxTrackingRange(8).trackingTickInterval(2).build("red_allay"));
    //public static final EntityType<ColoredAllayEntity> RED_ALLAY = Registry.register(Registry.ENTITY_TYPE, new Identifier(AmethystAdditions.MOD_ID, "red_allay"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ColoredAllayEntity::new).dimensions(EntityDimensions.fixed(0.35F, 0.6F)).build());
}
