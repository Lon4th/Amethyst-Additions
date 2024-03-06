package net.eps.amethystadds.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.slot.Slot;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class AmethystShield extends FabricBannerShieldItem implements AmethystShieldColorBehavior {

    public AmethystShield(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        NbtCompound nbt = stack.getOrCreateNbt();

        if (entity instanceof PlayerEntity player) {
            if (nbt.getBoolean("amethystadds:is_amethyst_broke") && world.isClient) {
                nbt.putBoolean("amethystadds:is_amethyst_broke", false);

                if (selected) {

                        this.spawnParticles(world, player, nbt, false);
                } else if (player.getStackInHand(Hand.OFF_HAND) == stack) {

                        this.spawnParticles(world, player, nbt, true);
                }
            }
        }
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (stack.isOf(ModItems.AMETHYST_SHIELD)) {
            if (clickType == ClickType.RIGHT) {
                ItemStack stackOnSlot = slot.getStack();

                if (stackOnSlot.getItem() instanceof ColoredAmethyst || stackOnSlot.isOf(Items.AMETHYST_SHARD)) {
                    NbtCompound nbt = stack.getNbt();
                    int amethysts = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
                    int colorOnSlot = stackOnSlot != Items.AMETHYST_SHARD.getDefaultStack() ? AmethystShieldColorBehavior.getColorOnSlot(stackOnSlot) : 10;

                    if (amethysts < 8) {
                        String writeToSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdFromAmethystCount(amethysts);

                        this.increaseAmethystCount(nbt);
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
        if (stack.isOf(ModItems.AMETHYST_SHIELD)) {
            if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
                if (otherStack.isOf(Items.AMETHYST_SHARD) || otherStack.getItem() instanceof ColoredAmethyst) {
                    NbtCompound nbt = stack.getNbt();
                    int amethysts = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
                    int colorOnSlot = otherStack != Items.AMETHYST_SHARD.getDefaultStack() ? AmethystShieldColorBehavior.getColorOnSlot(otherStack) : 10;

                    if (amethysts < 8) {
                        String writeToSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdFromAmethystCount(amethysts);

                        this.increaseAmethystCount(nbt);
                        nbt.putInt(writeToSlot, colorOnSlot);
                        otherStack.decrement(1);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getAmethystsCount(ItemStack shield) {
        NbtCompound nbt = shield.getNbt();
        if (nbt == null) {
            return 0;
        }

        return nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);
    }

    public void decreaseAmethystCount(ItemStack shield) {
        NbtCompound nbt = shield.getOrCreateNbt();
        int prev_int = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);


        nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, prev_int - 1);
        nbt.putBoolean("amethystadds:is_amethyst_broke", true);
    }

    public void increaseAmethystCount(NbtCompound nbt) {
        int prev_int = nbt.getInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG);

        nbt.putInt(AmethystAdditions.AMETHYST_COUNTER_NBT_TAG, prev_int + 1);
    }

    @Override
    public void appendShieldTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context) {
        String tooltipColor = AmethystSmithingTemplate.getTooltipColorForStack(stack);
        if (tooltipColor == null)
            return;
        tooltip.add(1, Text.translatable( "item.amethystadds.colored_amethyst.color", tooltipColor).formatted(Formatting.GRAY)
        );
    }

    public void spawnParticles(World world, PlayerEntity player, NbtCompound nbt, boolean offHand) {
        ItemStack stack = player.getActiveItem();
        int amethystPos = this.getAmethystsCount(stack) + 1;
        String getFromSlot = "amethystadds:amethyst_color_" + AmethystShieldColorBehavior.getIdForParticlesFromAmethystCount(amethystPos);
        int particleColor = nbt.getInt(getFromSlot);
        BlockStateParticleEffect amethystParticle = AmethystShieldColorBehavior.getParticleFromColor(particleColor);

        if (amethystPos == 8) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.79D, 1.35, z * 0.79D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 7) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.7D, 1.36, z * 0.7D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 6) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.8D, 1.05, z * 0.8D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 5) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.71D, 1.06, z * 0.71D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 4) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.82D, 0.75, z * 0.82D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 3) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.73D, 0.76, z * 0.73D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 2) {
            float yaw = player.bodyYaw + 43;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.85D, 0.45, z * 0.85D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        } else if (amethystPos == 1) {
            float yaw = player.bodyYaw + 13;
            double x = -Math.sin(Math.toRadians(yaw));
            double z = Math.cos(Math.toRadians(yaw));

            Vec3d itemPos = player.getPos().add(x * 0.76D, 0.46, z * 0.76D);
            if (offHand) {
                itemPos.multiply(-2, 1, 1);
                //itemPos.add(-1, 0, 0);
            }

            for (int i = 0; i < world.getRandom().nextBetweenExclusive(4, 6); i++) {
                world.addParticle(amethystParticle, itemPos.x, itemPos.y, itemPos.z, 0, 0, 0);
            }

        }
    }
}