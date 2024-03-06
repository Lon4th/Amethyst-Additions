package net.eps.amethystadds.client.entity;

import net.eps.amethystadds.AmethystAdditions;
import net.eps.amethystadds.entity.custom.ColoredAllayEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AllayEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.AllayEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;

@Environment(EnvType.CLIENT)
public class ColoredAllayRenderer extends MobEntityRenderer<ColoredAllayEntity, ColoredAllayModel> {
    public static final HashMap<Integer, String> COLOR_TO_ID = Util.make(new HashMap<>(), (colorToId) -> {
        colorToId.put(0, "_white");
        colorToId.put(1, "_orange");
        colorToId.put(2, "_magenta");
        colorToId.put(3, "");
        colorToId.put(4, "_yellow");
        colorToId.put(5, "_lime");
        colorToId.put(6, "_pink");
        colorToId.put(7, "_gray");
        colorToId.put(8, "_light_gray");
        colorToId.put(9, "_cyan");
        colorToId.put(10, "_purple");
        colorToId.put(11, "_blue");
        colorToId.put(12, "_brown");
        colorToId.put(13, "_green");
        colorToId.put(14, "_red");
        colorToId.put(15, "_black");
    });

    public ColoredAllayRenderer(EntityRendererFactory.Context context) {
        super(context, new ColoredAllayModel(context.getPart(EntityModelLayers.ALLAY)), 0.4F);
        this.addFeature(new HeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(ColoredAllayEntity entity) {
        return new Identifier(AmethystAdditions.MOD_ID, "textures/entity/allay" + COLOR_TO_ID.get(entity.getAllayColor()) + ".png");
    }

    @Override
    protected int getBlockLight(ColoredAllayEntity entity, BlockPos pos) {
        return 15;
    }

}
