package net.eps.amethystadds.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.custom.AmethystShield;
import net.eps.amethystadds.item.custom.AmethystSmithingTemplate;
import net.eps.amethystadds.item.custom.ColoredAmethyst;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WHITE_AMETHYST = registerItem("white_amethyst", new ColoredAmethyst(new Item.Settings(), 0, new NbtCompound()));
    public static final Item ORANGE_AMETHYST = registerItem("orange_amethyst", new ColoredAmethyst(new Item.Settings(), 1, new NbtCompound()));
    public static final Item MAGENTA_AMETHYST = registerItem("magenta_amethyst", new ColoredAmethyst(new Item.Settings(), 2, new NbtCompound()));
    public static final Item LIGHT_BLUE_AMETHYST = registerItem("light_blue_amethyst", new ColoredAmethyst(new Item.Settings(), 3, new NbtCompound()));
    public static final Item YELLOW_AMETHYST = registerItem("yellow_amethyst", new ColoredAmethyst(new Item.Settings(), 4, new NbtCompound()));
    public static final Item LIME_AMETHYST = registerItem("lime_amethyst", new ColoredAmethyst(new Item.Settings(), 5, new NbtCompound()));
    public static final Item PINK_AMETHYST = registerItem("pink_amethyst", new ColoredAmethyst(new Item.Settings(), 6, new NbtCompound()));
    public static final Item GRAY_AMETHYST = registerItem("gray_amethyst", new ColoredAmethyst(new Item.Settings(), 7, new NbtCompound()));
    public static final Item LIGHT_GRAY_AMETHYST = registerItem("light_gray_amethyst", new ColoredAmethyst(new Item.Settings(), 8, new NbtCompound()));
    public static final Item CYAN_AMETHYST = registerItem("cyan_amethyst", new ColoredAmethyst(new Item.Settings(), 9, new NbtCompound()));
    public static final Item BLUE_AMETHYST = registerItem("blue_amethyst", new ColoredAmethyst(new Item.Settings(), 11, new NbtCompound()));
    public static final Item BROWN_AMETHYST = registerItem("brown_amethyst", new ColoredAmethyst(new Item.Settings(),12, new NbtCompound()));
    public static final Item GREEN_AMETHYST = registerItem("green_amethyst", new ColoredAmethyst( new Item.Settings(), 13, new NbtCompound()));
    public static final Item RED_AMETHYST = registerItem("red_amethyst", new ColoredAmethyst(new Item.Settings(), 14, new NbtCompound()));
    public static final Item BLACK_AMETHYST = registerItem("black_amethyst", new ColoredAmethyst(new Item.Settings(), 15, new NbtCompound()));

    public static final Item WHITE_AMETHYST_SMITHING_TEMPLATE = registerItem("white_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("white", 0));
    public static final Item LIGHT_GRAY_AMETHYST_SMITHING_TEMPLATE = registerItem("light_gray_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("light_gray", 8));
    public static final Item GRAY_AMETHYST_SMITHING_TEMPLATE = registerItem("gray_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("gray", 7));
    public static final Item BLACK_AMETHYST_SMITHING_TEMPLATE = registerItem("black_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("black", 15));
    public static final Item BROWN_AMETHYST_SMITHING_TEMPLATE = registerItem("brown_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("brown", 12));
    public static final Item RED_AMETHYST_SMITHING_TEMPLATE = registerItem("red_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("red", 14));
    public static final Item ORANGE_AMETHYST_SMITHING_TEMPLATE = registerItem("orange_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("orange", 1));
    public static final Item YELLOW_AMETHYST_SMITHING_TEMPLATE = registerItem("yellow_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("yellow", 4));
    public static final Item LIME_AMETHYST_SMITHING_TEMPLATE = registerItem("lime_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("lime", 5));
    public static final Item GREEN_AMETHYST_SMITHING_TEMPLATE = registerItem("green_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("green", 13));
    public static final Item CYAN_AMETHYST_SMITHING_TEMPLATE = registerItem("cyan_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("cyan", 9));
    public static final Item LIGHT_BLUE_AMETHYST_SMITHING_TEMPLATE = registerItem("light_blue_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("light_blue", 3));
    public static final Item BLUE_AMETHYST_SMITHING_TEMPLATE = registerItem("blue_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("blue", 11));
    public static final Item PURPLE_AMETHYST_SMITHING_TEMPLATE = registerItem("purple_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("purple", 10));
    public static final Item MAGENTA_AMETHYST_SMITHING_TEMPLATE = registerItem("magenta_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("magenta", 2));
    public static final Item PINK_AMETHYST_SMITHING_TEMPLATE = registerItem("pink_amethyst_smithing_template", AmethystSmithingTemplate.createAmethystSmithingTemplate("pink", 6));


    public static final Item AMETHYST_SHIELD = registerItem("amethyst_shield", new AmethystShield(new Item.Settings().maxDamage(336), 10, 13, Items.OAK_PLANKS));

    public static void addToItemGroup(Item item) {
        if (item instanceof AmethystShield) {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(item));
        } else {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(item));
        }
    }

    private static Item registerItem(String name, Item item) {
        addToItemGroup(item);
        return Registry.register(Registries.ITEM, new Identifier(AmethystAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmethystAdditions.LOGGER.info("Registering Mod Items for" + AmethystAdditions.MOD_ID);
    }
}