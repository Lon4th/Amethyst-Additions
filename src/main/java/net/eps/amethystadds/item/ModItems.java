package net.eps.amethystadds.item;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.fluids.ModFluids;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item GREEN_AMETHYST = registerItem("green_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item LIME_AMETHYST = registerItem("lime_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item BLACK_AMETHYST = registerItem("black_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item BLUE_AMETHYST = registerItem("blue_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item BROWN_AMETHYST = registerItem("brown_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item CYAN_AMETHYST = registerItem("cyan_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item GRAY_AMETHYST = registerItem("gray_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item LIGHT_BLUE_AMETHYST = registerItem("light_blue_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item LIGHT_GRAY_AMETHYST = registerItem("light_gray_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item MAGENTA_AMETHYST = registerItem("magenta_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ORANGE_AMETHYST = registerItem("orange_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item PINK_AMETHYST = registerItem("pink_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RED_AMETHYST = registerItem("red_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item WHITE_AMETHYST = registerItem("white_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item YELLOW_AMETHYST = registerItem("yellow_amethyst", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item RED_WATER_BUCKET = registerItem("honey_bucket",
            new BucketItem(ModFluids.RED_WATER_STILL, new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AmethystAdditions.MOD_ID, name), item);
    }

    
    public static void registerModItems() {
        AmethystAdditions.LOGGER.info("Registering Mod Items for" + AmethystAdditions.MOD_ID);
    }
}
