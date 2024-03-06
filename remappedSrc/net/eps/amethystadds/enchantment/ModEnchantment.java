package net.eps.amethystadds.enchantment;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantment {

    public static Enchantment RELOAD = register("reload", new ReloadEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.OFFHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(AmethystAdditions.MOD_ID, name), enchantment);
    }

    public static void registerEnchantments() {
    }
}
