package net.eps.amethystadds.mixin;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;
import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.AmethystAddsClient;
import net.eps.amethystadds.client.entity.AmethystShieldEntityModel;
import net.eps.amethystadds.item.custom.AmethystShieldColorBehavior;
import net.eps.amethystadds.item.custom.AmethystShield;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin implements AmethystShieldColorBehavior {
    private ShieldEntityModel modelAmethystShield;
    private AmethystShieldEntityModel modelAmethystShard;

    /* IDENTIFYING TEXTURES */

    //SHIELD
    private static final SpriteIdentifier AMETHYST_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_base_nopattern" ));
    private static final SpriteIdentifier AMETHYST_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_base_nopattern" ));

    //AMETHYSTS
    private static final SpriteIdentifier AMETHYST_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_purple_v5" ));
    private static final SpriteIdentifier AMETHYST_RED_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_red_v5" ));
    private static final SpriteIdentifier AMETHYST_ORANGE_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_orange_v5" ));
    private static final SpriteIdentifier AMETHYST_YELLOW_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_yellow_v5" ));
    private static final SpriteIdentifier AMETHYST_BROWN_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_brown_v5" ));
    private static final SpriteIdentifier AMETHYST_MAGENTA_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_magenta_v5" ));
    private static final SpriteIdentifier AMETHYST_PINK_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_pink_v5" ));
    private static final SpriteIdentifier AMETHYST_WHITE_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_white_v5" ));
    private static final SpriteIdentifier AMETHYST_LIGHT_GRAY_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_light_gray_v5" ));
    private static final SpriteIdentifier AMETHYST_GRAY_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_gray_v5" ));
    private static final SpriteIdentifier AMETHYST_BLACK_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_black_v5" ));
    private static final SpriteIdentifier AMETHYST_GREEN_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_green_v5" ));
    private static final SpriteIdentifier AMETHYST_LIME_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_lime_v5" ));
    private static final SpriteIdentifier AMETHYST_BLUE_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_blue_v5" ));
    private static final SpriteIdentifier AMETHYST_LIGHT_BLUE_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_light_blue_v5" ));
    private static final SpriteIdentifier AMETHYST_CYAN_SHARD = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_cyan_v5" ));

    //AMETHYST BASES
    private static final SpriteIdentifier AMETHYST_RED_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_red" ));
    private static final SpriteIdentifier AMETHYST_ORANGE_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_orange" ));
    private static final SpriteIdentifier AMETHYST_YELLOW_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_yellow" ));
    private static final SpriteIdentifier AMETHYST_BROWN_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_brown" ));
    private static final SpriteIdentifier AMETHYST_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_purple" ));
    private static final SpriteIdentifier AMETHYST_MAGENTA_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_magenta" ));
    private static final SpriteIdentifier AMETHYST_PINK_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_pink" ));
    private static final SpriteIdentifier AMETHYST_BLACK_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_black" ));
    private static final SpriteIdentifier AMETHYST_GRAY_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_gray" ));
    private static final SpriteIdentifier AMETHYST_LIGHT_GRAY_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_light_gray" ));
    private static final SpriteIdentifier AMETHYST_WHITE_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_white" ));
    private static final SpriteIdentifier AMETHYST_GREEN_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_green" ));
    private static final SpriteIdentifier AMETHYST_LIME_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_lime" ));
    private static final SpriteIdentifier AMETHYST_BLUE_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_blue" ));
    private static final SpriteIdentifier AMETHYST_CYAN_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_cyan" ));
    private static final SpriteIdentifier AMETHYST_LIGHT_BLUE_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier( AmethystAdditions.MOD_ID, "entity/amethyst_shield_shard_base_light_blue" ));


    @Final
    @Shadow
    private EntityModelLoader entityModelLoader;


    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelAmethystShield(CallbackInfo ci){
        modelAmethystShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(AmethystAddsClient.AMETHYST_SHIELD_MODEL_LAYER));
        modelAmethystShard = new AmethystShieldEntityModel(this.entityModelLoader.getModelPart(AmethystAddsClient.AMETHYST_SHIELD_SHARDS_MODEL_LAYER));
    }


    @Inject(method = "render", at = @At("HEAD"))
    private void mainRender(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (stack.getItem() instanceof AmethystShield shield) {
            NbtCompound nbt = stack.getOrCreateNbt();

            /* SETTING BANNERS */

            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelAmethystShield, AMETHYST_SHIELD_BASE, AMETHYST_SHIELD_BASE_NO_PATTERN);


            matrices.push();
            matrices.scale(1.0F, -1.0F, -1.0F);

            /* GETTING TEXTURES */

            AmethystShieldColorBehavior.registerShardColorBehavior(AMETHYST_SHARD, AMETHYST_RED_SHARD, AMETHYST_ORANGE_SHARD, AMETHYST_YELLOW_SHARD, AMETHYST_BROWN_SHARD, AMETHYST_MAGENTA_SHARD, AMETHYST_PINK_SHARD, AMETHYST_WHITE_SHARD, AMETHYST_LIGHT_GRAY_SHARD, AMETHYST_GRAY_SHARD, AMETHYST_BLACK_SHARD, AMETHYST_GREEN_SHARD, AMETHYST_LIME_SHARD, AMETHYST_BLUE_SHARD, AMETHYST_LIGHT_BLUE_SHARD, AMETHYST_CYAN_SHARD, vertexConsumers, modelAmethystShard, stack);
            AmethystShieldColorBehavior.registerBaseColorBehavior(AMETHYST_BASE, AMETHYST_RED_BASE, AMETHYST_ORANGE_BASE, AMETHYST_YELLOW_BASE, AMETHYST_BROWN_BASE, AMETHYST_MAGENTA_BASE, AMETHYST_PINK_BASE, AMETHYST_WHITE_BASE, AMETHYST_LIGHT_GRAY_BASE, AMETHYST_GRAY_BASE, AMETHYST_BLACK_BASE, AMETHYST_GREEN_BASE, AMETHYST_LIME_BASE, AMETHYST_BLUE_BASE, AMETHYST_LIGHT_BLUE_BASE, AMETHYST_CYAN_BASE, vertexConsumers, modelAmethystShard, stack);

            AMETHYST_RED_BASE.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, modelAmethystShard.getLayer(AMETHYST_RED_BASE.getAtlasId()), false, stack.hasGlint()));

            VertexConsumer getVertexFromSlot_0 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_0) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_0) : 10);
            VertexConsumer getVertexFromSlot_1 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_1) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_1) : 10);
            VertexConsumer getVertexFromSlot_2 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_2) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_2) : 10);
            VertexConsumer getVertexFromSlot_3 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_3) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_3) : 10);
            VertexConsumer getVertexFromSlot_5 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_5) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_5) : 10);
            VertexConsumer getVertexFromSlot_6 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_6) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_6) : 10);
            VertexConsumer getVertexFromSlot_7 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_7) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_7) : 10);
            VertexConsumer getVertexFromSlot_8 = AmethystShieldColorBehavior.SHARD_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_8) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_8) : 10);


            /* SETTING MODELS + TEXTURES */

            //AMETHYST BASES
            modelAmethystShard.getShardBase_0().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_0) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_0) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_1().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_1) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_1) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_2().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_2) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_2) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_3().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_3) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_3) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_4().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_5) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_5) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_5().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_6) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_6) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_6().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_7) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_7) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            modelAmethystShard.getShardBase_7().render(matrices, AmethystShieldColorBehavior.BASE_COLOR_TO_VERTEX.get( nbt.contains(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_8) ? nbt.getInt(AmethystAdditions.AMETHYST_COLOR_ON_SLOT_8) : 10), light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            //AMETHYSTS
            if (shield.getAmethystsCount(stack) == 1) {

                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 2) {

                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 3) {

                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 4) {

                modelAmethystShard.getShard_4().render(matrices, getVertexFromSlot_5, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 5) {

                modelAmethystShard.getShard_3().render(matrices, getVertexFromSlot_3, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_4().render(matrices, getVertexFromSlot_5, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 6) {

                modelAmethystShard.getShard_2().render(matrices, getVertexFromSlot_2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_3().render(matrices, getVertexFromSlot_3, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_4().render(matrices, getVertexFromSlot_5, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 7) {

                modelAmethystShard.getShard_1().render(matrices, getVertexFromSlot_1, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_2().render(matrices, getVertexFromSlot_2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_3().render(matrices, getVertexFromSlot_3, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_4().render(matrices, getVertexFromSlot_5, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            } else if (shield.getAmethystsCount(stack) == 8) {

                modelAmethystShard.getShard_0().render(matrices, getVertexFromSlot_0, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_1().render(matrices, getVertexFromSlot_1, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_2().render(matrices, getVertexFromSlot_2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_3().render(matrices, getVertexFromSlot_3, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_4().render(matrices, getVertexFromSlot_5, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_5().render(matrices, getVertexFromSlot_6, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_6().render(matrices, getVertexFromSlot_7, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
                modelAmethystShard.getShard_7().render(matrices, getVertexFromSlot_8, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            }

            matrices.pop();
        }
    }
}
