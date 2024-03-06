package net.eps.amethystadds.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.custom.AmethystShield;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WHITE_AMETHYST = registerItem("white_amethyst", new ColoredAmethyst(new FabricItemSettings(), 0, new NbtCompound()));
    public static final Item ORANGE_AMETHYST = registerItem("orange_amethyst", new ColoredAmethyst(new FabricItemSettings(), 1, new NbtCompound()));
    public static final Item MAGENTA_AMETHYST = registerItem("magenta_amethyst", new ColoredAmethyst(new FabricItemSettings(), 2, new NbtCompound()));
    public static final Item LIGHT_BLUE_AMETHYST = registerItem("light_blue_amethyst", new ColoredAmethyst(new FabricItemSettings(), 3, new NbtCompound()));
    public static final Item YELLOW_AMETHYST = registerItem("yellow_amethyst", new ColoredAmethyst(new FabricItemSettings(), 4, new NbtCompound()));
    public static final Item LIME_AMETHYST = registerItem("lime_amethyst", new ColoredAmethyst(new FabricItemSettings(), 5, new NbtCompound()));
    public static final Item PINK_AMETHYST = registerItem("pink_amethyst", new ColoredAmethyst(new FabricItemSettings(), 6, new NbtCompound()));
    public static final Item GRAY_AMETHYST = registerItem("gray_amethyst", new ColoredAmethyst(new FabricItemSettings(), 7, new NbtCompound()));
    public static final Item LIGHT_GRAY_AMETHYST = registerItem("light_gray_amethyst", new ColoredAmethyst(new FabricItemSettings(), 8, new NbtCompound()));
    public static final Item CYAN_AMETHYST = registerItem("cyan_amethyst", new ColoredAmethyst(new FabricItemSettings(), 9, new NbtCompound()));
    public static final Item BLUE_AMETHYST = registerItem("blue_amethyst", new ColoredAmethyst(new FabricItemSettings(), 11, new NbtCompound()));
    public static final Item BROWN_AMETHYST = registerItem("brown_amethyst", new ColoredAmethyst(new FabricItemSettings(),12, new NbtCompound()));
    public static final Item GREEN_AMETHYST = registerItem("green_amethyst", new ColoredAmethyst( new FabricItemSettings(), 13, new NbtCompound()));
    public static final Item RED_AMETHYST = registerItem("red_amethyst", new ColoredAmethyst(new FabricItemSettings(), 14, new NbtCompound()));
    public static final Item BLACK_AMETHYST = registerItem("black_amethyst", new ColoredAmethyst(new FabricItemSettings(), 15, new NbtCompound()));

    public static final Item PURPLE_AMETHYST_SMITHING_TEMPLATE = registerItem("purple_amethyst_smithing_template", new ColoredAmethyst(new FabricItemSettings(), 10, new NbtCompound()));


    public static final Item AMETHYST_SHIELD = registerItem("amethyst_shield", new AmethystShield(new FabricItemSettings().maxDamage(2500), 10, 13, Items.OAK_PLANKS));

    public static void addItemsToItemGroups() {
        addToItemGroup(ItemGroups.INGREDIENTS, WHITE_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, ORANGE_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, MAGENTA_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, LIGHT_BLUE_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, YELLOW_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, LIME_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, PINK_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, GRAY_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, LIGHT_GRAY_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, CYAN_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, BLUE_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, BROWN_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, GREEN_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, RED_AMETHYST);
        addToItemGroup(ItemGroups.INGREDIENTS, BLACK_AMETHYST);

        addToItemGroup(ItemGroups.INGREDIENTS, PURPLE_AMETHYST_SMITHING_TEMPLATE);

        addToItemGroup(ItemGroups.COMBAT, AMETHYST_SHIELD);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AmethystAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmethystAdditions.LOGGER.info("Registering Mod Items for" + AmethystAdditions.MOD_ID);

        addItemsToItemGroups();
    }
}
