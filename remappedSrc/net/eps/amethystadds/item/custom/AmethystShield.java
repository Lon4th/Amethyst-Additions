package net.eps.amethystadds.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.enchantment.ModEnchantment;
import net.eps.amethystadds.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AmethystShield extends FabricBannerShieldItem implements AmethystShieldColorBehavior {
    private static boolean is_amethyst_broke;

    public AmethystShield(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
        AmethystShield.is_amethyst_broke = false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!selected) { return; }
        NbtCompound nbt = stack.getOrCreateNbt();

        if ((entity instanceof PlayerEntity player) && AmethystShield.is_amethyst_broke && world.isClient) {
            AmethystShield.spawnParticles(world, player, nbt);

            AmethystShield.is_amethyst_broke = false;
        }
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (stack.isOf(ModItems.AMETHYST_SHIELD) && EnchantmentHelper.get(stack).containsKey(ModEnchantment.RELOAD)) {
            if (clickType == ClickType.RIGHT) {
                ItemStack stackOnSlot = slot.getStack();

                if (stackOnSlot.getItem() instanceof ColoredAmethyst || stackOnSlot.isOf(Items.AMETHYST_SHARD)) {
                    NbtCompound nbt = stack.getNbt();
                    int amethysts = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
                    int colorOnSlot = stackOnSlot != Items.AMETHYST_SHARD.getDefaultStack() ? AmethystShieldColorBehavior.getColorOnSlot(stackOnSlot) : 10;

                    if (amethysts < 8) {
                        String writeToSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdFromAmethystCount(amethysts);

                        this.increaseAmethystCount(stack);
                        nbt.putInt(writeToSlot, colorOnSlot);
                        stackOnSlot.decrement(1);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (stack.isOf(ModItems.AMETHYST_SHIELD) && EnchantmentHelper.get(stack).containsKey(ModEnchantment.RELOAD)) {
            if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
                if (otherStack.isOf(Items.AMETHYST_SHARD) || otherStack.getItem() instanceof ColoredAmethyst) {
                    NbtCompound nbt = stack.getNbt();
                    int amethysts = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
                    int colorOnSlot = otherStack != Items.AMETHYST_SHARD.getDefaultStack() ? AmethystShieldColorBehavior.getColorOnSlot(otherStack) : 10;

                    if (amethysts < 8) {
                        String writeToSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdFromAmethystCount(amethysts);

                        this.increaseAmethystCount(stack);
                        nbt.putInt(writeToSlot, colorOnSlot);
                        otherStack.decrement(1);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int getAmethystsCount(ItemStack shield) {
        NbtCompound nbt = shield.getNbt();
        if (nbt == null) {
            return 0;
        }

        return nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
    }

    public static void decreaseAmethystCount(ItemStack shield) {
        NbtCompound nbt = shield.getNbt();
        int prev_int = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);

        nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, prev_int - 1);

        AmethystShield.is_amethyst_broke = true;
    }

    public void increaseAmethystCount(ItemStack shield) {
        NbtCompound nbt = shield.getNbt();
        int prev_int = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);

        nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, prev_int + 1);
    }



    public static void spawnParticles(World world, PlayerEntity player, NbtCompound nbt) {
        ItemStack stack = player.getActiveItem();
        String getFromSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdForParticlesFromAmethystCount(getAmethystsCount(stack));
        int particleColor = nbt.getInt(getFromSlot);
        BlockStateParticleEffect amethystParticle = AmethystShieldColorBehavior.getParticleFromColor(particleColor);
        System.out.println("amethyst color when it called - " + particleColor);

        if (getAmethystsCount(stack) == 8) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.79D, 1.35, z * 0.79D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 7) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.7D, 1.36, z * 0.7D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 6) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.8D, 1.05, z * 0.8D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 5) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.71D, 1.06, z * 0.71D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 4) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.82D, 0.75, z * 0.82D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 3) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.73D, 0.76, z * 0.73D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 2) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.85D, 0.45, z * 0.85D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (getAmethystsCount(stack) == 1) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.76D, 0.46, z * 0.76D);

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        }
    }
}
