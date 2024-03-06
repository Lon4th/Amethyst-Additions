package net.eps.amethystadds.util;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.eps.amethystadds.item.custom.AmethystShield;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AmethystShieldMain {

    public static void damage(Entity entity, DamageSource source) {
        if ((entity instanceof PlayerEntity player) && player.getActiveItem().getItem() instanceof AmethystShield shield) {
            Entity sourceEntity = source.getSource();
            ItemStack stack = player.getActiveItem();
            World world = player.getWorld();
            Random random = world.getRandom();

            int unbreakingLevel = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, stack) * 10;
            int sharpnessLevel = EnchantmentHelper.getLevel(Enchantments.SHARPNESS, stack);

            int damage = 4 + sharpnessLevel;
            int chance = MathHelper.nextBetween(random, 1, 100) + unbreakingLevel;


            if (!player.isBlocking()) return;
            if (sourceEntity == null) return;

            if (source.isOf(DamageTypes.MOB_PROJECTILE)) {
                if (chance < 90) {
                    shield.decreaseAmethystCount(stack);
                }
            }

            if ((source.getSource() instanceof LivingEntity) && shield.getAmethystsCount(stack) >= 1) {
                sourceEntity.damage(entity.getDamageSources().playerAttack(player), damage);

                if (chance < 90) {
                    shield.decreaseAmethystCount(stack);
                }
            }
        }
    }

}
