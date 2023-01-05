package net.eps.amethystadds.fluids;

import net.eps.amethystadds.AmethystAdditions;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid RED_WATER_STILL = register("red_water_still", new RedWaterFluid.Still());
    public static final FlowableFluid RED_WATER_FLOWING = register("red_water_flowing", new RedWaterFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(AmethystAdditions.MOD_ID, name), flowableFluid);
    }
}