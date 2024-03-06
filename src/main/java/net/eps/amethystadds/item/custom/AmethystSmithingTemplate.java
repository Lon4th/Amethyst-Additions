package net.eps.amethystadds.item.custom;

import net.eps.amethystadds.AmethystAdditions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmethystSmithingTemplate extends SmithingTemplateItem {
    private static final Formatting TITLE_FORMATTING;
    private static final Formatting DESCRIPTION_FORMATTING;
    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE;
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE;
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE;
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE;
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE;
    private static final Text AMETHYST_SMITHING_TEMPLATE_TEXT;
    private static final Text AMETHYST_SMITHING_TEMPLATE_APPLIES_TO_TEXT;
    private static final Text AMETHYST_SMITHING_TEMPLATE_INGREDIENTS_TEXT;
    private static final Text AMETHYST_SMITHING_TEMPLATE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text AMETHYST_SMITHING_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    public final int color;

    public AmethystSmithingTemplate(Settings settings, Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, int color, NbtCompound nbt) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
        nbt.putInt(AmethystAdditions.GLINT_COLOR_NBT_TAG, color);
        this.color = color;
    }


    public int getColor() {
        return color;
    }

    public NbtCompound getColorNbt(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(AmethystAdditions.GLINT_COLOR_NBT_TAG, this.color);
        return nbt;
    }

    public static String getTooltipColorForStack(ItemStack stack){
        if (stack.getNbt() == null || !stack.getNbt().contains(AmethystAdditions.GLINT_COLOR_NBT_TAG))
            return null;
        int color = stack.getNbt().getInt(AmethystAdditions.GLINT_COLOR_NBT_TAG);
        String dyeColor = DyeColor.byId(color).getName();
        return Arrays.stream(dyeColor
                        .split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static AmethystSmithingTemplate createAmethystSmithingTemplate(String colorText, int colorInt) {
        return new AmethystSmithingTemplate(new Item.Settings(), AMETHYST_SMITHING_TEMPLATE_APPLIES_TO_TEXT, AMETHYST_SMITHING_TEMPLATE_INGREDIENTS_TEXT, Text.translatable(Util.createTranslationKey("upgrade", new Identifier("amethystadds", "glint_color_" + colorText))).formatted(TITLE_FORMATTING), AMETHYST_SMITHING_TEMPLATE_BASE_SLOT_DESCRIPTION_TEXT, AMETHYST_SMITHING_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getAmethystSmithingTemplateEmptyBaseSlotTextures(), getAmethystSmithingTemplateEmptyAdditionsSlotTextures(), colorInt, new NbtCompound());
    }

    public static List<Identifier> getAmethystSmithingTemplateEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    public static List<Identifier> getAmethystSmithingTemplateEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_LAPIS_LAZULI_TEXTURE);
    }

    static {
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;
        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
        EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = new Identifier("item/empty_slot_lapis_lazuli");
        AMETHYST_SMITHING_TEMPLATE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier("amethystadds", "amethyst_smithing_template"))).formatted(TITLE_FORMATTING);
        AMETHYST_SMITHING_TEMPLATE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("amethystadds", "smithing_template.amethyst_smithing_template.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        AMETHYST_SMITHING_TEMPLATE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("amethystadds", "smithing_template.amethyst_smithing_template.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        AMETHYST_SMITHING_TEMPLATE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("amethystadds", "smithing_template.amethyst_smithing_template.base_slot_description")));
        AMETHYST_SMITHING_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("amethystadds", "smithing_template.amethyst_smithing_template.additions_slot_description")));
    }
}
