package net.eps.amethystadds.enchantment;

import net.eps.amethystadds.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

import static net.minecraft.enchantment.EnchantmentTarget.WEAPON;

public class ReloadEnchantment extends Enchantment {
    public ReloadEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, WEAPON, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(ModItems.AMETHYST_SHIELD);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
