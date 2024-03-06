package net.eps.amethystadds.entity;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<ColoredAllayEntity> COLORED_ALLAY = Registry.register(Registries.ENTITY_TYPE, new Identifier(AmethystAdditions.MOD_ID, "colored_allay"), EntityType.Builder.create(ColoredAllayEntity::new, SpawnGroup.CREATURE).setDimensions(0.35F, 0.6F).maxTrackingRange(8).trackingTickInterval(2).build("colored_allay"));
}
